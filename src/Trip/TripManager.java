package Trip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import routes.Route;
import city.City;
import exceptions.RouteNotFoundException;

public class TripManager {
	
	private Set<Collection<Route>> storedTripRoutes = new LinkedHashSet<Collection<Route>>();
	private List<Route> actualTripRoute = new ArrayList<Route>();
	private Trip trip;
	
	public TripManager(Trip trip) {
		this.trip = trip;
	}
	
	public Integer getAmountOfTripsWithMaximumStops(Integer maximumNumberOfStops) {
		
		return this.findAmountOfTripsWithMaximumStops(maximumNumberOfStops,tripStart());
	}

	public Integer getAmountOfTripsWithExactlyStops(Integer numberOfStops) throws RouteNotFoundException {
		
		return findAmountOfTripsWithAExactNumberOfStops(numberOfStops, tripStart());
	}
	
	public Integer getShortestRoute() throws RouteNotFoundException{
		return findShortestRoute(tripStart());
	}
	
	public Integer getTripsThatHaveWaySmallerThan(Integer wayLength) throws RouteNotFoundException{
		return findTripsThatHaveWaysSmallerThan(tripStart(), wayLength);	
	}
	
	private Integer findAmountOfTripsWithMaximumStops(Integer maximumNumberOfStops, City originCity) {

		for (Route route : originCity.getRoutesFromThisCity()) {

			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}
			
			if(actualTripRoute.size() > maximumNumberOfStops){
				break;
			}
			
			actualTripRoute.add(route);

			if (isTripsDestiny(route) && actualTripRoute.size() <= maximumNumberOfStops) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			} else {
				this.findAmountOfTripsWithMaximumStops(maximumNumberOfStops, route.getDestiny());
			}
			
		}
		
		removeLastRoute(actualTripRoute);

		return storedTripRoutes.size();
	}
	
	private Integer findAmountOfTripsWithAExactNumberOfStops(Integer exactNumberOfStops, City originCity) throws RouteNotFoundException {
		
		
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}
			
			if(actualTripRoute.size() > exactNumberOfStops){
				break ;
			}
			
			actualTripRoute.add(route);
			
			if (isTripsDestiny(route) && actualTripRoute.size() == exactNumberOfStops) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			} else {
				this.findAmountOfTripsWithAExactNumberOfStops(exactNumberOfStops, route.getDestiny());
			}
		}
		
		removeLastRoute(actualTripRoute);

		return storedTripRoutes.size();
	}
	
	private Integer findShortestRoute(City originCity) throws RouteNotFoundException{
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isTravelingInCircles(route)){
				removeLastRoute(actualTripRoute);
				break;
			}
			
			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}

			if ( updateTripRoute(route) && isTripsDestiny(route)) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			} else {
				this.findShortestRoute(route.getDestiny());
			}
		}
		
		removeLastRoute(actualTripRoute);

		return shortestRoute(storedTripRoutes);
	}

	private Integer findTripsThatHaveWaysSmallerThan(City originCity, Integer wayLength) throws RouteNotFoundException{
		
		for (Route route : originCity.getRoutesFromThisCity()) {
			
			if(isTravelingInCircles(route)){
				continue;
			}
			
			if(isLastRouteWithTheSameOrigin(route)){
				removeLastRoute(actualTripRoute);
			}
			
			actualTripRoute.add(route);

			if (isTripsDestiny(route) && getTripDistance() < wayLength) {
				storedTripRoutes.add(new ArrayList<Route>(actualTripRoute));
			}
			
			if(getTripDistance() < wayLength){
				this.findTripsThatHaveWaysSmallerThan(route.getDestiny(), wayLength);
			}
			
		}
		
		removeLastRoute(actualTripRoute);

		return storedTripRoutes.size();
		
	}
	
	private Integer getTripDistance() throws RouteNotFoundException{
		return new Trip(actualTripRoute).getTotalDistance();
	}
	
	private Integer shortestRoute(Collection<Collection<Route>> tripRoutes) throws RouteNotFoundException{
		
		Integer shortestDistance = 0;
		
		for(Collection<Route> trips : tripRoutes){
			
			Integer tripDistance = new Trip(trips).getTotalDistance();
			
			if(shortestDistance == 0){
				shortestDistance = tripDistance;
			}
			
			if(shortestDistance > tripDistance){
				shortestDistance = tripDistance;
			}
			
		}
		
		return shortestDistance;
		
	}
	
	private void removeLastRoute(List<Route> routes){
		if(!routes.isEmpty()){
			routes.remove(routes.size() -1);	
		}
		
	}
	
	private boolean updateTripRoute(Route route) {
		
		boolean updated = false;
		
		if(!actualTripRoute.contains(route)){
			updated = actualTripRoute.add(route);
		}
		
		return updated;
	}
	
	private boolean isTravelingInCircles(Route route) {
		return actualTripRoute.size() >= 2 && 
				actualTripRoute.get(actualTripRoute.size() -2).equals(route);
	}
	
	private boolean isLastRouteWithTheSameOrigin(Route route){
		return !actualTripRoute.isEmpty() && actualTripRoute.get(actualTripRoute.size() -1).getOrigin().equals(route.getOrigin());
	}
	
	private City tripDestiny() {
		return new City(trip.getCities().get(trip.getCities().size() - 1));
	}
	
	private boolean isTripsDestiny(Route route) {
		return route.getDestiny().equals(tripDestiny());
	}

	private City tripStart() {
		return new City(trip.getCities().get(0));
	}
	
}
