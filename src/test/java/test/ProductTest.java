package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Endpoints.ProductEndPoint;
import base.BaseClass;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ProductTest extends BaseClass{
	
	@Test
	public void getAllProductTest() {
		Response res= ProductEndPoint.getAllProdut(requestSpec);
		res.then().statusCode(200);
		
		int prdCount = res.body().jsonPath().getInt("total");
		Assert.assertTrue(prdCount > 0, "Total count of products should be greater than 0");
		
		System.out.println("Total count of products: " + prdCount);
		res.body().prettyPrint();
	}
	
	@Test(dependsOnMethods = "getAllProductTest")
	public void getProductbyIdTest()
	{
		Response res = ProductEndPoint.getProductById(requestSpec, 1);
		
		res.then()
         .statusCode(200)
         .body("id", org.hamcrest.Matchers.equalTo(1));
		System.out.println(res.asPrettyString());
	}

}
