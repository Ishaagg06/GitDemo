import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.Types;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJO.Addlocation;
import POJO.location;
import groovy.transform.stc.POJO;


public class FirstClass {
	// way to add static payload i.e. json file directly in body
	//(FileByte)

//	@Test(dataProvider="Place")
	public static void main(String[] args) {
		Addlocation l= new Addlocation();
		l.setAccuracy(50);
		l.setLanguage("French-IN");
		l.setName("rahul");
		l.setPhone_number(45678);
		l.setWebsite("http://rahulshettyacademy.com");
		l.setAddress("29, side layout, cohen 09");
		ArrayList<String> t= new ArrayList<String>();
		t.add("shoe park");
		t.add("sharp");
		l.setTypes(t);
		location p= new location();
	p.setLat( -38.383494);
	p.setLng(33.427362);
	l.setLocation(p);
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(l).when().post("maps/api/place/add/json").then().extract().response();
		String response1= response.asString();
		System.out.println(response1);
	
		
		System.out.println(response.statusCode());
		System.out.println(response.jsonPath().getString("scope"));
		
		System.out.println(response.jsonPath().getString("place_id"));
		System.out.println(response.headers());
		
		
	//	String placeId=response.jsonPath().getString("place_id");
	//	String newAddress = "Summer Walk, Africa";
		
		//Response responsebody=given().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n" + 
			//	"\"place_id\":\""+placeId+"\",\r\n" + 
				//"\"address\":\""+newAddress+"\",\r\n" + 
			//	"\"key\":\"qaclick123\"\r\n" + 
		//		"}").
		//when().put("maps/api/place/update/json").then().extract().response();
		
		
		
		//String response2= responsebody.asString();
		//System.out.println(response2);
		//System.out.println(responsebody.statusCode());
		
		
		Addlocation al=given().queryParam("key", "qaclick123").queryParam("place_id","d435fcda6e35229495705770aa2dbbdb" ).expect().defaultParser(Parser.JSON).when().get("maps/api/place/get/json").as(Addlocation.class);
ArrayList<String> a= new ArrayList<String>();
		
		
		List<String> w=al.getTypes();
		
		for(int j=0;j<w.size();j++)
		{
			a.add(w.get(j));
		}
		


	
	//String getresponsebody =getresponse.asString();
		//System.out.println(getresponsebody);
		//System.out.println(getresponse.statusCode());
		//String address=getresponse.jsonPath().getString("address");
		//assert address.equals(newAddress);
		//Assert.assertEquals(address, newAddress);
	}
		
	

		//@DataProvider(name="Place")
		
			//public Object[][] getData(){
			
		//	return new Object[][]{{"isha","12345"},{"rahul","45678"}};
				
			//}
	
		
		
		
	
	
		
		
		
		
		
		
		

	
	}

