package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.RequestBody;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;



public class StepDefination extends Utils{
	RequestSpecification reqest;
	ResponseSpecification res;
	Response response;
	TestDataBuild tb = new TestDataBuild();
	static String place_id;
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name,String language,String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		// TODO Auto-generated method stub
			
		reqest=given().spec(requestSpecification()).body(tb.AddPlace(name,language,address));
		
	   
	}

	@When("user call {string} with {string} http Request")
	public void user_call_with_http_request(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		ApiResources api=ApiResources.valueOf(string);
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		if(string2.equalsIgnoreCase("Post")){
		response=reqest.when().post(api.getResources());}
		else if (string2.equalsIgnoreCase("Delete")){
			response=reqest.when().post(api.getResources());
		}
		else if (string2.equalsIgnoreCase("get")){
			response=reqest.when().get(api.getResources());
		}
		
		else if (string2.equalsIgnoreCase("put")){
			response=reqest.when().put(api.getResources());
		}
	}
	

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  assertEquals(response.getStatusCode(), (int)int1);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    assertEquals(getJsonPath(response, keyvalue),ExpectedValue);
	}
	@Then("verify place Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String string, String string2) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id=getJsonPath(response, "place_id");
		reqest=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_call_with_http_request(string2,"get");
		assertEquals(getJsonPath(response, "name"), string);
		}
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		reqest=given().spec(requestSpecification()).body(tb.DeletePlacePayload(place_id));
	}


}
