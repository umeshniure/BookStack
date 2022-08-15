package com.dao;

import com.config.Config;
import com.model.BookCover;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookCoverDAO {

    private static final String SELECT_ALL_COVERTYPE = "select * from book_cover";

    public List<BookCover> selectAllCoverType() {
        List<BookCover> bookCover = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COVERTYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String cover_type = rs.getString("cover_type");
                int id = rs.getInt("id");
                bookCover.add(new BookCover(id, cover_type));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookCover;
    }
}
