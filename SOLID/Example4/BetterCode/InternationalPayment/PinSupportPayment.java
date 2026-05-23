package SOLID.Example4.BetterCode.InternationalPayment;

public class PinSupportPayment implements InternationalPaymentStrategy {
    private int pin;

    public PinSupportPayment(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return this.pin;
    }

    @Override
    public void intlPayment() {
        System.out.println("International payment with pin support : " + this.pin);
    }
}
