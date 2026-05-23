// Separated the code in individual files & instead of passing notificationTypes, I'm directly passing notifications so that with the help of contract (interface) we can call the same function for all types of notification, thus saving us from if-else / switch statements. Hence, our code respects both SRP & OCP.

package SOLID.Example2.BetterCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<Notification> notifications, String message) {
        for(Notification notification: notifications) {
            notification.sendNotification(message);
        }
    }
}
