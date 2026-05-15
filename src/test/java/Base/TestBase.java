package Base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static RequestSpecification httpRequest;
    public static Response response;
    //public String userID = "";

    public Logger logger;
    @BeforeClass
    public void setup()
    {
        //logger = Logger.getLogger("UsersRestAPI");
        //PropertyConfigurator.configure("Log4j.properties");
        //logger.setLevel(Level.Debug);
    }
}
