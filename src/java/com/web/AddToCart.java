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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println("cart servlet action = " + action);
        try {
            switch (action) {
                case ("/add-to-cart"):
                    //addToCart(request, response);
                    break;
                case ("remove"):
                    deleteCartItem(request, response);
                    break;
                default:
                    showCart(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void deleteCartItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("delete cart item called");
        int user_id = (int) request.getSession(false).getAttribute("id");
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cartItem = cartDAO.selectCart(id);
        if (cartItem.getUser_id() == user_id) {
            if (cartDAO.deleteCartById(id)) {
                System.out.println("one Cart item Successfully Deleted.");
                response.sendRedirect("cart");
            } else {
                System.out.println("Couldnot delete cart item.");
            }
        } else {
            System.out.println("user " + user_id + " - tried to delete others cart.");
        }
    }

    public void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = (int) request.getSession(false).getAttribute("id");
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        int quantity = 1;
        Date created_date = new Date(System.currentTimeMillis());
        Cart cartItem = cartDAO.selectCartByBookAndUserId(book_id, user_id);
        System.out.println("cart Item: " + cartItem);
        System.out.println(cartItem.getBook_id());
        if (cartItem.getBook_id() == book_id && cartItem.getUser_id() == user_id) {
            quantity = cartItem.getQuantity() + 1;
            Cart updateCart = new Cart(cartItem.getId(), user_id, book_id, quantity, cartItem.getCreated_date());
            if (cartDAO.updateCart(updateCart)) {
                System.out.println("Quantity successfully updated!");
                response.sendRedirect("home");
            } else {
                System.out.println("Failed to update cart!");
            }

        } else {
            Cart newCart = new Cart(user_id, book_id, quantity, created_date);
            cartDAO.insertIntoCart(newCart);
            System.out.println("Successfully inserted into cart.");
            response.sendRedirect("home");
        }
    }

    public void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = (int) request.getSession(false).getAttribute("id");
        List<Cart> cartItemList = cartDAO.selectCartByUserId(user_id);
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
