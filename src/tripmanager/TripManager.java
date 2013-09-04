package tripmanager;

import java.util.ArrayList;
import java.util.List;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public abstract class TripManager {
	
	protected List<Trip> storedTrips = new ArrayList<Trip>();
	protected Trip actualTrip;
	private City origin;
	private City destiny;
	
	public TripManager(City origin, City destiny) {
		this.origin = origin;
		this.destiny = destiny;
		actualTrip = new Trip(origin, destiny);
	}
	
	public abstract Integer getTripStats(Integer limit) throws RouteNotFoundException;
	
	protected boolean isLastRouteWithTheSameOrigin(Route route){
		return !actualTrip.getTripRoutes().isEmpty() && actualTrip.getTripRoutes().get(actualTrip.getTripRoutes().size() -1).getOrigin().equals(route.getOrigin());
	}
	
	protected boolean isTripsDestiny(Route route) {
		return route.getDestiny().equals(destiny);
	}

	protected City tripStart() {
		return origin;
	}
	
	protected void startAnotherTrip(){
		
		Trip anotherTrip = new Trip(origin, destiny);
		anotherTrip.getTripRoutes().addAll(actualTrip.getTripRoutes());
		actualTrip = anotherTrip;
	}
	
}
