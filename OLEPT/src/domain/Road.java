package domain;

public class Road {
	
	private int cost;
	
	private Stop fromStop;
	
	private Stop toStop;

	public Road(int cost, Stop fromStop, Stop toStop) {
		super();
		this.cost = cost;
		this.fromStop = fromStop;
		this.toStop = toStop;
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
	
	

}
