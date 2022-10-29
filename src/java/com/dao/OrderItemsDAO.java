package com.dao;

import com.config.Config;
import com.model.OrderItems;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAO {

    public void insertOrderItems(OrderItems newOrderItem) {
        String INSERT_ORDER_ITEMS_SQL = "INSERT INTO order_items (id, order_id, book_id, quantity, unit_price, total_price, tax_amount, shipping_amount) VALUES (?,?,?,?,?,?,?,?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ORDER_ITEMS_SQL);
            ps.setInt(1, newOrderItem.getId());
            ps.setString(2, newOrderItem.getOrder_id());
            ps.setInt(3, newOrderItem.getBook_id());
            ps.setInt(4, newOrderItem.getQuantity());
            ps.setDouble(5, newOrderItem.getUnit_price());
            ps.setDouble(6, newOrderItem.getTotal_price());
            ps.setDouble(7, newOrderItem.getTax_amount());
            ps.setDouble(8, newOrderItem.getShipping_amount());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<OrderItems> selectAllOrderItems() {
        String SELECT_ALL_ORDER_ITEMS = "select * from order_items INNER JOIN books ON order_items.book_id = books.id INNER JOIN book_order ON order_items.order_id = book_order.id";
        List<OrderItems> orderItemList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ORDER_ITEMS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                String order_id = rs.getString("order_id");
                double unit_price = rs.getDouble("unit_price");
                double total_price = rs.getDouble("total_price");
                double tax_amount = rs.getDouble("tax_amount");
                double shipping_amount = rs.getDouble("shipping_amount");
                orderItemList.add(new OrderItems(id, book_id, quantity, order_id, unit_price, total_price, tax_amount, shipping_amount));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderItemList;
    }

    public OrderItems selectOrderItems(int id) {
        String SELECT_ORDERITEMS_BY_ID = "select * from order_items "
                + "INNER JOIN books ON order_items.book_id = books.id "
                + "INNER JOIN book_order ON order_items.order_id = book_order.id "
                + "where id=?";
        OrderItems orderItems = new OrderItems();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ORDERITEMS_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                String order_id = rs.getString("order_id");
                double unit_price = rs.getDouble("unit_price");
                double total_price = rs.getDouble("total_price");
                double tax_amount = rs.getDouble("tax_amount");
                double shipping_amount = rs.getDouble("shipping_amount");
                orderItems = (new OrderItems(id, book_id, quantity, order_id, unit_price, total_price, tax_amount, shipping_amount));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderItems;
    }

    public List<OrderItems> selectOrderItemsByUserId(int id) {
        // user detailsl: name. email, profile pic
        // order: order id, ordered date, order subtotal, shipping address:post code, street, city, country
        // order items: book name, book cover name, quantity, book price, shipping amount
        String SELECT_ORDERITEMS_BY_USER_ID = "SELECT * FROM order_items "
                + "INNER JOIN books ON order_items.book_id = books.id "
                + "INNER JOIN book_order ON order_items.order_id = book_order.id "
                + "where book_order.user_id=?;";
        List<OrderItems> orderItems = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ORDERITEMS_BY_USER_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                String order_id = rs.getString("order_id");
                String book_name = rs.getString("books.name");
                double book_unit_price = rs.getDouble("unit_price");
                int vendor_id = rs.getInt("books.vendor_id");
                String book_cover_name = rs.getString("books.cover_photo_name");
                double shipping_amount = rs.getDouble("shipping_amount");
                double tax_amount = rs.getDouble("tax_amount");
                orderItems.add(new OrderItems(book_id, quantity, order_id, book_name, book_unit_price, book_cover_name, vendor_id, shipping_amount, tax_amount));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderItems;
    }

}
