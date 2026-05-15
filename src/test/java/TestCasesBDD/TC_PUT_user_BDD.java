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

public class TC_PUT_user_BDD extends TestBase {

    Map<String, Object> jsonAsMap = new HashMap<>();
    String usr = RestUtils.userName();
    String job = RestUtils.userJob();
    int pageNumber = 2;

    @BeforeClass
    void putData()
    {
        jsonAsMap.put("name", usr);
        jsonAsMap.put("job", job);
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/" + pageNumber;
    }

    @Test
    void putMultipleData()
    {
        Response response =
        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put()
                .then()
                .statusCode(200)
                .and()
                .statusLine("HTTP/1.1 200 OK")
                .log().all().extract().response();
        String jsonAsString = response.asString();
        Assert.assertEquals(jsonAsString.contains("updatedAt"), true);
    }
}
