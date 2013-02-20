package classes;

import java.util.Set;






public class City {

	private Character cityName;
	
	private Set<Way> waysFromThisCity;
	
	public City (Character cityName){
		this.cityName = cityName;
	}

	public Character getCityName(){
		return cityName;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		return ((City)obj).getCityName().equals(this.cityName);
	}
	
	
	
}
