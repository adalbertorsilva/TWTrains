
package trip;
import java.util.ArrayList;
import java.util.List;

import routes.Route;
import city.City;
import exceptions.RouteNotFoundException;

public class Trip implements Comparable<Trip>{

	private List<Route> tripRoutes;
	
	public Trip(City origin, City destiny) {

		this.tripRoutes = new ArrayList<Route>();
	}
	
	public Integer getTotalDistance() throws RouteNotFoundException  {

		Integer totalDistance = 0;
		
		for(Route route : tripRoutes){
			
			City origin = route.getOrigin();
			
			if(origin.getRoutesFromThisCity().contains(route)){
				totalDistance = totalDistance + route.getDistance();
			}else{
				throw new RouteNotFoundException();
			}
		}	

		return totalDistance;
	}
	
	public void addRouteToTrip(Route route){
		tripRoutes.add(route);
	}
	
	public void removeLastRouteFromTrip(){
		if(!tripRoutes.isEmpty()){
			tripRoutes.remove(tripRoutes.size() -1);	
		}
		
	}
	
	public List<Route> getTripRoutes() {
		return tripRoutes;
	}
	
	@Override
	public int compareTo(Trip arg0) {
		try {
			return this.getTotalDistance().compareTo(arg0.getTotalDistance());
		} catch (RouteNotFoundException e) {
			e.printStackTrace();
		}
		
		return 0;
	}	
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder(tripRoutes.toString());
		builder.append("\n");
		return builder.toString();
	}
}
