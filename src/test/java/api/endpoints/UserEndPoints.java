package api.endpoints;

import static api.endpoints.Routes.*;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {

	public static Response createUser(User payload) {
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		.when()
				.post(POST_URL);
	}

	public static Response createUser(String userName) {
		return given()
				.pathParam("username",userName)
				.when()
				.post(GET_URL);
	}

	public static Response updateUser(String userName, User payload) {
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.when()
				.post(UPDATE_URL);
	}

	public static Response updateUser(String userName) {
		return given()
				.pathParam("username",userName)
				.when()
				.post(DELETE_URL);
	}
}
