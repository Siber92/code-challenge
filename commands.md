
## Docker commands
```bash
docker run --name codeC -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
docker container start codeC
docker port codeC
docker exec -it codeC bash
psql -U postgre
```

## Database commands
```SQL
CREATE TABLE Translation (
    id UUID NOT NULL PRIMARY KEY,
    originalLang VARCHAR(256) NOT NULL,
    translated VARCHAR(256) NOT NULL,
    lang VARCHAR(50) NOT NULL
);

CREATE DATABASE ccdb;
\c ccdb
\d translation
CREATE EXTENSION "uuid-ossp";
INSERT INTO translation (id,originalLang,translated,lang) VALUES (uuid_generate_v4(), 'Svenska', 'Swedish', 'en');
SELECT * FROM translation;
SELECT originalLang,lang FROM translation;
SELECT originallang,translated,lang FROM translation WHERE originalLang = 'potatis' AND lang ='sv';
DELETE FROM translation
```