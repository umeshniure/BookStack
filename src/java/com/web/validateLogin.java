package com.web;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.config.Config;
import com.dao.UsersDAO;
import com.model.Users;
import com.secure.CheckEmail;
import com.secure.Encrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
@WebServlet(name = "validateLogin", urlPatterns = {"/login"})
public class validateLogin extends HttpServlet {

    private Encrypt encrypt;
    private CheckEmail checkemail;
    private UsersDAO userDAO;

    public void init() {
        encrypt = new Encrypt();
        checkemail = new CheckEmail();
        userDAO = new UsersDAO();
    }

    public void passvalue(HttpServletRequest request, HttpServletResponse response, String _email, String message)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
        request.setAttribute("message", message);
        request.setAttribute("email", _email);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String _email = "";
        RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
        request.setAttribute("message", message);
        request.setAttribute("email", _email);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _email = request.getParameter("email");
        String _password = request.getParameter("password");
        String message;
        try {
            if (!_email.equals("") && !_password.equals("")) {
                if (checkemail.emailValidity(_email)) {
                    Users user = userDAO.selectUserByEmailAndPassword(_email, encrypt.encryptPassword(_password));
                    System.out.println(user);
                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("id", user.getId());
                        session.setAttribute("user_type", user.getUser_type());
                        if (user.getUser_type() == 1) {
                            response.sendRedirect("home");
                        } else if (user.getUser_type() == 2) {
                            response.sendRedirect("vendor-dashboard.jsp");
                        }
                    } else {
                        message = "Incorect email or password!";
                        passvalue(request, response, _email, message);
                    }
                } else {
                    message = "Invalid email format!";
                    passvalue(request, response, _email, message);
                }
            } else {
                message = "Empty email or password!";
                passvalue(request, response, _email, message);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
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
