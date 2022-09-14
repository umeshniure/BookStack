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
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                String action = request.getParameter("action");
                if (action == null) {
                    action = "";
                }
                try {
                    switch (action) {
                        case ("updateCartQuantity"):
                            updateCartQuantity(request, response);
                            break;
                        case ("remove"):
                            deleteCartItem(request, response);
                            break;
                        default:
                            showCart(request, response);
                            break;
                    }
                } catch (IOException | ServletException ex) {
                    throw new ServletException(ex);
                }
            } else {
                String errorMessage = "Sorrry! you should log in first to access the page.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorrry! you should log in first to access the page";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    public void updateCartQuantity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = (int) request.getSession(false).getAttribute("id");
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        Cart cartItem = cartDAO.selectCart(id);
        int book_id = cartItem.getBook_id();
        int quantity = 1;
        switch (type) {
            case "add":
                quantity = cartItem.getQuantity() + 1;
                break;
            case "subtract":
                quantity = cartItem.getQuantity() - 1;
                break;
            default:
                quantity = 1;
                break;
        }
        if (cartItem.getUser_id() == user_id) {
            if (quantity >= 1) {
                Cart updateCartItem = new Cart(id, user_id, book_id, quantity, cartItem.getCreated_date());
                if (cartDAO.updateCart(updateCartItem)) {
                    System.out.println("one Cart item Successfully updated.");
                    response.sendRedirect("cart");
                } else {
                    String errorMessage = "Sorry, couldnot update cart item.";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                    request.setAttribute("errorMessage", errorMessage);
                    dispatcher.forward(request, response);
                    System.out.println("Couldnot update cart item.");
                }
            } else {
                cartDAO.deleteCartById(id);
                System.out.println("one Cart item Successfully deleted.");
                response.sendRedirect("cart");
            }
        } else {
            String errorMessage = "user " + user_id + " - tried to update others cart.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
            System.out.println("user " + user_id + " - tried to update others cart.");
        }
    }

    public void deleteCartItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = (int) request.getSession(false).getAttribute("id");
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cartItem = cartDAO.selectCart(id);
        if (cartItem.getUser_id() == user_id) {
            if (cartDAO.deleteCartById(id)) {
                response.sendRedirect("cart");
            } else {
                System.out.println("Couldnot delete cart item.");
            }
        } else {
            String errorMessage = "user " + user_id + " - tried to delete others cart.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
            System.out.println("user " + user_id + " - tried to delete others cart.");
        }
    }

    public void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = (int) request.getSession(false).getAttribute("id");
        List<Cart> cartItemList = cartDAO.selectCartByUserId(user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-to-cart.jsp");
        request.setAttribute("cartItemList", cartItemList);
        dispatcher.forward(request, response);
    }

    public void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = (int) request.getSession(false).getAttribute("id");
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        int quantity = 1;
        Date created_date = new Date(System.currentTimeMillis());
        Cart cartItem = cartDAO.selectCartByBookAndUserId(book_id, user_id);
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
                String errorMessage = "Failed to update cart!";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {

                String action = request.getParameter("action");
                if (action == null) {
                    action = "";
                }
                try {
                    switch (action) {
                        case ("add-to-cart"):
                            addToCart(request, response);
                            break;
                    }
                } catch (Exception ex) {
                    throw new ServletException(ex);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
