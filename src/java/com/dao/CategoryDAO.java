package com.dao;

import com.model.Category;
import com.config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private static final String SELECT_ALL_CATEGORY = "select * from categories";
    private static final String SELECT_CATEGORY_BY_ID = "select * from categories where id = ?";

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

}
