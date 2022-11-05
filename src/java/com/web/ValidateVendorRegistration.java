/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Users;
import com.dao.UsersDAO;
import com.secure.*;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "ValidateVendorRegistration", urlPatterns = {"/vendor_registration"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class ValidateVendorRegistration extends HttpServlet {

    private UsersDAO vendorsDAO;
    private CheckEmail check;
    private Encrypt encrypt;

    public void init() {
        vendorsDAO = new UsersDAO();
        check = new CheckEmail();
        encrypt = new Encrypt();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("vendor_registration.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            insertVendor(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void passValue(HttpServletRequest request, HttpServletResponse response, String store_name, long phone_number,
            String _email, String message) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("vendor_registration.jsp");
        request.setAttribute("vendorRegistrationError", message);
        request.setAttribute("store_name", store_name);
        request.setAttribute("phone_number", phone_number);
        request.setAttribute("email", _email);
        rd.forward(request, response);
    }

    public void insertVendor(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        try {
            Part pic_part = null;
            String store_name = request.getParameter("store_name");
            long phone_number = Long.parseLong(request.getParameter("phone_number"));
            String email = request.getParameter("email");
            String _password1 = request.getParameter("password1");
            String _password2 = request.getParameter("password2");
            String first_name = null;
            String last_name = null;
            int user_type = 2;
            String message;
            if (!store_name.equals("")) {
                if (!email.equals("")) {
                    if (check.emailValidity(email)) {
                        if (!_password1.equals("") && !_password2.equals("")) {
                            if (_password1.equals(_password2)) {
                                try {
                                    pic_part = request.getPart("profile_pic");
                                    //String fileName = extractFileName(pic_part);
                                    String fileName = store_name + "-profile_pic.png";
                                    String imageSavePath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\vendor_profiles" + File.separator + fileName;
                                    File fileSaveDir = new File(imageSavePath);
                                    pic_part.write(imageSavePath + File.separator);
                                    Users newVendor = new Users(first_name, last_name, store_name, phone_number, email, imageSavePath, fileName, encrypt.encryptPassword(_password1), user_type);
                                    vendorsDAO.insertUser(newVendor);
                                    RequestDispatcher dispatcher = request.getRequestDispatcher("LogIn.jsp");
                                    request.setAttribute("successMessage", "You are successfuly Registered. Please login with your registered account to continue.");
                                    dispatcher.forward(request, response);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            } else {
                                message = "Password didn't match!";
                                passValue(request, response, store_name, phone_number, email, message);
                            }
                        } else {
                            message = "Both password field should be filled!";
                            passValue(request, response, store_name, phone_number, email, message);
                        }
                    } else {
                        message = "Email format is not correct!";
                        passValue(request, response, store_name, phone_number, email, message);
                    }
                } else {
                    message = "Email field name cannot be empty!";
                    passValue(request, response, store_name, phone_number, email, message);
                }
            } else {
                message = "Store name cannot be empty!";
                passValue(request, response, store_name, phone_number, email, message);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String extractFileName(Part pic_part) {
        String contentDisp = pic_part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
