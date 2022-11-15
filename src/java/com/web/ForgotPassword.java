package com.web;

import com.secure.CheckEmail;
import com.config.Config;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {

    private CheckEmail checkemail;

    public void init() {
        checkemail = new CheckEmail();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = "";
        RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
        request.setAttribute("email", email);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        RequestDispatcher dispatcher;
        if (email.equals("")) {
            dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
            request.setAttribute("email", email);
            request.setAttribute("message", "Empty email address!");
            dispatcher.forward(request, response);
        }
        if (!checkemail.emailValidity(email)) {
            dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
            request.setAttribute("email", email);
            request.setAttribute("message", "Incorrect email format!");
            dispatcher.forward(request, response);
        }

        String hostemail = "info@bookstack.com";
        int otpvalue = 0;
        HttpSession mySession = request.getSession();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select email from users where email = '" + email + "' ");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Random rand = new Random();
                otpvalue = rand.nextInt(1255650);

                String to = email;// change accordingly
                // Get the session object
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.mailtrap.io");
                props.put("mail.smtp.socketFactory.port", "2525");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "2525");
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("12ab69c0e5faab", "5b582a23f69edb");// Put your email
                        // id and
                        // password here
                    }
                });
                // compose message
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(hostemail));// change accordingly
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("OTP code");
                    message.setText("you have requested OTP to reset your password. "
                            + "your OTP is: " + otpvalue
                            + " Enter above OTP to reset your password. "
                            + "Bookstack team. "
                            + "With Regards!");
                    // send message
                    Transport.send(message);
                    System.out.println("message sent successfully");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
                request.setAttribute("message", "OTP is sent to your email ID.");
                //request.setAttribute("connection", con);
                mySession.setAttribute("otp", otpvalue);
                mySession.setAttribute("email", email);
                dispatcher.forward(request, response);
                //request.setAttribute("status", "success");

            } else {
                dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
                request.setAttribute("email", email);
                request.setAttribute("message", "The entered email address is not registered!");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
