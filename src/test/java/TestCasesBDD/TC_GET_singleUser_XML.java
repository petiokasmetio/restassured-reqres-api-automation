package TestCasesBDD;

import Base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC_GET_singleUser_XML extends TestBase {

    //Verifying single XML content response
    @Test(priority = 1)
    void testSingleContent()
    {
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
                .then()
                .body("CUSTOMER.ID", equalTo("15"))
                .log().all();
    }

    //Verifying multiple XML content response
    @Test(priority = 2)
    void testMultipleContent()
    {
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
                .then()
                .body("CUSTOMER.ID", equalTo("15"))
                .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
                .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
                .log().all();
    }

    //Verifying all XML content response in one go
    @Test(priority = 3)
    void testAllContent()
    {
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
                .then()
                .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
                .log().all();
    }

    //Find values using XML path in XML response
    @Test(priority = 4)
    void testUsingXpath()
    {
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
                .then()
                .body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")))
                .log().all();
    }

    //Find values using XML path in XML response, second method
    @Test(priority = 5)
    void testUsingXpath2()
    {
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/INVOICE")
                .then()
                .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
                .body(hasXPath("/INVOICEList/INVOICE[text()='33']"))
                .log().all();
    }
}
