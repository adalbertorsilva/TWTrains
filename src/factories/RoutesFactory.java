package factories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import routes.Route;
import city.City;

public class RoutesFactory {
	
	private static Properties properties = null;
	

	public static List<Route> createRoutesFrom(City city) 
{
		
		List<Route> routes = new ArrayList<Route>();
		
		try {
			properties = new Properties();
			FileInputStream inputs = new FileInputStream("./properties/routes.properties");
			properties.load(inputs);
			
			for(Object key : properties.keySet()){
				
				Route route = createRoute(key); 
				
				if(route.getOrigin().equals(city)){
					routes.add(route);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Input not found");
		} catch (IOException e) {
			System.out.println("Input is not valid!");
		}
		
		Collections.sort(routes);
		
		return routes;
		
	}
	
	
	private static Route createRoute(Object key){
		
		String keyName = (String) key;
		
		return new Route(new City(keyName.substring(keyName.length() -2, keyName.length() -1)), 
						 new City(keyName.substring(keyName.length() -1)), 
						 new Integer(properties.getProperty(keyName)));
		
	}
	
}
