package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ToolsQaApiHelper {

        public static final String USER_NAME = "kate";
        private final String PASSWORD = "qwerty";
        Logger logger = Logger.getLogger(getClass());

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        public HashMap<String, String> getAccessToken() {
            HashMap<String, String> requestParams = new HashMap<>();
            requestParams.put("grant_type", "password");
            requestParams.put("username", USER_NAME);
            requestParams.put("password", PASSWORD);

            Response actualResponse = given()
                    .spec(requestSpecification)
                    .body(requestParams)
                    .when()
                    .post(ApiEndPoints.LOGIN)
                    .then()
                    .statusCode(200)
                    .log().all()
                    .extract().response();

            HashMap<String, String> access_token = new HashMap<>();
            access_token.put("access_token", actualResponse.jsonPath().get("access_token"));
            logger.info("access_token saved");
            return access_token;
        }
}
