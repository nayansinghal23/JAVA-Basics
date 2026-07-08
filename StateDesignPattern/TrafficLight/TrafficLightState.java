public interface TrafficLightState {
    void next(TrafficLightContext context);
    TrafficLightColor getColor();
}
