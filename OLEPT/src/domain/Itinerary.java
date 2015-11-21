package domain;

import java.util.List;

public class Itinerary {
	
	List<Stop> listStops;

	public Itinerary(List<Stop> listStops) {
		super();
		this.listStops = listStops;
	}

	public List<Stop> getListStops() {
		return listStops;
	}

	public void setListStops(List<Stop> listStops) {
		this.listStops = listStops;
	}
	
	

}
