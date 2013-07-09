package tripmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public abstract class TripManager {
	
	protected Set<Collection<Route>> storedTripRoutes = new LinkedHashSet<Collection<Route>>();
	protected List<Route> actualTripRoute = new ArrayList<Route>();
	protected Trip trip;
	
	public TripManager(Trip trip) {
		this.trip = trip;
	}
	
	
	public abstract Integer getTrip(Integer limit) throws RouteNotFoundException;
	
	protected void removeLastRoute(List<Route> routes){
		if(!routes.isEmpty()){
			routes.remove(routes.size() -1);	
		}
		
	}
	
	protected boolean isTravelingInCircles(Route route) {
		return actualTripRoute.size() >= 2 && 
				actualTripRoute.get(actualTripRoute.size() -2).equals(route);
	}
	
	protected boolean isLastRouteWithTheSameOrigin(Route route){
		return !actualTripRoute.isEmpty() && actualTripRoute.get(actualTripRoute.size() -1).getOrigin().equals(route.getOrigin());
	}
	
	private City tripDestiny() {
		return new City(trip.getCities().get(trip.getCities().size() - 1));
	}
	
	protected boolean isTripsDestiny(Route route) {
		return route.getDestiny().equals(tripDestiny());
	}

	protected City tripStart() {
		return new City(trip.getCities().get(0));
	}
	
}
