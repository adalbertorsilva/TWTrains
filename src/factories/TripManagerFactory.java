package factories;

import trip.Trip;
import tripmanager.LimitedWayTripManager;
import tripmanager.ShortestRouteTripManager;
import tripmanager.TripManager;
import tripmanager.MaximumNumberOfStopsTripManager;
import tripmanager.ExactNumberOfStopsTripManager;
import contants.TripManagersEnum;

public class TripManagerFactory {

	public static TripManager getInstance(TripManagersEnum tripManager, Trip trip) {
		
		switch (tripManager) {
		
			case MAXIMUM_NUMBER_OF_STOPS_TRIP_MANAGER:
				
				return new MaximumNumberOfStopsTripManager(trip);
				
			case EXACT_NUMBER_OF_STOPS_TRIP_MANAGER:
				
				return new ExactNumberOfStopsTripManager(trip);
				
			case SHORTEST_ROUTE_TRIP_MANAGER:
				
				return new ShortestRouteTripManager(trip);
			
			case LIMITED_WAY_TRIP_MANAGER:
				return new LimitedWayTripManager(trip);

		default:
			return null;
		}
		
		
		
	}
	
	
	

}