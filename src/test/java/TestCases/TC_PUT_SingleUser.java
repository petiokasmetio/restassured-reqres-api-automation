package TestCases;

import Base.TestBase;
import Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_PUT_SingleUser extends TestBase {

    RequestSpecification httpRequest;
    Response response;
    String usrName = RestUtils.userName();
    String usrJob = RestUtils.userJob();

    @BeforeClass
    void updateSingleUser() throws InterruptedException
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

        response = httpRequest.request(Method.PUT, "/api/users/2");
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
        Assert.assertEquals(statusCode, 200);
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
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
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
        Assert.assertEquals(contentEncoding, "gzip");
    }

    @AfterClass
    void tearDown()
    {
        System.out.println("FINISH");
    }
}
