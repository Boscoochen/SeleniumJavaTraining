import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

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
				.extract()
				.response();

		assertEquals(200, response.statusCode());
		assertEquals(response.jsonPath().getString("data.email"), "janet.weaver@reqres.in");
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

		assertEquals(200, response.statusCode());
		assertEquals("QpwL5tke4Pnpja7X4", response.jsonPath().getString("token"));
	}

	@Test
	public void deleteRequestTest() {
		Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.delete("/api/users/2")
				.then()
				.extract()
				.response();

		assertEquals(response.getBody().asString(), 204, response.statusCode());
	}

	@Test
	public void patchRequestTest() {
		String jsonData = "{\"name\":\"morpheus2\"}";
		Response response1 = given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.patch("/api/users/2")
				.then()
				.extract()
				.response();
		
		Response response2 = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.patch("/api/users/2")
				.then()
				.extract()
				.response();

		assertEquals(200, response1.statusCode());
		assertEquals("morpheus2", response1.jsonPath().getString("name"));
		assertTrue(response2.jsonPath().getString("updatedAt").compareTo(response1.jsonPath().getString("updatedAt")) > 0);
	}

	@Test
	public void putRequestTest() {
		String jsonData = "{\"name\":\"morpheus2\"}";
		Response response1 = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.put("/api/users/2")
				.then()
				.extract()
				.response();
		
		Response response2 = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when().put("/api/users/2")
				.then()
				.extract()
				.response();

		assertEquals(200, response1.statusCode());
		assertEquals("morpheus2", response1.jsonPath().getString("name"));
		assertTrue(response2.jsonPath().getString("updatedAt").compareTo(response1.jsonPath().getString("updatedAt")) > 0);
	}

	@Test
	public void deserializeDataIntoObject() {
		User user2 = new User(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");

		Map<String, Object> dataObject = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("/api/users/2")
				.as(new TypeRef<Map<String, Object>>() {});

		assertEquals(user2.toString(), dataObject.get("data").toString());
	}

	@Test
	public void deserializeDataIntoCollection() {
		User user7 = new User(7, "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg");
		User user8 = new User(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson", "https://reqres.in/img/faces/8-image.jpg");
		User user9 = new User(9, "tobias.funke@reqres.in", "Tobias", "Funke", "https://reqres.in/img/faces/9-image.jpg");
		User user10 = new User(10, "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg");
		User user11 = new User(11, "george.edwards@reqres.in", "George", "Edwards", "https://reqres.in/img/faces/11-image.jpg");
		User user12 = new User(12, "rachel.howell@reqres.in", "Rachel", "Howell", "https://reqres.in/img/faces/12-image.jpg");

		List<Map<String, Object>> dataObject = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("/api/users?page=2")
				.then()
				.extract()
				.path("data");
		
		assertEquals(user7.toString(), dataObject.get(0).toString());
		assertEquals(user8.toString(), dataObject.get(1).toString());
		assertEquals(user9.toString(), dataObject.get(2).toString());
		assertEquals(user10.toString(), dataObject.get(3).toString());
		assertEquals(user11.toString(), dataObject.get(4).toString());
		assertEquals(user12.toString(), dataObject.get(5).toString());
	}
}
