package com.example.saeed_pc.mydoctor.Main_MyDr.Service.Notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Accessories.constValue_General.constValue_General;
import com.example.saeed_pc.mydoctor.Main_MyDr.MainMyDr;
import com.example.saeed_pc.mydoctor.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
/**
 * Created by saeed on 19/08/2016.
 */
public class NotificationManager_MyDrApp {

    private Context context;

    public NotificationManager_MyDrApp(Context context) {
        this.context = context;

    }

    public void notificationSettingSimple(String s){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Title");
        builder.setContentInfo(s);
        builder.setSmallIcon(R.drawable.drawable_pic);
        builder.setSubText("subtext");

        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }

    public void notificationSettingAdvanced(String s){


        // pending intent : go to new activity after click on notification bar
        Intent intent = new Intent(context, MainMyDr.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, constValue_General.id_testNotification, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(pendingIntent);

        /*  ????????????????????

        how can cancel notification ?

         go to new activity "intent":

         NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         manager.cancel(constValue_General.id_testNotification);

         ??????????????????????*/

        // design notification
        builder.setContentTitle("My Doctor");
        builder.setContentInfo(s);
        builder.setSmallIcon(R.drawable.drawable_pic);
        builder.setSubText("subtext");


        // cancel (remove) notification via click on it
        builder.setAutoCancel(true);

        // notification is always on and it doesnt exit even after click on it
       // builder.setOngoing(true);

        // sound for notification
        RingtoneManager ringtoneManager = new RingtoneManager(context);
        builder.setSound(ringtoneManager.getRingtoneUri(RingtoneManager.TYPE_NOTIFICATION));
//        builder.setSound(soundUri);
     //   builder.setDefaults(Notification.DEFAULT_SOUND);

        //set light for notification
        builder.setDefaults(Notification.DEFAULT_LIGHTS);

        //set vibrate for notification
        long[] myPattern = {0, 800, 200, 200, 200, 3000};
        builder.setVibrate(myPattern);


       // builder.setStyle(inboxStyle);

        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        // create notification via specific id
        manager.notify(constValue_General.id_testNotification, builder.build());
    }

}
