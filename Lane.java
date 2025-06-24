package application;
import java.util.LinkedList;
import java.util.Queue;
public class Lane {
private final Queue<Vehicle> vehicles = new LinkedList<>();
public void addVehicle(String name, boolean isEmergency) {
vehicles.add(new Vehicle(name, isEmergency));
}
public String processVehicle() {
if (!vehicles.isEmpty()) {
Vehicle vehicle = vehicles.poll();
return vehicle.getName();
}
return null;
}
public Queue<String> getAllVehicles() {
Queue<String> vehicleNames = new LinkedList<>();
for (Vehicle vehicle : vehicles) {
vehicleNames.add(vehicle.getName());
}
return vehicleNames;
}
public int getCongestionLevel() {
return vehicles.size();
}
}
