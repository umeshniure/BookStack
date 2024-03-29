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

    public void init() {
        cartDAO = new CartDAO();
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
                request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
                response.sendRedirect("login");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page");
            response.sendRedirect("login");
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
                    request.getSession(false).setAttribute("successMessage", "One cart item is successfully updated.");
                    response.sendRedirect("cart");
                } else {
                    request.getSession(false).setAttribute("errorMessage", "Sorry, couldnot update cart item.");
                    response.sendRedirect("cart");
                }
            } else {
                cartDAO.deleteCartById(id);
                request.getSession(false).setAttribute("successMessage", "one Cart item Successfully deleted.");
                response.sendRedirect("cart");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorry, you cannot change others cart.");
            response.sendRedirect("home");
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
                request.getSession(false).setAttribute("successMessage", "One cart item is successfully deleted.");
                response.sendRedirect("cart");
            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorry, couldnot delete cart item.");
                response.sendRedirect("cart");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorry! you cannot delete others cart.");
            response.sendRedirect("home");
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
                request.getSession(false).setAttribute("successMessage", "Hurray! Successfully updated one item in the cart.");
                response.sendRedirect("home");
            } else {
                request.getSession(false).setAttribute("errorMessage", "Failed to update cart!");
                response.sendRedirect("home");
            }
        } else {
            Cart newCart = new Cart(user_id, book_id, quantity, created_date);
            cartDAO.insertIntoCart(newCart);
            request.getSession(false).setAttribute("successMessage", "Hurray! Successfully added one item to the cart.");
            response.sendRedirect("home");
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
                } catch (IOException | ServletException ex) {
                    throw new ServletException(ex);
                }

            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to add items to the cart.");
                response.sendRedirect("login");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to add items to the cart.");
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
