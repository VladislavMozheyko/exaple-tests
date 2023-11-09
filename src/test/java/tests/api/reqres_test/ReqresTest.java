package tests.api.reqres_test;

import api.reqres.UserData;
import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static ui.constants.Constant.Urls.REQRES;
import static ui.constants.Constant.Values.GET_LIST_USERS;
import static ui.constants.Constant.Values.RESPONSE200;

public class ReqresTest {
    @Test
    public void testAvatarAndIdTest() {
        Specifications.installSpecification(Specifications.requestSpecification(REQRES),(Specifications.responseSpecification(RESPONSE200)));
        List<UserData> users = given()
                .when()
                .get( GET_LIST_USERS)
                .then()
                .log().all().extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }
}
