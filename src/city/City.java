package city;


import java.util.List;

import factories.RouteFactory;

import routes.Route;



public class City {

	private Character cityName;
	
	private List<Route> routesFromThisCity;
	
	public City (Character cityName){
		this.cityName = cityName;
		routesFromThisCity = RouteFactory.createRoutesFromTheCity(cityName);
	}

	public Character getCityName(){
		return cityName;
	}
	
	public List<Route> getRoutesFromThisCity() {
		return routesFromThisCity;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof City){
			return ((City)obj).getCityName().equals(this.cityName);
		}
	
		return false;
	}
	
	
	
}
