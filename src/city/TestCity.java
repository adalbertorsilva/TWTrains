package city;

import static org.junit.Assert.*;
import org.junit.Test;

import routes.Route;
import routes.RouteAB;
import routes.RouteAD;
import routes.RouteAE;

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
	public void testAmountOfRoutesFromCityA() {

		final City cityA = new City('A');
		assertEquals(cityA.getRoutesFromThisCity().size(), 3);
		assertTrue(cityA.getRoutesFromThisCity().contains(new RouteAB()));
		assertTrue(cityA.getRoutesFromThisCity().contains(new RouteAD()));
		assertTrue(cityA.getRoutesFromThisCity().contains(new RouteAE()));
	}

	@Test
	public void testIfCityIsTheOriginOfItsRoutes() {

		final City cityA = new City('A');

		for (final Route route : cityA.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityA);
		}
	}
}
