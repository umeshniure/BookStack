package com.dao;

import com.config.Config;
import com.model.BookOrder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private static final String INSERT_ORDER_SQL = "INSERT INTO book_order (id, user_id, transaction_id, shipping_postcode, order_date, order_status, transaction_satus,\n"
            + "special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,\n"
            + "shipping_city, shipping_country, order_subtotal_amount, order_total_amount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_ORDER = "select * from book_order INNER JOIN users on book_order.user_id = users.id INNER JOIN order_status ON book_order.order_status = order_status.id INNER JOIN transaction_status ON book_order.transaction_status = transaction_status.id";
    private static final String SELECT_ORDER_BY_ID = "select * from book_order INNER JOIN order_status ON book_order.order_status = order_status.order_status INNER JOIN transaction_status ON book_order.transaction_status = transaction_status.transaction_status where id=?";

    public void insertOrder(BookOrder newOrder) {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ORDER_SQL);
            ps.setString(1, newOrder.getId());
            ps.setInt(2, newOrder.getUser_id());
            ps.setString(3, newOrder.getTransaction_id());
            if (newOrder.getShipping_postcode() == null) {
                ps.setNull(4, java.sql.Types.NULL);
            } else {
                ps.setInt(4, newOrder.getShipping_postcode());
            }
            ps.setDate(5, newOrder.getOrder_date());
            ps.setInt(6, newOrder.getOrder_status());
            ps.setInt(7, newOrder.getTransaction_satus());
            ps.setString(8, newOrder.getSpecial_instruction());
            ps.setString(9, newOrder.getPayment_method());
            ps.setString(10, newOrder.getShipping_method());
            ps.setString(11, newOrder.getShipping_street());
            ps.setString(12, newOrder.getShipping_apartment());
            ps.setString(13, newOrder.getShipping_province());
            ps.setString(14, newOrder.getShipping_city());
            ps.setString(15, newOrder.getShipping_country());
            ps.setDouble(16, newOrder.getOrder_subtotal_amount());
            ps.setDouble(17, newOrder.getOrder_total_amount());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<BookOrder> selectAllOrder() {
        List<BookOrder> orderList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int user_id = rs.getInt("user_id");
                String transaction_id = rs.getString("transaction_id");
                Integer shipping_postcode = rs.getInt("shipping_postcode");
                Date order_date = rs.getDate("order_date");
                int order_status = rs.getInt("order_status");
                String order_status_name = rs.getString("order_status.order_status");
                int transaction_satus = rs.getInt("transaction_status");
                String transaction_satus_name = rs.getString("transaction_status.transaction_status");
                String special_instruction = rs.getString("special_instruction");
                String payment_method = rs.getString("payment_method");
                String shipping_method = rs.getString("shipping_method");
                String shipping_street = rs.getString("shipping_street");
                String shipping_apartment = rs.getString("shipping_apartment");
                String shipping_province = rs.getString("shipping_province");
                String shipping_city = rs.getString("shipping_city");
                String shipping_country = rs.getString("shipping_country");
                double order_subtotal_amount = rs.getDouble("order_subtotal_amount");
                double order_total_amount = rs.getDouble("order_total_amount");
                String username = rs.getString("users.firstname")+ "  " + rs.getString("users.lastname");
                orderList.add(new BookOrder(id, user_id, transaction_id, shipping_postcode, order_date, order_status, order_status_name, transaction_satus, transaction_satus_name,
                        special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,
                        shipping_city, shipping_country, order_subtotal_amount, order_total_amount, username));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderList;
    }

    public BookOrder selectOrder(String id) {
        BookOrder order = new BookOrder();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ORDER_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String transaction_id = rs.getString("transaction_id");
                Integer shipping_postcode = rs.getInt("shipping_postcode");
                Date order_date = rs.getDate("order_date");
                int order_status = rs.getInt("order_status");
                String order_status_name = rs.getString("order_status.order_status");
                int transaction_satus = rs.getInt("transaction_satus");
                String transaction_satus_name = rs.getString("transaction_statu.transaction_status");
                String special_instruction = rs.getString("special_instruction");
                String payment_method = rs.getString("payment_method");
                String shipping_method = rs.getString("shipping_method");
                String shipping_street = rs.getString("shipping_street");
                String shipping_apartment = rs.getString("shipping_apartment");
                String shipping_province = rs.getString("shipping_province");
                String shipping_city = rs.getString("shipping_city");
                String shipping_country = rs.getString("shipping_country");
                double order_subtotal_amount = rs.getDouble("order_subtotal_amount");
                double order_total_amount = rs.getDouble("order_total_amount");
                String username = "";
                order = (new BookOrder(id, user_id, transaction_id, shipping_postcode, order_date, order_status, order_status_name, transaction_satus, transaction_satus_name,
                        special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,
                        shipping_city, shipping_country, order_subtotal_amount, order_total_amount ,username));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return order;
    }

}
