package com.dao;

import com.config.Config;
import com.model.Language;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAO {

    private static final String SELECT_ALL_LANGUAGE = "select * from language";
    private static final String SELECT_LANGUAGE_BY_ID = "select * from language where id = ?";

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
            while (rs.next()) {
                String language_name = rs.getString("language_name");
                id = rs.getInt("id");
                language = new Language(id, language_name);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return language;
    }
}
