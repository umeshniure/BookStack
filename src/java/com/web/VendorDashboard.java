/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.*;
import com.model.*;
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
@WebServlet(name = "VendorDashboard", urlPatterns = {"/vendorDashboard"})
public class VendorDashboard extends HttpServlet {

    UsersDAO userDAO;
    OrderDAO orderDAO;

    public void init() {
        userDAO = new UsersDAO();
        orderDAO = new OrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 2) {
                    String action = request.getParameter("action");
                    if (action == null) {
                        action = "";
                    }
                    switch (action) {
                        case ("orders"):
                            ShowVendorOrderPage(request, response);
                            break;
                        default:
                            showDashboard(request, response);
                            break;
                    }
                } else {
                    String errorMessage = "Sorry, You are not allowed to update book. ";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
                    request.setAttribute("errorMessage", errorMessage);
                    dispatcher.forward(request, response);
                }
            } else {
                String errorMessage = "Sorry, You are not allowed to update book because you are not logged in yet.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorry, You are not allowed to update book because you are not logged in yet.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    protected void ShowVendorOrderPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");
        Users vendor = userDAO.selectUser(id);
        List<BookOrder> orders = orderDAO.selectOrderByVendorId(id);
        System.out.print(orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vendor-order-page.jsp");
        request.setAttribute("vendor", vendor);
        request.setAttribute("orders", orders);
        request.setAttribute("page", "Orders");
        dispatcher.forward(request, response);
    }

    protected void showDashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");
        Users vendor = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vendor-dashboard.jsp");
        request.setAttribute("vendor", vendor);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
