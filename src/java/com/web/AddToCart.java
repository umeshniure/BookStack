/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.model.Books;
import java.io.IOException;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("servlet path = " + path);
        try {
            switch (path) {
                case ("/add-to-cart"):
                    addToCart(request, response);
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

    }

    public void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        List<Books> booklist = bookDAO.selectAllBooks();
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-to-cart.jsp");
//        request.setAttribute("booklist", booklist);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
