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
}
