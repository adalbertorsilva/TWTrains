package factories;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import routes.Route;
import city.City;

public class RoutesFactory {

	@SuppressWarnings("rawtypes")
	public static List<Route> createRoutesFromTheCity(City city) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		List<Route> routes = new ArrayList<Route>();
		
		for(Class classe : getClasses("routes")){
			
			if(!Modifier.isAbstract(classe.getModifiers())){
		
				Route route  = (Route) classe.newInstance();
				
				if(route.getOrigin().equals(city)){
					routes.add(route);
				}
			}
		}
		
		return routes;

	}
	
	@SuppressWarnings("rawtypes")
	 private static List<Class> getClasses(String pckgname) throws ClassNotFoundException {  
		ArrayList<Class> classes=new ArrayList<Class>();
			
		File directory=null;
	        
		try {  
			directory=new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile());  
		} catch(NullPointerException x) {  
			throw new ClassNotFoundException(pckgname + "not found");  
		}
	        
		if(directory.exists()) {  
			String[] files=directory.list();  
			for(int i=0; i<files.length; i++) {  
				if(files[i].endsWith(".class")) {  
					classes.add((Class<? extends Route>) Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6)).asSubclass(Route.class));  
				}  
			}  
		} else { 
			throw new ClassNotFoundException(pckgname + "not found");  
		}
		
		return classes;  
	 } 
}
