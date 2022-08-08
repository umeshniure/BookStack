package com.dao;

import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.model.Vendors;

public class VendorsDAO {

    private static final String INSERT_VENDOR_SQL = "INSERT INTO vendors" + "  (store_name, email, phone_number, profile_pic, password) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,semester from vendors where id =?";
    private static final String SELECT_ALL_USERS = "select * from vendors";
    private static final String DELETE_USERS_SQL = "delete from vendors where id = ?;";
    private static final String UPDATE_USERS_SQL = "update vendors set name = ?,email= ?, semester =? where id = ?;";

    public void insertVendor(Vendors newVendor) throws SQLException {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VENDOR_SQL);
            preparedStatement.setString(1, newVendor.getStore_name());
            preparedStatement.setString(2, newVendor.getEmail());
            preparedStatement.setLong(3, newVendor.getPhone_number());
            preparedStatement.setString(4, newVendor.getProfile_pic());
            preparedStatement.setString(5, newVendor.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
