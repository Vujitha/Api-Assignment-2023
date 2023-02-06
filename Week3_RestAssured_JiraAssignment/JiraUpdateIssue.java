package JiraAssignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class JiraUpdateIssue {
    @Test
	public void createIssue() {
		
		RestAssured.baseURI="https://restassuredapi2023.atlassian.net/rest/api/2/issue/";
		
		RestAssured.authentication=RestAssured.preemptive().basic("ujjithak@gmail.com", "FC39LPXk4fBrpHG0jAOW9335");
		
		RequestSpecification inpuRequest = RestAssured
											.given()
											.contentType("application/json")
											.accept("application/json")
											.when()
											.body("{\r\n"
													+ "    \"fields\": {\r\n"
													+ "        \"description\": \"Bug creation Using REST API for testing\"\r\n"
													+ "    }\r\n"
													+ "}");
		Response response = inpuRequest.put("10042");
		response.prettyPrint();
		int statusCode = response.statusCode();
		System.out.println("The response code for update is:"+" "+statusCode);
		ValidatableResponse statusCode2 = response.then().assertThat().statusCode(204);
		
	}
}
