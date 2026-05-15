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
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class TC_POST_user_BDD extends TestBase {

    Map<String, Object> jsonAsMap = new HashMap<>();
    String usr = RestUtils.userName();
    String job = RestUtils.userJob();

    @BeforeClass
    void postData()
    {
        jsonAsMap.put("name", usr); //jsonAsMap.put("name", RestUtils.userName());
        jsonAsMap.put("job", job);  //jsonAsMap.put("name", RestUtils.userJob());
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";
    }

    @Test
    public void postMultipleUserData()
    {
        Response response =
        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .post()
                .then()
                .statusLine("HTTP/1.1 201 Created")
                .and()
                //.body(contains(jsonAsMap))
                .statusCode(201)
                .log().all().extract().response();
        String jsonAsString = response.asString();
        Assert.assertEquals(jsonAsString.contains("createdAt"), true);
    }
}
