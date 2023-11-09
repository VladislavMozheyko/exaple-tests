package tests.api.reqres_test;

import api.reqres.*;
import api.specifications.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static ui.constants.Constant.Urls.REQRES;
import static ui.constants.Constant.Values.*;

public class ReqresTest {
    @Test
    public void testAvatarAndIdTest() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), (Specifications.responseSpecification(RESPONSE200)));
        List<UserData> users = given()
                .when()
                .get(LIST_USERS)
                .then()
                .log().all().extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }

    @Test
    public void successRegisterTest() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        UserRegistration userReg = new UserRegistration("eve.holt@reqres.in", "pistol");
        SuccessUserRegistration successReg = given()
                .body(userReg)
                .when()
                .post(REGISTER_SUCCESSFUL)
                .then()
                .log().all()
                .extract()
                .as(SuccessUserRegistration.class);
        Assertions.assertNotNull(successReg.getId());
        Assertions.assertNotNull(successReg.getToken());
        Assertions.assertEquals(id, successReg.getId());
        Assertions.assertEquals(token, successReg.getToken());
    }

    @Test
    public void unSuccessRegisterTest() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE400));
        String error = "Missing password";
        UserRegistration userReg = new UserRegistration("sydney@fife", "");
        UnSuccessRegistration unSuccessReg = given()
                .body(userReg)
                .when()
                .post(REGISTER_SUCCESSFUL)
                .then()
                .log().all()
                .extract()
                .as(UnSuccessRegistration.class);
        Assertions.assertNotNull(unSuccessReg.getError());
        Assertions.assertEquals(error, unSuccessReg.getError());
    }

    @Test
    public void checkYearsValueTest() {
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES), Specifications.responseSpecification(RESPONSE200));
        List<SortedDataByYears> sortedDataByYears = given()
                .when()
                .get(LIST_RESOURCE)
                .then()
                .log().all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", SortedDataByYears.class);
        List<Integer> years = sortedDataByYears.stream().map(SortedDataByYears::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedYears, years);
    }
    @Test
    public void deleteUserTest(){
        Specifications.installSpecification
                (Specifications.requestSpecification(REQRES),Specifications.responseSpecification(RESPONSE204));
        given()
                .when()
                .delete(DEL_USER_2)
                .then()
                .log().all();
    }
}
