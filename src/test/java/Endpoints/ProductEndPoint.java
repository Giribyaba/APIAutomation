package Endpoints;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ProductEndPoint {

	
	public static io.restassured.response.Response  getAllProdut(RequestSpecification requestSpec)
	{
		
		io.restassured.response.Response	res=given()
				.spec(requestSpec)
				
				.when()
				.get("/products");
		return res;
	}
	
	public static io.restassured.response.Response getProductById(RequestSpecification requestSpec, int productid) {
	    Response res = given()
	            .spec(requestSpec)
	            .pathParam("id", productid)
	            .when()
	            .get("/products/{id}");
	    return res;
	}
}
