package com.dao;

import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.model.Users;

public class UsersDAO {

    private static final String INSERT_VENDOR_SQL = "INSERT INTO users" + "  (firstname, lastname, store_name, email, phone_number, profile_pic, password, user_type) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,semester from vendors where id =?";
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
}
