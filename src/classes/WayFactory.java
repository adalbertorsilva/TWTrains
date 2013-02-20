package classes;

import java.util.ArrayList;
import java.util.List;

public class WayFactory {
	
	public static List<Way> createWaysFromTheCity(Character cityName){
		
		List<Way> ways = new ArrayList<Way>();
		
		switch (cityName) {
		case 'A':
			
			ways.add(new WayAB());
			ways.add(new WayAD());
			ways.add(new WayAE());
			break;

		default:
			break;
		}
		
		return ways;
		
	}

}
