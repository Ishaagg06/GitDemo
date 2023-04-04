package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static 	RequestSpecification req;
	
	public static RequestSpecification reqspec() throws IOException {
		PrintStream st = new PrintStream(new FileOutputStream("logging.txt")); 
	req= new RequestSpecBuilder().setBaseUri(properties("baseURI")).addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(st))
			.addFilter(ResponseLoggingFilter.logResponseTo(st))
			.setContentType(ContentType.JSON).build();
	return req;

}
	
	public static String properties(String Key) throws IOException {
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ishaa\\eclipse-workspace\\api\\src\\test\\java\\resources\\Config.properties");
		prop.load(fis);
		return prop.getProperty(Key);			
	}
	
	public static String getJsonPath(Response response,String key) {
		String resp=response.asString();
		JsonPath js= new JsonPath(resp);
		return js.get(key).toString();
	}
}
