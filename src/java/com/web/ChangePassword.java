/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.UsersDAO;
import com.secure.PasswordEncryption;
import com.secure.PasswordValidator;
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
@WebServlet(name = "ChangePassword", urlPatterns = {"/changePassword"})
public class ChangePassword extends HttpServlet {

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

                RequestDispatcher dispatcher = request.getRequestDispatcher("change-password.jsp");
                dispatcher.forward(request, response);

            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
                response.sendRedirect("login");

            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
            response.sendRedirect("login");

        }
    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (int) request.getSession(false).getAttribute("id");
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String confirm_password = request.getParameter("confirm_password");
        if (!old_password.equals("") && !new_password.equals("") && !confirm_password.equals("")) {
            if (new_password.equals(confirm_password)) {
                if (PasswordValidator.isValidPassword(confirm_password)) {
                    if (userDAO.selectUserByPassword(PasswordEncryption.encrypt(old_password), id)) {
                        if (!confirm_password.equals(old_password)) {
                            if (userDAO.changePassword(PasswordEncryption.encrypt(confirm_password), id)) {
                                RequestDispatcher dispatcher;
                                switch ((int) request.getSession(false).getAttribute("user_type")) {
                                    case 1:
                                        request.getSession(false).setAttribute("successMessage", "Your password has been successfully changed.");
                                        response.sendRedirect("home");
                                        break;
                                    case 2:
                                        request.getSession(false).setAttribute("successMessage", "Your password has been successfully changed.");
                                        response.sendRedirect("vendorDashboard");
                                        break;
                                    case 3:
                                        request.getSession(false).setAttribute("successMessage", "Your password has been successfully changed.");
                                        response.sendRedirect("adminDashboard");
                                        break;
                                }
                            } else {
                                request.getSession(false).setAttribute("errorMessage", "Sorry, password couldnot be changed at the moment.");
                                response.sendRedirect("changePassword");
                            }
                        } else {
                            String errorMessage = "Your old and new password are same. Please choose new password different from your current one.";
                            RequestDispatcher dispatcher = request.getRequestDispatcher("change-password.jsp");
                            request.setAttribute("message", errorMessage);
                            dispatcher.forward(request, response);
                        }

                    } else {
                        String errorMessage = "Sorry! your old password is incorrect.";
                        RequestDispatcher dispatcher = request.getRequestDispatcher("change-password.jsp");
                        request.setAttribute("message", errorMessage);
                        dispatcher.forward(request, response);
                    }
                } else {
                    String errorMessage = "Password must be at least 8 characters long, one capital letter, a number, and a special character.";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("change-password.jsp");
                    request.setAttribute("message", errorMessage);
                    dispatcher.forward(request, response);
                }
            } else {
                String errorMessage = "Sorry! password didnot match.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("change-password.jsp");
                request.setAttribute("message", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorry, none of the above fields can be empty.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("change-password.jsp");
            request.setAttribute("message", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {

                changePassword(request, response);

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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
