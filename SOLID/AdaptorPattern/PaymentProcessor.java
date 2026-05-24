package SOLID.AdaptorPattern;

public interface PaymentProcessor {
    void pay(double amountInUSD); // All adapters should implement this method.
}
