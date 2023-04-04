import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
public class OAuth {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
		
		String partialcode=url.split("code=")[1];
		System.out.println(partialcode);
		String code=partialcode.split("&scope=")[0];
		System.out.println(code);
		
	Response response = given().urlEncodingEnabled(false).queryParams("code", code).queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("grant_type", "authorization_code")

      
		.queryParams("state", "verifyfjdss")

        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")  .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

        .when().log().all()

        .post("https://www.googleapis.com/oauth2/v4/token").then().extract().response();
	
	String accesstoken=response.jsonPath().getString("access_token");
	System.out.println(accesstoken);
	
	Response response1=given().contentType("application/json").

queryParams("access_token", accesstoken).expect().defaultParser(Parser.JSON)

.when()

           .get("https://rahulshettyacademy.com/getCourse.php").then().extract().response();
	
	
	System.out.println(response1);
		

	}

}
