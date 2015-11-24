package domain;

import java.util.List;

public class Map {
	
	List<Stop> pattern;
	
	//the chosen area in Lyon
	String axis; 

	public Map(List<Stop> pattern, String axis) {
		super();
		this.pattern = pattern;
		this.axis = axis;
	}

	public List<Stop> getPattern() {
		return pattern;
	}

	public void setPattern(List<Stop> pattern) {
		this.pattern = pattern;
	}

	public String getAxis() {
		return axis;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}
	
	public Stop getStop(String stopName)
	{
		for(Stop stop: pattern)
		{
			if(stop.getName().equals(stopName))
			{
				return stop;
			}
		}
		return null;
	}
	

}
