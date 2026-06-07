package FactoryDesignPattern.NotificationFactory;

public class Main {
    public void main() {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(NotificationType.SMS);
        notification.send("Learning LLD...");
    }
}
