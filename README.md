# code-challenge
## REST-API server using spring boot with postgres database.

## Usage
[http://localhost:8090/translations](http://localhost:8090/translations)
Can send a GET request for all translations.

[http://localhost:8090/translations/en/bok](http://localhost:8090/translations/en/bok)
Sends a GET request to fetch the english translation of "bok".

[http://localhost:8090/translations](http://localhost:8090/translations)
Can send a POST request to add a translation.
Example:
```json
{
	"originalLang": "bok",
	"translated": "book",
	"lang": "en"
}
```