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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private UsersDAO userDAO;
    private CityDAO cityDAO;
    private ProvinceDAO provinceDAO;
    private CountryDAO countryDAO;
    private ShippingAddressDAO addressDAO;

    public void init() {
        userDAO = new UsersDAO();
        cityDAO = new CityDAO();
        provinceDAO = new ProvinceDAO();
        countryDAO = new CountryDAO();
        addressDAO = new ShippingAddressDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                String action = request.getParameter("action");
                if (action == null) {
                    action = "";
                }
                if (action.equals("deleteAddress")) {
                    deleteAddress(request, response);
                } else {
                    showUpdateProfilePage(request, response);
                }

            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
                response.sendRedirect("login");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
            response.sendRedirect("login");
        }
    }

    public void deleteAddress(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int) session.getAttribute("id");
        int id = Integer.parseInt(request.getParameter("id"));
        ShippingAddress address = addressDAO.selectShippingAddress(id, user_id);
        if (address.getId() != 0) {
            if (addressDAO.deleteShippingAddress(id)) {
                session.setAttribute("successMessage", "Your address is successfully deleted.");
                response.sendRedirect("updateProfile");
            } else {
                session.setAttribute("errorMessage", "Sorry! You address couldnot be deleted at the moment.");
                response.sendRedirect("updateProfile");
            }
        } else {
            session.setAttribute("errorMessage", "Sorry! You cannot delete others address.");
            response.sendRedirect("updateProfile");
        }
    }

    public void showUpdateProfilePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int) session.getAttribute("id");
        ShippingAddress fillAddress = null;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("fillAddress")) {
            int addressId = Integer.parseInt(request.getParameter("id"));
            fillAddress = addressDAO.selectShippingAddress(addressId, user_id);
        }
        Users user = userDAO.selectUser((int) session.getAttribute("id"));
        List<City> cities = cityDAO.selectAllCity();
        List<Province> provinces = provinceDAO.selectAllProvince();
        List<Country> countries = countryDAO.selectAllCountry();
        List<ShippingAddress> addresses = addressDAO.selectShippingAddressByUserId((int) session.getAttribute("id"));
        RequestDispatcher rd = request.getRequestDispatcher("user-profile-update-form.jsp");
        request.setAttribute("user", user);
        request.setAttribute("cities", cities);
        request.setAttribute("provinces", provinces);
        request.setAttribute("countries", countries);
        request.setAttribute("addresses", addresses);
        request.setAttribute("fillAddress", fillAddress);
        rd.forward(request, response);
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

    public void saveAddress(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            int user_id = (int) session.getAttribute("id");
            Integer postal_code;
            String temp = request.getParameter("postcode");
            if (temp == "" || temp == null) {
                postal_code = null;
            } else if (Integer.parseInt(temp) == 0) {
                postal_code = null;
            } else {
                postal_code = Integer.parseInt(temp);
            }
            String shipping_street = request.getParameter("street");
            String shipping_apartment = request.getParameter("apartment");
            int shipping_province = Integer.parseInt(request.getParameter("province"));
            int shipping_city = Integer.parseInt(request.getParameter("city"));
            int shipping_country = Integer.parseInt(request.getParameter("country"));
            String page = request.getParameter("page");
            boolean is_default = false;
            if (addressDAO.checkDefaultAddress(user_id) == 0) {
                is_default = true;
            }
            ShippingAddress Address = new ShippingAddress(user_id, shipping_street, shipping_apartment,
                    shipping_province, shipping_city, shipping_country, postal_code, is_default);
            if (addressDAO.insertshippingAddress(Address)) {
                request.getSession(false).setAttribute("successMessage", "Your address is saved successfully.");
            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorry! Your address couldnot be saved at the moment!");
            }
            if (page.equals("checkout")) {
                response.sendRedirect("order");
            } else if (page.equals("profile")) {
                response.sendRedirect("updateProfile");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAddress(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            int user_id = (int) session.getAttribute("id");
            int id = Integer.parseInt(request.getParameter("id"));
            Integer postal_code;
            String temp = request.getParameter("postcode");
            if (temp.equals("") || temp == null) {
                postal_code = null;
            } else if (Integer.parseInt(temp) == 0) {
                postal_code = null;
            } else {
                postal_code = Integer.parseInt(temp);
            }
            String shipping_street = request.getParameter("street");
            String shipping_apartment = request.getParameter("apartment");
            int shipping_province = Integer.parseInt(request.getParameter("province"));
            int shipping_city = Integer.parseInt(request.getParameter("city"));
            int shipping_country = Integer.parseInt(request.getParameter("country"));
            boolean is_default = Boolean.parseBoolean(request.getParameter("is_default"));
            ShippingAddress Address = new ShippingAddress(id, user_id, shipping_street, shipping_apartment,
                    shipping_province, shipping_city, shipping_country, postal_code, is_default);
            if (addressDAO.updateShippingAddress(Address)) {
                request.getSession(false).setAttribute("successMessage", "Your address is updated successfully.");
            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorry! Your address couldnot be updated at the moment!");
            }
            response.sendRedirect("updateProfile");
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("id") != null) {
                String action = (request.getParameter("action"));
                if (action == null) {
                    action = "";
                }
                switch (action) {
                    case "saveAddress":
                        saveAddress(request, response);
                        break;
                    case "updateAddress":
                        updateAddress(request, response);
                        break;
                    default:
                        updateProfile(request, response);
                        break;
                }
            } else {
                request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
                response.sendRedirect("login");
            }
        } else {
            request.getSession(false).setAttribute("errorMessage", "Sorrry! you should log in first to access the page.");
            response.sendRedirect("login");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
