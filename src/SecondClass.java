import io.restassured.path.json.JsonPath;

public class SecondClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		int courses= js.getInt("courses.size()");
		System.out.println(courses);
		int purchaseamt=js.get("dashboard.purchaseAmount");
		System.out.println("Purchase amount is" + js.getString("dashboard.purchaseAmount"));
		
		System.out.println("Title of first course is " +" " + js.getString("courses[0].title"));
		
		for(int i=0;i<courses;i++) {
		
			int price= js.get("courses["+i+"].price");
			
			
			System.out.println("title of the course is" + " "+ js.get("courses["+i+"].title"));
		System.out.println("price of the course is" + " "+ price);
		
		
		if(js.get("courses["+i+"].title").equals("RPA")) {
			System.out.println(js.getString("courses["+i+"].copies"));
		}
		
		
		
		}
		
		
		

	}

}
