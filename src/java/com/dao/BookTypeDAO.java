package com.dao;

import com.model.BookType;
import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDAO {

    private static final String SELECT_ALL_BOOKTYPE = "select * from book_type";

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
}
