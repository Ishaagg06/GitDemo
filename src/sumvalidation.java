import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class sumvalidation {
	
	public static void main(String[] args) {
		String response3= "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\" },\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ " ";
		JsonPath js= new JsonPath(response3);
		int purchaseamt=js.get("dashboard.purchaseAmount");
		int courses= js.getInt("courses.size()");
		System.out.println("courses");
		int sum=0;
		for(int i=0;i<courses;i++) {
			//courses.get(i);
			
			int amount;
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			//System.out.println("price of the course is" + " "+ js.get("courses["+i+"].price"));
		//System.out.println("copies of the course is" + " "+ js.get("courses["+i+"].copies"));
		 amount=price*copies;
		sum=sum+amount;
		
		
		
		
		System.out.println(sum);	
		Assert.assertEquals(sum, purchaseamt);
	}

}
}
