package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



//Userendpoints.java
//create for perform create , read, update, delete request the user

public class UserEndPoints {
	
	public static Response createUser(User payload)  //user payload we add because we send data
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return res;
		
	}
	public static Response readUser(String userName)  // here we not use user payload because we cannot send data
	{
		Response res = given()
				.pathParam("username", userName)
		
		.when()
			.get(Routes.get_url);
		
		return res;
		
	}
	
	public static Response updateUser(String userName,User payload)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
		
		.when()
			.put(Routes.update_url);
		
		return res;
		
	}
	public static Response deleteUser(String userName)  // here we not use user payload because we cannot send data
	{
		Response res = given()
				.pathParam("username", userName)
		
		.when()
			.delete(Routes.delete_url);
		
		return res;
		
	}
	

}
