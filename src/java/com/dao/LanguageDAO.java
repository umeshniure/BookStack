package com.dao;

import com.config.Config;
import com.model.Language;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAO {

    private static final String INSERT_LANGUAGE = "INSERT INTO language (language_name) VALUES (?);";
    private static final String SELECT_ALL_LANGUAGE = "select * from language";
    private static final String SELECT_LANGUAGE_BY_ID = "select * from language where id = ?";
    private static final String UPDATE_LANGUAGE = "UPDATE language SET language_name=? where id = ?";
    private static final String DELETE_LANGUAGE = "DELETE FROM language where id = ?;";

    public void insertLanguage(Language language) throws SQLException {
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LANGUAGE);
            preparedStatement.setString(1, language.getLanguage_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Language> selectAllLanguage() {
        List<Language> language = new ArrayList<>();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LANGUAGE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String language_name = rs.getString("language_name");
                int id = rs.getInt("id");
                language.add(new Language(id, language_name));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return language;
    }

    public Language selectLanguage(int id) {
        Language language = new Language();
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LANGUAGE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String language_name = rs.getString("language_name");
                id = rs.getInt("id");
                language = new Language(id, language_name);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return language;
    }

    public boolean updateLanguage(Language language) {
        boolean updated = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LANGUAGE);
            preparedStatement.setString(1, language.getLanguage_name());
            preparedStatement.setInt(2, language.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updated;
    }

    public boolean deleteLanguage(int id) {
        boolean deleted = false;
        try {
            Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LANGUAGE);
            preparedStatement.setInt(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return deleted;
    }
}
