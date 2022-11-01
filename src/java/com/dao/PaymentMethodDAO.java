package com.dao;

import com.config.Config;
import com.model.PaymentMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDAO {

    public boolean insertPaymentMethod(PaymentMethod payment) throws SQLException {
        String INSERT_ADDRESS = "INSERT INTO payment_method "
                + "(user_id, payment_type_id, provider, account_number, expiry_date, is_default) "
                + "VALUES (?,?,?,?,?,?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ADDRESS);
            ps.setInt(1, payment.getUser_id());
            ps.setInt(2, payment.getPayment_type_id());
            ps.setString(3, payment.getProvider());
            ps.setString(4, payment.getAccount_number());
            ps.setDate(5, payment.getExpiry_date());
            ps.setBoolean(6, payment.getIs_default());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
//
//    public List<PaymentMethod> selectAllPaymentMethod() {
//        String SELECT_ALL_ADDRESS = "SELECT * FROM shipping_address "
//                + "INNER JOIN city ON shipping_address.city = city.id "
//                + "INNER JOIN province ON shipping_address.province = province.id "
//                + "INNER JOIN country ON shipping_address.country = country.id";
//        List<PaymentMethod> addresses = new ArrayList<>();
//        try {
//            Connection connection = Config.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int user_id = rs.getInt("user_id");
//                Integer postal_code = rs.getInt("postal_code");
//                String street = rs.getString("street");
//                String apartment = rs.getString("apartment");
//                int city = rs.getInt("city");
//                String city_name = rs.getString("city_name");
//                int province = rs.getInt("province");
//                String province_name = rs.getString("province_name");
//                int country = rs.getInt("country");
//                String country_name = rs.getString("country_name");
//                boolean is_default = rs.getBoolean("is_default");
//                addresses.add(new PaymentMethod(id, user_id, street, apartment, city, city_name, province, province_name, country, country_name, postal_code, is_default));
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return addresses;
//    }
//
//    public PaymentMethod selectPaymentMethod(int id) {
//        String SELECT_ALL_ADDRESS = "SELECT * FROM shipping_address "
//                + "INNER JOIN city ON shipping_address.city = city.id "
//                + "INNER JOIN province ON shipping_address.province = province.id "
//                + "INNER JOIN country ON shipping_address.country = country.id "
//                + "where shipping_address.id = ?";
//        PaymentMethod address = new PaymentMethod();
//        try {
//            Connection connection = Config.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                int user_id = rs.getInt("user_id");
//                Integer postal_code = rs.getInt("postal_code");
//                String street = rs.getString("street");
//                String apartment = rs.getString("apartment");
//                int city = rs.getInt("city");
//                String city_name = rs.getString("city_name");
//                int province = rs.getInt("province");
//                String province_name = rs.getString("province_name");
//                int country = rs.getInt("country");
//                String country_name = rs.getString("country_name");
//                boolean is_default = rs.getBoolean("is_default");
//                address = new PaymentMethod(id, user_id, street, apartment, city, city_name, province, province_name, country, country_name, postal_code, is_default);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return address;
//    }
//
//    public List<PaymentMethod> selectPaymentMethodByUserId(int user_id) {
//        String SELECT_ALL_ADDRESS = "SELECT * FROM shipping_address "
//                + "INNER JOIN city ON shipping_address.city = city.id "
//                + "INNER JOIN province ON shipping_address.province = province.id "
//                + "INNER JOIN country ON shipping_address.country = country.id "
//                + "where user_id = ?";
//        List<PaymentMethod> address = new ArrayList<>();
//        try {
//            Connection connection = Config.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESS);
//            preparedStatement.setInt(1, user_id);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                Integer postal_code = rs.getInt("postal_code");
//                String street = rs.getString("street");
//                String apartment = rs.getString("apartment");
//                int city = rs.getInt("city");
//                String city_name = rs.getString("city_name");
//                int province = rs.getInt("province");
//                String province_name = rs.getString("province_name");
//                int country = rs.getInt("country");
//                String country_name = rs.getString("country_name");
//                boolean is_default = rs.getBoolean("is_default");
//                address.add(new PaymentMethod(id, user_id, street, apartment, city, city_name, province, province_name, country, country_name, postal_code, is_default));
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return address;
//    }
//
//    public boolean updatePaymentMethod(PaymentMethod address) {
//        String UPDATE_ADDRESS = "UPDATE shipping_address "
//                + "SET street=?, apartment=?, city=?, province=?, postal_code=?, country=?, is_default=? "
//                + "where id = ? AND user_id=?";
//        boolean updated = false;
//        try {
//            Connection connection = Config.getConnection();
//            PreparedStatement ps = connection.prepareStatement(UPDATE_ADDRESS);
//            ps.setString(1, address.getStreet());
//            ps.setString(2, address.getApartment());
//            ps.setInt(3, address.getCity());
//            ps.setInt(4, address.getProvince());
//            ps.setInt(6, address.getCountry());
//            ps.setBoolean(7, address.getIs_default());
//            ps.setInt(8, address.getId());
//            ps.setInt(9, address.getUser_id());
//            if (address.getPostal_code() == null) {
//                ps.setNull(5, java.sql.Types.NULL);
//            } else {
//                ps.setInt(5, address.getPostal_code());
//            }
//            updated = ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return updated;
//    }
//
//    public boolean deletePaymentMethod(int id) {
//        String DELETE_ADDRESS = "DELETE FROM shipping_address where id = ?;";
//        boolean deleted = false;
//        try {
//            Connection connection = Config.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS);
//            preparedStatement.setInt(1, id);
//            deleted = preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return deleted;
//    }
//

    public int checkDefaultPaymentMethod(int user_id) {
        String CHECK_DEFAULT_PAYMENT_METHOD = "SELECT id FROM paymeny_method WHERE user_id = ? AND is_default = true;";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_DEFAULT_PAYMENT_METHOD);
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
