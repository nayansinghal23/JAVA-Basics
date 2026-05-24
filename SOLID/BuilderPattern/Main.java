package SOLID.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        EmailBuilder emailBuilder = new EmailBuilder();
        Email email = emailBuilder.
            setTo("john@example.com")
            .setSubject("Test Subject")
            .setBody("This is a test email")
            .build();
        email.displayEmail();
    }
}
