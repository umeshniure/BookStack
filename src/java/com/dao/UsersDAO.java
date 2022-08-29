package com.dao;

import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.model.Users;
import java.sql.ResultSet;

public class UsersDAO {

    private static final String INSERT_VENDOR_SQL = "INSERT INTO users" + "  (firstname, lastname, store_name, email, phone_number, profile_pic, password, user_type) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id = ?";
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "select * from users where email = ? and password = ?";
    private static final String SELECT_ALL_USERS = "select * from vendors";
    private static final String DELETE_USERS_SQL = "delete from vendors where id = ?;";
    private static final String UPDATE_USERS_SQL = "update vendors set name = ?,email= ?, semester =? where id = ?;";

    public void insertUser(Users newUser) throws SQLException {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VENDOR_SQL);
            preparedStatement.setString(1, newUser.getFirstname());
            preparedStatement.setString(2, newUser.getLastname());
            preparedStatement.setString(3, newUser.getStore_name());
            preparedStatement.setString(4, newUser.getEmail());
            preparedStatement.setLong(5, newUser.getPhone_number());
            preparedStatement.setString(6, newUser.getProfile_pic());
            preparedStatement.setString(7, newUser.getPassword());
            preparedStatement.setInt(8, newUser.getUser_type());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Users selectUser(int id) {
        Users vendor = new Users();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String store_name = rs.getString("store_name");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                long phone_number = rs.getLong("phone_number");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int user_type = rs.getInt("user_type");
                String profile_pic = rs.getString("profile_pic");
                vendor = new Users(firstname, lastname, store_name, phone_number, email, profile_pic, password, user_type);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return vendor;
    }

    public Users selectUserByEmailAndPassword(String email, String password) {
        Users user = new Users();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String store_name = rs.getString("store_name");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                long phone_number = rs.getLong("phone_number");
                int user_type = rs.getInt("user_type");
                String profile_pic = rs.getString("profile_pic");
                user = new Users(id, firstname, lastname, store_name, phone_number, email, profile_pic, password, user_type);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
}
