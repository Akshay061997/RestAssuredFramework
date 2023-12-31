package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.RequestBody;

public class TestDataBuild {

	public RequestBody AddPlace(String name, String language,String address){
		List<String> types = new ArrayList<String>();
		Location L1 = new Location();
		L1.setLat(-38.383494);
		L1.setLng(33.427362);
		types.add("shoe park");
		types.add("shop");
		RequestBody rb = new RequestBody();
		rb.setAddress(address);
		rb.setAccuracy(50);
		rb.setLanguage(language);
		rb.setName(name);
		rb.setPhone_number("(+91) 983 893 3937");
		rb.setWebsite("http://google.com");
		rb.setTypes(types);
		rb.setLocation(L1);
		
		return rb;
	}
	public String DeletePlacePayload(String Placeid){
		 
		return "{\"place_id\":\""+Placeid+"\"}";
	}
}
