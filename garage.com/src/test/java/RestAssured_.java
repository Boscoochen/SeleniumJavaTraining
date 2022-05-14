import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import static org.junit.Assert.*;
import java.util.LinkedHashMap;
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

		assertEquals(response.statusCode(), 200);
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

		assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("token"), "QpwL5tke4Pnpja7X4");
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
		
		assertEquals(response.statusCode(), 204);
	}
	
	@Test
	public void patchRequestTest() {
		String jsonData = "{\"name\":\"morpheus2\"}";
		Response response = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.patch("/api/users/2")
				.then()
				.extract()
				.response();

		assertEquals(response.statusCode(), 200);
		assertEquals(response.jsonPath().getString("name"), "morpheus2");
	}

	
	@Test
	public void putRequestTest() {
		String jsonData = "{\"name\":\"morpheus2\"}";
		Response response = 
				given()
				.body(jsonData)
				.contentType(ContentType.JSON)
				.when()
				.put("/api/users/2")
				.then()
				.extract()
				.response();

		assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("name"), "morpheus2");
	}
	
	@Test
	public void deserializeDataIntoObject() {
		LinkedHashMap<String, Object> actuaLinkedHashMap  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap.put("id", 2);
		actuaLinkedHashMap.put("email", "janet.weaver@reqres.in");
		actuaLinkedHashMap.put("first_name", "Janet");
		actuaLinkedHashMap.put("last_name", "Weaver");
		actuaLinkedHashMap.put("avatar", "https://reqres.in/img/faces/2-image.jpg");
		
		Map<String, Map<String, Object>> dataObject = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("/api/users/2")
				.as(new TypeRef<Map<String, Map<String, Object>>>() {});

		assertEquals(dataObject.get("data"), actuaLinkedHashMap);
	}
	
	@Test
	public void deserializeDataIntoCollection() {
		LinkedHashMap<String, Object> actuaLinkedHashMap1  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap1.put("id", 7);
		actuaLinkedHashMap1.put("email", "michael.lawson@reqres.in");
		actuaLinkedHashMap1.put("first_name", "Michael");
		actuaLinkedHashMap1.put("last_name", "Lawson");
		actuaLinkedHashMap1.put("avatar", "https://reqres.in/img/faces/7-image.jpg");
		
		LinkedHashMap<String, Object> actuaLinkedHashMap2  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap2.put("id", 8);
		actuaLinkedHashMap2.put("email", "lindsay.ferguson@reqres.in");
		actuaLinkedHashMap2.put("first_name", "Lindsay");
		actuaLinkedHashMap2.put("last_name", "Ferguson");
		actuaLinkedHashMap2.put("avatar", "https://reqres.in/img/faces/8-image.jpg");
		
		LinkedHashMap<String, Object> actuaLinkedHashMap3  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap3.put("id", 9);
		actuaLinkedHashMap3.put("email", "tobias.funke@reqres.in");
		actuaLinkedHashMap3.put("first_name", "Tobias");
		actuaLinkedHashMap3.put("last_name", "Funke");
		actuaLinkedHashMap3.put("avatar", "https://reqres.in/img/faces/9-image.jpg");
		
		LinkedHashMap<String, Object> actuaLinkedHashMap4  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap4.put("id", 10);
		actuaLinkedHashMap4.put("email", "byron.fields@reqres.in");
		actuaLinkedHashMap4.put("first_name", "Byron");
		actuaLinkedHashMap4.put("last_name", "Fields");
		actuaLinkedHashMap4.put("avatar", "https://reqres.in/img/faces/10-image.jpg");
		
		LinkedHashMap<String, Object> actuaLinkedHashMap5  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap5.put("id", 11);
		actuaLinkedHashMap5.put("email", "george.edwards@reqres.in");
		actuaLinkedHashMap5.put("first_name", "George");
		actuaLinkedHashMap5.put("last_name", "Edwards");
		actuaLinkedHashMap5.put("avatar", "https://reqres.in/img/faces/11-image.jpg");
		
		LinkedHashMap<String, Object> actuaLinkedHashMap6  = new LinkedHashMap<String, Object>();
		actuaLinkedHashMap6.put("id", 12);
		actuaLinkedHashMap6.put("email", "rachel.howell@reqres.in");
		actuaLinkedHashMap6.put("first_name", "Rachel");
		actuaLinkedHashMap6.put("last_name", "Howell");
		actuaLinkedHashMap6.put("avatar", "https://reqres.in/img/faces/12-image.jpg");
		
		
		List<Map<String, Object>>dataObject = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("/api/users?page=2")
				.then()
				.extract()
				.path("data");

		assertEquals(dataObject.get(0), actuaLinkedHashMap1);
		assertEquals(dataObject.get(1), actuaLinkedHashMap2);
		assertEquals(dataObject.get(2), actuaLinkedHashMap3);
		assertEquals(dataObject.get(3), actuaLinkedHashMap4);
		assertEquals(dataObject.get(4), actuaLinkedHashMap5);
		assertEquals(dataObject.get(5), actuaLinkedHashMap6);	
	}
}



