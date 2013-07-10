package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import city.City;
import factories.RoutesFactory;

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

	@Test
	public void testWaysFromCityA(){

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity(new City('A'));

		assertEquals(ways.size(), 3);
		assertTrue(ways.contains(new RouteAB()));
		assertTrue(ways.contains(new RouteAD()));
		assertTrue(ways.contains(new RouteAE()));

	}

	@Test
	public void testWaysFromCityB(){

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity(new City('B'));

		assertEquals(ways.size(), 1);
		assertTrue(ways.contains(new RouteBC()));

	}

	@Test
	public void testWaysFromCityC(){

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity(new City('C'));

		assertEquals(ways.size(), 2);
		assertTrue(ways.contains(new RouteCD()));
		assertTrue(ways.contains(new RouteCE()));

	}

	@Test
	public void testWaysFromCityD(){

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity(new City('D'));

		assertEquals(ways.size(), 2);
		assertTrue(ways.contains(new RouteDC()));
		assertTrue(ways.contains(new RouteDE()));

	}

	@Test
	public void testWaysFromCityE(){

		final List<Route> ways = RoutesFactory.createRoutesFromTheCity(new City('E'));

		assertEquals(ways.size(), 1);
		assertTrue(ways.contains(new RouteEB()));

	}
	
}
