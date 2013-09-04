package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tripmanager.ExactNumberOfStopsTripManager;
import tripmanager.LimitedWayTripManager;
import tripmanager.MaximumNumberOfStopsTripManager;
import tripmanager.ShortestRouteTripManager;
import city.City;
import constants.TripManagersEnum;
import factories.TripManagerFactory;


public class TestTripManagerFactory {

	@Test
	public void testGetInstanceOfMaximumNumberOfStopsTripManager(){
		
		assertTrue(TripManagerFactory.getInstance(TripManagersEnum.MAXIMUM_NUMBER_OF_STOPS_TRIP_MANAGER, new City("C"),new City("C")) instanceof MaximumNumberOfStopsTripManager);
	}
	
	@Test
	public void testGetInstanceOfExactNumberOfStopsTripManager(){
		
		assertTrue(TripManagerFactory.getInstance(TripManagersEnum.EXACT_NUMBER_OF_STOPS_TRIP_MANAGER, new City("C"),new City("C")) instanceof ExactNumberOfStopsTripManager);
	}
	
	@Test
	public void testGetInstanceOfShortestRouteTripManager(){
		
		assertTrue(TripManagerFactory.getInstance(TripManagersEnum.SHORTEST_ROUTE_TRIP_MANAGER, new City("C"),new City("C")) instanceof ShortestRouteTripManager);
	}
	
	@Test
	public void testGetInstanceOfLimitedWayTripManager(){
		
		assertTrue(TripManagerFactory.getInstance(TripManagersEnum.LIMITED_WAY_TRIP_MANAGER, new City("C"),new City("C")) instanceof LimitedWayTripManager);
	}

}
