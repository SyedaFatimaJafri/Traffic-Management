package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;
public class TrafficVisualizer {
    private final Pane pane;
    private final Graph graph;
    public TrafficVisualizer(Stage primaryStage, Graph graph) {
        this.pane = new Pane();
        this.graph = graph;
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Traffic Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void startSimulation(Lane lane, TrafficLight light) {
        drawGraph();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            light.displayTiming();
            Map<String, Integer> congestionData = new HashMap<>();
            congestionData.put("A", lane.getCongestionLevel());
            graph.updateWeightsBasedOnCongestion(congestionData);
            Map<String, Integer> shortestPaths = graph.findShortestPath("A");
            System.out.println("Shortest paths from A: " + shortestPaths);
            String vehicle = lane.processVehicle();
            if (vehicle != null) {
                System.out.println("Vehicle passed: " + vehicle);
            }
            updateVisualization(lane);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    private void drawGraph() {
        int xOffset = 100;
        int yOffset = 300;

        for (String intersection : graph.getIntersections()) {
            Text label = new Text(xOffset - 10, yOffset - 10, intersection);
            pane.getChildren().add(label);

            xOffset += 150;
        }
        for (Road road : graph.getRoads()) {
            Line edge = new Line(
                    100 * graph.getIntersections().indexOf(road.getSource()) + 100,
                    300,
                    100 * graph.getIntersections().indexOf(road.getDestination()) + 100,
                    300
            );
            edge.setStroke(Color.BLACK);
            edge.setStrokeWidth(2);
            pane.getChildren().add(edge);
        }
    }
    private void updateVisualization(Lane lane) {
        pane.getChildren().removeIf(node -> node instanceof Text && ((Text) node).getText().startsWith("Congestion:"));
        Text congestionText = new Text(10, 50, "Congestion: " + lane.getCongestionLevel());
        congestionText.setFill(lane.getCongestionLevel() > 5 ? Color.RED : Color.GREEN);
        pane.getChildren().add(congestionText);
        pane.getChildren().removeIf(node -> node instanceof ImageView);
        int xOffset = 100;

    }
}

