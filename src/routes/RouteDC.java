package routes;

import city.City;

public class RouteDC extends Route{
	
	public RouteDC(){
		distance = 8;
		origin = new City('D');
		destiny = new City('C');
	}

}
