package Week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {
	
	@Test
	public void create() {
		
		RestAssured.baseURI="https://dev73313.service-now.com/api/now/table";
		
		RestAssured.authentication=RestAssured.basic("admin", "d1aPemL=@OQ1");
		
		RequestSpecification inputRequest= RestAssured
												.given()
												.accept("application/xml")
				                                .contentType("application/json")				                                
				                                .when()
				                                .body("{\r\n"
				                                		+ "    \"description\": \"Created with postman\",\r\n"
				                                		+ "    \"short_description\": \"My first created via Postman\"\r\n"
				                                		+ "}");
				                                
		Response response=inputRequest.put("/change_request/0c8313d62f78a110beb53e0ef699b6a5");
		int statusCode = response.getStatusCode();
		System.out.println("The status code for update incident is:"+" "+statusCode);
		response.prettyPrint();
	}

}
