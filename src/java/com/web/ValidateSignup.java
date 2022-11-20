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
@WebServlet(name = "ValidateSignup", urlPatterns = {"/signup"})
public class ValidateSignup extends HttpServlet {

    private Encrypt encrypt;
    private CheckEmail checkemail;
    private UsersDAO userDAO;

    public void init() {
        encrypt = new Encrypt();
        checkemail = new CheckEmail();
        userDAO = new UsersDAO();
    }

    public void passValue(HttpServletRequest request, HttpServletResponse response, String _firstname, String _lastname,
            String _email, String message) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
        request.setAttribute("message", message);
        request.setAttribute("firstname", _firstname);
        request.setAttribute("lastname", _lastname);
        request.setAttribute("email", _email);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String first_name = request.getParameter("firstname");
        String last_name = request.getParameter("lastname");
        String email = request.getParameter("email");
        String _password1 = request.getParameter("password");
        String _password2 = request.getParameter("password2");
        int user_type = 1;
        String store_name = null;
        long phone_number = 0;
        String imageSavePath = null;
        String profile_pic_name = null;
        try {
            String message;
            if (!email.equals("") && !_password1.equals("") && !_password2.equals("")) {
                if (checkemail.emailValidity(email)) {
                    if (_password1.equals(_password2)) {
                        Users newuser = new Users(first_name, last_name, store_name, phone_number, email, imageSavePath, profile_pic_name, encrypt.encryptPassword(_password1), user_type);
                        if (userDAO.insertUser(newuser)) {
                            request.getSession(false).setAttribute("successMessage", "You are successfuly Registered. Please login with your registered account to continue.");
                            response.sendRedirect("login");
                        } else {
                            request.getSession(false).setAttribute("errorMessage", "Sorry! could not register at the moment.");
                            response.sendRedirect("signup");
                        }
                    } else {
                        message = "The passwords didnot match!";
                        passValue(request, response, first_name, last_name, email, message);
                    }
                } else {
                    message = "Incorrect email format!";
                    passValue(request, response, first_name, last_name, email, message);
                }
            } else {
                message = "Empty email or password!";
                passValue(request, response, first_name, last_name, email, message);
            }

        } catch (Exception e) {
            out.println(e);
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
