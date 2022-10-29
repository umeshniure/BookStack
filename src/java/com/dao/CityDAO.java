package com.dao;

import com.config.Config;
import com.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    public void insertCity(City city) throws SQLException {
        String INSERT_CITY = "INSERT INTO city (city_name) VALUES (?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITY);
            preparedStatement.setString(1, city.getCity_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<City> selectAllCity() {
        String SELECT_ALL_CITY = "SELECT * from city";
        List<City> cities = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CITY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("city_name");
                int id = rs.getInt("id");
                cities.add(new City(id, name));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cities;
    }

    public City selectCity(int id) {
        String SELECT_CITY_BY_ID = "SELECT * from city where id = ?";
        City city = new City();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CITY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String city_name = rs.getString("city_name");
                id = rs.getInt("id");
                city = new City(id, city_name);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return city;
    }

    public boolean updateCity(City city) {
        String UPDATE_CITY = "UPDATE city SET city_name=? where id = ?";
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITY);
            preparedStatement.setString(1, city.getCity_name());
            preparedStatement.setInt(2, city.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteCity(int id) {
        String DELETE_CITY = "DELETE FROM city where id = ?;";
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITY);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }
}
