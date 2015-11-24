package domain;

import java.util.List;

public class Stop {

	private String name;
	
	private int cost;
	
	private List<Road> roads;

	public Stop(String name, int cost, List<Road> roads) {
		this.roads = roads;
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Road> getRoads() {
		return roads;
	}

	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}
	
	
	
}
