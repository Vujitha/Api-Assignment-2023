package JiraAssignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraCreateIssue {
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
													+ "        \"project\": {\r\n"
													+ "            \"key\": \"TSTP\"\r\n"
													+ "        },\r\n"
													+ "        \"summary\": \"create issue in RA project\",\r\n"
													+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
													+ "        \"issuetype\": {\r\n"
													+ "            \"name\": \"Bug\"\r\n"
													+ "        }\r\n"
													+ "    }\r\n"
													+ "}");
		Response response = inpuRequest.post();
		response.prettyPrint();
		int statusCode = response.statusCode();
		System.out.println("The response code for creation is:"+" "+statusCode);
		
	}
}
