package com.dao;

import com.model.Books;
import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String SELECT_ALL_BOOKS = "select * from books";
    private static final String INSERT_BOOK_SQL = "INSERT INTO books" + "  (isbn, name, author, publication, price, discounted_price,\n"
            + "                published_year, category, cover_type, language, type, description, cover_photo, cover_photo_name, vendor_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_BOOK_BY_ID = "select * from books where id =?";

    public List<Books> selectAllBooks() {
        List<Books> booklist = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long isbn = rs.getLong("isbn");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                String publication = rs.getString("publication");
                int category = rs.getInt("category");
                int cover_type = rs.getInt("cover_type");
                int language = rs.getInt("language");
                int type = rs.getInt("type");
                String description = rs.getString("description");
                String cover_photo = rs.getString("cover_photo");
                String cover_photo_name = rs.getString("cover_photo_name");
                int discounted_price = rs.getInt("discounted_price");
                int published_year = rs.getInt("published_year");
                int vendor_id = rs.getInt("vendor_id");
                booklist.add(new Books(id, isbn, name, author, publication, price, discounted_price,
                        published_year, category, cover_type, language, type, description, cover_photo, cover_photo_name, vendor_id));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return booklist;
    }

    public void insertBook(Books newBook) {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_BOOK_SQL);
            ps.setString(2, newBook.getName());
            ps.setString(3, newBook.getAuthorName());
            ps.setString(4, newBook.getPublication());
            ps.setLong(1, newBook.getISBN());
            ps.setInt(8, newBook.getCategory());
            ps.setInt(9, newBook.getCover_type());
            ps.setInt(10, newBook.getLanguage());
            ps.setString(12, newBook.getDescription());
            ps.setInt(11, newBook.getType());
            ps.setString(13, newBook.getCover_photo());
            ps.setString(14, newBook.getCover_photo_name());
            ps.setInt(15, newBook.getVendor_id());
            ps.setInt(5, newBook.getPrice());
            ps.setInt(6, newBook.getDiscounted_price());
            ps.setInt(7, newBook.getPublished_year());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Books> selectBook(int id) {
        List<Books> bookDetail = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                long isbn = rs.getLong("isbn");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                String publication = rs.getString("publication");
                int category = rs.getInt("category");
                int cover_type = rs.getInt("cover_type");
                int language = rs.getInt("language");
                int type = rs.getInt("type");
                String description = rs.getString("description");
                String cover_photo = rs.getString("cover_photo");
                String cover_photo_name = rs.getString("cover_photo_name");
                int discounted_price = rs.getInt("discounted_price");
                int published_year = rs.getInt("published_year");
                int vendor_id = rs.getInt("vendor_id");
                bookDetail.add(new Books(id, isbn, name, author, publication, price, discounted_price,
                        published_year, category, cover_type, language, type, description, cover_photo, cover_photo_name, vendor_id));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookDetail;
    }
}
