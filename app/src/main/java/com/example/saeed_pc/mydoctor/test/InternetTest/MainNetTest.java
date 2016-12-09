package com.example.saeed_pc.mydoctor.test.InternetTest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saeed_pc.mydoctor.Main.MainActivity;
import com.example.saeed_pc.mydoctor.Main.service.MyService;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.manger.MyImageDownloader;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.manger.MyWebPageDownloader;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.manger.NetworkFunction;
import com.example.saeed_pc.mydoctor.Main_MyDr.Service.TestService;
import com.example.saeed_pc.mydoctor.R;
import com.example.saeed_pc.mydoctor.test.InternetTest.net.Login_push_netTest;
import com.example.saeed_pc.mydoctor.test.InternetTest.net.Register_push_netTest;
import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.push.PushNotification;
import com.shephertz.app42.paas.sdk.android.push.PushNotificationService;
import com.shephertz.app42.paas.sdk.android.user.User;
import com.shephertz.app42.paas.sdk.android.user.UserService;
import com.example.saeed_pc.mydoctor.Main_MyDr.Service.Notification.NotificationManager_MyDrApp;

import java.util.ArrayList;

public class MainNetTest extends AppCompatActivity {



    private NetworkFunction network;
    public static TextView pageContent;
    public static ImageView ButtnSearch;
    public static EditText edtPageName;
    private Button btnLoginPush;
    private Button btnRegisterPush;
    private EditText edtUserPush;
    private EditText edtPassPush;
    private EditText edtRolePush;

    private String userName = "arash";          // Device username for registration user in App42
    private String deviceToken = "Device Token1";  // Device ID       for registration user in App42

    private String channel = "News Channel";
    private String description = "Channel all about the news";
    private String message  = "Message which you have to send";
    private PushNotificationService pushNotificationService;
    private UserService userService;

