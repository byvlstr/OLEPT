package domain;

import java.util.List;

public class Road {
	
	private int cost;
	
	private String toStop;
	
	private TransportLine availableTransport;

	public Road(int cost, String toStop, TransportLine availableTransport) {
		this.cost = cost;
		this.toStop = toStop;
		this.availableTransport = availableTransport;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getToStop() {
		return toStop;
	}

	public void setToStop(String toStop) {
		this.toStop = toStop;
	}

	public TransportLine getAvailableTransport() {
		return availableTransport;
	}

	public void setAvailableTransport(TransportLine availableTransport) {
		this.availableTransport = availableTransport;
	}
	
	

}
