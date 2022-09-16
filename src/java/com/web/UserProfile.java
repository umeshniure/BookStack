/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.UsersDAO;
import com.model.Users;
import java.io.IOException;
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
@WebServlet(name = "UserProfile", urlPatterns = {"/userProfile"})
public class UserProfile extends HttpServlet {

    UsersDAO userDAO;

    public void init() {
        userDAO = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {

                Users user = userDAO.selectUser((int) session.getAttribute("id"));
                RequestDispatcher rd = request.getRequestDispatcher("user-profile-update-form.jsp");
                request.setAttribute("user", user);
                rd.forward(request, response);

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
