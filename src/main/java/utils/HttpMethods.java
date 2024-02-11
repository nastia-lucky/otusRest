package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpMethods extends BaseUtils {

  private HttpMethods() {
  }

  public static String post(Object object, String endpoint, int statusCode) {
    RequestSpecification requestSpecification = RestAssured
        .given();
    Response response = requestSpecification
        .baseUri(MY_URL)
        .accept(ContentType.JSON)
        .contentType(ContentType.JSON)
        .body(object)
        .when()
        .log()
        .all()
        .post(endpoint);
    response.then()
        .log()
        .all()
        .assertThat()
        .statusCode(statusCode);

    return response.asString();

  }


  public static String put(Object object, String endpoint, int statusCode) {
    RequestSpecification requestSpecification = RestAssured
        .given();
    Response response = requestSpecification
        .baseUri(MY_URL)
        .accept(ContentType.JSON)
        .contentType(ContentType.JSON)
        .body(object)
        .when()
        .log()
        .all()
        .put(endpoint);
    response.then()
        .log()
        .all()
        .assertThat()
        .statusCode(statusCode);

    return response.asString();

  }


  public static Response getWithParam(String endpoint, int statusCode, String param, String paramValue) {
    RequestSpecification requestSpecification = RestAssured
        .given();

    Response response = requestSpecification
        .baseUri(MY_URL)
        .param(param, paramValue)
        .when()
        .log()
        .all()
        .get(endpoint);

    response.then()
        .log()
        .all()
        .assertThat()
        .statusCode(statusCode);

    return response;
  }


  public static int getStatusCode(String endpoint) {
    RequestSpecification requestSpecification = RestAssured
        .given()
        .log()
        .all();
    Response response = requestSpecification
        .baseUri(MY_URL)
        .log()
        .all()
        .when()
        .get(endpoint);
    response.then().log().all();
    return response.getStatusCode();
  }

  public static Response getResponse(String endpoint) {
    RequestSpecification requestSpecification = RestAssured
        .given()
        .log()
        .all();
    Response response = requestSpecification
        .baseUri(MY_URL)
        .log()
        .all()
        .when()
        .get(endpoint);
    response.then().log().all();
    return response;
  }


  public static String delete(String endpoint, int statusCode) {
    RequestSpecification requestSpecification = RestAssured
        .given();
    Response response = requestSpecification
        .baseUri(MY_URL)
        .when()
        .log()
        .all()
        .delete(endpoint);

    response.then()
        .log()
        .all()
        .assertThat()
        .statusCode(statusCode);
    return response.asString();
  }


  public static int deleteAndGetStatusCode(String endpoint) {
    RequestSpecification requestSpecification = RestAssured
        .given();
    Response response = requestSpecification
        .baseUri(MY_URL)
        .when()
        .log()
        .all()
        .delete(endpoint);
    return response.getStatusCode();
  }


}
