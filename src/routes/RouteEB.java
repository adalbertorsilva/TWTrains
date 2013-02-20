package routes;

import city.City;

public class RouteEB extends Route{
	
	public RouteEB(){
		distance = 3;
		origin = new City('E');
		destiny = new City('B');
	}

}
