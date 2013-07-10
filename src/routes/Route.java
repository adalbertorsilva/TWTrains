package routes;

import city.City;

public class Route implements Comparable<Route>{

	protected City origin;

	protected City destiny;

	protected Integer distance;;

	public Route(City origin, City destiny, Integer distance) {
		this.origin = origin;
		this.destiny = destiny;
		this.distance = distance;
	}

	public Integer getDistance() {

		return this.distance;
	}

	public City getOrigin() {

		return this.origin;
	}
	
	public City getDestiny(){
		return this.destiny;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(origin.toString())
			   .append(" -> ")
			   .append(destiny.toString());
		
		return builder.toString();
	}
	
	@Override
	public boolean equals(final Object obj) {

		if ((obj != null) && (obj instanceof Route)) {
			final Route way = (Route) obj;
			return this.origin.equals(way.origin) && this.destiny.equals(way.destiny) && this.distance.equals(way.distance);
		}

		return false;
	}


	@Override
	public int compareTo(Route o) {
		
		Integer result = this.getOrigin().getCityName().compareTo(o.getOrigin().getCityName()); 
		
		return result == 0 ? this.getDestiny().getCityName().compareTo(o.getDestiny().getCityName()) : result;
	}

}
