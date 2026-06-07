package FactoryDesignPattern.NotificationFactory;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email notification : " + message);
    }
}
