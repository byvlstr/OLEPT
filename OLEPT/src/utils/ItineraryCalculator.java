package utils;

import java.util.HashMap;
import java.util.Vector;

import domain.Itinerary;
import domain.Map;
import domain.Road;
import domain.Stop;

public class ItineraryCalculator {
	
	private static final Integer INFINITY = 10000;
	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	
	private java.util.Map<String, Integer> costsPerRoad;
	private java.util.Map<String, String> stopOrderMap;
	private java.util.Map<String, Integer> colourPerStopMap;
	private java.util.Map<String, Integer> costsToStop;

	public ItineraryCalculator(Map map) {
		costsPerRoad = null; //=XMLReader.x()
		stopOrderMap = new HashMap<String, String>();
		colourPerStopMap = new HashMap<String, Integer>();
		costsToStop = new HashMap<String, Integer>();
	}

	public Itinerary computeDijkstraShortestPath(Map map, Stop start)
	{
		for(Stop stop: map.getPattern())
		{
			costsToStop.put(stop.getName(), INFINITY);
			stopOrderMap.put(stop.getName(), null);
			colourPerStopMap.put(stop.getName(), WHITE);
		}
		costsToStop.put(start.getName(), 0);
		colourPerStopMap.put(start.getName(), GREY);
		while(colourPerStopMap.size() != 0){
			String s = findMinimalCostStop();
			Stop stop = map.getStop(s);
			for(Road road : stop.getRoads()){
				Stop nextStop = road.getToStop();
				if(colourPerStopMap.get(stop.getName()) != BLACK){
					release(stop, nextStop);
					if(colourPerStopMap.get(stop.getName()) == WHITE){
						colourPerStopMap.put(stop.getName(), GREY);
					}
				}
			}
		}
		return null;
	}

	private void release(Stop stop, Stop nextStop) {
		int thisCost = costsPerRoad.get(stop.getName());
		int nextCost = costsPerRoad.get(nextStop.getName());
		if(nextCost > (thisCost + ))
		
	}

	private String findMinimalCostStop() {
		int minCost = INFINITY;
		String minStop = null;
		for(String s : colourPerStopMap.keySet()){
			if(colourPerStopMap.get(s) == GREY){
				if(costsToStop.get(s) < INFINITY){
					minCost = costsPerRoad.get(s);
					minStop = s;
				}
			}
		}
		if(minStop == null) minStop = null;
		return minStop;
	}
}
