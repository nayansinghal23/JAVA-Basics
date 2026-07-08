public class RedLight implements TrafficLightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Red Light: Cars must stop.");
        context.setState(new YellowLight());
    }

    @Override
    public TrafficLightColor getColor() {
        return TrafficLightColor.RED;
    }
}
