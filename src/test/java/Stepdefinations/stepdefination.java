package Stepdefinations;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import POJO.Addlocation;
import POJO.location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDatabuild;
import resources.Utils;
import resources.APIResources;

public class stepdefination {
	Response response;
	RequestSpecification req;
	ResponseSpecification resp;
	static String place_id;
	//String baseURI;
	//RestAssured.baseURI="https://rahulshettyacademy.com";
	@Given("add place payload with {string},{string},{string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		
	req=given().spec(Utils.reqspec()).body(TestDatabuild.addPlacePayload(name,language,address));
		
		
	
	}
	@When("{string} call is made to {string} request")
	public void call_is_made_to_post_request(String resource,String method) {
		APIResources apiresources= APIResources.valueOf(resource);
		System.out.println(apiresources.getResource());
	resp= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	if(method.equalsIgnoreCase("POST")) {
		response=req.when().post(apiresources.getResource());
	}
	else if(method.equalsIgnoreCase("GET")) {
		response=req.when().post(apiresources.getResource());
	}
	}
	@Then("status code is returned as {int}")
	public void status_code_is_returned_as(Integer int1) {
	    
	    assertEquals(response.getStatusCode(),200);
	    
	    
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String Expected, String resource) throws IOException {
	  place_id=Utils.getJsonPath(response, "place_id");
	  System.out.println(place_id);
	  req=given().spec(Utils.reqspec()).queryParam("place_id", place_id);
	  call_is_made_to_post_request(resource,"GET");
	  String actualname=Utils.getJsonPath(response, "name");
	  System.out.println(actualname);
	  assertEquals(Expected,actualname);
	  
	  
	}
	
	@Given("delete place payload")
	public void delete_place_payload() throws IOException {
		
		req=given().spec(Utils.reqspec()).body(TestDatabuild.deletePlacePayload(place_id));
		 
	}



	




}
