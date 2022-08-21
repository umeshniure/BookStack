/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.model.*;
import com.dao.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/cart"})
public class AddToCart extends HttpServlet {

    private CartDAO cartDAO;
    private BookDAO bookDAO;

    public void init() {
        cartDAO = new CartDAO();
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("servlet path = " + path);
        try {
            switch (path) {
                case ("/add-to-cart"):
                    //addToCart(request, response);
                    break;
                default:
                    showCart(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date created_date = new Date(System.currentTimeMillis());
        Cart cartItem = cartDAO.selectCart(book_id);
        if (cartItem.getBook_id() == book_id && cartItem.getUser_id() == user_id) {
            quantity = cartItem.getQuantity() + 1;
            System.out.println("AddToCart.java-> cannot add same book multiple times at the moment!");
        } else {
            Cart newCart = new Cart(user_id, book_id, quantity, created_date);
            cartDAO.insertIntoCart(newCart);
            System.out.println("Successfully inserted into cart.");
            response.sendRedirect("home");
        }
    }

    public void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cart> cartItemList = cartDAO.selectAllCart();
        List<Books> book = bookDAO.selectAllBooks();
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-to-cart.jsp");
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("book", book);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("do post method of addtocatr servlet called.");
        addToCart(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
