package techverito.service;

import techverito.constants.Messages;
import techverito.util.Logging;

/*
 * Service class to send Email
 */
public class NotificationServiceImpl implements NotificationService {


    public void sendEmail() {
        Logging.displayMessage(Messages.emailNotification);
    }

    public void sendSms() {
        Logging.displayMessage(Messages.smsNotification);
    }
}
