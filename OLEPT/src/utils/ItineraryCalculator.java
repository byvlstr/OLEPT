package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import domain.Itinerary;
import domain.Map;
import domain.Road;
import domain.Stop;

public class ItineraryCalculator {
	
	private static final Integer INFINITY = 10000;

	
	private java.util.Map<String, String> previousStopInPath;
	private java.util.Map<String, Integer> costToStop;

	public ItineraryCalculator(Map map) {
		previousStopInPath = new HashMap<String, String>();
		costToStop = new HashMap<String, Integer>();
	}
	
	/**
	 * Wiki Dijkstra pseudo code references:
	 * dist = costToStop
	 * Graph = map.pattern
	 * prev = previousStopInPath
	 * Q = unvisitedNodes
	 * 
	 * @param map
	 * @param start
	 * @return itinerary
	 * @throws Exception 
	 */
	public Itinerary computeDijkstraShortestPath(Map map, String start, String goal) throws Exception
	{
		Set<Stop> unvisitedNodes = new HashSet<Stop>();
		for(Stop stop : map.getPattern()){
			costToStop.put(stop.getName(), INFINITY);
			previousStopInPath.put(stop.getName(), null);
			unvisitedNodes.add(stop);
			//distance from start stop to itself
			costToStop.put(start, 0);
		}
		while(!unvisitedNodes.isEmpty()){
			String minStop = findMinimalCostStop(unvisitedNodes);
			if(minStop == null) throw new Exception("Stop costs may be wrong...");
			Stop minimalCostStop = map.getStop(minStop);
			
			if(minimalCostStop.getName().equals(goal)) break;
			if(unvisitedNodes.remove(minimalCostStop)){
				
				for(Road road: minimalCostStop.getRoads()){
					Stop neighbour = map.getStop(road.getToStop());
					int alternative = road.getCost() + costToStop.get(minStop);
					if(alternative + minimalCostStop.getCost() < costToStop.get(neighbour.getName())){
						costToStop.put(neighbour.getName(), alternative);
						previousStopInPath.put(neighbour.getName(), minStop);
					}					
				}
				
			}else{
				throw new Exception("Stop list may be wrong...");
			}
		}
		Itinerary shortestPath = getShortestPath(goal, map);

		return shortestPath;
	}

	/**
	 * 
	 * @param goal
	 * @return
	 */
	private Itinerary getShortestPath(String goal, Map map) {
		Stack<String> stack = new Stack<String>();
		String stop = goal;
		int duration = costToStop.get(goal);
		while(previousStopInPath.get(stop) != null){
			stack.push(stop);
			Stop thisStop = map.getStop(stop);
			duration += thisStop.getCost();
			stop = previousStopInPath.get(stop);
		}
		stack.push(stop);
		Itinerary itinerary = new Itinerary(stack, duration);
		return itinerary;
	}

	/** 
	 * 
	 * @return minStop
	 */
	private String findMinimalCostStop(Set<Stop> unvisitedNodes) {
		int minCost = INFINITY;
		String minStop = null;
		for(Stop stop : unvisitedNodes){
				if(costToStop.get(stop.getName()) < minCost){
					minCost = costToStop.get(stop.getName());
					minStop = stop.getName();
				}
		}
		return minStop;
	}
}
