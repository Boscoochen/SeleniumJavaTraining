

import io.restassured.RestAssured;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * 
 * API descriptions are on this page: https://reqres.in/
 * 
 * Using RestAssured ... 1. (GET single user) Write a test that verifies the
 * email address for employee id 2 is 'janet.weaver@reqres.in'
 * 
 * 2. (POST login - succesful) Write a test that verifies the token return
 * value.
 * 
 * 3. (DELETE) a. Write a test that verifies the response code of 204. b. Lookup
 * response code 204 and add it to your test as a comment.
 * 
 * 4. (PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that
 * UpdatedAt timestamp is updated and that the name was updated.
 * 
 * 5. (PUT) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that
 * UpdatedAt timestamp is updated and that the name was updated.
 * 
 * 6. (GET single user). Deserialize the user data into an object.
 * 
 * 7. (GET list users). Deserialize the user data into a collection of objects.
 * 
 * Use REST Assured to deserialize data. Use Junit as the test framework.
 *
 * 
 */

public class RestAssured_ {
	@Before
	public void url() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	public void getRequestTest() {
		Response response = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("/api/users/2")
				.then()
//					.log().ifStatusCodeIsEqualTo(200)
//					.body("result.email", equalTo("janet.weaver@reqres.in"))
				.extract()
				.response();

//		String bodyAsString = response.getBody().asString();
//		System.out.println(bodyAsString);
		assertEquals(200, response.statusCode());
        assertEquals("janet.weaver@reqres.in", response.jsonPath().getString("data.email"));
	}
	
	@Test
	public void postRequestTest() {

		String jsonData = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"cityslicka\"}";
		Response response = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.post("/api/login")
				.then()
				.extract()
				.response();

		String bodyAsString = response.getBody().asString();
//		System.out.println(bodyAsString);
		assertEquals(200, response.statusCode());
//		System.out.println(response.jsonPath().getString("token"));
        assertEquals("QpwL5tke4Pnpja7X4", response.jsonPath().getString("token"));
	}
	
	@Test
	public void deleteRequestTest() {
		Response response = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.delete("/api/users/2")
				.then()
				.extract()
				.response();
		
		assertEquals(204, response.statusCode());
//		System.out.println(response.jsonPath().getString("token"));
//        assertEquals("QpwL5tke4Pnpja7X4", response.jsonPath().getString("token"));
	}
	
	@Test
	public void patchRequestTest() {
		String jsonData = "{\"name\":\"morpheus2\",\"job\":\"zion resident\"}";
		Response response = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.patch("/api/users/2")
				.then()
				.extract()
				.response();
		
		String bodyAsString = response.getBody().asString();
		System.out.println(bodyAsString);
		assertEquals(200, response.statusCode());
//		System.out.println(response.jsonPath().getString("token"));
//        assertEquals("QpwL5tke4Pnpja7X4", response.jsonPath().getString("token"));
	}

	
	@Test
	public void putRequestTest() {
		String jsonData = "{\"name\":\"morpheus2\",\"job\":\"zion resident\"}";
		Response response = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.put("/api/users/2")
				.then()
				.extract()
				.response();
		
		String bodyAsString = response.getBody().asString();
		System.out.println(bodyAsString);
		assertEquals(200, response.statusCode());
//		System.out.println(response.jsonPath().getString("token"));
//        assertEquals("QpwL5tke4Pnpja7X4", response.jsonPath().getString("token"));
	}
}
