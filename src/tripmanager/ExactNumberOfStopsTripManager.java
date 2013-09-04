package tripmanager;

import routes.Route;
import city.City;
import exceptions.RouteNotFoundException;

public class ExactNumberOfStopsTripManager extends TripManager {

	public ExactNumberOfStopsTripManager(City origin, City destiny) {
		super(origin, destiny);
	}

	@Override
	public Integer getTripStats(Integer limit) throws RouteNotFoundException{
		return findAmountOfTripsWithAExactNumberOfStops(limit, tripStart());
	}
	
	private Integer findAmountOfTripsWithAExactNumberOfStops(Integer exactNumberOfStops, City originCity) throws RouteNotFoundException{
		
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isLastRouteWithTheSameOrigin(route)){
				actualTrip.removeLastRouteFromTrip();
			}
			
			if(actualTrip.getTripRoutes().size() > exactNumberOfStops){
				break ;
			}
			
			actualTrip.addRouteToTrip(route);
			
			if (isTripsDestiny(route) && actualTrip.getTripRoutes().size() == exactNumberOfStops) {
				storedTrips.add(actualTrip);
				startAnotherTrip();
			} else {
				this.findAmountOfTripsWithAExactNumberOfStops(exactNumberOfStops, route.getDestiny());
			}
		}
		
		actualTrip.removeLastRouteFromTrip();

		return storedTrips.size();
	}

}
