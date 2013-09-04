package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tripmanager.TripManager;
import city.City;
import constants.TripManagersEnum;
import exceptions.RouteNotFoundException;
import factories.TripManagerFactory;

public class TestTripManager {

	@Test
	public void testGetNumberOfTripsWithAMaximumNumberOfStops() throws RouteNotFoundException{
		TripManager tripManager = TripManagerFactory.getInstance(TripManagersEnum.MAXIMUM_NUMBER_OF_STOPS_TRIP_MANAGER, new City("C"),new City("C"));
		assertEquals(tripManager.getTripStats(3), new Integer(2));
	}
	
	@Test
	public void testGetNumberOfTripsWithNumberOfStops() throws RouteNotFoundException{
		TripManager tripManager = TripManagerFactory.getInstance(TripManagersEnum.EXACT_NUMBER_OF_STOPS_TRIP_MANAGER, new City("A"),new City("C"));
		assertEquals(tripManager.getTripStats(4), new Integer(3));
	}
	
	@Test
	public void testFindingTheShortestRouteFromAToC() throws RouteNotFoundException{
		TripManager tripManager = TripManagerFactory.getInstance(TripManagersEnum.SHORTEST_ROUTE_TRIP_MANAGER, new City("A"),new City("C"));
		assertEquals(tripManager.getTripStats(null), new Integer(9));
	}
	
	@Test
	public void testFindingTheShortestRouteFromBToB() throws RouteNotFoundException{
		TripManager tripManager = TripManagerFactory.getInstance(TripManagersEnum.SHORTEST_ROUTE_TRIP_MANAGER, new City("B"),new City("B"));
		assertEquals(tripManager.getTripStats(null), new Integer(9));
	}
	
	@Test
	public void testFindingRoutesFromCToCWithAWaySmallerThan30() throws RouteNotFoundException{
		TripManager tripManager = TripManagerFactory.getInstance(TripManagersEnum.LIMITED_WAY_TRIP_MANAGER, new City("C"),new City("C"));
		assertEquals(tripManager.getTripStats(30), new Integer(7));
	}

}
