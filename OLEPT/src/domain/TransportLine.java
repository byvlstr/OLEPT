package domain;

public abstract class TransportLine {

	String lineName;

	public TransportLine(String lineName) {
		super();
		this.lineName = lineName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	
}
