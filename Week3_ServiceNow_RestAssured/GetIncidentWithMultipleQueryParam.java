package Week3;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentWithMultipleQueryParam {
	
	@Test
	public void create() {
		
		RestAssured.baseURI="https://dev73313.service-now.com/api/now/table";
		
		RestAssured.authentication=RestAssured.basic("admin", "d1aPemL=@OQ1");
		
		Map<String,String> multipleQueryparam = new HashMap<String,String>();
		multipleQueryparam.put("sysparm_fields", "sys_id,short_description");
		multipleQueryparam.put("sysparm_limit", "2");
		
		RequestSpecification inputRequest= RestAssured
												.given()
				                                .accept("application/json")
				                                .queryParams(multipleQueryparam);	
				                                
		Response response=inputRequest.get("/change_request");
		int statusCode = response.getStatusCode();
		System.out.println("The status code for get incident is:"+" "+statusCode);
		response.prettyPrint();
	
	}

}
