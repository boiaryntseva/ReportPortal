import api.ToolsQaApiHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.HashMap;

import static api.ApiEndPoints.LIST_OF_PROJECT_LAUNCHES;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;


public class ApiTests {
    //    ToolsQaApiHelper toolsQaApiHelper = new ToolsQaApiHelper();
//    HashMap<String, String> tokenAndId = toolsQaApiHelper.getAccessToken();
//   // String token = tokenAndId.get("access_token");
    static final String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODU4MDk5MjYsInVzZXJfbmFtZSI6ImthdGUiLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiYTQyZjY2ODUtODJiNy00NmU2LWE4NWQtN2U1NGY2YmYzN2QyIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.ABx6CCnWhVsGQGvkndJeaicsBe_-YxRakqY_d1FtcAo";
    static final String auth = "Bearer " + accessToken;

    static final RequestSpecification requestSpecification =
            new RequestSpecBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", auth)
                    .build()
                    .log()
                    .all();

    @Test
    public void getListOfLaunches() {
        String response = given()
          .spec(requestSpecification)
//     Option 2:           .headers(
//                        "Bearer ", token,
//                        "Content-Type",
//                        ContentType.JSON,
//                        "Accept",
//                        ContentType.JSON)
//                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get(LIST_OF_PROJECT_LAUNCHES)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().toString();

        System.out.println(response);
    }
}
