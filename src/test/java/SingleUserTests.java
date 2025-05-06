
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SingleUserTests extends TestBase{


    @Test
    void checkIdUserWithLogsTest() {
        given()
                .log().all()
                .get("/users/2")
                .then()
                .log().all()
                .body("data.id", is(2));
    }

    @Test
    void checkIdUserWithSomeLogsTest() {
        given()
                .log().all()
                .get("/users/2")
                .then()
                .log().body()
                .body("data.id", is(2));
    }

    @Test
    void checkIdUserWithStatusTest() {
        given()
                .log().uri()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2));
    }

}
