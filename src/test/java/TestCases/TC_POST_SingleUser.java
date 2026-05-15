package TestCases;

import Base.TestBase;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utilities.RestUtils;
import org.testng.annotations.Test;

public class TC_POST_SingleUser extends TestBase {

    String usrName = RestUtils.userName();
    String usrJob = RestUtils.userJob();


    @BeforeClass
    void getSingleUser() throws InterruptedException
    {
        //logger.info("START");
        RestAssured.baseURI = "https://reqres.in";
        httpRequest = RestAssured.given();
        //JSONObject is a JSON, can be added Key-Value pairs {"name", "job"}
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", usrName);  //Cast
        requestParams.put("job", usrJob);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.request(Method.POST, "/api/users");
        Thread.sleep(2);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(usrName));
        Assert.assertTrue(responseBody.contains(usrJob));
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }

    @Test
    void checkStatusLine()
    {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
    }

    @Test
    void checkServerType()
    {
        String serverType = response.header("Server");
        Assert.assertEquals(serverType, "cloudflare");
    }

    @Test
    void checkContentEncoding()
    {
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding, null);
    }

    @AfterClass
    void tearDown()
    {
        System.out.println("FINISH");
    }
}
