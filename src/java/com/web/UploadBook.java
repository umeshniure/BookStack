/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Books;
import com.dao.BookDAO;
import com.web.ValidateVendorRegistration;
import com.secure.*;
import java.io.File;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "UploadBook", urlPatterns = {"/UploadBook"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class UploadBook extends HttpServlet {

    BookDAO bookDAO;
    ValidateVendorRegistration validateVendor;

    public void init() {
        bookDAO = new BookDAO();
        validateVendor = new ValidateVendorRegistration();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            insertBook(request, response);
        } catch (Exception e) {
            System.out.println(e);
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

    public void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String bookname = request.getParameter("bookname");
        long isbn = Long.parseLong(request.getParameter("isbn"));
        int price = Integer.parseInt(request.getParameter("price"));
        int discounted_price = Integer.parseInt(request.getParameter("discounted_price"));
        String category = request.getParameter("category");
        String cover_type = request.getParameter("cover_type");
        String language = request.getParameter("language");
        String book_type = request.getParameter("book_type");
        String publication = request.getParameter("publication");
        int published_year = Integer.parseInt(request.getParameter("published_year"));
        String description = request.getParameter("description");
        String cover_photo = request.getParameter("cover_photo");
        String cover_photo_name = request.getParameter("cover_photo_name");
        String authorname = request.getParameter("authorname");
        String message = "";
        try {
            Part pic_part = null;
            pic_part = request.getPart("cover_photo");
            String fileName = validateVendor.extractFileName(pic_part);
            String imageSavePath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos" + File.separator + fileName;
            File fileSaveDir = new File(imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            Books newBook = new Books(isbn, bookname, authorname, publication, price, discounted_price,
                    published_year, category, cover_type, language, book_type, description, imageSavePath, fileName);
            bookDAO.insertBook(newBook);
            response.sendRedirect("home");
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
