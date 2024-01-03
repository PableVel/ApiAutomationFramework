package api.endpoints;

import static api.endpoints.Routes.*;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
				.post(POST_URL);
		return response;
	}

	public static Response readUser(String userName) {
		return given()
					.pathParam("username",userName)
				.when()
					.get(GET_URL);
	}

	public static Response updateUser(String userName, User payload) {
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				.when()
				.put(UPDATE_URL);
	}

	public static Response deleteUser(String userName) {
		return given()
				.pathParam("username",userName)
				.when()
				.delete(DELETE_URL);
	}
}
