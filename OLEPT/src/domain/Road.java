package domain;

import java.util.List;

public class Road {
	
	private int cost;
	
	private Stop fromStop;
	
	private Stop toStop;
	
	private List<TransportLine> availableTransports;

	public Road(int cost, Stop fromStop, Stop toStop, List<TransportLine> availableTransports) {
		this.cost = cost;
		this.fromStop = fromStop;
		this.toStop = toStop;
		this.availableTransports = availableTransports;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Stop getFromStop() {
		return fromStop;
	}

	public void setFromStop(Stop fromStop) {
		this.fromStop = fromStop;
	}

	public Stop getToStop() {
		return toStop;
	}

	public void setToStop(Stop toStop) {
		this.toStop = toStop;
	}

	public List<TransportLine> getAvailableTransports() {
		return availableTransports;
	}

	public void setAvailableTransports(List<TransportLine> availableTransports) {
		this.availableTransports = availableTransports;
	}
	
	

}
