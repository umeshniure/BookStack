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
import com.dao.OrderDAO;
import com.dao.UsersDAO;
import com.model.BookOrder;
import com.model.Users;
import java.io.IOException;
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
@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;
    private LanguageDAO languageDAO;
    private BookCoverDAO bookCoverDAO;
    private BookTypeDAO bookTypeDAO;
    private UsersDAO userDAO;
    private CartDAO cartDAO;
    private OrderDAO orderDAO;

    public void init() {
        bookDAO = new BookDAO();
        categoryDAO = new CategoryDAO();
        languageDAO = new LanguageDAO();
        bookCoverDAO = new BookCoverDAO();
        bookTypeDAO = new BookTypeDAO();
        userDAO = new UsersDAO();
        cartDAO = new CartDAO();
        orderDAO = new OrderDAO();
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
                            default:
                                showAdminDashboard(request, response);
                                break;
                        }
                    } catch (IOException | ServletException ex) {
                        throw new ServletException(ex);
                    }

                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("home");
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

    public void showAdminDashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int noOfBooks = bookDAO.countBooks();
        int noOfVendors = userDAO.countVendors();
        int noOfUsers = userDAO.countUsers();
        int totalCarts = cartDAO.countCart();
        List<Users> vendors = userDAO.selectVendors();
        List<BookOrder> orders = orderDAO.selectAllOrder();
        System.out.println("ord4rs are: " + orders);
        RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.jsp");
        request.setAttribute("noOfBooks", noOfBooks);
        request.setAttribute("noOfVendors", noOfVendors);
        request.setAttribute("noOfUsers", noOfUsers);
        request.setAttribute("totalCarts", totalCarts);
        request.setAttribute("vendors", vendors);
        request.setAttribute("orders", orders);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
