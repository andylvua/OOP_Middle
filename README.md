# Middle. Java web scraping API

[![Java CI with Maven](https://github.com/andylvua/OOP_Middle/actions/workflows/maven.yml/badge.svg)](https://github.com/andylvua/OOP_Middle/actions/workflows/maven.yml)
> Team members: Andrii Yaroshevych, Pavlo Kryven, Nazar Demchuk, Tymur Krasnianskyi

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

We have developed a simple web scraping API based on [Spring Boot](https://spring.io/projects/spring-boot) and [Jsoup](https://jsoup.org/)

### Diagrams and used patterns

Diagram of the project structure, use case diagram, and description of the used patterns are available in the [tasks](tasks) folder.

## Usage

### General usage

The API is available at [middle-scraping-api.herokuapp.com](https://middle-scraping-api.herokuapp.com).

To get information about a company, send a GET request to the `scraping.api/scrape` endpoint with the `domain` parameter:

```bash
curl https://middle-scraping-api.herokuapp.com/scraping.api/scrape?domain={{domain}}
```

or, if you prefer to use a UI, go to [middle-scraping-api.herokuapp.com](https://middle-scraping-api.herokuapp.com/).

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/93153950/204440583-3ea125da-371f-4fb3-867b-d268c0b32f28.png">

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

<img width="453" alt="image" src="https://user-images.githubusercontent.com/93153950/204438306-b42ce1fe-067a-4f3d-b08b-6c64ffb851a8.png">

Example response:

<img width="1395" alt="image" src="https://user-images.githubusercontent.com/93153950/204438329-6747da19-eac0-4c54-b709-76996ebc8d74.png">

## License

The [MIT](https://choosealicense.com/licenses/mit/) License (MIT)

Copyright © 2022. Andrii Yaroshevych, Pavlo Kryven, Nazar Demchuk, Tymur Krasnianskyi