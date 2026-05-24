/**
 * Three important parts of Builder Pattern:
 * 1. setters that return this keyword for chaining.
 * 2. getters that return the values of the fields.
 * 3. build method that returns the final object.
 */

package SOLID.BuilderPattern;

import java.util.List;

public class EmailBuilder {
    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments;

    public EmailBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder setBody(String body) {
        this.body = body;
        return this;
    }
    
    public EmailBuilder setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder setBcc(String bcc) {
        this.bcc = bcc;
        return this;
    }
    
    public EmailBuilder setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }
    
    public String getTo() {
        return this.to;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }
    
    public String getCc() {
        return this.cc;
    }

    public String getBcc() {
        return this.bcc;
    }

    public List<String> getAttachments() {
        return this.attachments;
    }

    public Email build() {
        return new Email(this);
    }
}
