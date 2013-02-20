package routes;

import city.City;


public class RouteAD extends Route {
	
	public RouteAD(){
		distance = 5;
		origin = new City('A');
		destiny = new City('D');
	}

}
