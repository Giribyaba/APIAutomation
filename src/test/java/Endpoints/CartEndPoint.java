package Endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;

public class CartEndPoint {
	
	public static Response getCartbyId(RequestSpecification requestspec, int cartid)
	{
		Response res=given()
				.spec(requestspec)
				.pathParam("id",cartid)
				
				.when()
				.get("/cart/{id}");
		return res;
	}

	public static Response getUserCart(RequestSpecification requestspec, int userid)
	{
		Response res=given()
				.spec(requestspec)
				.pathParam("userId",userid)
				
				.when()
				.get("/carts/user/{userId}");
		
		return res;
	}
}
