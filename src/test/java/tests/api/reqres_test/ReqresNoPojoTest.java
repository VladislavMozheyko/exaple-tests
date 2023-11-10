package tests.api.reqres_test;

import api.specifications.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static ui.constants.Constant.Urls.REQRES;
import static ui.constants.Constant.Values.*;

public class ReqresNoPojoTest {
    @Test
    public void checkAvatarsNoPojoTest() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE200));
        Response response = given()
                .get(LIST_USERS)
                .then()
                .log().all()
                .body("data.id", notNullValue())
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.avatar", notNullValue())
                .extract()
                .response();
        JsonPath jsonPath = response.jsonPath();
        List<String> avatars = jsonPath.get("data.avatar");
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        for (int i = 0; i < avatars.size(); i++) {
            Assertions.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }
        Assertions.assertTrue(emails.stream().allMatch(x -> x.endsWith("@reqres.in")));
    }

    @Test
    public void successRegisterTestNoPojo() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE200));
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        given().body(user)
                .when()
                .post(REGISTER_SUCCESSFUL)
                .then()
                .log().all()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void successRegisterTestNoPojoType2() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE200));
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        Response response = given()
                .body(user)
                .when()
                .post(REGISTER_SUCCESSFUL)
                .then()
                .log().all()
                .extract()
                .response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assertions.assertEquals(4, id);
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", token);
    }

    @Test
    public void unSuccessRegisterTestNoPojo() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE400));
        Map<String, String> user = new HashMap<>();
        user.put("email", "sydney@fife");
        given()
                .body(user)
                .when()
                .post(REGISTER_SUCCESSFUL)
                .then()
                .log().all()
                .body("error", equalTo("Missing password"));
    }
}
