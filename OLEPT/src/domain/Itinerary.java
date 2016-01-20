package domain;

import java.util.Stack;

public class Itinerary {
	
	Stack<String> stackStops;

	public Itinerary(Stack<String> stackStops) {
		super();
		this.stackStops = stackStops;
	}

	public Stack<String> getStackStops() {
		return stackStops;
	}

	public void setStackStops(Stack<String> stackStops) {
		this.stackStops = stackStops;
	}
	
	

}
