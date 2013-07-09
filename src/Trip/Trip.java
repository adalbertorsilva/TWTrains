
package trip;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import routes.Route;
import city.City;
import exceptions.RouteNotFoundException;

public class Trip {

	private List<Character> cities;
	
	private Collection<Route> tripRoutes;
	
	public Trip(Character... cities) {

		this.cities = Arrays.asList(cities);
	}
	
	public Trip(final Collection<Route> tripRoutes) {

		this.tripRoutes = tripRoutes;
	}

	public Integer getTotalDistance() throws RouteNotFoundException {

		if(tripRoutes != null){
			return getTotalDistanceByRoutes(tripRoutes);
		}else{
			return getTotalDistanceByCities(cities);
		}

	}
	
	private Integer getTotalDistanceByCities(List<Character> cities) throws RouteNotFoundException {

		Integer totalDistance = 0;
		int i = 0;
		while (i < cities.size() - 1) {

			City origintCity = new City(cities.get(i));
			City destinyCity = new City(cities.get(i + 1));

			Route route = findRoute(origintCity, destinyCity);

			totalDistance = totalDistance + route.getDistance();

			i++;
		}

		return totalDistance;

	}
	
	private Integer getTotalDistanceByRoutes(Collection<Route> routes)  {

		Integer totalDistance = 0;
		
		for(Route route : routes){
			totalDistance = totalDistance + route.getDistance();
		}	

		return totalDistance;

	}

	private Route findRoute(City origintCity, City destinyCity)
			throws RouteNotFoundException {

		for (Route route : origintCity.getRoutesFromThisCity()) {
			if (route.getDestiny().equals(destinyCity)) {
				return route;
			}
		}

		throw new RouteNotFoundException();

	}

	public List<Character> getCities() {
		return cities;
	}
	
}
