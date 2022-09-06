package com.dao;

import com.model.BookType;
import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDAO {

    private static final String INSERT_BOOKTYPE = "INSERT INTO book_type (type) VALUES (?);";
    private static final String SELECT_ALL_BOOKTYPE = "select * from book_type";
    private static final String SELECT_BOOKTYPE_BY_ID = "select * from book_type where id = ?";
    private static final String UPDATE_BOOKTYPE = "UPDATE book_type SET type = ? where id = ?";
    private static final String DELETE_BOOKTYPE = "DELETE FROM book_type where id = ?;";

    public List<BookType> selectAllBookType() {
        List<BookType> bookType = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKTYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type");
                int id = rs.getInt("id");
                bookType.add(new BookType(id, type));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookType;
    }

    public BookType selectBookType(int id) {
        BookType bookType = new BookType();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKTYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String book_Type = rs.getString("type");
                id = rs.getInt("id");
                bookType = new BookType(id, book_Type);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookType;
    }

    public void insertBookType(BookType bookType) throws SQLException {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKTYPE);
            preparedStatement.setString(1, bookType.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean updateBookType(BookType bookType) {
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKTYPE);
            preparedStatement.setString(1, bookType.getType());
            preparedStatement.setInt(2, bookType.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteBookType(int id) {
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKTYPE);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }
}
