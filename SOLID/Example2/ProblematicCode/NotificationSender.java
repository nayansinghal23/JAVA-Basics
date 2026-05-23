// Not only it violets SRP but if-else isn't scalable, hence violeting OCP.

package SOLID.Example2.ProblematicCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<NotificationType> notificationTypes, String message) {
        for(NotificationType notificationType: notificationTypes) {
            switch (notificationType) {
                case SMS:
                    notificationType.sendSMSNotification(message);
                    break;

                case WHATSAPP:
                    notificationType.sendWhatsAppNotification(message);
                    break;

                case EMAIL:
                    notificationType.sendEmailNotification(message);
                    break;

                case PUSH:
                    notificationType.sendPushNotification(message);
                    break;
            
                default:
                    break;
            }
        }
    }
}
