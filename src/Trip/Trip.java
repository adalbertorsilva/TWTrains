package Trip;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
		while (i < cities.size() - 1) {

			City origintCity = new City(cities.get(i));
			City destinyCity = new City(cities.get(i + 1));

			Route route = findRoute(origintCity, destinyCity);

			totalDistance = totalDistance + route.getDistance();

			i++;
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



	public Integer getAmountOfTrips(final Integer maximumNumberOfStops) {

		this.numberOfTrips = 0;
		return this.findAmountOfTrips(maximumNumberOfStops,
				tripStart(), 0, new LinkedHashSet<Route>());
	}

	private Integer findAmountOfTrips(final Integer maximumNumberOfStops, final City originCity, int numberOfStops, final Set<Route> traveledRoutes) {

		routes: for (final Route route : originCity.getRoutesFromThisCity()) {

			if (route.getOrigin().equals(tripStart()) && this.isRouteNeverTraveled(traveledRoutes, route)) {
				numberOfStops = 0;
			}

			while (numberOfStops <= maximumNumberOfStops) {
				if (route.getOrigin().equals(tripDestiny()) && this.isRouteNeverTraveled(traveledRoutes, route)) {
					this.numberOfTrips++;
					traveledRoutes.add(route);
					continue routes;
				} else {
					traveledRoutes.add(route);
					this.findAmountOfTrips(maximumNumberOfStops, route.getDestiny(), ++numberOfStops, traveledRoutes);
				}

			}

		}

		return this.numberOfTrips;
	}

	private City tripDestiny() {
		return new City(this.cities.get(this.cities.size() - 1));
	}

	private City tripStart() {
		return new City(this.cities.get(0));
	}
	
	private boolean isRouteNeverTraveled(final Set<Route> seenRoutes, final Route route) {

		return !seenRoutes.contains(route);
	}
	


}
