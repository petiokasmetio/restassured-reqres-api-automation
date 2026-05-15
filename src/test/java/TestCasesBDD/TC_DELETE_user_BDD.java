package TestCasesBDD;

import Base.TestBase;
import Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TC_DELETE_user_BDD extends TestBase {

    int pageNumber = 2;

    @BeforeClass
    void deleteData()
    {

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/" + pageNumber;
    }

    @Test
    void deleteUser()
    {
        Response response =    //BDD can be stored in response variable with .extract().response(); at the end of
                                                                        // deleteUser() method
        given()
        .when()
                .delete()
                .then()
                .statusCode(204)
                .and()
                .statusLine("HTTP/1.1 204 No Content")
                .log().all().extract().response();

        String jsonAsString = response.asString();  // Store json response as string variable
        Assert.assertEquals(jsonAsString.contains(""), true);
    }
}
