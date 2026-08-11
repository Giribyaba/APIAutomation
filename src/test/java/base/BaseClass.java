package base;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class BaseClass {
protected RequestSpecification requestSpec;
	@BeforeClass
	public void setup() throws IOException
	{
		
		
		ConfigReader.loadproperties();
		
		requestSpec =new RequestSpecBuilder()
		.setBaseUri(ConfigReader.getProperty("baseURI"))
		.setContentType("application/json")
		.setAccept(ContentType.JSON)

		.build();

}
}
