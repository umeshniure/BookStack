package com.web;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.config.Config;
import com.secure.CheckEmail;
import com.secure.Encrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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

    public void init() {
        encrypt = new Encrypt();
        checkemail = new CheckEmail();
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String _firstname = "";
        String _lastname = "";
        String _email = "";
        RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
        request.setAttribute("message", message);
        request.setAttribute("firstname", _firstname);
        request.setAttribute("lastname", _lastname);
        request.setAttribute("email", _email);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String _firstname = request.getParameter("firstname");
        String _lastname = request.getParameter("lastname");
        String _email = request.getParameter("email");
        String _password1 = request.getParameter("password");
        String _password2 = request.getParameter("password2");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = Config.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into users(firstname, lastname, email, password ) values(?,?,?,?)");
            String message = " ";

            RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
            if (!_email.equals("") && !_password1.equals("") && !_password2.equals("")) {
                if (checkemail.emailValidity(_email)) {
                    if (_password1.equals(_password2)) {
                        out.println(_firstname);
                        stmt.setString(1, _firstname);
                        stmt.setString(2, _lastname);
                        stmt.setString(3, _email);
                        stmt.setString(4, encrypt.encryptPassword(_password1));
                        int status = stmt.executeUpdate();
                        if (status > 0) {
                            out.print("Successfully registered!");
                        }
                    } else {
                        message = "The passwords didnot match!";
                        passValue(request, response, _firstname, _lastname, _email, message);
                    }
                } else {
                    message = "Invalid email address!";
                    passValue(request, response, _firstname, _lastname, _email, message);
                }
            } else {
                message = "Empty email or password!";
                passValue(request, response, _firstname, _lastname, _email, message);
            }
            con.close();

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
