package com.codechallenge.service;

import com.codechallenge.dao.TranslationDao;
import com.codechallenge.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class TranslationService implements TranslationDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TranslationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTranslation(Translation translation) {
        String originalLang = translation.getOriginalLang();
        String translated = translation.getTranslated();
        String lang = translation.getLang();

        final String sqlStatement = "INSERT INTO translation (id,originalLang,translated,lang) " +
                "VALUES (uuid_generate_v4(), ?, ?, ?)";

        jdbcTemplate.update(sqlStatement, originalLang,translated,lang);

        return 0;
    }

    @Override
    public List<Translation> getTranslation(String originalLangArg, String langArg) {
        final String sqlStatement = "SELECT * " +
                "FROM translation WHERE originalLang = ? AND lang = ?";

        List<Translation> translations = jdbcTemplate.query(sqlStatement,
                new Object[]{originalLangArg,langArg},
                (resultSet, i) -> {

            UUID id = UUID.fromString(resultSet.getString("id"));
            String originalLang = resultSet.getString("originalLang");
            String translation = resultSet.getString("translated");
            String lang = resultSet.getString("lang");

            return new Translation(id,originalLang,translation,lang);
        });

        return translations;
    }

    @Override
    public List<Translation> getAllTranslations() {
        final String sqlStatement = "SELECT * FROM translation";
        List<Translation> allTranslations = jdbcTemplate.query(sqlStatement,(resultSet, i) -> {

            UUID id = UUID.fromString(resultSet.getString("id"));
            String originalLang = resultSet.getString("originalLang");
            String translation = resultSet.getString("translated");
            String lang = resultSet.getString("lang");

            return new Translation(id,originalLang,translation,lang);
        });
        return allTranslations;
    }
}
