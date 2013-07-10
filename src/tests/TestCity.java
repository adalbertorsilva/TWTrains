package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import city.City;

import routes.Route;
import routes.RouteAB;
import routes.RouteAD;
import routes.RouteAE;
import routes.RouteBC;
import routes.RouteCD;
import routes.RouteCE;
import routes.RouteDC;
import routes.RouteDE;
import routes.RouteEB;

public class TestCity {

	/**
	 * 1. Test city name from city A
	 * 
	 * 2. Test amount of routes from city A
	 * 
	 * 3. Test if the origin from the routes is the city A
	 * 
	 * 4. Test city name from city B
	 * 
	 * 5. Test amount of routes from city B
	 * 
	 * 6. Test if the origin from the routes is the city B
	 * 
	 * 7. Test city name from city C
	 * 
	 * 8. Test amount of routes from city C
	 * 
	 * 9. Test if the origin from the routes is the city C
	 * 
	 * 10. Test city name from city D
	 * 
	 * 11. Test amount of routes from city D
	 * 
	 * 12. Test if the origin from the routes is the city D
	 * 
	 * 13. Test city name from city E
	 * 
	 * 14. Test amount of routes from city E
	 * 
	 * 15. Test if the origin from the routes is the city E
	 * 
	 */

	@Test
	public void testNameFromCityA() {

		final City cityA = new City('A');
		assertEquals(cityA.getCityName(), new Character('A'));

	}

	@Test
	public void testAmountOfRoutesFromCityA() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityA = new City('A');
		assertEquals(cityA.getRoutesFromThisCity().size(), 3);
		assertTrue(cityA.getRoutesFromThisCity().contains(new RouteAB()));
		assertTrue(cityA.getRoutesFromThisCity().contains(new RouteAD()));
		assertTrue(cityA.getRoutesFromThisCity().contains(new RouteAE()));
	}

	@Test
	public void testIfCityAIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityA = new City('A');

		for (final Route route : cityA.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityA);
		}
	}
	
	
	@Test
	public void testNameFromCityB() {

		final City cityB = new City('B');
		assertEquals(cityB.getCityName(), new Character('B'));

	}

	@Test
	public void testAmountOfRoutesFromCityB() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityB = new City('B');
		assertEquals(cityB.getRoutesFromThisCity().size(), 1);
		assertTrue(cityB.getRoutesFromThisCity().contains(new RouteBC()));
	}

	@Test
	public void testIfCityBIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityB = new City('B');

		for (final Route route : cityB.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityB);
		}
	}
	
	@Test
	public void testNameFromCityC() {

		final City cityC = new City('C');
		assertEquals(cityC.getCityName(), new Character('C'));

	}

	@Test
	public void testAmountOfRoutesFromCityC() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityC = new City('C');
		assertEquals(cityC.getRoutesFromThisCity().size(), 2);
		assertTrue(cityC.getRoutesFromThisCity().contains(new RouteCE()));
		assertTrue(cityC.getRoutesFromThisCity().contains(new RouteCD()));
	}

	@Test
	public void testIfCityCIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityC = new City('C');

		for (final Route route : cityC.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityC);
		}
	}
	
	@Test
	public void testNameFromCityD() {

		final City cityD = new City('D');
		assertEquals(cityD.getCityName(), new Character('D'));

	}

	@Test
	public void testAmountOfRoutesFromCityD() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityD = new City('D');
		assertEquals(cityD.getRoutesFromThisCity().size(), 2);
		assertTrue(cityD.getRoutesFromThisCity().contains(new RouteDC()));
		assertTrue(cityD.getRoutesFromThisCity().contains(new RouteDE()));
	}

	@Test
	public void testIfCityDIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityD = new City('D');

		for (final Route route : cityD.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityD);
		}
	}
	
	@Test
	public void testNameFromCityE() {

		final City cityE = new City('E');
		assertEquals(cityE.getCityName(), new Character('E'));

	}

	@Test
	public void testAmountOfRoutesFromCityE() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityE = new City('E');
		assertEquals(cityE.getRoutesFromThisCity().size(), 1);
		assertTrue(cityE.getRoutesFromThisCity().contains(new RouteEB()));
	}

	@Test
	public void testIfCityEIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityE = new City('E');

		for (final Route route : cityE.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityE);
		}
	}
}
