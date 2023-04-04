package resources;

import java.util.ArrayList;

import POJO.Addlocation;
import POJO.location;

public class TestDatabuild {
	public static Addlocation addPlacePayload(String name, String language, String address) {
		
	
	Addlocation l= new Addlocation();
	l.setAccuracy(50);
	l.setLanguage(language);
	l.setName(name);
	l.setPhone_number(45678);
	l.setWebsite("http://rahulshettyacademy.com");
	l.setAddress(address);
	ArrayList<String> t= new ArrayList<String>();
	t.add("shoe park");
	t.add("sharp");
	l.setTypes(t);
	location p= new location();
p.setLat( -38.383494);
p.setLng(33.427362);
l.setLocation(p);
return l;
}
	
	public static String deletePlacePayload(String placeId)
	{
	return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
	
}
