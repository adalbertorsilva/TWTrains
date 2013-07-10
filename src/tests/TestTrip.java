package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public class TestTrip {

	@Test(expected = RouteNotFoundException.class)
	public void testFindingAnExistingRoute() throws RouteNotFoundException{

		final Trip trip = new Trip("A", "E", "D");
		trip.getTotalDistance();

	}
	
	@Test
	public void testGetTotalDistanceToTripABC() throws RouteNotFoundException{
		final Trip trip = new Trip("A", "B" ,"C");
		assertEquals(trip.getTotalDistance(), new Integer(9));
	}
	
	@Test
	public void testGetTotalDistanceToTripAD() throws RouteNotFoundException{
		final Trip trip = new Trip("A", "D");
		assertEquals(trip.getTotalDistance(), new Integer(5));
	}
	
	@Test
	public void testGetTotalDistanceToTripADC() throws RouteNotFoundException{
		final Trip trip = new Trip("A", "D" ,"C");
		assertEquals(trip.getTotalDistance(), new Integer(13));
	}
	
	@Test
	public void testGetTotalDistanceToTripAEBCD() throws RouteNotFoundException{
		final Trip trip = new Trip("A","E","B","C","D");
		assertEquals(trip.getTotalDistance(), new Integer(22));
	}
	
	@Test
	
	public void testGetTotalDistanceToTripAEBCDByRoutes() throws RouteNotFoundException{
		
		List<Route> routes = new ArrayList<Route>();
		routes.add(new Route(new City("A"), new City("E"), 7));
		routes.add(new Route(new City("E"), new City("B"), 3));
		routes.add(new Route(new City("B"), new City("C"), 4));
		routes.add(new Route(new City("C"), new City("D"), 8));
		
		
		final Trip trip = new Trip(routes);
		assertEquals(trip.getTotalDistance(), new Integer(22));
	}
	

}
