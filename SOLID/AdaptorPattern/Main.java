// Allows 2 incompatible interfaces to work together by converting one of the interfaces into the other that the client expects.

package SOLID.AdaptorPattern;

public class Main {
    public static void main(String[] args) {
        StripeAdaptor stripeAdaptor = new StripeAdaptor("1234567890");
        RazorpayAdaptor razorpayAdaptor = new RazorpayAdaptor("+91 7070067322");

        stripeAdaptor.pay(90);
        razorpayAdaptor.pay(30);
    }
}
