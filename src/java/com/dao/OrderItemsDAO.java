package com.dao;

import com.config.Config;
import com.model.OrderItems;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAO {

    private static final String INSERT_ORDER_ITEMS_SQL = "INSERT INTO order_items (id, order_id, book_id, quantity, total_price, tax_amount, shipping_amount) VALUES (?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_ORDER_ITEMS = "select * from order_items INNER JOIN books ON order_items.book_id = books.id INNER JOIN book_order ON order_items.order_id = book_order.id";
    private static final String SELECT_ORDERITEMS_BY_ID = "select * from INNER JOIN books ON order_items.book_id = books.id INNER JOIN book_order ON order_items.order_id = book_order.id where id=?";

    public void insertOrderItems(OrderItems newOrderItem) {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ORDER_ITEMS_SQL);
            ps.setInt(1, newOrderItem.getId());
            ps.setString(2, newOrderItem.getOrder_id());
            ps.setInt(3, newOrderItem.getBook_id());
            ps.setInt(4, newOrderItem.getQuantity());
            ps.setDouble(5, newOrderItem.getTotal_price());
            ps.setDouble(6, newOrderItem.getTax_amount());
            ps.setDouble(7, newOrderItem.getShipping_amount());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<OrderItems> selectAllOrderItems() {
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
                double total_price = rs.getDouble("total_price");
                double tax_amount = rs.getDouble("tax_amount");
                double shipping_amount = rs.getDouble("shipping_amount");
                orderItemList.add(new OrderItems(id, book_id, quantity, order_id, total_price, tax_amount, shipping_amount));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderItemList;
    }

    public OrderItems selectOrderItems(int id) {
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
                double total_price = rs.getDouble("total_price");
                double tax_amount = rs.getDouble("tax_amount");
                double shipping_amount = rs.getDouble("shipping_amount");
                orderItems = (new OrderItems(id, book_id, quantity, order_id, total_price, tax_amount, shipping_amount));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderItems;
    }
}