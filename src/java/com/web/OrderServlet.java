/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.*;
import com.model.*;
import com.secure.RandomAlphanumericString;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

    private CartDAO cartDAO;
    private UsersDAO userDAO;
    private OrderDAO orderDao;
    private OrderItemsDAO orderItemsDAO;
    private ShippingAddressDAO addressDAO;
    private CityDAO cityDAO;
    private ProvinceDAO provinceDAO;
    private CountryDAO countryDAO;
    private PaymentTypeDAO paymentDAO;
    private RandomAlphanumericString randomString;
    private UpdateProfile updateProfile;

    public void init() {
        cartDAO = new CartDAO();
        userDAO = new UsersDAO();
        orderDao = new OrderDAO();
        orderItemsDAO = new OrderItemsDAO();
        addressDAO = new ShippingAddressDAO();
        cityDAO = new CityDAO();
        provinceDAO = new ProvinceDAO();
        countryDAO = new CountryDAO();
        paymentDAO = new PaymentTypeDAO();
        randomString = new RandomAlphanumericString();
        updateProfile = new UpdateProfile();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 1) {
                    String action = request.getParameter("action");
                    if (action == null) {
                        action = "";
                    }
                    switch (action) {
                        case "history":
                            userOrderHistory(request, response);
                            break;
                        case "recentOrder":
                            break;
                        case "fillAddress":
                            int id = Integer.parseInt(request.getParameter("id"));
                            showCheckoutPage(request, response, id);
                            break;
                        default:
                            int userCartCount = cartDAO.userCartCount((int) session.getAttribute("id"));
                            if (userCartCount > 0) {
                                int defaultAddId = addressDAO.checkDefaultAddress((int) session.getAttribute("id"));
                                showCheckoutPage(request, response, defaultAddId);
                            } else {
                                String errorMessage = "Sorry, your cart is empty. Please add some books on your cart to access the page.";
                                RequestDispatcher dispatcher2 = request.getRequestDispatcher("home");
                                request.setAttribute("errorMessage", errorMessage);
                                dispatcher2.forward(request, response);
                            }
                            break;
                    }
                } else {
                    request.getSession(false).setAttribute("errorMessage", "Ohh! You cannot access this page.");
                    response.sendRedirect("home");
                }
            } else {
                request.getSession(false).setAttribute("errorMessage", "Ohh! It seems you not logged in yet. Please login first.");
                response.sendRedirect("login");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Ohh! It seems you not logged in yet. Please login first.");
            response.sendRedirect("login");
        }
    }

    public void userOrderHistory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // user detailsl: name. email, profile pic
        // order: order id, ordered date, order subtotal, shipping address:post code, street, city, country
        // order items: book name, book cover name, quantity, book price, shipping amount
        HttpSession session = request.getSession(false);
        Users user = userDAO.selectUser((int) session.getAttribute("id"));
        List<OrderItems> orderItems = orderItemsDAO.selectOrderItemsByUserId((int) session.getAttribute("id"));
        List<BookOrder> orders = orderDao.selectOrderByUserId((int) session.getAttribute("id"));
        List<ShippingAddress> addresses = addressDAO.selectShippingAddressByUserId((int) session.getAttribute("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-order-history.jsp");
        request.setAttribute("user", user);
        request.setAttribute("orderItems", orderItems);
        request.setAttribute("orders", orders);
        request.setAttribute("addresses", addresses);
        dispatcher.forward(request, response);
    }

    public void showCheckoutPage(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int) session.getAttribute("id");
        Users user = userDAO.selectUser(user_id);
        List<Cart> cartItemList = cartDAO.selectCartByUserId(user_id);
        List<City> cities = cityDAO.selectAllCity();
        List<Province> provinces = provinceDAO.selectAllProvince();
        List<Country> countries = countryDAO.selectAllCountry();
        List<ShippingAddress> addresses = addressDAO.selectShippingAddressByUserId(user_id);
        List<PaymentType> paymentTypes = paymentDAO.selectAllPaymentType();
        ShippingAddress fillAddress = addressDAO.selectShippingAddress(id, user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("user", user);
        request.setAttribute("cities", cities);
        request.setAttribute("provinces", provinces);
        request.setAttribute("countries", countries);
        request.setAttribute("addresses", addresses);
        request.setAttribute("fillAddress", fillAddress);
        request.setAttribute("paymentTypes", paymentTypes);
        dispatcher.forward(request, response);
    }

    public void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int) session.getAttribute("id");
        String id = randomString.secureString();
        String transaction_id = null;
        Integer shipping_postcode;
        String temp = request.getParameter("postcode");
        if (temp == "") {
            shipping_postcode = null;
        } else if (Integer.parseInt(temp) == 0) {
            shipping_postcode = null;
        } else {
            shipping_postcode = Integer.parseInt(temp);
        }
        int order_status = 1;
        int transaction_satus = 1;
        Date order_date = new Date(System.currentTimeMillis());
        String special_instruction = request.getParameter("specialInstruction");
        String shipping_street = request.getParameter("street");
        String shipping_apartment = request.getParameter("apartment");
        int province_id = Integer.parseInt(request.getParameter("province"));
        String shipping_province = provinceDAO.selectProvince(province_id).getProvince_name();
        int city_id = Integer.parseInt(request.getParameter("city"));
        String shipping_city = cityDAO.selectCity(city_id).getCity_name();
        int country_id = Integer.parseInt(request.getParameter("country"));
        String shipping_country = countryDAO.selectCountry(country_id).getCountry_name();
        Double order_subtotal_amount = Double.parseDouble(request.getParameter("order_subtotal"));
        Double order_total_amount = Double.parseDouble(request.getParameter("order_total"));
        String payment_method = request.getParameter("paymentMethod");
        int shipping_method = 1;
        BookOrder order = new BookOrder(id, user_id, transaction_id, shipping_postcode, order_date, order_status, transaction_satus,
                special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,
                shipping_city, shipping_country, order_subtotal_amount, order_total_amount);
        orderDao.insertOrder(order);
        List<Cart> cartList = cartDAO.selectCartByUserId(user_id);
        for (Cart cart : cartList) {
            int book_id = cart.getBook_id();
            int quantity = cart.getQuantity();
            String order_id = id;
            double unit_price;
            if (cart.getDiscounted_price() != 0 && cart.getDiscounted_price() != null) {
                unit_price = cart.getDiscounted_price();
            } else {
                unit_price = 0;
            }
            if (unit_price == 0) {
                unit_price = cart.getPrice();
            }
            double total_price = quantity * unit_price;
            double tax_amount = Double.parseDouble(String.format("%.0f", (13.0 / 100.0) * total_price));
            double shipping_amount = 0;
            OrderItems orderItem = new OrderItems(book_id, quantity, order_id, unit_price, total_price, tax_amount, shipping_amount);
            orderItemsDAO.insertOrderItems(orderItem);
        }
        cartDAO.deleteCartByUserId(user_id);
        request.getSession(false).setAttribute("successMessage", "congratulations! Your order has been successfully placed and cart has been emptied.");
        response.sendRedirect("home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("id") == 1) {
                    String action = (request.getParameter("action"));
                    if (action.equals("submitOrder")) {
                        insertOrder(request, response);
                    } else if (action.equals("saveAddress")) {
                        updateProfile.init();
                        updateProfile.saveAddress(request, response);
                    } else {
                        response.sendRedirect("order");
                    }
                } else {
                    request.getSession(false).setAttribute("errorMessage", "Sorry, only users are allowed to access this page.");
                    response.sendRedirect("home");
                }
            } else {
                request.getSession(false).setAttribute("errorMessage", "Ohh! It seems you not logged in yet. Please login first.");
                response.sendRedirect("login");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Ohh! It seems you not logged in yet. Please login first.");
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
