/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.*;
import com.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "AdminDatabase", urlPatterns = {"/adminDatabase"})
public class AdminDatabase extends HttpServlet {

    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;
    private LanguageDAO languageDAO;
    private BookCoverDAO bookCoverDAO;
    private BookTypeDAO bookTypeDAO;
    private UsersDAO userDAO;
    private UserTypeDAO userTypeDAO;
    private CartDAO cartDAO;

    public void init() {
        bookDAO = new BookDAO();
        categoryDAO = new CategoryDAO();
        languageDAO = new LanguageDAO();
        bookCoverDAO = new BookCoverDAO();
        bookTypeDAO = new BookTypeDAO();
        userDAO = new UsersDAO();
        userTypeDAO = new UserTypeDAO();
        cartDAO = new CartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 3) {

                    String action = request.getParameter("action");
                    if (action == null) {
                        action = "";
                    }
                    try {
                        switch (action) {
                            case ("insertCategoryForm"):
                                showCategoryInsertForm(request, response);
                                break;
                            case ("categoryUpdateForm"):
                                showCategoryUpdateForm(request, response);
                                break;
                            case ("removeCategory"):
                                deleteCategory(request, response);
                                break;
                            case ("insertLanguageForm"):
                                showLanguageInsertForm(request, response);
                                break;
                            case ("updateLanguageForm"):
                                showLanguageUpdateForm(request, response);
                                break;
                            case ("removeLanguage"):
                                deleteLanguage(request, response);
                                break;
                            case ("insertBookCoverForm"):
                                showBookCoverInsertForm(request, response);
                                break;
                            case ("updateBookCoverForm"):
                                showBookCoverUpdateForm(request, response);
                                break;
                            case ("removeBookCover"):
                                deleteBookCover(request, response);
                                break;
                            case ("insertUserTypeForm"):
                                showUserTypeInsertForm(request, response);
                                break;
                            case ("userTypeUpdateForm"):
                                showUserTypeUpdateForm(request, response);
                                break;
                            case ("removeUserType"):
                                deleteUserType(request, response);
                                break;
                            case ("insertBookTypeForm"):
                                showBookTypeInsertForm(request, response);
                                break;
                            case ("bookTypeUpdateForm"):
                                showBookTypeUpdateForm(request, response);
                                break;
                            case ("removeBookType"):
                                deleteBookType(request, response);
                                break;
                            default:
                                showDatabase(request, response);
                                break;
                        }
                    } catch (Exception ex) {
                        throw new ServletException(ex);
                    }

                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("login");
                    String errorMessage = "Sorry, you are not authorised to access this page.";
                    request.setAttribute("errorMessage", errorMessage);
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login");
                String errorMessage = "You are not logged in. please log in with admin account to access this page.";
                request.setAttribute("errorMessage", errorMessage);
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login");
            String errorMessage = "You are not logged in. please log in with admin account to access this page.";
            request.setAttribute("errorMessage", errorMessage);
            rd.forward(request, response);
        }
    }

    public void showCategoryInsertForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("category-insert-form.jsp");
        request.setAttribute("action", "insert");
        rd.forward(request, response);
    }

    public void showCategoryUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.selectCategory(id);
        RequestDispatcher rd = request.getRequestDispatcher("category-insert-form.jsp");
        request.setAttribute("category", category);
        request.setAttribute("action", "update");
        rd.forward(request, response);
    }

    public void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (categoryDAO.deleteCategory(id)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void showLanguageUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Language language = languageDAO.selectLanguage(id);
        RequestDispatcher rd = request.getRequestDispatcher("language-insert-form.jsp");
        request.setAttribute("language", language);
        request.setAttribute("action", "update");
        rd.forward(request, response);
    }

    public void showLanguageInsertForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("language-insert-form.jsp");
        request.setAttribute("action", "insert");
        rd.forward(request, response);
    }

    public void deleteLanguage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (languageDAO.deleteLanguage(id)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void showBookCoverInsertForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("bookcover-insert-form.jsp");
        request.setAttribute("action", "insert");
        rd.forward(request, response);
    }

    public void showBookCoverUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookCover bookCover = bookCoverDAO.selectBookCover(id);
        RequestDispatcher rd = request.getRequestDispatcher("bookcover-insert-form.jsp");
        request.setAttribute("bookCover", bookCover);
        request.setAttribute("action", "update");
        rd.forward(request, response);
    }

    public void deleteBookCover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (bookCoverDAO.deleteBookCoverType(id)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void showUserTypeInsertForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("usertype-insert-form.jsp");
        request.setAttribute("action", "insert");
        rd.forward(request, response);
    }

    public void showUserTypeUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserType userType = userTypeDAO.selectUserType(id);
        RequestDispatcher rd = request.getRequestDispatcher("usertype-insert-form.jsp");
        request.setAttribute("userType", userType);
        request.setAttribute("action", "update");
        rd.forward(request, response);
    }

    public void deleteUserType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (userTypeDAO.deleteUserType(id)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void showBookTypeInsertForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("booktype-insert-form.jsp");
        request.setAttribute("action", "insert");
        rd.forward(request, response);
    }

    public void showBookTypeUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookType bookType = bookTypeDAO.selectBookType(id);
        RequestDispatcher rd = request.getRequestDispatcher("booktype-insert-form.jsp");
        request.setAttribute("bookType", bookType);
        request.setAttribute("action", "update");
        rd.forward(request, response);
    }

    public void deleteBookType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (bookTypeDAO.deleteBookType(id)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void showDatabase(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categories = categoryDAO.selectAllCategory();
        List<Language> languages = languageDAO.selectAllLanguage();
        List<BookCover> bookcover = bookCoverDAO.selectAllCoverType();
        List<BookType> bookType = bookTypeDAO.selectAllBookType();
        List<UserType> userType = userTypeDAO.selectAllUserType();
        RequestDispatcher rd = request.getRequestDispatcher("admin-database-page.jsp");
        request.setAttribute("categories", categories);
        request.setAttribute("languages", languages);
        request.setAttribute("bookcover", bookcover);
        request.setAttribute("bookType", bookType);
        request.setAttribute("userType", userType);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 3) {

                    String action = request.getParameter("action");
                    System.out.println(action);
                    if (action == null) {
                        action = "";
                    }
                    try {
                        switch (action) {
                            case ("insertCategory"):
                                InsertCategory(request, response);
                                break;
                            case ("updateCategory"):
                                updateCategory(request, response);
                                break;
                            case ("insertLanguage"):
                                insertLanguage(request, response);
                                break;
                            case ("updateLanguage"):
                                updateLanguage(request, response);
                                break;
                            case ("insertBookCoverType"):
                                insertBookCover(request, response);
                                break;
                            case ("updateBookCoverType"):
                                updateBookCover(request, response);
                                break;
                            case ("insertUserType"):
                                insertUserType(request, response);
                                break;
                            case ("updateUserType"):
                                updateUserType(request, response);
                                break;
                            case ("insertBookType"):
                                insertBookType(request, response);
                                break;
                            case ("updateBookType"):
                                updateBookType(request, response);
                                break;
                        }
                    } catch (Exception ex) {
                        throw new ServletException(ex);
                    }

                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("login");
                    String errorMessage = "Sorry, you are not authorised to access this page.";
                    request.setAttribute("errorMessage", errorMessage);
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login");
                String errorMessage = "You are not logged in. please log in with admin account to access this page.";
                request.setAttribute("errorMessage", errorMessage);
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login");
            String errorMessage = "You are not logged in. please log in with admin account to access this page.";
            request.setAttribute("errorMessage", errorMessage);
            rd.forward(request, response);
        }
    }

    public void InsertCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String category_name = request.getParameter("category");
        Category category = new Category(category_name);
        categoryDAO.insertCategory(category);
        response.sendRedirect("adminDatabase");
    }

    public void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String category_name = request.getParameter("category");
        Category category = new Category(id, category_name);
        if (categoryDAO.updateCategory(category)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void insertLanguage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String language_name = request.getParameter("language");
        Language language = new Language(language_name);
        languageDAO.insertLanguage(language);
        response.sendRedirect("adminDatabase");
    }

    public void updateLanguage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String language_name = request.getParameter("language");
        Language language = new Language(id, language_name);
        if (languageDAO.updateLanguage(language)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void insertBookCover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String cover_type = request.getParameter("bookCover");
        BookCover cover = new BookCover(cover_type);
        bookCoverDAO.insertBookCoverType(cover);
        response.sendRedirect("adminDatabase");
    }

    public void updateBookCover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String bookCover = request.getParameter("bookCover");
        BookCover cover = new BookCover(id, bookCover);
        if (bookCoverDAO.updateBookCoverType(cover)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void insertUserType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String user_type = request.getParameter("userType");
        UserType userType = new UserType(user_type);
        userTypeDAO.insertUserType(userType);
        response.sendRedirect("adminDatabase");
    }

    public void updateUserType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String user_type = request.getParameter("userType");
        UserType userType = new UserType(id, user_type);
        if (userTypeDAO.updateUserType(userType)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    public void insertBookType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String book_type = request.getParameter("bookType");
        BookType bookType = new BookType(book_type);
        bookTypeDAO.insertBookType(bookType);
        response.sendRedirect("adminDatabase");
    }

    public void updateBookType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String book_type = request.getParameter("bookType");
        BookType bookType = new BookType(id, book_type);
        if (bookTypeDAO.updateBookType(bookType)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
