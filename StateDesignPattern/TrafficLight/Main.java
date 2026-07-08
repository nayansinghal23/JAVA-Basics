public class Main {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        for (int i = 0; i < 6; i++) {  // Change the light multiple times
            trafficLight.next();
            System.out.println();
        }
    }
}
