package GetSetAndSerializationAndDeserialization;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static java.lang.reflect.Array.get;

public class UserSerialization extends TestBase {

    @Test(priority = 1)
    public void postNewUserSerialization()
    {
        //If the api allow to add more values this code below can be used
//        ArrayList<String> coursesList = new ArrayList<String>();
//        coursesList.add("Java");
//        coursesList.add("Selenium");

        GetAndSetMethods gasm = new GetAndSetMethods();
        gasm.setUserName("Petio");
        gasm.setUserJob("Programmer");
        //this is a part from coursesList
        //gasm.setCourses(coursesList);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(gasm)
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .statusCode(201)
                        .assertThat()
                        .log().all().extract().response();

       String jsonAsString = response.asString();
       Assert.assertEquals(jsonAsString.contains("Petio"), true);
       Assert.assertEquals(jsonAsString.contains("createdAt"), true);
       Assert.assertEquals(jsonAsString.contains("Programmer"), true);
    }

    @Test(priority = 2)
    void getNewUserDeserialization()
    {
        GetAndSetMethods gasm = RestAssured.get("https://reqres.in/api/users?page=2").as(GetAndSetMethods.class);
        //Must assert get response from upper line
        System.out.println(gasm.getUserRecord());
        System.out.println(gasm.userName);
        System.out.println(gasm.userJob);
    }
}
