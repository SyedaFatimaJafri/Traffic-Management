package application;

class Node {
private final String name;
private final int distance;
public Node(String name, int distance) {
this.name = name;
this.distance = distance;
}
public String getName() {
return name;
}

public int getDistance() {
return distance;
}
}

