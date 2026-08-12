package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Endpoints.CartEndPoint;
import base.BaseClass;
import io.restassured.response.Response;

public class CartTest extends BaseClass{
	@Test
	public void getCarTestById()
	{
		
	Response response=	CartEndPoint.getCartbyId(requestSpec,1);
	response.then().statusCode(200);
	int Cartid = response.jsonPath().getInt("id");
	Assert.assertEquals(Cartid, 1);
	
	System.out.println(response.asPrettyString());
	}

	
	@Test
	public void getUserCart()
	{
		Response response = CartEndPoint.getUserCart(requestSpec, 1);
		response.then().statusCode(200);
		
		System.out.println(  response.asPrettyString());
		
	}
}
