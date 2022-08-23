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
import javax.servlet.http.HttpSession;

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
                case ("update"):
                    updateCartItem(request, response);
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
        System.out.println(user_id);
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cartItem = cartDAO.selectCart(id);
        System.out.println(cartItem.getUser_id());
        if (cartItem.getUser_id() == user_id) {
            if (cartDAO.deleteCartById(id)) {
//                System.out.println("one Cart item Successfully Deleted.");
//                String SuccessMessage = "One cart item has been successfully deleted.";
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
//                request.setAttribute("SuccessMessage", SuccessMessage);
//                dispatcher.forward(request, response);
                response.sendRedirect("cart");
            } else {
                System.out.println("Couldnot delete cart item.");
            }
        } else {
            System.out.println("user " + user_id + " - tried to delete others cart.");
        }
    }

    public void updateCartItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("update cart item called");
        int user_id = (int) request.getSession(false).getAttribute("id");
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        Cart cartItem = cartDAO.selectCart(id);
        System.out.println(cartItem.getUser_id());
        if (cartItem.getUser_id() == user_id) {
            Cart updateCartItem = new Cart(id, user_id, book_id, quantity, cartItem.getCreated_date());
            if (cartDAO.updateCart(updateCartItem)) {
                System.out.println("one Cart item Successfully updated.");
//                String SuccessMessage = "One cart item has been successfully deleted.";
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
//                request.setAttribute("SuccessMessage", SuccessMessage);
//                dispatcher.forward(request, response);
                response.sendRedirect("cart");
            } else {
                System.out.println("Couldnot update cart item.");
            }
        } else {
            System.out.println("user " + user_id + " - tried to update others cart.");
        }
    }

    public void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            if (session.getAttribute("id") != null) {
                int user_id = (int) session.getAttribute("id");
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
                        String successMessage = "Hurray! Successfully updated one item in the cart.";
                        RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                        request.setAttribute("successMessage", successMessage);
                        dispatcher.forward(request, response);
                    } else {
                        System.out.println("Failed to update cart!");
                    }

                } else {
                    Cart newCart = new Cart(user_id, book_id, quantity, created_date);
                    cartDAO.insertIntoCart(newCart);
                    System.out.println("Successfully inserted into cart.");
                    String successMessage = "Hurray! Successfully added one item to the cart.";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                    request.setAttribute("successMessage", successMessage);
                    dispatcher.forward(request, response);
                }
            } else {
                String errorMessage = "Sorrry! you should log in first to add items to the cart.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorrry! you should log in first to add items to the cart.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    public void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        System.out.println("session is: " + session);
        if (session != null) {
            if (session.getAttribute("id") == null) {
                String errorMessage = "Ohh! I think you not logged in yet. Please login first.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            } else {
                int user_id = (int) session.getAttribute("id");
                List<Cart> cartItemList = cartDAO.selectCartByUserId(user_id);
                List<Books> book = bookDAO.selectAllBooks();
                RequestDispatcher dispatcher = request.getRequestDispatcher("add-to-cart.jsp");
                request.setAttribute("cartItemList", cartItemList);
                request.setAttribute("book", book);
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
