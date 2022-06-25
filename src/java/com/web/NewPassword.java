package com.web;

import com.config.Config;
import com.secure.Encrypt;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

    private Encrypt encrypt;

    public void init() {
        encrypt = new Encrypt();
    }

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
                try {
                    Connection con = Config.getConnection();
                    PreparedStatement pst = con.prepareStatement("update users set password = ? where email = ? ");
                    pst.setString(1, encrypt.encryptPassword(newPassword));
                    pst.setString(2, (String) session.getAttribute("email"));

                    int rowCount = pst.executeUpdate();
                    if (rowCount > 0) {
                        request.setAttribute("status", "resetSuccess");
                        dispatcher = request.getRequestDispatcher("LogIn.jsp");
                    } else {
                        request.setAttribute("status", "resetFailed");
                        dispatcher = request.getRequestDispatcher("login.jsp");
                    }
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
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
