package com.dao;

import com.config.Config;
import com.model.UserType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTypeDAO {

    private static final String SELECT_ALL_USERTYPE = "select * from user_type";
    private static final String SELECT_USERTYPE_BY_ID = "select * from user_type where id = ?";
    private static final String INSERT_USERTYPE = "INSERT INTO user_type (type) VALUES (?);";
    private static final String UPDATE_USERTYPE = "UPDATE user_type SET type = ? where id = ?";
    private static final String DELETE_USERTYPE = "DELETE FROM user_type where id = ?;";

    public List<UserType> selectAllUserType() {
        List<UserType> userType = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERTYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String user_type = rs.getString("type");
                int id = rs.getInt("id");
                userType.add(new UserType(id, user_type));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return userType;
    }

    public UserType selectUserType(int id) {
        UserType userType = new UserType();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERTYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String user_type = rs.getString("type");
                id = rs.getInt("id");
                userType = new UserType(id, user_type);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return userType;
    }

    public void insertUserType(UserType userType) throws SQLException {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERTYPE);
            preparedStatement.setString(1, userType.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean updateUserType(UserType userType) {
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERTYPE);
            preparedStatement.setString(1, userType.getType());
            preparedStatement.setInt(2, userType.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteUserType(int id) {
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERTYPE);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }
}
