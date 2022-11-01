package com.dao;

import com.config.Config;
import com.model.Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDAO {

    public void insertProvince(Province province) throws SQLException {
        String INSERT_PROVINCE = "INSERT INTO province (province_name) VALUES (?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROVINCE);
            preparedStatement.setString(1, province.getProvince_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Province> selectAllProvince() {
        String SELECT_ALL_PROVINCE = "select * from province";
        List<Province> province = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROVINCE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("province_name");
                int id = rs.getInt("id");
                province.add(new Province(id, name));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return province;
    }

    public Province selectProvince(int id) {
        String SELECT_PROVINCE_BY_ID = "select * from province where id = ?";
        Province province = new Province();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROVINCE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("province_name");
                id = rs.getInt("id");
                province = new Province(id, name);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return province;
    }

    public boolean updateProvince(Province province) {
        String UPDATE_PROVINCE = "UPDATE province SET province_name=? where id = ?";
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROVINCE);
            preparedStatement.setString(1, province.getProvince_name());
            preparedStatement.setInt(2, province.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteProvince(int id) {
        String DELETE_PROVINCE = "DELETE FROM province where id = ?;";
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROVINCE);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }
}
