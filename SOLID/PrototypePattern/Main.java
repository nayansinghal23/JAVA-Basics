package SOLID.PrototypePattern;

public class Main {
    public static void main(String[] args) {
        Email email1 = new Email("john@example.com", "jane@example.com", "Test email", "This is a test email");

        Email email2 = email1.clone();
        email2.displayEmail();

        PremiumEmail premiumEmail1 = new PremiumEmail("john@example.com", "jane@example.com", "Test email", "This is a test email", "cc@example.com", "bcc@example.com");
        PremiumEmail premiumEmail2 = premiumEmail1.clone();
        premiumEmail2.displayEmail();
    }
}
