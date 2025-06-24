package application;

class Road {
private final String source;
private final String destination;
private int weight;

public Road(String source, String destination, int weight) {
this.source = source;
this.destination = destination;
this.weight = weight;
}

public String getSource() {
return source;
}
public String getDestination() {
return destination;
}
public int getWeight() {
return weight;
}

public void setWeight(int weight) {
this.weight = weight;
}
}

