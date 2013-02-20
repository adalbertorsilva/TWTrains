package routes;

import city.City;


public class RouteBC extends Route {

	public RouteBC(){
		distance = 4;
		origin = new City('B');
		destiny = new City('C');
	}
	
	@Override
	public Integer getDistance() {
		return distance;
	}

}
