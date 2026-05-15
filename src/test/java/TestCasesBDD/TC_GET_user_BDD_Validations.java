package TestCasesBDD;

import Base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC_GET_user_BDD_Validations extends TestBase {

    @Test(priority = 1)
    public void testStatusCode()
    {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void testMultipleContent()
    {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .and()
                .statusLine("HTTP/1.1 200 OK")
                .log().all();
    }

    @Test(priority = 3)
    public void verifySingleBodyContent()
    {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .and()
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .log().all();
    }

    @Test(priority = 4)
    public void verifyMultipleBodyContent()
    {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .and()
                .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron"))
                .log().all();
    }

    @Test(priority = 4)
    public void settingParametersAndHeaders()
    {
        given()
                .param("MyName", "")
                .header("MyHeader", "")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
