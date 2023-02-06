package Week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncident {
	
	@Test
	public void create() {
		
		RestAssured.baseURI="https://dev73313.service-now.com/api/now/table";
		
		RestAssured.authentication=RestAssured.basic("admin", "d1aPemL=@OQ1");
		
		RequestSpecification inputRequest= RestAssured
												.given()
				                                .accept("application/json")
				                                .queryParam("sysparm_fields", "sys_id,short_description")
				                                .queryParam("	", "1");
				                                
		Response response=inputRequest.get("/change_request");
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	
	}

}
