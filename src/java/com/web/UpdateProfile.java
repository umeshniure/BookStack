/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.UsersDAO;
import com.model.Users;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "UpdateProfile", urlPatterns = {"/updateProfile"})

@MultipartConfig(fileSizeThreshold = 1024 * 1024, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class UpdateProfile extends HttpServlet {

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

    public void updateProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (int) request.getSession(false).getAttribute("id");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String store_name = request.getParameter("store_name");
        String email = request.getParameter("email");
        long phone_number = Long.parseLong(request.getParameter("phone_number"));
        Part pic_part = request.getPart("profile_pic");
        String imageSavePath, fileName;
        Users user = userDAO.selectUser(id);
        if (pic_part.getSize() <= 0) {
            imageSavePath = user.getProfile_pic();
            fileName = user.getProfile_pic_name();
        } else {
            //String fileName = validateVendor.extractFileName(pic_part);
            fileName = firstname + "-" + lastname + "-" + id + ".png";
            //String contextPath = request.getContextPath();
            String imageFolderPath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\user_profiles";
            File fileSaveDir = new File(imageFolderPath);
            fileSaveDir.mkdir();
            imageSavePath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\user_profiles\\" + File.separator + fileName;
            System.out.println("user profile image save path: " + imageSavePath);
            pic_part.write(imageSavePath + File.separator);
        }
        Users updateUser = new Users(id, firstname, lastname, store_name, phone_number, email, imageSavePath, fileName);
        if (userDAO.updateUser(updateUser)) {
            request.getSession(false).setAttribute("successMessage", "Your profile is successfully updated.");
            response.sendRedirect("updateProfile");
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorry! Your profile couldnot be updated at the moment");
            response.sendRedirect("updateProfile");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {

                updateProfile(request, response);

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
