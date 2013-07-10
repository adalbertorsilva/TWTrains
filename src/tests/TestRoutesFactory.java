package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import routes.Route;
import city.City;
import factories.RoutesFactory;

public class TestRoutesFactory {

	@Test
	public void testWaysFromCityA(){

		final List<Route> ways = RoutesFactory.createRoutesFrom(new City("A"));

		assertEquals(ways.size(), 3);
		assertTrue(ways.contains(new Route(new City("A"), new City("B"), 5)));
		assertTrue(ways.contains(new Route(new City("A"), new City("D"), 5)));
		assertTrue(ways.contains(new Route(new City("A"), new City("E"), 7)));

	}

	@Test
	public void testWaysFromCityB(){

		final List<Route> ways = RoutesFactory.createRoutesFrom(new City("B"));

		assertEquals(ways.size(), 1);
		assertTrue(ways.contains(new Route(new City("B"), new City("C"), 4)));

	}

	@Test
	public void testWaysFromCityC(){

		final List<Route> ways = RoutesFactory.createRoutesFrom(new City("C"));

		assertEquals(ways.size(), 2);
		assertTrue(ways.contains(new Route(new City("C"), new City("D"), 8)));
		assertTrue(ways.contains(new Route(new City("C"), new City("E"), 2)));

	}

	@Test
	public void testWaysFromCityD(){

		final List<Route> ways = RoutesFactory.createRoutesFrom(new City("D"));

		assertEquals(ways.size(), 2);
		assertTrue(ways.contains(new Route(new City("D"), new City("C"), 8)));
		assertTrue(ways.contains(new Route(new City("D"), new City("E"), 6)));

	}

	@Test
	public void testWaysFromCityE(){

		final List<Route> ways = RoutesFactory.createRoutesFrom(new City("E"));

		assertEquals(ways.size(), 1);
		assertTrue(ways.contains(new Route(new City("E"), new City("B"), 3)));

	}
	
}
