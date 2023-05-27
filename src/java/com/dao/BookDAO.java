package com.dao;

import com.model.Books;
import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

//    private static final String SELECT_BOOK_BY_ID = "select * from books where id =?";
    //SELECT table1.*, table2.first_name FROM table1 LEFT JOIN table2
    public int countBooks() {
        String BOOK_COUNT = "SELECT count(*) FROM books";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BOOK_COUNT);
            ResultSet rs = preparedStatement.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Books> selectBooksBySearchQuery(String searchQuery) {
        List<Books> booklist = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from books INNER JOIN categories ON books.category = categories.id "
//                    + "WHERE CONTAINS(name,'" + searchQuery + "') OR CONTAINS(isbn,'" + searchQuery + "') OR CONTAINS(author,'" + searchQuery + "') "
//                    + "OR CONTAINS(category_name,'" + searchQuery + "') OR CONTAINS(description,'" + searchQuery + "');");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books INNER JOIN categories ON books.category = categories.id "
                    + "WHERE name LIKE '" + searchQuery + "' OR isbn LIKE '" + searchQuery + "' OR author LIKE '" + searchQuery + "' "
                    + "OR category_name LIKE '" + searchQuery + "' OR description LIKE '" + searchQuery + "';");
            // select * from books INNER JOIN categories ON books.category = categories.id WHERE CONTAINS(name,'') OR CONTAINS(isbn,'') OR CONTAINS(author,'') OR CONTAINS(category_name,'') OR CONTAINS(description,'');

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long isbn = rs.getLong("isbn");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                String publication = rs.getString("publication");
                int category = rs.getInt("category");
                String category_name = rs.getString("category_name");
                int cover_type = rs.getInt("cover_type");
                int language = rs.getInt("language");
                int type = rs.getInt("type");
                String description = rs.getString("description");
                String cover_photo = rs.getString("cover_photo");
                String cover_photo_name = rs.getString("cover_photo_name");
                int discounted_price = rs.getInt("discounted_price");
                int published_year = rs.getInt("published_year");
                int vendor_id = rs.getInt("vendor_id");
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String book_type = "";
                String cover = "";
                String vendor = "";
                booklist.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language, type,
                        description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return booklist;
    }

    public List<Books> selectAllBooks() {
        String SELECT_ALL_BOOKS = "select * from books INNER JOIN categories ON books.category = categories.id";
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
                String category_name = rs.getString("category_name");
                int cover_type = rs.getInt("cover_type");
                int language = rs.getInt("language");
                int type = rs.getInt("type");
                String description = rs.getString("description");
                String cover_photo = rs.getString("cover_photo");
                String cover_photo_name = rs.getString("cover_photo_name");
                int discounted_price = rs.getInt("discounted_price");
                int published_year = rs.getInt("published_year");
                int vendor_id = rs.getInt("vendor_id");
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String book_type = "";
                String cover = "";
                String vendor = "";
                booklist.add(new Books(id, isbn, name, author, publication, price, discounted_price,
                        published_year, category, cover_type, language, type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return booklist;
    }

    public boolean insertBook(Books newBook) {
        String INSERT_BOOK_SQL = "INSERT INTO books" + "  (isbn, name, author, publication, price, discounted_price,published_year, category, cover_type, \n"
                + "language, type, description, cover_photo, cover_photo_name, vendor_id, quantity) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_BOOK_SQL);
            ps.setString(2, newBook.getName());
            ps.setString(3, newBook.getAuthor());
            ps.setString(4, newBook.getPublication());
            ps.setLong(1, newBook.getIsbn());
            ps.setInt(8, newBook.getCategory());
            ps.setInt(9, newBook.getCover_type());
            ps.setInt(10, newBook.getLanguage());
            ps.setString(12, newBook.getDescription());
            ps.setInt(11, newBook.getType());
            ps.setString(13, newBook.getCover_photo());
            ps.setString(14, newBook.getCover_photo_name());
            ps.setInt(15, newBook.getVendor_id());
            ps.setInt(5, newBook.getPrice());
            ps.setInt(16, newBook.getQuantity());
            if (newBook.getDiscounted_price() == null) {
                ps.setNull(6, java.sql.Types.NULL);
            } else {
                ps.setInt(6, newBook.getDiscounted_price());
            }
            ps.setInt(7, newBook.getPublished_year());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateBook(Books newBook) {
        String UPDATE_BOOK_SQL = "UPDATE books set isbn=?, name=?, author=?, publication=?, price=?, discounted_price=?,\n"
                + "published_year=?, category=?, cover_type=?, language=?, type=?, description=?, cover_photo=?, cover_photo_name=?, vendor_id=?, quantity=? where id=?;";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK_SQL);
            ps.setLong(1, newBook.getIsbn());
            ps.setString(2, newBook.getName());
            ps.setString(3, newBook.getAuthor());
            ps.setString(4, newBook.getPublication());
            ps.setInt(5, newBook.getPrice());
            if (newBook.getDiscounted_price() == null) {
                ps.setNull(6, java.sql.Types.NULL);
            } else {
                ps.setInt(6, newBook.getDiscounted_price());
            }
            ps.setInt(7, newBook.getPublished_year());
            ps.setInt(8, newBook.getCategory());
            ps.setInt(9, newBook.getCover_type());
            ps.setInt(10, newBook.getLanguage());
            ps.setInt(11, newBook.getType());
            ps.setString(12, newBook.getDescription());
            ps.setString(13, newBook.getCover_photo());
            ps.setString(14, newBook.getCover_photo_name());
            ps.setInt(15, newBook.getVendor_id());
            ps.setInt(16, newBook.getQuantity());
            ps.setInt(17, newBook.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateQuantity(int id, int quantity) {
        String UPDATE_QUANTITY_SQL = "UPDATE books SET quantity=? WHERE id=?;";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_QUANTITY_SQL);
            if (quantity < 0) {
                quantity = 0;
            }
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public int getQuantity(int id) {
        String GET_BOOK_QUANTITY = "SELECT quantity FROM books WHERE id=?;";
        try {
            Connection connection = Config.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_BOOK_QUANTITY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public Books selectBook(int id) {
        String SELECT_BOOK_BY_ID = "select * from books INNER JOIN categories ON books.category = categories.id INNER JOIN language ON books.language = language.id "
                + "INNER JOIN book_type ON books.type = book_type.id INNER JOIN book_cover ON books.cover_type = book_cover.id INNER JOIN users ON books.vendor_id = users.id where books.id = ?";
        Books bookDetail = new Books();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
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
                int quantity = rs.getInt("quantity");

                String language_name = rs.getString("language_name");
                String category_name = rs.getString("category_name");
                String book_type = rs.getString("book_type.type");
                String cover = rs.getString("book_cover.cover_type");
                String vendor = rs.getString("store_name");
                bookDetail = (new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookDetail;
    }

    public List<Books> selectBookByVendorID(int id) {
        String SELECT_BOOK_BY_VENDOR_ID = "select * from books INNER JOIN categories ON books.category = categories.id where books.vendor_id = ?";
        List<Books> bookList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_VENDOR_ID);
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
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String category_name = rs.getString("category_name");
                String book_type = "";
                String cover = "";
                String vendor = "";
                bookList.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public List<Books> selectBookByCategory(int id) {
        String SELECT_BOOK_BY_CATEGORY = "select * from books INNER JOIN categories ON books.category = categories.id where category = ?";
        List<Books> bookList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_CATEGORY);
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
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String category_name = rs.getString("category_name");
                String book_type = "";
                String cover = "";
                String vendor = "";
                bookList.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public List<Books> selectBookByAuthor(String authorName) {
        String SELECT_BOOK_BY_AUTHOR = "select * from books INNER JOIN categories ON books.category = categories.id where author = ?";
        List<Books> bookList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_AUTHOR);
            preparedStatement.setString(1, authorName);
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
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String category_name = rs.getString("category_name");
                String book_type = "";
                String cover = "";
                String vendor = "";
                bookList.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public List<Books> selectBookByLanguage(int languageId) {
        String SELECT_BOOK_BY_LANGUAGE = "select * from books INNER JOIN categories ON books.category = categories.id where language = ?";
        List<Books> bookList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_LANGUAGE);
            preparedStatement.setInt(1, languageId);
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
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String category_name = rs.getString("category_name");
                String book_type = "";
                String cover = "";
                String vendor = "";
                bookList.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public List<Books> selectBookByCover(int coverId) {
        String SELECT_BOOK_BY_COVER = "select * from books INNER JOIN categories ON books.category = categories.id where cover_type = ?";
        List<Books> bookList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_COVER);
            preparedStatement.setInt(1, coverId);
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
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String category_name = rs.getString("category_name");
                String book_type = "";
                String cover = "";
                String vendor = "";
                bookList.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public List<Books> selectBookByBookType(int bookTypeId) {
        String SELECT_BOOK_BY_BOOKTYPE = "select * from books INNER JOIN categories ON books.category = categories.id where type = ?";
        List<Books> bookList = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_BOOKTYPE);
            preparedStatement.setInt(1, bookTypeId);
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
                int quantity = rs.getInt("quantity");

                String language_name = "";
                String category_name = rs.getString("category_name");
                String book_type = "";
                String cover = "";
                String vendor = "";
                bookList.add(new Books(id, isbn, name, author, publication, price, discounted_price, published_year, category, cover_type, language,
                        type, description, cover_photo, cover_photo_name, vendor_id, category_name, language_name, book_type, cover, vendor, quantity));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public boolean deleteBookById(int id) {
        String DELETE_BOOK_SQL = "delete from books where id = ?;";
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return deleted;
    }
}
