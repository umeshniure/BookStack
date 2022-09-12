/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.BookDAO;
import com.dao.CartDAO;
import com.dao.UsersDAO;
import com.model.*;
import com.model.Cart;
import java.io.IOException;
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
@WebServlet(name = "Checkout", urlPatterns = {"/checkout"})
public class Checkout extends HttpServlet {

    private CartDAO cartDAO;
    private BookDAO bookDAO;
    private UsersDAO userDAO;

    public void init() {
        cartDAO = new CartDAO();
        bookDAO = new BookDAO();
        userDAO = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void showCheckoutPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") == null) {
                String errorMessage = "Ohh! I think you not logged in yet. Please login first.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            } else {
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
        showCheckoutPage(request, response);
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
