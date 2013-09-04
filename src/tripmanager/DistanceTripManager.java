package tripmanager;

import routes.Route;
import city.City;

public abstract class DistanceTripManager extends TripManager{

	public DistanceTripManager(City origin, City destiny) {
		super(origin, destiny);
	}
	
	protected boolean isTravelingInCircles(Route route) {
		return actualTrip.getTripRoutes().size() >= 2 && 
				actualTrip.getTripRoutes().get(actualTrip.getTripRoutes().size() -2).equals(route);
	}
}
