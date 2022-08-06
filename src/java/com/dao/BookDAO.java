package com.dao;

import com.model.Books;
import com.config.Config;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static final String SELECT_ALL_BOOKS = "select * from books";

    public List<Books> selectAllBooks() {
        List<Books> booklist = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                long isbn = rs.getLong("isbn");                
                String author = rs.getString("author");
                int price = rs.getInt("price");
                String publication = rs.getString("publication");
                String category = rs.getString("category");
                booklist.add(new Books(isbn, name, author, publication, price, category));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return booklist;
    }
}
