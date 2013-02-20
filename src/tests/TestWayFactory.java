package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import classes.Way;
import classes.WayAB;
import classes.WayAD;
import classes.WayAE;
import classes.WayFactory;

public class TestWayFactory {

	@Test
	public void testWaysFromCityA() {
		
		List<Way> ways = WayFactory.createWaysFromTheCity('A');
		
		assertEquals(ways.size(), 3);
		assertTrue(ways.contains(new WayAB()));
		assertTrue(ways.contains(new WayAD()));
		assertTrue(ways.contains(new WayAE()));
		
	}

}
