
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserNotFoundTest extends TestBase{


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
