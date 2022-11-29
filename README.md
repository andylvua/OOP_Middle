# Middle. Java web scraping API

> Team members: Andrii Yaroshevych, Pavlo Kryven

## Task

Develop the solution that will allow you to extract information about a company from its domain. Your application
should support the following information:

* Company name
* Twitter URL
* Facebook URL
* Company logo
* Company icon
* Number of employees
* Company address

## Solution

We have developed a simple web scraping API based on [Spring Boot](https://spring.io/projects/spring-boot) and [Jsoup](https://jsoup.org/).

## Usage

### General usage

The API is available at [middle-scraping-api.herokuapp.com](https://middle-scraping-api.herokuapp.com).

To get information about a company, send a GET request to the `scraping.api/scrape` endpoint with the `domain` parameter:

```bash
curl https://middle-scraping-api.herokuapp.com/scraping.api/scrape?domain={{domain}}
```

or, if you prefer to use a UI, go to [middle-scraping-api.herokuapp.com](https://middle-scraping-api.herokuapp.com/).

Here, you can enter the domain name and click the submit button to get the information about the company.

### Build locally

To build the project, run the following command:
```bash
mvn package
```

Run the tests:
```bash
mvn test
```

### Run locally

To run the project, run the following command:
```bash
mvn spring-boot:run
```

## Examples

You can find examples of the API usage in the `examples` directory.

Let's send test request to the API:


Example response:

```json
{
  "name": "GitHub",
  "twitter": "https://twitter.com/github",
  "facebook": "https://www.facebook.com/GitHub",
  "logo": "https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png",
  "icon": "https://github.githubassets.com/favicons/favicon.svg",
  "employees": "1,000+",
  "address": "88 Colin P Kelly Jr St, San Francisco, CA 94107, USA"
}
```
