package SOLID.AdaptorPattern;

public class StripeAdaptor implements PaymentProcessor {
    private String cardNumber;

    public StripeAdaptor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amountInUSD) {
        // api.makePayment(cardNumber, amountInUSD); -> Some 3rd party API that we want to use. Making it compatible with by wrapping up in adaptor.
        System.out.println("Paid " + amountInUSD + " USD using Stripe card " + this.cardNumber);
    }
}
