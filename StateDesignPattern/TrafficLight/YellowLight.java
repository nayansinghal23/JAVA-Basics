public class YellowLight implements TrafficLightState {

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Yellow Light: Prepare to go.");
        context.setState(new GreenLight());       
    }

    @Override
    public TrafficLightColor getColor() {
        return TrafficLightColor.YELLOW;
    }
}
