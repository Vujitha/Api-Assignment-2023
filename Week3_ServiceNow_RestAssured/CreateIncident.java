package Week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {
	
	@Test
	public void create() {
		
		RestAssured.baseURI="https://dev73313.service-now.com/api/now/table";
		
		RestAssured.authentication=RestAssured.basic("admin", "d1aPemL=@OQ1");
		
		RequestSpecification inputRequest= RestAssured
												.given()
				                                .contentType("application/json")
				                                .accept("application/json")
				                                .when()
				                                .body("{\r\n"
				                                		+ "    \"description\": \"Created with postman\",\r\n"
				                                		+ "    \"short_description\": \"My first created via Postman\"\r\n"
				                                		+ "}");
		Response response=inputRequest.post("/change_request");
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		
	}

}
