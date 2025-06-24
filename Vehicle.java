package application;

public class Vehicle {
	
	private final String name;
	private final boolean isEmergency;
	public Vehicle(String name, boolean isEmergency) {
	this.name = name;
	this.isEmergency = isEmergency;
	}
	public String getName() {
	return name;
	}
	public boolean isEmergency() {
	return isEmergency;
	}
}


