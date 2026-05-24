package SOLID.BuilderPattern;

import java.util.List;

public class Email {
    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments;

    public Email(EmailBuilder emailBuilder) {
        this.to = emailBuilder.getTo();
        this.subject = emailBuilder.getSubject();
        this.body = emailBuilder.getBody();
        this.cc = emailBuilder.getCc();
        this.bcc = emailBuilder.getBcc();
        this.attachments = emailBuilder.getAttachments();
    }
    
    // Getter only - no setters (immutability)
    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }   

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }
    
    public List<String> getAttachments() {
        return attachments;
    }

    public void displayEmail() {
        System.out.println("To : " + to);
        System.out.println("Subject : " + subject);
        System.out.println("Body : " + body);
        System.out.println("CC : " + cc);
        System.out.println("BCC : " + bcc);
        System.out.println("Attachments : " + attachments);
    }
}
