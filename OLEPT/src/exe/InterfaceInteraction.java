package exe;

import java.util.Stack;

import domain.Itinerary;
import domain.Map;
import inputoutput.XMLReader;
import utils.ItineraryCalculator;

public class InterfaceInteraction {

	public static void main(String[] args) {

		XMLReader xmlReader = new XMLReader();
		try {
			Map map = xmlReader.readXMLFile();
			ItineraryCalculator itineraryCalculator = new ItineraryCalculator(map);
			Itinerary itinerary = itineraryCalculator.computeDijkstraShortestPath(map, "Charpennes Charles Hernu", "Guillotière Gabriel Péri");
			displayItinerary(itinerary);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void displayItinerary(Itinerary itinerary){
		Stack<String> stack = itinerary.getStackStops();
		System.out.println("######################################");
		System.out.println("############# Itinerary ##############");
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("");
		System.out.println("Duration : "+itinerary.getDuration() + " minutes");
		System.out.println("######################################");

	}

}
