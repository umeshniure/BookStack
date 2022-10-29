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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private BookDAO bookDAO;
    private UsersDAO userDAO;
    private OrderDAO orderDao;
    private OrderItemsDAO orderItemsDAO;
    private ShippingAddressDAO addressDAO;
    private CityDAO cityDAO;
    private ProvinceDAO provinceDAO;
    private CountryDAO countryDAO;
    private PaymentTypeDAO paymentDAO;
    private RandomAlphanumericString randomString;

    public void init() {
        cartDAO = new CartDAO();
        bookDAO = new BookDAO();
        userDAO = new UsersDAO();
        orderDao = new OrderDAO();
        orderItemsDAO = new OrderItemsDAO();
        addressDAO = new ShippingAddressDAO();
        cityDAO = new CityDAO();
        provinceDAO = new ProvinceDAO();
        countryDAO = new CountryDAO();
        paymentDAO = new PaymentTypeDAO();
        randomString = new RandomAlphanumericString();
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
                    String errorMessage = "Ohh! You cannot access this page.";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                    request.setAttribute("errorMessage", errorMessage);
                    dispatcher.forward(request, response);
                }
            } else {
                String errorMessage = "Ohh! It seems you not logged in yet. Please login first.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Ohh! It seems you not logged in yet. Please login first.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-order-history.jsp");
        request.setAttribute("user", user);
        request.setAttribute("orderItems", orderItems);
        request.setAttribute("orders", orders);
        dispatcher.forward(request, response);
    }

    public void showCheckoutPage(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int) session.getAttribute("id");
        Users user = userDAO.selectUser(user_id);
        List<Cart> cartItemList = cartDAO.selectCartByUserId(user_id);
        List<Books> book = bookDAO.selectAllBooks();
        List<City> cities = cityDAO.selectAllCity();
        List<Province> provinces = provinceDAO.selectAllProvince();
        List<Country> countries = countryDAO.selectAllCountry();
        List<ShippingAddress> addresses = addressDAO.selectShippingAddressByUserId(user_id);
        List<PaymentType> paymentTypes = paymentDAO.selectAllPaymentType();
        ShippingAddress fillAddress = addressDAO.selectShippingAddress(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("book", book);
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
        
        int payment_method = Integer.parseInt(request.getParameter("paymentMethod"));
        
        System.out.println("Payment method: " + payment_method);
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
            double tax_amount = (13 / 100) * total_price;
            double shipping_amount = 0;
            OrderItems orderItem = new OrderItems(book_id, quantity, order_id, unit_price, total_price, tax_amount, shipping_amount);
            orderItemsDAO.insertOrderItems(orderItem);
        }
//        cartDAO.deleteCartByUserId(user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home");
        request.setAttribute("successMessage", "congratulations! Your order has been successfully placed and cart has been emptied.");
        dispatcher.forward(request, response);
    }

    public void saveAddress(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            int user_id = (int) session.getAttribute("id");
            Integer postal_code;
            String temp = request.getParameter("postcode");
            if (temp == "" || temp == null) {
                postal_code = null;
            } else if (Integer.parseInt(temp) == 0) {
                postal_code = null;
            } else {
                postal_code = Integer.parseInt(temp);
            }
            String shipping_street = request.getParameter("street");
            String shipping_apartment = request.getParameter("apartment");
            int shipping_province = Integer.parseInt(request.getParameter("province"));
            int shipping_city = Integer.parseInt(request.getParameter("city"));
            int shipping_country = Integer.parseInt(request.getParameter("country"));
            boolean is_default = false;
            if (addressDAO.checkDefaultAddress(user_id) == 0) {
                is_default = true;
            }
            ShippingAddress Address = new ShippingAddress(user_id, shipping_street, shipping_apartment,
                    shipping_province, shipping_city, shipping_country, postal_code, is_default);
            if (addressDAO.insertshippingAddress(Address)) {
                request.getSession(false).setAttribute("successMessage", "Your address is saved successfully.");
            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorry! Your address couldnot be saved at the moment!");
            }
            response.sendRedirect("order");
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                String action = (request.getParameter("action"));
                System.out.println(action);
                if (action.equals("submitOrder")) {
                    insertOrder(request, response);
                } else if (action.equals("saveAddress")) {
                    saveAddress(request, response);
                } else {
                    response.sendRedirect("order");
                }
            } else {
                String errorMessage = "Ohh! It seems you not logged in yet. Please login first.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Ohh! It seems you not logged in yet. Please login first.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
