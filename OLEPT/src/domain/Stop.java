package domain;

import java.util.List;

public class Stop {

	private String name;
	
	private int cost;
	
	private List<TransportLine> availableTransports;

	public Stop(String name, int cost) {
		super();
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
	
	
}
