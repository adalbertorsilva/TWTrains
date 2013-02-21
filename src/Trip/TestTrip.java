package Trip;

import org.junit.Test;

import exceptions.RouteNotFoundException;

public class TestTrip {

	/**
	 * 1. Test throw an exception when a non-existing route is passed
	 */

	@Test(expected = RouteNotFoundException.class)
	public void testFindingAnExistingRoute() {

		final Trip trip = new Trip('A', 'C');
		trip.getTotalDistance();

	}

}
