package FactoryDesignPattern.NotificationFactory;

public class NotificationFactory {
    public Notification createNotification(NotificationType notificationType) {
        if(notificationType == NotificationType.EMAIL) {
            return new EmailNotification();
        }
        else if(notificationType == NotificationType.SMS) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("This type isn't supported.");
    }
}
