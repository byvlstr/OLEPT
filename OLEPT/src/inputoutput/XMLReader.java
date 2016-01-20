package inputoutput;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Map;
import domain.Road;
import domain.Stop;
import domain.Tramway;
import domain.TransportLine;
import domain.Underground;

public class XMLReader {

	private static final String LYON_MAP_XML = "LyonMap.xml";

	public XMLReader() {
	}
	
	/**
	 * Read XML file and populate the map
	 * @return map
	 * @throws Exception
	 */
	public Map readXMLFile() throws Exception
	{
		Map map = new Map();
		Document doc = getDocumentFromFile();		
		getAndSetMapAxis(doc, map);
		
		//Populate the map with stops
		NodeList stopList = doc.getElementsByTagName("Stop");
		List<Stop> listStops = new LinkedList<Stop>();
		for(int i=0; i<stopList.getLength(); i++){
			Element stopElement = (Element) stopList.item(i);
			String name = stopElement.getAttribute("name");
			int stopCost = Integer.parseInt(stopElement.getAttribute("cost"));
			
			NodeList roadList = stopElement.getChildNodes();
			List<Road> listRoads = new LinkedList<Road>();
			for(int j=0; j<roadList.getLength(); j++){
				
				if(roadList.item(j).getNodeType() == Node.ELEMENT_NODE){
					Element roadElement = (Element) roadList.item(j);
					int roadCost = Integer.parseInt(roadElement.getAttribute("cost"));
					String toStop = roadElement.getAttribute("toStop");	
					

						Element transportLineElement = (Element)roadElement.getElementsByTagName("TransportLine").item(0);
						String tLtype = transportLineElement.getAttribute("type");
						String tLname = transportLineElement.getAttribute("name");
						TransportLine transportLine = null;
						if(tLtype.equals("Underground")){
							transportLine = new Underground(tLname);
						}else if(tLtype.equals("Tramway")){
							transportLine = new Tramway(tLname);
						}
						
						if(transportLine != null){
							Road road = new Road(roadCost, toStop, transportLine);
							listRoads.add(road);
						}else{
							throw new Exception("Transport lines' data (type) is wrong!");
						}
				}
			}
			
			if(!listRoads.isEmpty()){
				Stop stop = new Stop(name, stopCost, listRoads);
				listStops.add(stop);
			}else{
				throw new Exception("Roads could not be added to this stop : " + name);
			}
		}
		map.setPattern(listStops);

		return map;
	}
	
	/**
	 * Get axis from xml root element
	 * Set axis attribute in map
	 * @param doc
	 * @param map
	 */
	private void getAndSetMapAxis(Document doc, Map map) {
		Element mapElement = doc.getDocumentElement();
		map.setAxis(mapElement.getAttribute("axis"));		
	}

	/**
	 * DOM administrative actions
	 * @return Document
	 */
	private Document getDocumentFromFile(){
		try{
			File xmlFile = new File(LYON_MAP_XML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
