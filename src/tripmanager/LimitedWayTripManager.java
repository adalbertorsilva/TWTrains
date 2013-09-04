package tripmanager;

import routes.Route;
import city.City;
import exceptions.RouteNotFoundException;

public class LimitedWayTripManager extends DistanceTripManager {

	public LimitedWayTripManager(City origin, City destiny) {
		super(origin, destiny);
	}

	@Override
	public Integer getTripStats(Integer limit) throws RouteNotFoundException{
		return findTripsThatHaveWaysSmallerThan(tripStart(), limit);
	}
	
	private Integer findTripsThatHaveWaysSmallerThan(City originCity, Integer wayLength) throws RouteNotFoundException{
		
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isTravelingInCircles(route)){
				continue;
			}
			
			if(isLastRouteWithTheSameOrigin(route)){
				actualTrip.removeLastRouteFromTrip();
			}
			
			actualTrip.addRouteToTrip(route);

			if (isTripsDestiny(route) && isLengthExceded(wayLength)) {
				storedTrips.add(actualTrip);
				startAnotherTrip();
			}
			
			if(isLengthExceded(wayLength)){
				this.findTripsThatHaveWaysSmallerThan(route.getDestiny(), wayLength);
			}
			
		}
		
		actualTrip.removeLastRouteFromTrip();

		return storedTrips.size();
		
	}

	private boolean isLengthExceded(Integer wayLength)
			throws RouteNotFoundException{
		return actualTrip.getTotalDistance() < wayLength;
	}
	
}
