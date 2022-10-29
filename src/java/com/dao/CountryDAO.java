package com.dao;

import com.config.Config;
import com.model.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public void insertCountry(Country country) throws SQLException {
        String INSERT_COUNTRY = "INSERT INTO country (country_name) VALUES (?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY);
            preparedStatement.setString(1, country.getCountry_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Country> selectAllCountry() {
        String SELECT_ALL_COUNTRY = "SELECT * from country";
        List<Country> country = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("country_name");
                int id = rs.getInt("id");
                country.add(new Country(id, name));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return country;
    }

    public Country selectCountry(int id) {
        String SELECT_COUNTRY_BY_ID = "SELECT * from country where id = ?";
        Country country = new Country();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("country_name");
                id = rs.getInt("id");
                country = new Country(id, name);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return country;
    }

    public boolean updateProvince(Country country) {
        String UPDATE_COUNTRY = "UPDATE country SET country_name=? where id = ?";
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COUNTRY);
            preparedStatement.setString(1, country.getCountry_name());
            preparedStatement.setInt(2, country.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteProvince(int id) {
        String DELETE_PROVINCE = "DELETE FROM country where id = ?;";
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
