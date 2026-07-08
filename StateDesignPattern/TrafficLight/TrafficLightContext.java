public class TrafficLightContext {
    private TrafficLightState state = new RedLight();

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }
}
