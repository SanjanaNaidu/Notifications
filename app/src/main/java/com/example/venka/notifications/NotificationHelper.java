package com.example.venka.notifications;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

/**
 * Created by venka on 2/16/2019.
 */

public class NotificationHelper extends ContextWrapper {
    public static final String channel1ID="channel1D";
    public static final String channel1name="channel 1";
    public static final String channel2ID="channel2D";
    public static final String channel2name="channel2";
    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES .O){
            createChannels();

        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels() {

    NotificationChannel ch = new NotificationChannel(channel1ID,channel1name, NotificationManager.IMPORTANCE_DEFAULT);
    ch.enableLights(true);
    ch.enableVibration(true);
    ch.setLightColor(R.color.colorPrimary);
    ch.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
    getManager().createNotificationChannel(ch);
        NotificationChannel ch2 = new NotificationChannel(channel1ID,channel1name, NotificationManager.IMPORTANCE_DEFAULT);
        ch2.enableLights(true);
        ch2.enableVibration(true);
        ch2.setLightColor(R.color.colorPrimary);
        ch2.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(ch2);
    }

    public NotificationManager getManager(){
        if(mManager==null){
            mManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }
    return mManager;
    }
    public NotificationCompat.Builder getChNotification(String Title,String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID)
                .setContentTitle(Title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_one);
    }

    public NotificationCompat.Builder getCh2Notification(String Title,String Message){
        return new NotificationCompat.Builder(getApplicationContext(),channel2ID)
                .setContentTitle(Title)
                .setContentText(Message)
                .setSmallIcon(R.drawable.ic_two);

    }


}

