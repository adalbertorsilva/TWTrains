package tripmanager;

import java.util.Collections;
import java.util.List;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public class ShortestRouteTripManager extends DistanceTripManager {

	public ShortestRouteTripManager(City origin, City destiny) {
		super(origin, destiny);
	}

	@Override
	public Integer getTripStats(Integer limit) throws RouteNotFoundException{
		
		return findShortestRoute(tripStart());
	}
	
	private Integer findShortestRoute(City originCity) throws RouteNotFoundException{
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isTravelingInCircles(route)){
				break;
			}
			
			if(isLastRouteWithTheSameOrigin(route)){
				actualTrip.removeLastRouteFromTrip();
			}

			if ( updateTripRoute(route) && isTripsDestiny(route)) {
				storedTrips.add(actualTrip);
				startAnotherTrip();
			} else {
				this.findShortestRoute(route.getDestiny());
			}
		}
		
		actualTrip.removeLastRouteFromTrip();

		return shortestRoute(storedTrips);
	}
	
	private boolean updateTripRoute(Route route) {
		
		boolean updated = false;
		
		if(!actualTrip.getTripRoutes().contains(route)){
			updated = actualTrip.getTripRoutes().add(route);
		}
		
		return updated; 
	}
	
	private Integer shortestRoute(List<Trip> trips) throws RouteNotFoundException{
		
		Collections.sort(trips);

		if(trips.isEmpty()){
			return 0;
		}
		
		return trips.get(0).getTotalDistance();
		
	}

}
