package SOLID.PrototypePattern;

public class PremiumEmail extends Email {
    private String cc;
    private String bcc;

    PremiumEmail(String sender, String receiver, String subject, String body, String cc, String bcc) {
        super(sender, receiver, subject, body);
        this.cc = cc;
        this.bcc = bcc;
    }

    // Copy constructor
    PremiumEmail(PremiumEmail premiumEmail) {
        super(premiumEmail);
        this.cc = premiumEmail.cc;
        this.bcc = premiumEmail.bcc;
    }

    @Override
    public PremiumEmail clone() {
        return new PremiumEmail(this); // calling the copy constructor
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }
    
    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    @Override
    public void displayEmail() {
        super.displayEmail();
        System.out.println("CC : " + cc);
        System.out.println("BCC : " + bcc);
    }
}
