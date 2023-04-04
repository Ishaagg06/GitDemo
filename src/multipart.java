import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class multipart {
	
	public static void main(String[] args) {
		// Session Filter helps us to pass the Session vlaues like name and key from Response of one api to Request of another Api, so let's suppose 
		// you have to pass key value generated in the response of api as the path paramter to another api, so intead of parsing the response we can 
		//make use of Session Filter to do it directly.
		
		SessionFilter session=new SessionFilter();
		RestAssured.baseURI="http://localhost:8080";
		given().log().all().header("Content-Type","application-json").body("{\r\n" + 

"    \"username\": \"RahulShetty\",\r\n" + 

"    \"password\": \"Master11\"\r\n" + 

"}").log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response();
		
		String expectedMessage ="Hi How are you?";
		
		given().log().all().pathParam("key", "1010").header("Content-Type","application-json").body("{\r\n" + 

"    \"body\": \""+expectedMessage+"\",\r\n" + 

"    \"visibility\": {\r\n" + 

"        \"type\": \"role\",\r\n" + 

"        \"value\": \"Administrators\"\r\n" + 

"    }\r\n" + 

"}").filter((Filter) session).when().post("/rest/api/2/issue/{key}/comment").then().log().all()

.assertThat().statusCode(201).extract().response();
		
				
	given().header("X-Atlassian-Token","no-check").filter((Filter)session).pathParam("key", "10101").header("Content-Type","multipart/form-data")
	.multiPart("File",new File("jira.text")).when().post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
	}

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}



