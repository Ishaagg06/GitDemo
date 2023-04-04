package Stepdefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	
	public void beforescenario() throws IOException {
		stepdefination m= new stepdefination();
		if(m.place_id==null)
		{
			m.add_place_payload_with("Shetty", "French", "Asia");
			m.call_is_made_to_post_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
		}
	}

}
