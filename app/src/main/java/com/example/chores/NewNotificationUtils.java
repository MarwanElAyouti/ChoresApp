package com.example.chores;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;

/**
 * Notification utensils for devices running android >= 8.0 Oreo (API 26)
 * Creates a notification channel when needed.
 *
 * @author Sietze Gelderloos, 1242663
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class NewNotificationUtils extends ContextWrapper implements NotificationUtils {

    private NotificationManager nManager;
    public static final String CHANNEL_ID = "com.examples.chores.ANDROID";
    public static final String CHANNEL_NAME = "Default Channel";
    String NOTIFICATION_TAG = "Chores";

    public NewNotificationUtils(Context base) {
        super(base);
        createChannels(base);
    }

    public void createChannels(Context base) {
        NotificationChannel defaultChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                getManager().IMPORTANCE_DEFAULT);

        // Set vibration
        defaultChannel.enableVibration(PreferenceManager.getDefaultSharedPreferences(base)
                    .getBoolean("notifications_new_message_vibrate", true));
        // Set sound
        defaultChannel.setSound(Uri.parse("DEFAULT_SOUND"),
                new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setLegacyStreamType(AudioManager.STREAM_NOTIFICATION)
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION_EVENT).build());
        // For notification lights
        defaultChannel.enableLights(true);
        defaultChannel.setLightColor(Color.WHITE);
        // Set how these notifications are visible on the loch screen
        defaultChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(defaultChannel);
    }

    public Notification.Builder getNotification(Context base, String title, String body) {
        return new Notification.Builder(getApplicationContext(), CHANNEL_ID);
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
