/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.BookCoverDAO;
import com.dao.BookDAO;
import com.dao.BookTypeDAO;
import com.dao.CategoryDAO;
import com.dao.LanguageDAO;
import com.dao.UsersDAO;
import com.model.BookCover;
import com.model.BookType;
import com.model.Books;
import com.model.Category;
import com.model.Language;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "VendorBooks", urlPatterns = {"/vendorbook"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class VendorBooks extends HttpServlet {

    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;
    private LanguageDAO languageDAO;
    private BookCoverDAO bookCoverDAO;
    private BookTypeDAO bookTypeDAO;
    private UsersDAO userDAO;

    public void init() {
        bookDAO = new BookDAO();
        categoryDAO = new CategoryDAO();
        languageDAO = new LanguageDAO();
        bookCoverDAO = new BookCoverDAO();
        bookTypeDAO = new BookTypeDAO();
        userDAO = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case ("updateform"):
                    showBookUpdateForm(request, response);
                    break;
                case ("delete"):
                    deleteBook(request, response);
                    break;
                default:
                    vendorBookList(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    public void showBookUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Books book = bookDAO.selectBook(id);
        System.out.println("book id: " + book.getId());
        List<Category> categories = categoryDAO.selectAllCategory();
        List<Language> language = languageDAO.selectAllLanguage();
        List<BookCover> bookCover = bookCoverDAO.selectAllCoverType();
        List<BookType> bookType = bookTypeDAO.selectAllBookType();
        RequestDispatcher dispatcher = request.getRequestDispatcher("vendor-book-upload.jsp");
        request.setAttribute("book", book);
        request.setAttribute("categories", categories);
        request.setAttribute("language", language);
        request.setAttribute("bookCover", bookCover);
        request.setAttribute("bookType", bookType);
        request.setAttribute("action", "update");
        dispatcher.forward(request, response);
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("delete book method called");
        int id = Integer.parseInt(request.getParameter("id"));
        if (bookDAO.deleteBookById(id)) {
            response.sendRedirect("vendorbook");
        } else {
            response.sendRedirect("vendorbook");
        }
    }

    public void vendorBookList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 2) {
                    int id = (int) session.getAttribute("id");
                    List<Books> books = bookDAO.selectBookByVendorID(id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("vendor-book-list.jsp");
                    request.setAttribute("books", books);
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                    request.setAttribute("errorMessage", "Sorry! you are not authorised to access this page.");
                    dispatcher.forward(request, response);
                }
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login");
                request.setAttribute("errorMessage", "Sorry! you are not authorised. Please login to access this page.");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login");
            request.setAttribute("errorMessage", "Sorry! you are not logged in yet. Please login to access this page.");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            updateBook(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if ((int) session.getAttribute("user_type") == 2) {
                System.out.println("start");
                System.out.println(request.getParameter("id"));
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("id passed");
                String bookname = request.getParameter("bookname");
                long isbn = Long.parseLong(request.getParameter("isbn"));
                System.out.println("isbn passed");
                int price = Integer.parseInt(request.getParameter("price"));
                System.out.println("price passed");
                Integer discounted_price;
                if (request.getParameter("discounted_price") == null) {
                    discounted_price = null;
                } else if (Integer.parseInt(request.getParameter("discounted_price")) == 0) {
                    discounted_price = null;
                } else {
                    discounted_price = Integer.parseInt(request.getParameter("discounted_price"));
                }
                System.out.println("discount passed");
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
                    Part pic_part;
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
                    Books newBook = new Books(id, isbn, bookname, authorname, publication, price, discounted_price,
                            published_year, category, cover_type, language, book_type, description, imageSavePath, fileName, vendor_id);
                    bookDAO.updateBook(newBook);
                    response.sendRedirect("vendorbook");
                } catch (IOException | ServletException e) {
                    System.out.println(e);
                }
            } else {
                String errorMessage = "Sorry, You are not allowed to update book. ";
                RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorry, You are not allowed to update book. ";
            RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
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
