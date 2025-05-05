import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserNotFoundTest {

    @BeforeAll
    static void ignoreCheckSSL() {
        RestAssured.config = RestAssured.config()
                .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()); // Игнорирует SSL-ошибки
        given()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(401);
    }

    @Test
    void checkStatusTest() {
        given()
                .log().uri()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(401);
    }
}
