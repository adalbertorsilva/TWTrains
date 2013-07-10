package city;

import java.util.List;

import routes.Route;
import factories.RoutesFactory;

public class City {

	private final String cityName;

	public City(final String cityName) {

		this.cityName = cityName;
	}

	public String getCityName() {

		return this.cityName;
	}

	public List<Route> getRoutesFromThisCity(){

		return RoutesFactory.createRoutesFrom(this);
	}

	@Override
	public String toString() {
		return cityName.toString();
	}
	
	@Override
	public boolean equals(final Object obj) {

		if ((obj != null) && (obj instanceof City)) {
			return ((City) obj).getCityName().equalsIgnoreCase(this.cityName);
		}

		return false;
	}

}
