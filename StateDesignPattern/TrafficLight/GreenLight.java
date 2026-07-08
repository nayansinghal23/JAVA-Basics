public class GreenLight implements TrafficLightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Green Light: Cars can go.");
        context.setState(new RedLight());
    }

    @Override
    public TrafficLightColor getColor() {
        return TrafficLightColor.GREEN;
    }
    
}
