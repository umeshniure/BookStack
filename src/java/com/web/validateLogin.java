package com.web;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.dao.UsersDAO;
import com.model.Users;
import com.secure.CheckEmail;
import com.secure.Encrypt;
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

    @Override
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
        String loginType = request.getParameter("loginType");
        if (loginType.equals("normalLogin")) {
            normalLogin(request, response);
        } else {
//            loginWithGoogle(request, response);
        }
    }

//    public void loginWithGoogle(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//
//        try {
//            String idToken = request.getParameter("id_token");
//            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
//            String name = (String) payLoad.get("name");
//            String email = payLoad.getEmail();
//            System.out.println("User name: " + name);
//            System.out.println("User email: " + email);
//
//            HttpSession session = request.getSession(true);
//            session.setAttribute("userName", name);
//            request.getServletContext()
//                    .getRequestDispatcher("/welcome-page.jsp").forward(request, response);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void normalLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _email = request.getParameter("email");
        String _password = request.getParameter("password");
        String message;
        try {
            if (!_email.equals("") && !_password.equals("")) {
                if (checkemail.emailValidity(_email)) {
                    Users user = userDAO.selectUserByEmailAndPassword(_email, encrypt.encryptPassword(_password));
                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("id", user.getId());
                        session.setAttribute("user_type", user.getUser_type());
                        switch (user.getUser_type()) {
                            case 1:
                                RequestDispatcher rd = request.getRequestDispatcher("home");
                                request.setAttribute("successMessage", "Welcome to BookStack! you are successfully logged in.");
                                rd.forward(request, response);
                                break;
                            case 2:
                                request.getSession(false).setAttribute("successMessage", "Welcome vendor! you are successfully logged in.");
                                response.sendRedirect("vendor-dashboard.jsp");
                                break;
                            case 3:
                                request.getSession(false).setAttribute("successMessage", "You are successfully logged in.");
                                response.sendRedirect("admin");
                                break;
                            default:
                                RequestDispatcher rd2 = request.getRequestDispatcher("home");
                                request.setAttribute("successMessage", "Welcome to BookStack! you are successfully logged in.");
                                rd2.forward(request, response);
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
