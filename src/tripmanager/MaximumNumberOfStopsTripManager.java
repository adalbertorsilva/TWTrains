package tripmanager;

import java.util.ArrayList;

import routes.Route;
import trip.Trip;
import city.City;

public class MaximumNumberOfStopsTripManager extends TripManager{

	public MaximumNumberOfStopsTripManager(Trip trip) {
		super(trip);
	}

	@Override
	public Integer getTripStats(Integer limit){
		return findAmountOfTripsWithMaximumStops(limit, tripStart());
	}
	
	private Integer findAmountOfTripsWithMaximumStops(Integer maximumNumberOfStops, City originCity){

		for (Route route : originCity.getRoutesFromThisCity()) {

			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}
			
			if(actualTripRoute.size() > maximumNumberOfStops){
				break;
			}
			
			actualTripRoute.add(route);

			if (isTripsDestiny(route) && actualTripRoute.size() <= maximumNumberOfStops) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			} else {
				this.findAmountOfTripsWithMaximumStops(maximumNumberOfStops, route.getDestiny());
			}
			
		}
		
		removeLastRoute(actualTripRoute);

		return storedTripRoutes.size();
	}

}
