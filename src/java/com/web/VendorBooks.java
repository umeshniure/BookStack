/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.*;
import com.model.*;
import java.io.File;
import java.io.IOException;
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 2) {

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
        request.setAttribute("page", "Update book");
        dispatcher.forward(request, response);
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Books book = bookDAO.selectBook(id);
        String book_cover = book.getCover_photo();
        String book_cover_name = book.getCover_photo_name();
        if (bookDAO.deleteBookById(id)) {
//            File file = new File("../images/book_cover_photos" + book.getVendor_id() + "/" + book_cover_name);
            File file = new File(book_cover);
            if (file.delete()) {
                System.out.println("cover is also removed.");
            } else {
                System.out.println("Book cover couldnot be deleted.");
            }
            request.getSession(false).setAttribute("successMessage", "One book is successfully removed.");
            response.sendRedirect("vendorbook");
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorry, the book couldnot be deleted.");
            response.sendRedirect("vendorbook");
        }
    }

    public void vendorBookList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");
        List<Books> books = bookDAO.selectBookByVendorID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vendor-book-list.jsp");
        request.setAttribute("books", books);
        request.setAttribute("page", "My Books");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {

            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 2) {

                    try {
                        updateBook(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                } else {
                    String errorMessage = "Sorry, You are not allowed to update book. ";
                    RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
                    request.setAttribute("errorMessage", errorMessage);
                    dispatcher.forward(request, response);
                }
            } else {
                String errorMessage = "Sorry, You are not allowed to update book because you are not logged in yet.";
                RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
                request.setAttribute("errorMessage", errorMessage);
                dispatcher.forward(request, response);
            }
        } else {
            String errorMessage = "Sorry, You are not allowed to update book because you are not logged in yet.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("vendorbook");
            request.setAttribute("errorMessage", errorMessage);
            dispatcher.forward(request, response);
        }
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession(false);
        int id = Integer.parseInt(request.getParameter("id"));
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
        Books book = bookDAO.selectBook(id);
        try {
            Part pic_part = request.getPart("cover_photo");
            String imageSavePath, fileName;
            if (pic_part.getSize() <= 0) {
                imageSavePath = book.getCover_photo();
                fileName = book.getCover_photo_name();
            } else {
                //String fileName = validateVendor.extractFileName(pic_part);
                fileName = bookname + "-vendor" + vendor_id + ".png";
                //String contextPath = request.getContextPath();
                String imageFolderPath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\" + session.getAttribute("id");
                File fileSaveDir = new File(imageFolderPath);
                fileSaveDir.mkdir();
                imageSavePath = "C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\" + session.getAttribute("id") + File.separator + fileName;
                System.out.println("image save path: " + imageSavePath);
                pic_part.write(imageSavePath + File.separator);
            }
            Books newBook = new Books(id, isbn, bookname, authorname, publication, price, discounted_price,
                    published_year, category, cover_type, language, book_type, description, imageSavePath, fileName, vendor_id);
            if (bookDAO.updateBook(newBook)) {
                request.getSession(false).setAttribute("successMessage", "One book is successfully updated.");
            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorry, the book couldnot be edited");
            }
            response.sendRedirect("vendorbook");
        } catch (IOException | ServletException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
