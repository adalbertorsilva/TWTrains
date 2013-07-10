package tripmanager;

import java.util.ArrayList;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public class ExactNumberOfStopsTripManager extends TripManager {

	public ExactNumberOfStopsTripManager(Trip trip) {
		super(trip);
	}

	@Override
	public Integer getTripStats(Integer limit) throws RouteNotFoundException{
		return findAmountOfTripsWithAExactNumberOfStops(limit, tripStart());
	}
	
	private Integer findAmountOfTripsWithAExactNumberOfStops(Integer exactNumberOfStops, City originCity) throws RouteNotFoundException{
		
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}
			
			if(actualTripRoute.size() > exactNumberOfStops){
				break ;
			}
			
			actualTripRoute.add(route);
			
			if (isTripsDestiny(route) && actualTripRoute.size() == exactNumberOfStops) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			} else {
				this.findAmountOfTripsWithAExactNumberOfStops(exactNumberOfStops, route.getDestiny());
			}
		}
		
		removeLastRoute(actualTripRoute);

		return storedTripRoutes.size();
	}

}
