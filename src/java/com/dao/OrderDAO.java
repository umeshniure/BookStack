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

    public void insertOrder(BookOrder newOrder) {
        String INSERT_ORDER_SQL = "INSERT INTO book_order (id, user_id, transaction_id, shipping_postcode, order_date, order_status, transaction_status,\n"
                + "special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,\n"
                + "shipping_city, shipping_country, order_subtotal_amount, order_total_amount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
            ps.setInt(10, newOrder.getShipping_method());
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
        String SELECT_ALL_ORDER = "select * from book_order "
                + "INNER JOIN users on book_order.user_id = users.id "
                + "INNER JOIN order_status ON book_order.order_status = order_status.id "
                //                + "INNER JOIN transaction_status ON book_order.transaction_status = transaction_status.id "
                + "ORDER BY order_date DESC";
        List<BookOrder> orderList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int user_id = rs.getInt("user_id");
//                String transaction_id = rs.getString("transaction_id");
//                Integer shipping_postcode = rs.getInt("shipping_postcode");
                Date order_date = rs.getDate("order_date");
                int order_status = rs.getInt("order_status");
                String order_status_name = rs.getString("order_status.order_status");
//                int transaction_satus = rs.getInt("transaction_status");
//                String transaction_satus_name = rs.getString("transaction_status.transaction_status");
//                String special_instruction = rs.getString("special_instruction");
//                int payment_method = rs.getInt("payment_method");
//                int shipping_method = rs.getInt("shipping_method");
//                String shipping_street = rs.getString("shipping_street");
//                String shipping_apartment = rs.getString("shipping_apartment");
//                String shipping_province = rs.getString("shipping_province");
//                String shipping_city = rs.getString("shipping_city");
//                String shipping_country = rs.getString("shipping_country");
//                double order_subtotal_amount = rs.getDouble("order_subtotal_amount");
                double order_total_amount = rs.getDouble("order_total_amount");
                String username = rs.getString("users.firstname") + "  " + rs.getString("users.lastname");
//                String book_name = "";
//                String book_author = "";
                orderList.add(new BookOrder(id, user_id, order_date, order_status, order_status_name, order_total_amount, username));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderList;
    }

    public BookOrder selectOrder(String id) {
        String SELECT_ORDER_BY_ID = "select * from book_order "
                + "INNER JOIN order_status ON book_order.order_status = order_status.order_status "
                + "INNER JOIN transaction_status ON book_order.transaction_status = transaction_status.transaction_status where id=?";
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
                int transaction_satus = rs.getInt("transaction_status");
                String transaction_satus_name = rs.getString("transaction_status.transaction_status");
                String special_instruction = rs.getString("special_instruction");
                String payment_method = rs.getString("payment_method");
                int shipping_method = rs.getInt("shipping_method");
                String shipping_street = rs.getString("shipping_street");
                String shipping_apartment = rs.getString("shipping_apartment");
                String shipping_province = rs.getString("shipping_province");
                String shipping_city = rs.getString("shipping_city");
                String shipping_country = rs.getString("shipping_country");
                double order_subtotal_amount = rs.getDouble("order_subtotal_amount");
                double order_total_amount = rs.getDouble("order_total_amount");
                String username = "";
                String book_name = "";
                String book_author = "";
                order = (new BookOrder(id, user_id, transaction_id, shipping_postcode, order_date, order_status, order_status_name, transaction_satus, transaction_satus_name,
                        special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,
                        shipping_city, shipping_country, order_subtotal_amount, order_total_amount, username, book_name, book_author));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return order;
    }

    public List<BookOrder> selectOrderByVendorId(int vendorId) {
        String SELECT_ORDER_BY_VENDOR_ID = "select * from order_items "
                + "INNER JOIN book_order ON order_items.order_id = book_order.id "
                //                + "INNER JOIN order_status ON book_order.order_status = order_status.order_status "
                //            + "INNER JOIN transaction_status ON book_order.transaction_status = transaction_status.transaction_status "
                + "INNER JOIN users on book_order.user_id = users.id "
                + "INNER JOIN books ON books.id = order_items.book_id "
                + "where books.vendor_id=? ORDER BY book_order.order_date DESC";
        List<BookOrder> order = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ORDER_BY_VENDOR_ID);
            ps.setInt(1, vendorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("order_id");
                int user_id = rs.getInt("book_order.user_id");
                String transaction_id = rs.getString("transaction_id");
                Integer shipping_postcode = rs.getInt("shipping_postcode");
                Date order_date = rs.getDate("order_date");
                int order_status = rs.getInt("order_status");
//                String order_status_name = rs.getString("order_status.order_status");
                String order_status_name = "";
                int transaction_satus = rs.getInt("transaction_status");
//                String transaction_satus_name = rs.getString("transaction_status.transaction_status");
                String transaction_satus_name = "";
                String special_instruction = rs.getString("special_instruction");
                String payment_method = rs.getString("payment_method");
                int shipping_method = rs.getInt("shipping_method");
                String shipping_street = rs.getString("shipping_street");
                String shipping_apartment = rs.getString("shipping_apartment");
                String shipping_province = rs.getString("shipping_province");
                String shipping_city = rs.getString("shipping_city");
                String shipping_country = rs.getString("shipping_country");
                double order_subtotal_amount = rs.getDouble("order_subtotal_amount");
                double order_total_amount = rs.getDouble("order_total_amount");
                String username = rs.getString("users.firstname") + "  " + rs.getString("users.lastname");
                String book_name = rs.getString("books.name");
                String book_author = rs.getString("books.author");
                int quantity = rs.getInt("order_items.quantity");
                long phone_number = rs.getLong("users.phone_number");
                order.add(new BookOrder(id, user_id, transaction_id, shipping_postcode, order_date, order_status, order_status_name, transaction_satus, transaction_satus_name,
                        special_instruction, payment_method, shipping_method, shipping_street, shipping_apartment, shipping_province,
                        shipping_city, shipping_country, order_subtotal_amount, order_total_amount, username, book_name, book_author, quantity, phone_number));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return order;
    }

    public List<BookOrder> selectOrderByUserId(int user_id) {
        // user detailsl: name. email, profile pic
        // order: order id, ordered date, order subtotal, shipping address:post code, street, city, country
        // order items: book name, book cover name, quantity, book price, shipping amount
        String SELECT_ORDERITEMS_BY_ID = "select * from book_order "
                + "INNER JOIN shipping_method ON book_order.shipping_method = shipping_method.id "
//                + "INNER JOIN payment_method ON order_items.order_id = book_order.id "
                + "where book_order.user_id=? ORDER BY order_date DESC";
        List<BookOrder> orders = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ORDERITEMS_BY_ID);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                double order_total_amount = rs.getDouble("order_total_amount");
                double order_subtotal_amount = rs.getDouble("order_subtotal_amount");
                Date order_date = rs.getDate("order_date");
                Integer postalcode = rs.getInt("shipping_postcode");
                String street = rs.getString("shipping_street");
                String apartment = rs.getString("shipping_apartment");
                String city = rs.getString("shipping_city");
                String province = rs.getString("shipping_province");
                String country = rs.getString("shipping_country");
                String shipping_method_name = rs.getString("shipping_method.name");
                int shipping_method = rs.getInt("shipping_method.id");
                String payment_method = rs.getString("payment_method");
                orders.add(new BookOrder(id, order_total_amount, order_subtotal_amount, order_date, postalcode, street, apartment, city, province, country, payment_method, shipping_method, shipping_method_name));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

}
