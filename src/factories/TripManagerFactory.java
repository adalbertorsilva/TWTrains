package factories;

import tripmanager.ExactNumberOfStopsTripManager;
import tripmanager.LimitedWayTripManager;
import tripmanager.MaximumNumberOfStopsTripManager;
import tripmanager.ShortestRouteTripManager;
import tripmanager.TripManager;
import city.City;
import constants.TripManagersEnum;

public class TripManagerFactory {

	public static TripManager getInstance(TripManagersEnum tripManager, City origin, City destiny) {
		
		switch (tripManager) {
		
			case MAXIMUM_NUMBER_OF_STOPS_TRIP_MANAGER:
				
				return new MaximumNumberOfStopsTripManager(origin, destiny);
				
			case EXACT_NUMBER_OF_STOPS_TRIP_MANAGER:
				
				return new ExactNumberOfStopsTripManager(origin, destiny);
				
			case SHORTEST_ROUTE_TRIP_MANAGER:
				
				return new ShortestRouteTripManager(origin, destiny);
			
			case LIMITED_WAY_TRIP_MANAGER:
				return new LimitedWayTripManager(origin, destiny);

		default:
			return null;
		}
		
		
		
	}
	
	
	

}
