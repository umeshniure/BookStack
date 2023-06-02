package com.web;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.dao.UsersDAO;
import com.model.Users;
import com.secure.CheckEmail;
import com.secure.PasswordEncryption;
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
@WebServlet(name = "validateLogin", urlPatterns = {"/login"})
public class validateLogin extends HttpServlet {

    private CheckEmail checkemail;
    private UsersDAO userDAO;

    public void init() {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        validateNormalLogin(request, response);
    }

    public void validateNormalLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _email = request.getParameter("email");
        String _password = request.getParameter("password");
        String message;
        try {
            if (!_email.equals("") && !_password.equals("")) {
                if (checkemail.isEmailValid(_email)) {
                    Users user = userDAO.selectUserByEmailAndPassword(_email, PasswordEncryption.encrypt(_password));
                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("id", user.getId());
                        session.setAttribute("user_type", user.getUser_type());
                        switch (user.getUser_type()) {
                            case 1:
                                request.getSession(false).setAttribute("successMessage", "Hello " + user.getFirstname() + ", welcome back to BookStack!");
                                response.sendRedirect("home");
                                break;
                            case 2:
                                request.getSession(false).setAttribute("successMessage", "Welcome vendor! you are successfully logged in.");
                                response.sendRedirect("vendorbook");
                                break;
                            case 3:
                                request.getSession(false).setAttribute("successMessage", "Hello admin! You are successfully logged in.");
                                response.sendRedirect("admin");
                                break;
                            default:
                                request.getSession(false).setAttribute("successMessage", "Hello " + user.getFirstname() + ", welcome back to BookStack!");
                                response.sendRedirect("home");
                                break;
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

        } catch (IOException | ServletException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
