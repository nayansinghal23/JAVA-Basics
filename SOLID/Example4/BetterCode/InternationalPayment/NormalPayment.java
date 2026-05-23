package SOLID.Example4.BetterCode.InternationalPayment;

public class NormalPayment implements InternationalPaymentStrategy {
    @Override
    public void intlPayment() {
        System.out.println("International payment without pin support");
    }
}
