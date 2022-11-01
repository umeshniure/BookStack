/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.model.*;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;
    private UsersDAO userDAO;
    private ShippingAddressDAO addressDAO;

    public void init() {
        bookDAO = new BookDAO();
        categoryDAO = new CategoryDAO();
        userDAO = new UsersDAO();
        addressDAO = new ShippingAddressDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String path = request.getServletPath();
        String path = request.getParameter("action");
        if (path == null) {
            path = "";
        }
        System.out.println(path);
        try {
            switch (path) {
                case ("book-detail"):
                    showBookDetail(request, response);
                    break;
                case ("category"):
                    allBooksOfCategory(request, response);
                    break;
                case ("vendor"):
                    allBooksOfVendor(request, response);
                    break;
                case ("author"):
                    bookByAuthor(request, response);
                    break;
                case ("language"):
                    bookByLanguage(request, response);
                    break;
                case ("coverType"):
                    bookByCoverType(request, response);
                    break;
                case ("bookType"):
                    bookByBookType(request, response);
                    break;
                default:
                    showHome(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("catch exception page");
            System.out.println(ex);
            throw new ServletException(ex);
        }
    }

    public void showBookDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookno = request.getParameter("id");
        if (bookno.equals("")) {
            bookno = "" + 0;
        }
        int id = Integer.parseInt(bookno);
        Books bookDetail = bookDAO.selectBook(id);
        List<Books> SameCategoryBook = bookDAO.selectBookByCategory(bookDetail.getCategory());
        List<Books> SameAuthorBook = bookDAO.selectBookByAuthor(bookDetail.getAuthor());
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-detail.jsp");
        request.setAttribute("book", bookDetail);
        request.setAttribute("SameCategoryBook", SameCategoryBook);
        request.setAttribute("SameAuthorBook", SameAuthorBook);
        dispatcher.forward(request, response);
    }

    public void allBooksOfCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryID = request.getParameter("id");
        if (categoryID.equals("")) {
            categoryID = "" + 0;
        }
        int id = Integer.parseInt(categoryID);
        List<Books> bookList = bookDAO.selectBookByCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all-books.jsp");
        request.setAttribute("name", "Category");
        request.setAttribute("booklist", bookList);
        dispatcher.forward(request, response);
    }

    public void allBooksOfVendor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vendorID = request.getParameter("id");
        if (vendorID.equals("")) {
            vendorID = "" + 0;
        }
        int id = Integer.parseInt(vendorID);
        List<Books> bookList = bookDAO.selectBookByVendorID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all-books.jsp");
        request.setAttribute("name", "Seller");
        request.setAttribute("booklist", bookList);
        dispatcher.forward(request, response);
    }

    public void bookByAuthor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String authorName = request.getParameter("name");
        List<Books> bookList = bookDAO.selectBookByAuthor(authorName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all-books.jsp");
        request.setAttribute("name", "Author");
        request.setAttribute("booklist", bookList);
        dispatcher.forward(request, response);
    }

    public void bookByLanguage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String languageId = request.getParameter("id");
        if (languageId.equals("")) {
            languageId = "" + 0;
        }
        int id = Integer.parseInt(languageId);
        List<Books> bookList = bookDAO.selectBookByLanguage(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all-books.jsp");
        request.setAttribute("name", "Language");
        request.setAttribute("booklist", bookList);
        dispatcher.forward(request, response);
    }

    public void bookByCoverType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String coverId = request.getParameter("id");
        if (coverId.equals("")) {
            coverId = "" + 0;
        }
        int id = Integer.parseInt(coverId);
        List<Books> bookList = bookDAO.selectBookByCover(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all-books.jsp");
        request.setAttribute("name", "Cover type");
        request.setAttribute("booklist", bookList);
        dispatcher.forward(request, response);
    }

    public void bookByBookType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookTypeId = request.getParameter("id");
        if (bookTypeId.equals("")) {
            bookTypeId = "" + 0;
        }
        int id = Integer.parseInt(bookTypeId);
        List<Books> bookList = bookDAO.selectBookByBookType(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all-books.jsp");
        request.setAttribute("name", "Book type");
        request.setAttribute("booklist", bookList);
        dispatcher.forward(request, response);
    }

    public void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Users user = null;
        List<ShippingAddress> addresses = null;
        if (session != null) {
            if (session.getAttribute("id") != null) {
                user = userDAO.selectUser((int) session.getAttribute("id"));
                addresses = addressDAO.selectShippingAddressByUserId((int) session.getAttribute("id"));

            }
        }
        List<Books> booklist = bookDAO.selectAllBooks();
        List<Category> categoryList = categoryDAO.selectAllCategory();
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("booklist", booklist);
        request.setAttribute("addresses", addresses);
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
