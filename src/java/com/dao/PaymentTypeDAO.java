package com.dao;

import com.config.Config;
import com.model.PaymentType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDAO {

    public void insertPaymentType(PaymentType payment) throws SQLException {
        String INSERT_PAYMENT_TYPE = "INSERT INTO payment_type (payment_type) VALUES (?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_TYPE);
            preparedStatement.setString(1, payment.getPayment_type());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<PaymentType> selectAllPaymentType() {
        String SELECT_ALL_PAYMENT_TYPE = "SELECT * from payment_type";
        List<PaymentType> payment_type = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENT_TYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("payment_type");
                int id = rs.getInt("id");
                payment_type.add(new PaymentType(id, name));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return payment_type;
    }

    public PaymentType selectPaymentType(int id) {
        String SELECT_PAYMENT_TYPE_BY_ID = "SELECT * from Payment_type where id = ?";
        PaymentType payment = new PaymentType();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("payment_type");
                id = rs.getInt("id");
                payment = new PaymentType(id, name);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return payment;
    }

    public boolean updatePaymentType(PaymentType payment) {
        String UPDATE_PAYMENT_TYPE = "UPDATE payment_type SET payment_type=? where id = ?";
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_TYPE);
            preparedStatement.setString(1, payment.getPayment_type());
            preparedStatement.setInt(2, payment.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deletePaymentType(int id) {
        String DELETE_PAYMENT_TYPE = "DELETE FROM payment_type where id = ?;";
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PAYMENT_TYPE);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }
}
