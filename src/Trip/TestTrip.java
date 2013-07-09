package trip;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import routes.Route;
import routes.RouteAE;
import routes.RouteBC;
import routes.RouteCD;
import routes.RouteEB;

import exceptions.RouteNotFoundException;

public class TestTrip {

	/**
	 * 1. Test throw an exception when a non-existing route is passed ( A-E-D )
	 * @throws RouteNotFoundException
	 * 
	 *  2. Test method that calculate the total trip distance (A-B-C / A-D / A-D-C / A-E-B-C-D) 
	 *  
	 *  3. Test method to find a number of trips of a city to another with a maximum number of stops
	 */

	@Test(expected = RouteNotFoundException.class)
	public void testFindingAnExistingRoute() throws RouteNotFoundException {

		final Trip trip = new Trip('A', 'E', 'D');
		trip.getTotalDistance();

	}
	
	@Test
	public void testGetTotalDistanceToTripABC() throws RouteNotFoundException{
		final Trip trip = new Trip('A', 'B' ,'C');
		assertEquals(trip.getTotalDistance(), new Integer(9));
	}
	
	@Test
	public void testGetTotalDistanceToTripAD() throws RouteNotFoundException{
		final Trip trip = new Trip('A', 'D');
		assertEquals(trip.getTotalDistance(), new Integer(5));
	}
	
	@Test
	public void testGetTotalDistanceToTripADC() throws RouteNotFoundException{
		final Trip trip = new Trip('A', 'D' ,'C');
		assertEquals(trip.getTotalDistance(), new Integer(13));
	}
	
	@Test
	public void testGetTotalDistanceToTripAEBCD() throws RouteNotFoundException{
		final Trip trip = new Trip('A','E','B','C','D');
		assertEquals(trip.getTotalDistance(), new Integer(22));
	}
	
	@Test
	
	public void testGetTotalDistanceToTripAEBCDByRoutes() throws RouteNotFoundException{
		
		List<Route> routes = new ArrayList<Route>();
		routes.add(new RouteAE());
		routes.add(new RouteEB());
		routes.add(new RouteBC());
		routes.add(new RouteCD());
		
		
		final Trip trip = new Trip(routes);
		assertEquals(trip.getTotalDistance(), new Integer(22));
	}
	

}
