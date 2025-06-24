import javafx.application.Application;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
	import javafx.scene.layout.BorderPane;
	import javafx.application.Application;
	import javafx.stage.Stage;
	public class Main_ extends Application {
	    @Override
	    public void start(Stage primaryStage) {
	    Graph cityGraph = new Graph();
	    cityGraph.addIntersection("A");
	     cityGraph.addIntersection("B");
	        cityGraph.addIntersection("C");
	        cityGraph.addIntersection("D");
	        cityGraph.addRoad("A", "B", 2);
	        cityGraph.addRoad("B", "C", 3);
	        cityGraph.addRoad("A", "D", 5);
	        cityGraph.addRoad("D", "C", 4);      
	        Lane laneA = new Lane();
	        TrafficLight lightA = new TrafficLight(10, 5);
	        laneA.addVehicle("Car1", false);
	        laneA.addVehicle("Ambulance1", true);
	        laneA.addVehicle("Car2", false);
	        TrafficVisualizer visualizer = new TrafficVisualizer(primaryStage, cityGraph);
	        visualizer.startSimulation(laneA, lightA);
	    }
            public static void main(String[] args) {
	        launch(args);
    }
}
