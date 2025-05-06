
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ListResourseTests extends TestBase {


    @Test
    void checkListWithStatusTest() {
        given()
                .log().uri()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void checkTotalWithLogsTest() {
        given()
                .log().all()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .body("total", is(12));
    }
}
