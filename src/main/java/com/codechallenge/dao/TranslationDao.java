package com.codechallenge.dao;

import com.codechallenge.model.Translation;

import java.util.List;


public interface TranslationDao {

    default int insertTranslation(Translation translation) {
        return 0;
    }
    List<Translation> getTranslation(String originalLang, String lang);

    List<Translation> getAllTranslations();
}
