package city;

import java.util.List;

import routes.Route;
import factories.RoutesFactory;

public class City {

	private final Character cityName;

	public City(final Character cityName) {

		this.cityName = cityName;
	}

	public Character getCityName() {

		return this.cityName;
	}

	public List<Route> getRoutesFromThisCity() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		return RoutesFactory.createRoutesFromTheCity(this);
	}

	@Override
	public String toString() {
		return cityName.toString();
	}
	
	@Override
	public boolean equals(final Object obj) {

		if ((obj != null) && (obj instanceof City)) {
			return ((City) obj).getCityName().equals(this.cityName);
		}

		return false;
	}

}
