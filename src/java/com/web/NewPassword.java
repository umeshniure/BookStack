package com.web;

import com.config.Config;
import com.secure.OldEncrypt;
import com.secure.PasswordEncryption;
import com.secure.PasswordValidator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        RequestDispatcher dispatcher = null;
        if (!newPassword.equals("") && !confPassword.equals("")) {
            if (newPassword.equals(confPassword)) {
                if (PasswordValidator.isValidPassword(confPassword)) {
                    try {
                        Connection con = Config.getConnection();
                        PreparedStatement pst = con.prepareStatement("update users set password = ? where email = ? ");
                        pst.setString(1, PasswordEncryption.encrypt(newPassword));
                        pst.setString(2, (String) session.getAttribute("email"));

                        int rowCount = pst.executeUpdate();
                        if (rowCount > 0) {
                            request.getSession(false).setAttribute("successMessage", "Your password is successfully reset. Please login with your new password.");
                            response.sendRedirect("login");
                        } else {
                            request.getSession(false).setAttribute("errorMessage", "Sorry! your password couldnot be reset at the moment.");
                            response.sendRedirect("login");
                        }
                        dispatcher.forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    request.setAttribute("message", "Password must be at least 8 characters long, one capital letter, a number, and a special character.");
                    dispatcher = request.getRequestDispatcher("newPassword.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("message", "Password mismatched!");
                dispatcher = request.getRequestDispatcher("newPassword.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("message", "Empty password field!");
            dispatcher = request.getRequestDispatcher("newPassword.jsp");
            dispatcher.forward(request, response);
        }
    }

}
