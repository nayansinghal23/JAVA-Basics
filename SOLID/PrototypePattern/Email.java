package SOLID.PrototypePattern;

public class Email implements EmailPrototype<Email> {
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    Email(String sender, String receiver, String subject, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }

    // Copy constructor
    Email(Email email) {
        this.sender = email.sender;
        this.receiver = email.receiver;
        this.subject = email.subject;
        this.body = email.body;
    }

    @Override
    public Email clone() {
        return new Email(this); // calling the copy constructor
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void displayEmail() {
        System.out.println("Sender : " + sender);
        System.out.println("Receiver : " + receiver);
        System.out.println("Subject : " + subject);
        System.out.println("Body : " + body);
    }
}
