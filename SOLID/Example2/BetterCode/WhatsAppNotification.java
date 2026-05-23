package SOLID.Example2.BetterCode;

public class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("WhatsApp : " + message);
    }
}
