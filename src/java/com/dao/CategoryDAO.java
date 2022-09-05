package com.dao;

import com.model.Category;
import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private static final String INSERT_CATEGORY = "INSERT INTO categories (category_name) VALUES (?);";
    private static final String SELECT_ALL_CATEGORY = "select * from categories";
    private static final String SELECT_CATEGORY_BY_ID = "select * from categories where id = ?";
    private static final String UPDATE_CATEGORY = "UPDATE categories set category_name=? where id = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM categories where id = ?;";

    public void insertCategory(Category category) throws SQLException {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
            preparedStatement.setString(1, category.getCategory_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Category> selectAllCategory() {
        List<Category> category = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String category_name = rs.getString("category_name");
                int id = rs.getInt("id");
                category.add(new Category(id, category_name));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return category;
    }

    public Category selectCategory(int id) {
        Category category = new Category();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String category_name = rs.getString("category_name");
                id = rs.getInt("id");
                category = new Category(id, category_name);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return category;
    }

    public boolean updateCategory(Category category) {
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY);
            preparedStatement.setString(1, category.getCategory_name());
            preparedStatement.setInt(2, category.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteCategory(int id) {
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }

}
