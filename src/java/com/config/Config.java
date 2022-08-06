package com.config;

//import com.mysql.cj.*;
import java.sql.*;

public class Config {

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/bookstack_db?";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e);
        }
        return connection;
    }
}
