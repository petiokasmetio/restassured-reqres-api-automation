package TestCases;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_GET_UserList extends TestBase {

    @BeforeClass
    void getAllUsers() throws InterruptedException
    {
        //logger.info("START");
        RestAssured.baseURI = "https://reqres.in";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/api/users?page=2");
        Thread.sleep(2);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertNotNull(responseBody);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        //logger.info("Status code is ==>" + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime()
    {
        long responseTime = response.getTime();
        //logger.info("Response time is ==>" + responseTime);
        if(responseTime > 5000)
            //logger.warn("Be careful greather than 5000");
        Assert.assertTrue(responseTime < 4999);
    }

    @Test
    void checkStatusLine()
    {
        String statusLine = response.getStatusLine();
        //logger.info("Status line is ==>" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
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

//    @Test
//    void checkContentLength()
//    {
//        String contentLength = response.header("Content-Length");
//        if (Integer.parseInt(contentLength) < 100)
//            //logger.warn("Content length is less than 100");
//        Assert.assertTrue(Integer.parseInt(contentLength) > 100);
//    }

    @Test
    void checkCookies()
    {
        String cookie = response.getCookie("APGSPPGKPSG");
        //Assert.assertEquals(cookie, "ANSAF*ASFASF*F&AN(*F&BS*(F");
    }

    @AfterClass
    void tearDown()
    {
        //logger.info("FINISH");
    }
}
