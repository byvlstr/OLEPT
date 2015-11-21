package domain;

public class Journey {
	
	private Stop startingPoint;
	
	private Stop goal;

	public Journey(Stop startingPoint, Stop goal) {
		super();
		this.startingPoint = startingPoint;
		this.goal = goal;
	}

	public Stop getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(Stop startingPoint) {
		this.startingPoint = startingPoint;
	}

	public Stop getGoal() {
		return goal;
	}

	public void setGoal(Stop goal) {
		this.goal = goal;
	}
	
	

}
