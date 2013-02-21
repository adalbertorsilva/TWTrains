package Trip;

import java.util.Arrays;
import java.util.List;

import routes.Route;

import city.City;
import exceptions.RouteNotFoundException;

public class Trip {

	private final List<Character> cities;

	public Trip(final Character... cities) {

		this.cities = Arrays.asList(cities);
	}

	public Integer getTotalDistance() throws RouteNotFoundException {
		
		Integer totalDistance = 0;
		int i = 0;
		while(i < cities.size() - 1){
			
			City origintCity = new City(cities.get(i));
			City destinyCity = new City(cities.get(i + i));
			
			Route route =  findRoute(origintCity, destinyCity);
			
			totalDistance = totalDistance + route.getDistance();
			
			i++;
		}

		return totalDistance;

	}

	private Route findRoute(City origintCity, City destinyCity) throws RouteNotFoundException {
		
		for(Route route : origintCity.getRoutesFromThisCity()){
			if(route.getDestiny().equals(destinyCity)){
				return route;
			}
		}
		
		throw new RouteNotFoundException();
		
	}

}
