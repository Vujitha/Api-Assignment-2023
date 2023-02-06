package Week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident {
	
	@Test
	public void create() {
		
		RestAssured.baseURI="https://dev73313.service-now.com/api/now/table";
		
		RestAssured.authentication=RestAssured.basic("admin", "d1aPemL=@OQ1");
		
		RequestSpecification inputRequest= RestAssured
												.given();
				                                				                                
		Response response=inputRequest.delete("/change_request/0c8313d62f78a110beb53e0ef699b6a5");
		int statusCode = response.getStatusCode();
		System.out.println("The status code for delete incident is:"+" "+statusCode);
		response.then().assertThat().statusCode(204);
		response.prettyPrint();
	}

}
