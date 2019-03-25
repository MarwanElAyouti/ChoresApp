package com.example.chores;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;

/**
 * Facade class for making it very easy to manage notifications in chores.
 * Strategy Design Pattern
 *
 * @author Sietze Gelderloos, 1242663
 */
public class ChoresNotificationHelper {

    /**
     * Creates a notification builder, either with or without notification channel,
     * depending on the device's api level.
     *
     * @param base the context from which the notification is created
     * @param title the title to be displayed in the notification
     * @param body the body to be displayed in the notification
     * @return a notification builder which can be amended simply by .set[anything](...)
     */
    public static Notification.Builder notificationBuilder(Context base, String title, String body) {
        NotificationUtils notificationUtils;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationUtils = new NewNotificationUtils(base);
        } else {
            notificationUtils = new OldNotificationUtils(base);
        }

        return notificationUtils.getNotification(base, title, body)
                // set default settings for a notification here.
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_stat_chores_helper)
                .setAutoCancel(true);
    }

    /**
     * Uses the proper NotificationUtils to display the notification passed as an argument
     *
     * @param base the context from which the notification is passed
     * @param notification the notification to display
     */
    public static void notify(Context base, Notification notification) {
        // only if settings are such that notifications should be shown
        if (PreferenceManager.getDefaultSharedPreferences(base)
                .getBoolean("notifications_new_message", true)) {
            NotificationUtils notificationUtils;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationUtils = new NewNotificationUtils(base);
            } else {
                notificationUtils = new OldNotificationUtils(base);
            }

            notificationUtils.notify(notification);
        }
    }

    /**
     * Helper function to easily display notifications while only having access to its builder.
     *
     * @param base the context from which the notification builder is passed
     * @param builder the builder to build and display
     */
    public static void notifyWithBuilder(Context base, Notification.Builder builder) {
        notify(base, builder.build());
    }
}
