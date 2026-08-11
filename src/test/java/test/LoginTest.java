package test;

import org.testng.annotations.Test;

import Endpoints.AuthEndpoints;
import base.BaseClass;
import io.restassured.response.Response;
import payload.LoginRequest;

public class LoginTest extends BaseClass{
	
	@Test
		public void loginTest() {
		LoginRequest payload = new LoginRequest();
		payload.setUsername("emilys");
		payload.setPassword("emilyspass");
		
	Response res= AuthEndpoints.login(requestSpec, payload);
	System.out.println("Request body sent: " + payload.toString());  // if LoginRequest has a toString()
	System.out.println("Response body: " + res.getBody().asString());
	res.then().statusCode(200);
	
	
	Response res2=AuthEndpoints.getProfile(requestSpec, res.jsonPath().getString("accessToken"));
	res2.then().statusCode(200);
	
	res2.body().prettyPrint();
	
	System.out.println("Access Token: " + res.jsonPath().getString("accessToken"));
	
	
	
	
		
	}

}
