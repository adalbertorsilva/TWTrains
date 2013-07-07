package Trip;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RouteNotFoundException;

public class TestTripManager {

	@Test
	public void testGetNumberOfTripsWithAMaximumNumberOfStops(){
		Trip trip = new Trip('C','C');
		TripManager tripManager = new TripManager(trip);
		assertEquals(tripManager.getAmountOfTripsWithMaximumStops(3), new Integer(2));
	}
	
	@Test
	public void testGetNumberOfTripsWithNumberOfStops() throws RouteNotFoundException{
		Trip trip = new Trip('A','C');
		TripManager tripManager = new TripManager(trip);
		assertEquals(tripManager.getAmountOfTripsWithExactlyStops(4), new Integer(3));
	}
	
	@Test
	public void testFindingTheShortestRouteFromAToC() throws RouteNotFoundException{
		Trip trip = new Trip('A','C');
		TripManager tripManager = new TripManager(trip);
		assertEquals(tripManager.getShortestRoute(), new Integer(9));
	}
	
	@Test
	public void testFindingTheShortestRouteFromBToB() throws RouteNotFoundException{
		Trip trip = new Trip('B','B');
		TripManager tripManager = new TripManager(trip);
		assertEquals(tripManager.getShortestRoute(), new Integer(9));
	}
	
//	@Test
//	public void testFindingRoutesFromCToCWithAWaySmallerThan30() throws RouteNotFoundException{
//		Trip trip = new Trip('C','C');
//		TripManager tripManager = new TripManager(trip);
//		assertEquals(tripManager.getRoutesThatHaveWaysSmallerThan(30), new Integer(7));
//	}

}
