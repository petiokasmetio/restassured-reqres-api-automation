package TestCases;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_DELETE_SingleUser extends TestBase {

    RequestSpecification httpRequest;
    Response response;

    @BeforeClass
    void updateSingleUser() throws InterruptedException
    {
        String id = "1";
        //logger.info("START");
        RestAssured.baseURI = "https://reqres.in";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/api/users/2");
        //First get the JsonPath object instance from the response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        //Capture id
        String usrID = jsonPathEvaluator.get("[0].id");  //"[0].id == 2" from line below "/api/users/"[0].id""
        response = httpRequest.request(Method.DELETE, "/api/users/2" + usrID);
        Thread.sleep(2);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        //Assert.assertTrue(responseBody.contains("Succesfully deleted record"));
        Assert.assertEquals(responseBody, "");
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }

    @AfterClass
    void tearDown()
    {
        System.out.println("FINISH");
    }
}
