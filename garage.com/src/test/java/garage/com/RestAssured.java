package garage.com;

import static io.restassured.RestAssured.*;

import org.junit.Test;

/**
 * 
 * API descriptions are on this page:
https://reqres.in/

Using RestAssured ...
1. (GET single user) Write a test that verifies the email address for employee id 2 is 'janet.weaver@reqres.in' 

2. (POST login - succesful) Write a test that verifies the token return value.

3. (DELETE) 
a. Write a test that verifies the response code of 204. 
b. Lookup response code 204 and add it to your test as a comment.

4. (PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

5. (PUT) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

6. (GET single user). Deserialize the user data into an object.

7. (GET list users). Deserialize the user data into a collection of objects.

Use REST Assured to deserialize data.
Use Junit as the test framework.

 *
 */

public class RestAssured {
	@Test
	public void testApi() {

		
		
	}
}
