package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

import api.endpoints.UserEndPoints;
import api.payloads.User;

public class UserTests {

	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload = new User();  //creating object for pojo
		
		//POJO method
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response res = UserEndPoints.createUser(userPayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	
	@Test(priority=2)
	public void testGetUser()
	{
		Response res = UserEndPoints.readUser(this.userPayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	
	@Test(priority=3)
	public void testPutUser()
	{
		
		//update using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		res.then().log().body();
		
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		//checking the data after update
		Response resAfterupdate = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		Assert.assertEquals(resAfterupdate.getStatusCode(),200);
	}
	
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		Response res = UserEndPoints.deleteUser(this.userPayload.getUsername());	
		Assert.assertEquals(res.getStatusCode(),200);
	}
}
