package application;

import java.util.*;
public class Graph {
private final Map<String, List<Road>> adjacencyList = new HashMap<>();
private final List<String> intersections = new ArrayList<>();
public void addIntersection(String name) {
intersections.add(name);
adjacencyList.put(name, new ArrayList<>());
}
public void addRoad(String from, String to, int weight) {
adjacencyList.get(from).add(new Road(from, to, weight));
adjacencyList.get(to).add(new Road(to, from, weight)); // Bidirectional
}
public List<String> getIntersections() {
return intersections;
}
public List<Road> getRoads() {
List<Road> roads = new ArrayList<>();
for (List<Road> roadList : adjacencyList.values()) {
roads.addAll(roadList);
}
return roads;
}
public Map<String, Integer> findShortestPath(String source) {
Map<String, Integer> distances = new HashMap<>();
PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
Set<String> visited = new HashSet<>();
for (String intersection : intersections) {
distances.put(intersection, Integer.MAX_VALUE);
}
distances.put(source, 0);
pq.add(new Node(source, 0));
while (!pq.isEmpty()) {
Node currentNode = pq.poll();
String current = currentNode.getName();
if (visited.contains(current)) continue;
visited.add(current);
for (Road road : adjacencyList.get(current)) {
String neighbor = road.getDestination();
int newDist = distances.get(current) + road.getWeight();
if (newDist < distances.get(neighbor)) {
distances.put(neighbor, newDist);
pq.add(new Node(neighbor, newDist));
}
}
}
return distances;
}
public void updateWeightsBasedOnCongestion(Map<String, Integer> congestionData) {
for (String intersection : congestionData.keySet()) {
int congestionLevel = congestionData.get(intersection);
for (Road road : adjacencyList.get(intersection)) {
road.setWeight(road.getWeight() + congestionLevel);
}
}
}
}
