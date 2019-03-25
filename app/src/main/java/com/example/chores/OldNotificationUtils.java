package com.example.chores;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;


/**
 * Notification utensils for use with older android versions (pre 8.0 Oreo), because no thought
 * is paid to Notification Channels. This is required from 8.0 on and not supported before...
 *
 * @author Sietze Gelderloos, 1242663
 */
public class OldNotificationUtils extends ContextWrapper implements NotificationUtils {
    NotificationManager nManager;
    String NOTIFICATION_TAG = "Chores";

    public OldNotificationUtils(Context base) {
        super(base);
    }

    @Override
    public Notification.Builder getNotification(Context base, String title, String body) {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        // Set vibration, of don't.
        if (PreferenceManager.getDefaultSharedPreferences(base)
                .getBoolean("notifications_new_message_vibrate", true)) {
            builder.setVibrate(new long[] {200, 200});
        } else {
            builder.setVibrate(new long[] {});
        }
        // set ringtone
        builder.setSound(Uri.parse("DEFAULT_SOUND"));
        return builder;
    }

    @Override
    public void notify(Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            getManager().notify(NOTIFICATION_TAG, 0, notification);
        } else {
            getManager().notify(NOTIFICATION_TAG.hashCode(), notification);
        }
    }

    private NotificationManager getManager() {
        if (nManager == null) {
            nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return nManager;
    }
}
