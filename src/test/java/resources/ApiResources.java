package resources;

public enum ApiResources {

	AddPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	UpdatePlaceApi("/maps/api/place/update/json"),
	DeletePlaceApi("/maps/api/place/delete/json");
	private String resource;
	
	ApiResources(String resource){
		this.resource=resource;
	}
	public String getResources(){
		
		return resource;
	}
}
