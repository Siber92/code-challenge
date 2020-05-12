CREATE TABLE Translation (
    id UUID NOT NULL PRIMARY KEY,
    originalLang VARCHAR(256) NOT NULL,
    translated VARCHAR(256) NOT NULL,
    lang VARCHAR(50) NOT NULL
);