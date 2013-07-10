package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import routes.Route;
import city.City;

public class TestCity {



	@Test
	public void testNameFromCityA() {

		final City cityA = new City("A");
		assertEquals(cityA.getCityName(), "A");

	}

	@Test
	public void testAmountOfRoutesFromCityA() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityA = new City("A");
		assertEquals(cityA.getRoutesFromThisCity().size(), 3);
		assertTrue(cityA.getRoutesFromThisCity().contains(new Route(new City("A"), new City("B"), 5)));
		assertTrue(cityA.getRoutesFromThisCity().contains(new Route(new City("A"), new City("D"), 5)));
		assertTrue(cityA.getRoutesFromThisCity().contains(new Route(new City("A"), new City("E"), 7)));
	}

	@Test
	public void testIfCityAIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityA = new City("A");

		for (final Route route : cityA.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityA);
		}
	}
	
	
	@Test
	public void testNameFromCityB() {

		final City cityB = new City("B");
		assertEquals(cityB.getCityName(), "B");

	}

	@Test
	public void testAmountOfRoutesFromCityB() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityB = new City("B");
		assertEquals(cityB.getRoutesFromThisCity().size(), 1);
		assertTrue(cityB.getRoutesFromThisCity().contains(new Route(new City("B"), new City("C"), 4)));
	}

	@Test
	public void testIfCityBIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityB = new City("B");

		for (final Route route : cityB.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityB);
		}
	}
	
	@Test
	public void testNameFromCityC() {

		final City cityC = new City("C");
		assertEquals(cityC.getCityName(), "C");

	}

	@Test
	public void testAmountOfRoutesFromCityC() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityC = new City("C");
		assertEquals(cityC.getRoutesFromThisCity().size(), 2);
		assertTrue(cityC.getRoutesFromThisCity().contains(new Route(new City("C"), new City("D"), 8)));
		assertTrue(cityC.getRoutesFromThisCity().contains(new Route(new City("C"), new City("E"), 2)));
	}

	@Test
	public void testIfCityCIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityC = new City("C");

		for (final Route route : cityC.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityC);
		}
	}
	
	@Test
	public void testNameFromCityD() {

		final City cityD = new City("D");
		assertEquals(cityD.getCityName(), "D");

	}

	@Test
	public void testAmountOfRoutesFromCityD() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityD = new City("D");
		assertEquals(cityD.getRoutesFromThisCity().size(), 2);
		assertTrue(cityD.getRoutesFromThisCity().contains(new Route(new City("D"), new City("C"), 8)));
		assertTrue(cityD.getRoutesFromThisCity().contains(new Route(new City("D"), new City("E"), 6)));
	}

	@Test
	public void testIfCityDIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityD = new City("D");

		for (final Route route : cityD.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityD);
		}
	}
	
	@Test
	public void testNameFromCityE() {

		final City cityE = new City("E");
		assertEquals(cityE.getCityName(), "E");

	}

	@Test
	public void testAmountOfRoutesFromCityE() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityE = new City("E");
		assertEquals(cityE.getRoutesFromThisCity().size(), 1);
		assertTrue(cityE.getRoutesFromThisCity().contains(new Route(new City("E"), new City("B"), 3)));
	}

	@Test
	public void testIfCityEIsTheOriginOfItsRoutes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		final City cityE = new City("E");

		for (final Route route : cityE.getRoutesFromThisCity()) {
			assertEquals(route.getOrigin(), cityE);
		}
	}
}
