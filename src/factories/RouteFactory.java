package factories;

import java.util.ArrayList;
import java.util.List;

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


public class RouteFactory {
	
	public static List<Route> createRoutesFromTheCity(Character cityName){
		
		List<Route> routes = new ArrayList<Route>();
		
		switch (cityName) {
		case 'A':
			
			routes.add(new RouteAB());
			routes.add(new RouteAD());
			routes.add(new RouteAE());
			break;

		case 'B':
			routes.add(new RouteBC());
			break;
			
		case 'C':
			routes.add(new RouteCD());
			routes.add(new RouteCE());
			break;
			
		case 'D':
			routes.add(new RouteDC());
			routes.add(new RouteDE());
			break;
		
		case 'E':
			routes.add(new RouteEB());
			
		default:
			break;
		}
		
		return routes;
		
	}

}
