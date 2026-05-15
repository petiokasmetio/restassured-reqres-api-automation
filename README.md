# RestAssured Reqres API Automation

Java-based API test automation project using RestAssured, TestNG and Maven.

This project demonstrates API testing fundamentals such as sending HTTP requests, validating responses, checking status codes and organizing automated API tests in a reusable structure.

## Disclaimer

This project is created for QA automation practice, learning and portfolio demonstration purposes.

It uses the public Reqres API, which is designed for testing and prototyping API requests.

The project does not interact with private systems, production business data or confidential information.

## Overview

The project contains automated API tests for common REST API operations using RestAssured.

It demonstrates how to test REST endpoints by validating:

- HTTP status codes
- response bodies
- JSON fields
- request/response behavior
- basic CRUD-style API flows
- positive API scenarios
- reusable API test structure

## Key Features

- RestAssured-based API automation
- TestNG test execution
- Maven project structure
- GET request validation
- POST request validation
- PUT/PATCH-style update validation
- DELETE request validation
- status code assertions
- JSON response validation
- reusable test organization
- public API testing practice

## Technologies Used

- Java
- RestAssured
- TestNG
- Maven
- JSON validation
- Maven Surefire Plugin

## Tested API Scenarios

The project demonstrates API scenarios such as:

```text
GET     - retrieve users/resources
POST    - create a user/resource
PUT     - update a user/resource
PATCH   - partially update a user/resource
DELETE  - delete a user/resource
```

## Example Validations

Typical validations include:

```text
Status code is 200, 201, 204 or an expected error code
Response contains expected fields
Response body contains expected user/resource data
JSON values match expected test data
API response follows the expected structure
```

## Project Structure

```text
restassured-reqres-api-automation
├── src
│   └── test
│       └── java
│           └── ...
├── pom.xml
├── testng.xml
├── README.md
└── .gitignore
```

## How to Run

Make sure Java and Maven are installed.

Clone the repository:

```bash
git clone https://github.com/petiokasmetio/restassured-reqres-api-automation.git
cd restassured-reqres-api-automation
```

Run the tests:

```bash
mvn clean test
```

Run with the TestNG suite file:

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

## Example RestAssured Test Concept

Example API validation structure:

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .statusCode(200);
```

## QA Skills Demonstrated

This project demonstrates:

- API test automation
- RestAssured usage
- TestNG test organization
- Maven-based test execution
- REST API testing fundamentals
- HTTP method validation
- JSON response validation
- status code assertions
- request/response testing
- reusable API test structure
- practical QA automation mindset

## Current Project Status

Current version:

- Java Maven project
- RestAssured API tests
- TestNG test execution
- public API testing practice
- basic request/response validation

## Limitations

Current limitations:

- public API availability may affect test execution
- no advanced reporting yet
- no CI/CD pipeline yet
- limited negative test scenarios
- limited JSON schema validation
- no environment-based configuration yet
- no advanced request/response specification layer yet

## Potential Future Improvements

Possible next improvements:

- add reusable base API client
- add request and response specifications
- add JSON schema validation
- add negative API test scenarios
- add Allure or HTML reporting
- add GitHub Actions CI pipeline
- add environment configuration
- add better test data management
- add response time assertions
- add more complete CRUD coverage
- add logging for request and response details

## Author

Petar Nikolov

Test Automation Engineering Analyst with experience in ERP and banking systems, Java/Python automation, Selenium, API testing, QA tooling, XML test data generation and business-critical software testing.