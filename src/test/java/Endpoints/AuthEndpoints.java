package Endpoints;

import java.net.ResponseCache;
import static io.restassured.RestAssured.given;
import org.openqa.selenium.devtools.v123.fetch.model.AuthChallengeResponse.Response;

import io.restassured.specification.RequestSpecification;
import payload.LoginRequest;

public class AuthEndpoints {
	
	public static io.restassured.response.Response login(RequestSpecification requestSpec, LoginRequest loginRequest)
	{
		io.restassured.response.Response res =given()
				.spec(requestSpec)
				.body(loginRequest)
				
				
				.when()
				.post("/auth/login");
		
		
				return res;
			
	}	
				public static io.restassured.response.Response getProfile(RequestSpecification requestSpec, String token)
				{
					
					 if (token == null || token.isEmpty()) {
					        throw new IllegalArgumentException("Token is null or empty - did login() run successfully first?");
					    }
					io.restassured.response.Response res2 =given()
							.spec(requestSpec)
							.header("Authorization", "Bearer " + token)
							
							
							.when()
							.get("/auth/me");
					
					
							return res2;
				}
				
		
	
	
	
	
	 
	
}
