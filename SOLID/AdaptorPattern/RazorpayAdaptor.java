package SOLID.AdaptorPattern;

public class RazorpayAdaptor implements PaymentProcessor {
    private String phoneNumber;

    public RazorpayAdaptor(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amountInUSD) {
        double amountInINR = amountInUSD * 80;
        // api.makePayment(phoneNumber, amountInINR); -> Some 3rd party API that we want to use. Making it compatible with by wrapping up in adaptor.
        System.out.println("Paid " + amountInUSD + " USD using Razorpay number " + this.phoneNumber);
    }
}