    private String pwd = "1111111111";
    private String emailId = "saeed@gmail.com";
    private NotificationManager_MyDrApp notificationManager_myDrApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_net_test);
        init();
        notificationManager_myDrApp = new NotificationManager_MyDrApp(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        BroadcastFilter("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        BroadcastFilter("onStop");
    }


    /*
    Broadcast
     */
    private BroadcastReceiver MyDownloaderReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String number = intent.getStringExtra("number");
            pageContent.setText(number);
            notificationManager_myDrApp.notificationSettingAdvanced(number);


        }
    };

    void BroadcastFilter(String ResumeStop){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.saeed_pc.mydoctor.test.InternetTest.MyDownloaderReceiver.BroadcastPM");

        if (ResumeStop.equals("onResume")) {
            registerReceiver(MyDownloaderReceiver,intentFilter);
        }else {
            unregisterReceiver(MyDownloaderReceiver);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////


















    private void init() {
        Log.i("===>","MainNetTest.init.1");
             network = new NetworkFunction (this);
        Log.i("===>","MainNetTest.init.2");
          pageContent = (TextView) findViewById(R.id.TxtNetTst_PageContent);
          ButtnSearch = (ImageView) findViewById(R.id.imgViewNetTst_searchBtn);
          edtPageName = (EditText) findViewById(R.id.edtTxtNetTst_SiteName);


          btnLoginPush = (Button) findViewById(R.id.btnNetTst_LoginPush);
          btnRegisterPush = (Button) findViewById(R.id.btnNetTst_RegisterPush);
          edtUserPush = (EditText) findViewById(R.id.edtNetTst_Usr);
          edtPassPush = (EditText) findViewById(R.id.edtNetTst_pass);
          edtRolePush = (EditText) findViewById(R.id.edtNetTst_Role);

        App42API.initialize(this,
                "e059192594b48b1b7f9cca204ef00c42f026002ad50e53c4daa5416d39df8402",
                "517386803abfedc009ab15b2669bcfaae531b7b831758c1fa62b0c722e2e06ee");
        pushNotificationService = App42API.buildPushNotificationService();

        // create a user in App42
        userService = App42API.buildUserService();
        userService.createUser( userName, pwd, emailId, new App42CallBack() {
            public void onSuccess(Object response)
            {
                User user = (User)response;
                System.out.println("userName is " + user.getUserName());
                System.out.println("emailId is " + user.getEmail());
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
            }
        });

        //create a user notification in App42
        pushNotificationService.storeDeviceToken(userName, deviceToken, new App42CallBack() {
            public void onSuccess(Object response)
            {
                PushNotification pushNotification  = (PushNotification)response;
                System.out.println("userName is " + pushNotification.getUserName());
                System.out.println("DeviceToken is " +  pushNotification.getDeviceToken());
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
            }
        });


        // create a channel for push notification
        pushNotificationService.createChannelForApp(channel, description, new App42CallBack() {
            public void onSuccess(Object response)
            {
                PushNotification pushNotification  = (PushNotification)response;
                ArrayList<PushNotification.Channel> channelList = pushNotification.getChannelList();
                for(PushNotification.Channel channelObj : channelList)
                {
                    System.out.println("channelName is " + channelObj.getName());
                    System.out.println("Description is " +  channelObj.getDescription());
                }
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
            }
        });

        // subscribe the channel

        pushNotificationService.subscribeToChannel(channel, userName, new App42CallBack() {
            public void onSuccess(Object response)
            {
                PushNotification pushNotification  = (PushNotification)response;
                System.out.println("UserName is " + pushNotification.getUserName());
                ArrayList<PushNotification.Channel> channelList = pushNotification.getChannelList();
                for(PushNotification.Channel channelObj : channelList)
                {
                    System.out.println("channelName is " + channelObj.getName());
                }
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
            }
        });






        Log.i("===>","MainNetTest.init.3");
    }


    public void onClick_NetTst_searchBtn(View view) {

        Log.i("===>","MainNetTest.init.1");
        network.isNetworkReady();
        Log.i("===>","MainNetTest.init.2");
        if(MainActivity.flag_ready_network){
            Log.i("===>","MainNetTest.init.3.1");

            Toast.makeText(this, "Network is :"+ MainActivity.flag_ready_network, Toast.LENGTH_LONG).show();

                new MyImageDownloader(this).execute(edtPageName.getText().toString());

        }else{
            Log.i("===>","MainNetTest.init.3.2");
            Toast.makeText(this, "Network is :"+ MainActivity.flag_ready_network, Toast.LENGTH_LONG).show();
        }
        Log.i("===>","MainNetTest.init.4");
    }

    public void onLoginPush_netTes(View view) {

        // wamp server login
   //    new Login_push_netTest(this).execute(edtUserPush.getText().toString(),edtPassPush.getText().toString());


   //    //Send push messages to a particular channel.

   //    pushNotificationService.sendPushMessageToChannel(channel,message, new App42CallBack() {
   //        public void onSuccess(Object response)
   //        {
   //            PushNotification pushNotification  = (PushNotification)response;
   //            System.out.println("Message is " + pushNotification.getMessage());
   //            ArrayList<PushNotification.Channel> channelList = pushNotification.getChannelList();
   //            for(PushNotification.Channel channelObj : channelList)
   //            {
   //                System.out.println("channelName is " + channelObj.getName());
   //            }
   //        }
   //        public void onException(Exception ex)
   //        {
   //            System.out.println("Exception Message"+ex.getMessage());
   //        }
   //    });


        //Authenticate user based on username and password

        userService.authenticate(edtUserPush.getText().toString() , edtPassPush.getText().toString(), new App42CallBack() {
            public void onSuccess(Object response)
            {
                User user = (User)response;
                System.out.println("userName is " + user.getUserName());
                System.out.println("sessionId is " + user.getSessionId());
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message : "+ex.getMessage());
            }
        });

    }

    public void onRegisterPush_netTes(View view) {

        // wamp server registration
   //     new Register_push_netTest(this).execute(edtUserPush.getText().toString(),edtPassPush.getText().toString(),
   //             edtRolePush.getText().toString());


        //Send push message to all your users.
        pushNotificationService.sendPushMessageToAll( message, new App42CallBack() {
            public void onSuccess(Object response)
            {
                PushNotification pushNotification  = (PushNotification)response;
                System.out.println("Message is " + pushNotification.getMessage());
                System.out.println("Expiry is " + pushNotification.getExpiry());
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
            }
        });
    }

    //  this button come from net test activity and we use it for starting service
    public void onStartServiceNetTest(View view) {

        Intent intent = new Intent(this, TestService.class);
        startService(intent);

    }

    //  this button come from net test activity and we use it for stopping service
    public void onStopServiceNetTest(View view) {
        Intent intent = new Intent(this, TestService.class);
        stopService(intent);
    }




}
