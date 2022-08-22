package com.dao;

import com.config.Config;
import com.model.Cart;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    private static final String INSERT_INTO_CART = "INSERT INTO cart" + "  (user_id, book_id, quantity, created_date) VALUES " + " (?, ?, ?, ?);";
    private static final String SELECT_ALL_CART = "select * from cart";
    private static final String SELECT_CART_BY_ID = "select * from cart where id = ?";
    private static final String SELECT_CART_BY_USER_ID = "select * from cart where user_id = ?";
    private static final String SELECT_CART_BY_BOOK_AND_USER_ID = "select * from cart where user_id = ? and book_id = ?";
    private static final String UPDATE_CART = "update cart set user_id = ?,book_id = ?, quantity = ?, created_date = ? where id = ?;";
    private static final String DELETE_CART_ITEM = "delete from cart where id = ?;";

    public List<Cart> selectAllCart() {
        List<Cart> allCart = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CART);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                Date created_date = rs.getDate("created_date");
                allCart.add(new Cart(id, user_id, book_id, quantity, created_date));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return allCart;
    }

    public Cart selectCart(int id) {
        Cart cartItem = new Cart();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                Date created_date = rs.getDate("created_date");
                cartItem = new Cart(id, user_id, book_id, quantity, created_date);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cartItem;
    }

    public List<Cart> selectCartByUserId(int user_id) {
        List<Cart> userCart = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_USER_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                Date created_date = rs.getDate("created_date");
                userCart.add(new Cart(id, user_id, book_id, quantity, created_date));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return userCart;
    }

    public Cart selectCartByBookAndUserId(int book_id, int user_id) {
        Cart cartItem = new Cart();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_BOOK_AND_USER_ID);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, book_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                Date created_date = rs.getDate("created_date");
                cartItem = new Cart(id, user_id, book_id, quantity, created_date);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cartItem;
    }

    public void insertIntoCart(Cart newCartItem) {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CART);
            preparedStatement.setInt(1, newCartItem.getUser_id());
            preparedStatement.setInt(2, newCartItem.getBook_id());
            preparedStatement.setInt(3, newCartItem.getQuantity());
            preparedStatement.setDate(4, newCartItem.getCreated_date());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updateCart(Cart cartUpdate) {
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART);
            preparedStatement.setInt(1, cartUpdate.getUser_id());
            preparedStatement.setInt(2, cartUpdate.getBook_id());
            preparedStatement.setInt(3, cartUpdate.getQuantity());
            preparedStatement.setDate(4, cartUpdate.getCreated_date());
            preparedStatement.setInt(5, cartUpdate.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteCartById(int id) {
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_ITEM);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
            System.out.println("cart deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        return deleted;
    }
}
