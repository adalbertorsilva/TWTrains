package tripmanager;

import routes.Route;
import city.City;

public class MaximumNumberOfStopsTripManager extends TripManager{

	public MaximumNumberOfStopsTripManager(City origin, City destiny) {
		super(origin, destiny);
	}

	@Override
	public Integer getTripStats(Integer limit){
		return findAmountOfTripsWithMaximumStops(limit, tripStart());
	}
	
	private Integer findAmountOfTripsWithMaximumStops(Integer maximumNumberOfStops, City originCity){

		for (Route route : originCity.getRoutesFromThisCity()) {

			if(isLastRouteWithTheSameOrigin(route)){
				actualTrip.removeLastRouteFromTrip();
			}
			
			if(actualTrip.getTripRoutes().size() > maximumNumberOfStops){
				break;
			}
			
			actualTrip.addRouteToTrip(route);

			if (isTripsDestiny(route) && actualTrip.getTripRoutes().size() <= maximumNumberOfStops) {
				storedTrips.add(actualTrip);
				startAnotherTrip();
				break;
			} else {
				this.findAmountOfTripsWithMaximumStops(maximumNumberOfStops, route.getDestiny());
			}
			
		}
		
		actualTrip.removeLastRouteFromTrip();

		return storedTrips.size();
	}

}
