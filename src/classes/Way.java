package classes;


public abstract class Way {
	
	protected City origin;
	
	protected City destiny;
	
	protected Integer distance;;
	
	public Integer getDistance(){
		return distance;	
	}
	
	public Integer getTotalDistance(){
		return new WayAB().getDistance() + new WayBC().getDistance();
	}

	@Override
	public boolean equals(Object obj) {
		
		if( obj != null &&  obj instanceof Way){
			Way way = (Way) obj;
			return this.origin.equals(way.origin) && 
					this.destiny.equals(way.destiny) &&
					this.distance.equals(way.distance);
		}
		
		return false; 
	}
	
	

}
