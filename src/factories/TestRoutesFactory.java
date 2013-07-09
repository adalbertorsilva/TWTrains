package factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

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

public class TestRoutesFactory {

	/**
	 * 1. Test ways from A
	 * 
	 * 2. Test ways from B
	 * 
	 * 3. Test ways from C
	 * 
	 * 4. Test ways from D
	 * 
	 * 5. Test ways from E
	 * 
	 * 6. Test create route A -> B
	 * 
	 * 6. Test create route A -> D
	 * 
	 * 6. Test create route A -> E
	 * 
	 * 6. Test create route B -> C
	 * 
	 * 6. Test create route C -> D
	 * 
	 * 6. Test create route C -> E
	 * 
	 * 6. Test create route D -> C
	 * 
	 * 6. Test create route D -> E
	 * 
	 * 6. Test create route E -> B
	 */

	@Test
	public void testWaysFromCityA() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('A');

		assertEquals(ways.size(), 3);
		assertTrue(ways.contains(new RouteAB()));
		assertTrue(ways.contains(new RouteAD()));
		assertTrue(ways.contains(new RouteAE()));

	}

	@Test
	public void testWaysFromCityB() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('B');

		assertEquals(ways.size(), 1);
		assertTrue(ways.contains(new RouteBC()));

	}

	@Test
	public void testWaysFromCityC() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('C');

		assertEquals(ways.size(), 2);
		assertTrue(ways.contains(new RouteCD()));
		assertTrue(ways.contains(new RouteCE()));

	}

	@Test
	public void testWaysFromCityD() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('D');

		assertEquals(ways.size(), 2);
		assertTrue(ways.contains(new RouteDC()));
		assertTrue(ways.contains(new RouteDE()));

	}

	@Test
	public void testWaysFromCityE() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('E');

		assertEquals(ways.size(), 1);
		assertTrue(ways.contains(new RouteEB()));

	}
	
}
