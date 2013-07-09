package tripmanager;

import java.util.ArrayList;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public class LimitedWayTripManager extends TripManager {

	public LimitedWayTripManager(Trip trip) {
		super(trip);
	}

	@Override
	public Integer getTrip(Integer limit) throws RouteNotFoundException{
		return findTripsThatHaveWaysSmallerThan(tripStart(), limit);
	}
	
	private Integer findTripsThatHaveWaysSmallerThan(City originCity, Integer wayLength) throws RouteNotFoundException{
		
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isTravelingInCircles(route)){
				continue;
			}
			
			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}
			
			actualTripRoute.add(route);

			if (isTripsDestiny(route) && isLengthExceded(wayLength)) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			}
			
			if(isLengthExceded(wayLength)){
				this.findTripsThatHaveWaysSmallerThan(route.getDestiny(), wayLength);
			}
			
		}
		
		removeLastRoute(actualTripRoute);

		return storedTripRoutes.size();
		
	}

	private boolean isLengthExceded(Integer wayLength)
			throws RouteNotFoundException {
		return getTripDistance() < wayLength;
	}
	
	private Integer getTripDistance() throws RouteNotFoundException{
		return new Trip(actualTripRoute).getTotalDistance();
	}

}
