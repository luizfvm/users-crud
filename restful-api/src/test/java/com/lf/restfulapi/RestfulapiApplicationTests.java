package com.lf.restfulapi;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.lf.restfulapi.domain.User;

import static com.jayway.restassured.RestAssured.given;

/**
 * Test class responsible for implementing functional tests.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulapiApplicationTests {

	@BeforeClass
	public static void setup() {
		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(8080);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String basePath = System.getProperty("server.base");
		if (basePath == null) {
			basePath = "/users/";
		}
		RestAssured.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://localhost";
		}
		RestAssured.baseURI = baseHost;
	}

	@Test
	public void WhenGetRequest_Return200StatusCode() {
		given().when().get("/").then().statusCode(200);
	}

	@Test
	public void WhenGetRequest_InvalidUser_Return404StatusCode() {
		String id = RandomStringUtils.randomAlphabetic(8);
		given().when().get("/" + id).then().statusCode(404);
	}

	@Test
	public void WhenUserIsCreated_Return201StatusCode() {
		Map<String, String> user = new HashMap<>();
		user.put("name", "user5");
		user.put("email", "user5@gmail.com");

		given().contentType("application/json").body(user).when().post("/").then().statusCode(201);
	}

	@Test
	public void WhenUserIsDeleted_Return204StatusCode() {
		User userToBeDeleted = new User("Id", "user6", "user6@gmail.com");
		given().contentType("application/json").body(userToBeDeleted).when().post("/");
		given().when().delete("/" + userToBeDeleted.getId()).then().statusCode(204);
	}

	@Test
	public void WhenUsersNameAreRetrieved_Return201StatusCode() {
		given().when().get("/").then().body("name", hasItems("user1", "user2", "user3", "user4")).statusCode(200);
	}

}

