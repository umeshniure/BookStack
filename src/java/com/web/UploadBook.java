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
import com.model.*;
import com.dao.*;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "UploadBook", urlPatterns = {"/UploadBook"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class UploadBook extends HttpServlet {

    BookDAO bookDAO;
    CategoryDAO categoryDao;
    LanguageDAO languageDAO;
    BookTypeDAO bookTypeDAO;
    BookCoverDAO bookCoverDAO;
    ValidateVendorRegistration validateVendor;

    public void init() {
        bookDAO = new BookDAO();
        categoryDao = new CategoryDAO();
        languageDAO = new LanguageDAO();
        bookTypeDAO = new BookTypeDAO();
        bookCoverDAO = new BookCoverDAO();
        validateVendor = new ValidateVendorRegistration();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                if (session.getAttribute("user_type") != null) {
                    if ((int) session.getAttribute("user_type") == 2) {

                        showBookUploadForm(request, response);

                    } else {
                        String errorMessage = "Sorry, You are not allowed to access this page.";
                        RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                        request.setAttribute("errorMessage", errorMessage);
                        dispatcher.forward(request, response);
                    }
                } else {
                    String errorMessage = "Ohh! looks like you are not logged in yet. Please login first.";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login");
                    request.setAttribute("errorMessage", errorMessage);
                    dispatcher.forward(request, response);
                }
            } else {
                String errorMessage = "Ohh! looks like you are not logged in yet. Please login first.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("login");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    public void showBookUploadForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = categoryDao.selectAllCategory();
        List<Language> language = languageDAO.selectAllLanguage();
        List<BookCover> bookCover = bookCoverDAO.selectAllCoverType();
        List<BookType> bookType = bookTypeDAO.selectAllBookType();
        RequestDispatcher rd = request.getRequestDispatcher("vendor-book-upload.jsp");
        request.setAttribute("categories", categories);
        request.setAttribute("language", language);
        request.setAttribute("bookCover", bookCover);
        request.setAttribute("bookType", bookType);
        request.setAttribute("action", "insert");
        request.setAttribute("page", "Upload book");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if ((int) session.getAttribute("user_type") == 2) {

                try {
                    insertBook(request, response);
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                String errorMessage = "Sorry, You are not allowed to upload book. ";
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorry, You are not allowed to upload book. ";
            RequestDispatcher dispatcher = request.getRequestDispatcher("home");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    public void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession(false);
        String bookname = request.getParameter("bookname");
        long isbn = Long.parseLong(request.getParameter("isbn"));
        int price = Integer.parseInt(request.getParameter("price"));
        Integer discounted_price;
        String temp = request.getParameter("discounted_price");
        if (temp.equals("")) {
            discounted_price = null;
        } else if (Integer.parseInt(temp) == 0) {
            discounted_price = null;
        } else {
            discounted_price = Integer.parseInt(temp);
        }
        int category = Integer.parseInt(request.getParameter("category"));
        int cover_type = Integer.parseInt(request.getParameter("cover_type"));
        int language = Integer.parseInt(request.getParameter("language"));
        int book_type = Integer.parseInt(request.getParameter("book_type"));
        String publication = request.getParameter("publication");
        int published_year = Integer.parseInt(request.getParameter("published_year"));
        String description = request.getParameter("description");
        String authorname = request.getParameter("authorname");
        int vendor_id = (int) session.getAttribute("id");
        try {
            Part pic_part = null;
            pic_part = request.getPart("cover_photo");
            //String fileName = validateVendor.extractFileName(pic_part);
            String fileName = bookname + "-vendor" + vendor_id + ".png";
            //String contextPath = request.getContextPath();
            String contextPath = new File("").getAbsolutePath();
            System.out.println("Context Path: " + contextPath);
            String imageFolderPath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\" + session.getAttribute("id");
            File fileSaveDir = new File(imageFolderPath);
            fileSaveDir.mkdir();
            String imageSavePath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\" + session.getAttribute("id") + File.separator + fileName;
            System.out.println("image save path: " + imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            Books newBook = new Books(isbn, bookname, authorname, publication, price, discounted_price,
                    published_year, category, cover_type, language, book_type, description, imageSavePath, fileName, vendor_id);
            System.out.println("book constructor called");
            bookDAO.insertBook(newBook);
            response.sendRedirect("UploadBook");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

