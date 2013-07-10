package tripmanager;

import java.util.ArrayList;
import java.util.Collection;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public class ShortestRouteTripManager extends TripManager {

	public ShortestRouteTripManager(Trip trip) {
		super(trip);
	}

	@Override
	public Integer getTrip(Integer limit) throws RouteNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		return findShortestRoute(tripStart());
	}
	
	private Integer findShortestRoute(City originCity) throws RouteNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isTravelingInCircles(route)){
				break;
			}
			
			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}

			if ( updateTripRoute(route) && isTripsDestiny(route)) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			} else {
				this.findShortestRoute(route.getDestiny());
			}
		}
		
		removeLastRoute(actualTripRoute);

		return shortestRoute(storedTripRoutes);
	}
	
	private boolean updateTripRoute(Route route) {
		
		boolean updated = false;
		
		if(!actualTripRoute.contains(route)){
			updated = actualTripRoute.add(route);
		}
		
		return updated; 
	}
	
	private Integer shortestRoute(Collection<Collection<Route>> tripRoutes) throws RouteNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Integer shortestDistance = 0;
		
		for(Collection<Route> trips : tripRoutes){
			
			Integer tripDistance = new Trip(trips).getTotalDistance();
			
			if(shortestDistance == 0){
				shortestDistance = tripDistance;
			}
			
			if(shortestDistance > tripDistance){
				shortestDistance = tripDistance;
			}
			
		}
		
		return shortestDistance;
		
	}

}
