/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dao.BookCoverDAO;
import com.dao.BookDAO;
import com.dao.BookTypeDAO;
import com.dao.CartDAO;
import com.dao.CategoryDAO;
import com.dao.LanguageDAO;
import com.dao.UsersDAO;
import com.model.Category;
import com.model.Language;
import com.model.Users;
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
    private CartDAO cartDAO;

    public void init() {
        bookDAO = new BookDAO();
        categoryDAO = new CategoryDAO();
        languageDAO = new LanguageDAO();
        bookCoverDAO = new BookCoverDAO();
        bookTypeDAO = new BookTypeDAO();
        userDAO = new UsersDAO();
        cartDAO = new CartDAO();
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
                default:
                    showDatabase(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
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

    public void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (categoryDAO.deleteCategory(id)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
        }
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

    public void showDatabase(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                if ((int) session.getAttribute("user_type") == 3) {
                    List<Category> categories = categoryDAO.selectAllCategory();
                    List<Language> languages = languageDAO.selectAllLanguage();
                    RequestDispatcher rd = request.getRequestDispatcher("admin-database-page.jsp");
                    request.setAttribute("categories", categories);
                    request.setAttribute("languages", languages);
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
                    String errorMessage = "Sorry, you are not authorised to access this page.";
                    request.setAttribute("errorMessage", errorMessage);
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
                String errorMessage = "You are not logged in. please log in with admin account to access this page.";
                request.setAttribute("errorMessage", errorMessage);
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
            String errorMessage = "You are not logged in. please log in with admin account to access this page.";
            request.setAttribute("errorMessage", errorMessage);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
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
        System.out.println("post update method entered.");
        System.out.println(request.getParameter("category"));
        System.out.println(request.getParameter("id"));
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
        System.out.println(request.getParameter("language"));
        System.out.println(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
        String language_name = request.getParameter("language");
        Language language = new Language(id, language_name);
        if (languageDAO.updateLanguage(language)) {
            response.sendRedirect("adminDatabase");
        } else {
            response.sendRedirect("adminDatabase");
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
