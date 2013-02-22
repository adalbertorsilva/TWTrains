package routes;

import city.City;

public abstract class Route {

	protected City origin;

	protected City destiny;

	protected Integer distance;;

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

}
