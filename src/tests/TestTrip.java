package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import routes.Route;
import trip.Trip;
import city.City;
import exceptions.RouteNotFoundException;

public class TestTrip {

	@Test(expected = RouteNotFoundException.class)
	public void testFindingAnExistingRoute() throws RouteNotFoundException{

		final Trip trip = new Trip(new City("A"),new City("D"));
		trip.addRouteToTrip(new Route(new City("A"), new City("E"), 7));
		trip.addRouteToTrip(new Route(new City("E"), new City("D"), 7));
		trip.getTotalDistance();

	}
	
	@Test
	public void testGetTotalDistanceToTripABC() throws RouteNotFoundException{
		
		final Trip trip = new Trip(new City("A"),new City("C"));
		trip.addRouteToTrip(new Route(new City("A"), new City("B"), 5));
		trip.addRouteToTrip(new Route(new City("B"), new City("C"), 4));
		
		assertEquals(trip.getTotalDistance(), new Integer(9));
	}
	
	@Test
	public void testGetTotalDistanceToTripAD() throws RouteNotFoundException{
		
		final Trip trip = new Trip(new City("A"),new City("D"));
		trip.addRouteToTrip(new Route(new City("A"), new City("D"), 5));
		assertEquals(trip.getTotalDistance(), new Integer(5));
	}
	
	@Test
	public void testGetTotalDistanceToTripADC() throws RouteNotFoundException{
		
		final Trip trip = new Trip(new City("A"),new City("C"));
		trip.addRouteToTrip(new Route(new City("A"), new City("D"), 5));
		trip.addRouteToTrip(new Route(new City("D"), new City("C"), 8));
		assertEquals(trip.getTotalDistance(), new Integer(13));
	}
	
	@Test
	public void testGetTotalDistanceToTripAEBCD() throws RouteNotFoundException{
		
		
		
		final Trip trip = new Trip(new City("A"),new City("D"));
		trip.addRouteToTrip(new Route(new City("A"), new City("E"), 7));
		trip.addRouteToTrip(new Route(new City("E"), new City("B"), 3));
		trip.addRouteToTrip(new Route(new City("B"), new City("C"), 4));
		trip.addRouteToTrip(new Route(new City("C"), new City("D"), 8));
		assertEquals(trip.getTotalDistance(), new Integer(22));
	}
	

}
