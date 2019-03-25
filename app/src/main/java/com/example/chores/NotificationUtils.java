package com.example.chores;

import android.app.Notification;
import android.content.Context;

/**
 * Interface to set up Strategy design pattern, such that the ChoresNotificationHandler facade
 * can easily choose whether or not to use Notification Channels.
 *
 * @author Sietze Gelderloos, 1242663
 */
public interface NotificationUtils {


    Notification.Builder getNotification(Context base, String title, String body);

    void notify(Notification notification);
}
