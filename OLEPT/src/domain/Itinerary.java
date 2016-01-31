package domain;

import java.util.Stack;

public class Itinerary {
	
	private Stack<String> stackStops;
	private int duration ;

	public Itinerary(Stack<String> stackStops, int duration) {
		super();
		this.stackStops = stackStops;
		this.duration = duration;
	}

	public Stack<String> getStackStops() {
		return stackStops;
	}

	public void setStackStops(Stack<String> stackStops) {
		this.stackStops = stackStops;
	}
	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
