package com.codechallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Translation {
    private final UUID id;

    @NotBlank
    private final String originalLang;

    @NotBlank
    private final String translated;

    @NotBlank
    private final String lang;

    public Translation(UUID id,
                       @JsonProperty("originalLang") String originalLang,
                       @JsonProperty("translated") String translated,
                       @JsonProperty("lang")String lang) {
        this.id = id;
        this.originalLang = originalLang;
        this.translated = translated;
        this.lang = lang;
    }

    public UUID getId() {
        return id;
    }

    public String getOriginalLang() {
        return originalLang;
    }

    public String getTranslated() {
        return translated;
    }

    public String getLang() {
        return lang;
    }

}
