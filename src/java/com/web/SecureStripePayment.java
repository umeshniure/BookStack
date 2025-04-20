///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.stripe.Stripe;
//import com.stripe.model.Charge;
//import com.stripe.exception.StripeException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// *
// * @author Umesh
// */
//@WebServlet(name = "SecureStripePayment", urlPatterns = {"/secureStripePayment"})
//public class SecureStripePayment extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String token = request.getParameter("stripeToken");
//        System.out.println("Token is: " + token);
//        int amount = 999; // Amount in cents (e.g., $9.99)
//
//        // Set your secret API key
//        Stripe.apiKey = "sk_test_51NCHgbAnmHEqWsDuevP5ip7QsXBFjnQVV41wVZkRWjC0LyEO80ccfJgt1U10tThqOSGh0hKnYsTpjTaJkQttSrSw00ifiM9sBK";
//
//        // Create a charge
//        try {
//            Map<String, Object> chargeParams = new HashMap<>();
//            chargeParams.put("amount", amount);
//            chargeParams.put("currency", "jpy");
//            chargeParams.put("source", token);
//
//            Charge.create(chargeParams);
//
//            // Payment successful, perform any necessary actions
//            // (e.g., update database, send email confirmation)
//            response.sendRedirect("success.jsp"); // Redirect to a success page
//        } catch (StripeException e) {
//            // Handle any Stripe-related errors
//            System.out.println("StripeException occured: " + e);
//            response.sendRedirect("error.jsp"); // Redirect to an error page
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
