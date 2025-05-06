import io.restassured.RestAssured;

import io.restassured.config.SSLConfig;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        RestAssured.config = RestAssured.config()
                .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()); // Игнорируем SSL
    }
}
