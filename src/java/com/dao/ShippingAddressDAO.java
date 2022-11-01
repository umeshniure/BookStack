package com.dao;

import com.config.Config;
import com.model.ShippingAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShippingAddressDAO {

    public boolean insertshippingAddress(ShippingAddress address) throws SQLException {
        String INSERT_ADDRESS = "INSERT INTO shipping_address "
                + "(user_id, street, apartment, city, province, postal_code, country, is_default) "
                + "VALUES (?,?,?,?,?,?,?,?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ADDRESS);
            ps.setInt(1, address.getUser_id());
            ps.setString(2, address.getStreet());
            ps.setString(3, address.getApartment());
            ps.setInt(4, address.getCity());
            ps.setInt(5, address.getProvince());
            if (address.getPostal_code() == null || address.getPostal_code() == 0) {
                ps.setNull(6, java.sql.Types.NULL);
            } else {
                ps.setInt(6, address.getPostal_code());
            }
            ps.setInt(7, address.getCountry());
            ps.setBoolean(8, address.getIs_default());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<ShippingAddress> selectAllShippingAddress() {
        String SELECT_ALL_ADDRESS = "SELECT * FROM shipping_address "
                + "INNER JOIN city ON shipping_address.city = city.id "
                + "INNER JOIN province ON shipping_address.province = province.id "
                + "INNER JOIN country ON shipping_address.country = country.id";
        List<ShippingAddress> addresses = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                Integer postal_code = rs.getInt("postal_code");
                String street = rs.getString("street");
                String apartment = rs.getString("apartment");
                int city = rs.getInt("city");
                String city_name = rs.getString("city_name");
                int province = rs.getInt("province");
                String province_name = rs.getString("province_name");
                int country = rs.getInt("country");
                String country_name = rs.getString("country_name");
                boolean is_default = rs.getBoolean("is_default");
                addresses.add(new ShippingAddress(id, user_id, street, apartment, city, city_name, province, province_name, country, country_name, postal_code, is_default));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return addresses;
    }

    public ShippingAddress selectShippingAddress(int id, int user_id) {
        String SELECT_ALL_ADDRESS = "SELECT * FROM shipping_address "
                + "INNER JOIN city ON shipping_address.city = city.id "
                + "INNER JOIN province ON shipping_address.province = province.id "
                + "INNER JOIN country ON shipping_address.country = country.id "
                + "where shipping_address.id = ? AND user_id=?";
        ShippingAddress address = new ShippingAddress();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Integer postal_code = rs.getInt("postal_code");
                String street = rs.getString("street");
                String apartment = rs.getString("apartment");
                int city = rs.getInt("city");
                String city_name = rs.getString("city_name");
                int province = rs.getInt("province");
                String province_name = rs.getString("province_name");
                int country = rs.getInt("country");
                String country_name = rs.getString("country_name");
                boolean is_default = rs.getBoolean("is_default");
                address = new ShippingAddress(id, user_id, street, apartment, city, city_name, province, province_name, country, country_name, postal_code, is_default);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return address;
    }

    public List<ShippingAddress> selectShippingAddressByUserId(int user_id) {
        String SELECT_ALL_ADDRESS = "SELECT * FROM shipping_address "
                + "INNER JOIN city ON shipping_address.city = city.id "
                + "INNER JOIN province ON shipping_address.province = province.id "
                + "INNER JOIN country ON shipping_address.country = country.id "
                + "where user_id = ?";
        List<ShippingAddress> address = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Integer postal_code = rs.getInt("postal_code");
                String street = rs.getString("street");
                String apartment = rs.getString("apartment");
                int city = rs.getInt("city");
                String city_name = rs.getString("city_name");
                int province = rs.getInt("province");
                String province_name = rs.getString("province_name");
                int country = rs.getInt("country");
                String country_name = rs.getString("country_name");
                boolean is_default = rs.getBoolean("is_default");
                address.add(new ShippingAddress(id, user_id, street, apartment, city, city_name, province, province_name, country, country_name, postal_code, is_default));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return address;
    }

    public boolean updateShippingAddress(ShippingAddress address) {
        String UPDATE_ADDRESS = "UPDATE shipping_address "
                + "SET street=?, apartment=?, city=?, province=?, postal_code=?, country=?, is_default=? "
                + "WHERE id = ? AND user_id=?";
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_ADDRESS);
            ps.setString(1, address.getStreet());
            ps.setString(2, address.getApartment());
            ps.setInt(3, address.getCity());
            ps.setInt(4, address.getProvince());
            ps.setInt(6, address.getCountry());
            ps.setBoolean(7, address.getIs_default());
            ps.setInt(8, address.getId());
            ps.setInt(9, address.getUser_id());
            if (address.getPostal_code() == null) {
                ps.setNull(5, java.sql.Types.NULL);
            } else {
                ps.setInt(5, address.getPostal_code());
            }
            updated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteShippingAddress(int id) {
        String DELETE_ADDRESS = "DELETE FROM shipping_address where id = ?;";
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }

    public int checkDefaultAddress(int user_id) {
        String CHECK_DEFAULT_ADDRESS = "SELECT id FROM shipping_address where user_id = ? AND is_default = true;";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_DEFAULT_ADDRESS);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
}
