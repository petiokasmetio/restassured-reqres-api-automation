package TestCases;

import Base.TestBase;
import Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TC_POST_Users_HashMap extends TestBase {

    Map<String, Object> jsonAsMap = new HashMap<>();
    String usr = RestUtils.userName();
    String job = RestUtils.userJob();

    @BeforeClass
    void putData()
    {
        jsonAsMap.put("name", usr);
        jsonAsMap.put("job", job);
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";
    }

    @Test
    public void postMultipleUserData()
    {
        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .post()
                .then()
                .statusLine("HTTP/1.1 201 Created")
                .statusCode(201);
    }
}
