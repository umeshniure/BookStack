/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;
import com.dao.BookDAO;
import com.model.Books;
import java.sql.SQLException;

/**
 *
 * @author Umesh
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("servlet path = " + action);
        try {
            switch (action) {
                case ("/book-detail"):
                    showBookDetail(request, response);
                    break;
//                case ("/insert"):
//                    insertUser(request, response);
//                    break;
//                case ("/delete"):
//                    deleteUser(request, response);
//                    break;
//                case ("/edit"):
//                    showEditForm(request, response);
//                    break;
//                case ("/update"):
//                    updateUser(request, response);
//                    break;
                default:
                    showHome(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void showBookDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Books> bookDetail = bookDAO.selectBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-detail.jsp");
        request.setAttribute("listUser", bookDetail);
        dispatcher.forward(request, response);
    }

    public void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Session : " + request.getSession(false));
        List<Books> booklist = bookDAO.selectAllBooks();
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        request.setAttribute("booklist", booklist);
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
