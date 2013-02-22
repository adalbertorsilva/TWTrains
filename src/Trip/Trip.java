package Trip;

import java.util.Arrays;
import java.util.List;

import routes.Route;

import city.City;
import exceptions.RouteNotFoundException;

public class Trip {

	private final List<Character> cities;
	
	private Integer numberOfTrips = 0;

	public Trip(final Character... cities) {

		this.cities = Arrays.asList(cities);
	}

	public Integer getTotalDistance() throws RouteNotFoundException {
		
		Integer totalDistance = 0;
		int i = 0;
		while(i < cities.size() - 1){
			
			City origintCity = new City(cities.get(i));
			City destinyCity = new City(cities.get(i + 1));
			
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

	public Integer getNumberOfTrips(Integer maximumNumberOfStops) {
		
		numberOfTrips = 0;
		return findTrips(maximumNumberOfStops, new City(cities.get(0)), 1);
	}

	private Integer findTrips(Integer maximumNumberOfStops, City originCity, int numberOfStops) {
		while(numberOfStops < maximumNumberOfStops){
			
			routes:
			for(Route route : originCity.getRoutesFromThisCity()){
				
				if(route.getDestiny().equals(new City(cities.get(cities.size() -1)))){
					numberOfTrips++;
					continue routes;
				}
				
				findTrips(maximumNumberOfStops, route.getDestiny(), ++numberOfStops);
			}
		
			numberOfStops++;
		}
		
		return numberOfTrips;
	}

}
