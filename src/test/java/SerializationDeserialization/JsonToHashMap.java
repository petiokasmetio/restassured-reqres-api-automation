package SerializationDeserialization;

import Base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonToHashMap extends TestBase {

    public Map<String, Object> jsonAsMap = new HashMap<>();

    //Post request
    @Test(priority = 1)
    public void postNewUser()
    {

        jsonAsMap.put("name", "Petar");
        jsonAsMap.put("job", "programmer");

        //If I have this json I have to use this ArrayList map below
        //{
//        "name": "morpheus",
//        "job": "leader"
//        "courses": [
//            "Java",
//            "Selenium"
//              ]
//        }
//        ArrayList<String> coursersList = new ArrayList<>();
//        coursersList.add("Java");
//        coursersList.add("Selenium");
//
//        jsonAsMap.put("courses", coursersList);
        Response response =
        given()
                .contentType(ContentType.JSON)
                .body(jsonAsMap)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all().extract().response();

        String jsonAsString = response.asString();
        Assert.assertEquals(jsonAsString.contains("Petar"), true);
    }
}

