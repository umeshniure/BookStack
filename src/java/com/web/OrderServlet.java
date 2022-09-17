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
    private BookDAO bookDAO;
    private UsersDAO userDAO;
    private OrderDAO orderDao;
    private OrderItemsDAO orderItemsDAO;
    private RandomAlphanumericString randomString;

    public void init() {
        cartDAO = new CartDAO();
        bookDAO = new BookDAO();
        userDAO = new UsersDAO();
        orderDao = new OrderDAO();
        orderItemsDAO = new OrderItemsDAO();
        randomString = new RandomAlphanumericString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {

                int userCartCount = cartDAO.userCartCount((int) session.getAttribute("id"));
                System.out.println("cart count is: " + userCartCount);
                if (userCartCount > 0) {
                    showCheckoutPage(request, response);
                } else {
                    String errorMessage = "Sorry, your cart is empty. Please add some books on your cart to access the page.";
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

    public void showCheckoutPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                int user_id = (int) session.getAttribute("id");
                List<Cart> cartItemList = cartDAO.selectCartByUserId(user_id);
                System.out.println(cartItemList);
                List<Books> book = bookDAO.selectAllBooks();
                Users user = userDAO.selectUser(user_id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
                request.setAttribute("cartItemList", cartItemList);
                request.setAttribute("book", book);
                request.setAttribute("user", user);
                dispatcher.forward(request, response);
            } else {
                String errorMessage = "Ohh! I think you not logged in yet. Please login first.";
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

    public void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int) session.getAttribute("id");
        String id = randomString.secureString();
        String transaction_id = null;
        Integer shipping_postcode;
        String temp = request.getParameter("postcode");
        if (temp == null) {
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
        String payment_method = "Cash On Delivery";
        String shipping_method = "Standard Shipping";
        String shipping_street = request.getParameter("street");
        String shipping_apartment = request.getParameter("apartment");
        String shipping_province = request.getParameter("province");
        String shipping_city = request.getParameter("city");
        String shipping_country = request.getParameter("country");
        Double order_subtotal_amount = Double.parseDouble(request.getParameter("order_subtotal"));
        Double order_total_amount = Double.parseDouble(request.getParameter("order_total"));
        BookOrder order = new BookOrder(id, user_id, transaction_id, shipping_postcode, order_date, order_status, transaction_satus,
                special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,
                shipping_city, shipping_country, order_subtotal_amount, order_total_amount);
        orderDao.insertOrder(order);
        List<Cart> cartList = cartDAO.selectCartByUserId(user_id);
        for (Cart cart : cartList) {
            int book_id = cart.getBook_id();
            int quantity = cart.getQuantity();
            String order_id = id;
            double total_price = order_subtotal_amount;
            double tax_amount = 0;
            double shipping_amount = 0;
            OrderItems orderItem = new OrderItems(book_id, quantity, order_id, total_price, tax_amount, shipping_amount);
            orderItemsDAO.insertOrderItems(orderItem);
        }
        cartDAO.deleteCartByUserId(user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home");
        request.setAttribute("successMessage", "congratulations! Your order has been successfully placed and cart has been emptied.");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {

                insertOrder(request, response);

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
