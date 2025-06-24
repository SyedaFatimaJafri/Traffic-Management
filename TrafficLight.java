package application;

public class TrafficLight {
	
		private final int greenDuration;
		private final int redDuration;
		private int timer = 0;
		public TrafficLight(int greenDuration, int redDuration) {
		this.greenDuration = greenDuration;
		this.redDuration = redDuration;
		}
		public void displayTiming() {
		timer = (timer + 1) % (greenDuration + redDuration);
		String status = timer < greenDuration ? "GREEN" : "RED";
		System.out.println("Traffic Light: " + status);
		}
}




