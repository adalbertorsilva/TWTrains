package factories;

import java.util.List;

import org.junit.Assert;
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
	 */

	@Test
	public void testWaysFromCityA() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('A');

		Assert.assertEquals(ways.size(), 3);
		Assert.assertTrue(ways.contains(new RouteAB()));
		Assert.assertTrue(ways.contains(new RouteAD()));
		Assert.assertTrue(ways.contains(new RouteAE()));

	}

	@Test
	public void testWaysFromCityB() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('B');

		Assert.assertEquals(ways.size(), 1);
		Assert.assertTrue(ways.contains(new RouteBC()));

	}

	@Test
	public void testWaysFromCityC() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('C');

		Assert.assertEquals(ways.size(), 2);
		Assert.assertTrue(ways.contains(new RouteCD()));
		Assert.assertTrue(ways.contains(new RouteCE()));

	}

	@Test
	public void testWaysFromCityD() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('D');

		Assert.assertEquals(ways.size(), 2);
		Assert.assertTrue(ways.contains(new RouteDC()));
		Assert.assertTrue(ways.contains(new RouteDE()));

	}

	@Test
	public void testWaysFromCityE() {

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity('E');

		Assert.assertEquals(ways.size(), 1);
		Assert.assertTrue(ways.contains(new RouteEB()));

	}

}
