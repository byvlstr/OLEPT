package utils;

import java.util.HashMap;
import java.util.Vector;

import domain.Itinerary;
import domain.Map;
import domain.Stop;

public class ItineraryCalculator {
	
	private static final Integer INFINITY = 10000;
	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	
	private java.util.Map<String, Integer> costsPerRoad;
	private java.util.Map<String, String> stopOrderMap;
	private java.util.Map<String, Integer> colourPerStopMap;

	public ItineraryCalculator(Map map) {
		costsPerRoad = new HashMap<String, Integer>();
		stopOrderMap = new HashMap<String, String>();
		colourPerStopMap = new HashMap<String, Integer>();
	}

	public Itinerary computeDijkstraShortestPath(Map map, Stop start)
	{
		for(Stop stop: map.getPattern())
		{
			costsPerRoad.put(stop.getName(), INFINITY);
			stopOrderMap.put(stop.getName(), null);
			colourPerStopMap.put(stop.getName(), WHITE);
		}
		costsPerRoad.put(start.getName(), 0);
		colourPerStopMap.put(start.getName(), GREY);
		return null;
	}
}
