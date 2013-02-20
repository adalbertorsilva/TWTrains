package Trip;

import routes.RouteAB;
import routes.RouteBC;

public class Trip {
	
	public Integer getTotalDistance(){
		return new RouteAB().getDistance() + new RouteBC().getDistance();
	}

}
