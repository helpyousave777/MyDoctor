package com.example.saeed_pc.mydoctor.Main_MyDr.GCM;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.app.MyApplication;
import com.example.saeed_pc.mydoctor.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.adapter.ChatRoomsAdapter;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.app.Config;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.app.EndPoints;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.gcm.GcmIntentService;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.gcm.NotificationUtils;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.helper.SimpleDividerItemDecoration;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.model.ChatRoom;
import com.example.saeed_pc.mydoctor.Main_MyDr.GCM.model.Message;

public class MainGCMTest extends AppCompatActivity {

    private String TAG = MainGCMTest.class.getSimpleName();
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private ArrayList<ChatRoom> chatRoomArrayList;
    private ChatRoomsAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("===>","MainGCMTest.onCreate.1");
        /**
         * Check for login session. If not logged in launch
         * login activity
         * */
        if (MyApplication.getInstance().getPrefManager().getUser() == null) {
            launchLoginActivity();
        }

        Log.i("===>","MainGCMTest.onCreate.2");
        setContentView(R.layout.activity_main_gcm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_GCMTest);
        setSupportActionBar(toolbar);
        Log.i("===>","MainGCMTest.onCreate.3");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_gcm_test);
        Log.i("===>","MainGCMTest.onCreate.4");

        /**
         * Broadcast receiver calls in two scenarios
         * 1. gcm registration is completed
         * 2. when new push notification is received
         * */
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                Log.i("===>","MainGCMTest.onCreate.5");
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    subscribeToGlobalTopic();

                } else if (intent.getAction().equals(Config.SENT_TOKEN_TO_SERVER)) {
                    // gcm registration id is stored in our server's MySQL
                    Log.i(TAG, "GCM registration id is sent to our server");

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received
                    handlePushNotification(intent);
                }
                Log.i("===>","MainGCMTest.onCreate.6");
            }
        };

        Log.i("===>","MainGCMTest.onCreate.7");
        chatRoomArrayList = new ArrayList<>();
        mAdapter = new ChatRoomsAdapter(this, chatRoomArrayList);
        Log.i("===>","MainGCMTest.onCreate.8");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));
        Log.i("===>","MainGCMTest.onCreate.9");
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        Log.i("===>","MainGCMTest.onCreate.10");

        recyclerView.addOnItemTouchListener(new ChatRoomsAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new ChatRoomsAdapter.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Log.i("===>","MainGCMTest.onCreate.11");
                // when chat is clicked, launch full chat thread activity
                ChatRoom chatRoom = chatRoomArrayList.get(position);
                Intent intent = new Intent(MainGCMTest.this, ChatRoomActivity.class);
                intent.putExtra("chat_room_id", chatRoom.getId());
                intent.putExtra("name", chatRoom.getName());
                startActivity(intent);
                Log.i("===>","MainGCMTest.onCreate.12");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        Log.i("===>","MainGCMTest.onCreate.13");

        /**
         * Always check for google play services availability before
         * proceeding further with GCM
         * */
        if (checkPlayServices()) {
            registerGCM();
            fetchChatRooms();
        }
        Log.i("===>","MainGCMTest.onCreate.14");
    }

    /**
     * Handles new push notification
     */
    private void handlePushNotification(Intent intent) {
        Log.i("===>","MainGCMTest.handlePushNotification.1");
        int type = intent.getIntExtra("type", -1);

        // if the push is of chat room message
        // simply update the UI unread messages count
        if (type == Config.PUSH_TYPE_CHATROOM) {
            Log.i("===>","MainGCMTest.handlePushNotification.2");
            Message message = (Message) intent.getSerializableExtra("message");
            String chatRoomId = intent.getStringExtra("chat_room_id");

            if (message != null && chatRoomId != null) {
                updateRow(chatRoomId, message);
            }
        } else if (type == Config.PUSH_TYPE_USER) {
            Log.i("===>","MainGCMTest.handlePushNotification.3");
            // push belongs to user alone
            // just showing the message in a toast
            Message message = (Message) intent.getSerializableExtra("message");
            Toast.makeText(getApplicationContext(), "New push: " + message.getMessage(), Toast.LENGTH_LONG).show();
        }
        Log.i("===>","MainGCMTest.handlePushNotification.4");


    }

    /**
     * Updates the chat list unread count and the last message
     */
    private void updateRow(String chatRoomId, Message message) {
        Log.i("===>","MainGCMTest.updateRow.1");
        for (ChatRoom cr : chatRoomArrayList) {
            if (cr.getId().equals(chatRoomId)) {
                int index = chatRoomArrayList.indexOf(cr);
                cr.setLastMessage(message.getMessage());
                cr.setUnreadCount(cr.getUnreadCount() + 1);
                chatRoomArrayList.remove(index);
                chatRoomArrayList.add(index, cr);
                break;
            }
        }
        Log.i("===>","MainGCMTest.updateRow.2");
        mAdapter.notifyDataSetChanged();
        Log.i("===>","MainGCMTest.updateRow.3");
    }


    /**
     * fetching the chat rooms by making http call
     */
    private void fetchChatRooms() {
        Log.i("===>","MainGCMTest.fetchChatRooms.1");
        StringRequest strReq = new StringRequest(Request.Method.GET,
                EndPoints.CHAT_ROOMS, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.i(TAG, "response: " + response);

                try {
                    JSONObject obj = new JSONObject(response);

                    // check for error flag
                    if (obj.getBoolean("error") == false) {
                        JSONArray chatRoomsArray = obj.getJSONArray("chat_rooms");
                        for (int i = 0; i < chatRoomsArray.length(); i++) {
                            JSONObject chatRoomsObj = (JSONObject) chatRoomsArray.get(i);
                            ChatRoom cr = new ChatRoom();
                            cr.setId(chatRoomsObj.getString("chat_room_id"));
                            cr.setName(chatRoomsObj.getString("name"));
                            cr.setLastMessage("");
                            cr.setUnreadCount(0);
                            cr.setTimestamp(chatRoomsObj.getString("created_at"));

                            chatRoomArrayList.add(cr);
                        }

                    } else {
                        // error in fetching chat rooms
                        Toast.makeText(getApplicationContext(), "" + obj.getJSONObject("error").getString("message"), Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    Log.i(TAG, "json parsing error: " + e.getMessage());
                    Toast.makeText(getApplicationContext(), "Json parse error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

                mAdapter.notifyDataSetChanged();

                // subscribing to all chat room topics
                subscribeToAllTopics();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                Log.i(TAG, "Volley error: " + error.getMessage() + ", code: " + networkResponse);
                Toast.makeText(getApplicationContext(), "Volley error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //Adding request to request queue
        MyApplication.getInstance().addToRequestQueue(strReq);
        Log.i("===>","MainGCMTest.fetchChatRooms.2");
    }

    // subscribing to global topic
    private void subscribeToGlobalTopic() {
        Log.i("===>","MainGCMTest.subscribeToGlobalTopic.1");
        Intent intent = new Intent(this, GcmIntentService.class);
        intent.putExtra(GcmIntentService.KEY, GcmIntentService.SUBSCRIBE);
        intent.putExtra(GcmIntentService.TOPIC, Config.TOPIC_GLOBAL);
        startService(intent);
        Log.i("===>","MainGCMTest.subscribeToGlobalTopic.2");
    }

    // Subscribing to all chat room topics
    // each topic name starts with `topic_` followed by the ID of the chat room
    // Ex: topic_1, topic_2
    private void subscribeToAllTopics() {
        Log.i("===>","MainGCMTest.subscribeToAllTopics.1");
        for (ChatRoom cr : chatRoomArrayList) {

            Intent intent = new Intent(this, GcmIntentService.class);
            intent.putExtra(GcmIntentService.KEY, GcmIntentService.SUBSCRIBE);
            intent.putExtra(GcmIntentService.TOPIC, "topic_" + cr.getId());
            startService(intent);
        }
        Log.i("===>","MainGCMTest.subscribeToAllTopics.2");
    }

    private void launchLoginActivity() {
        Log.i("===>","MainGCMTest.launchLoginActivity.1");
        Intent intent = new Intent(MainGCMTest.this, LoginActivity_GCMTest.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        Log.i("===>","MainGCMTest.launchLoginActivity.2");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("===>","MainGCMTest.onResume.1");

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));
        Log.i("===>","MainGCMTest.onResume.2");

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));
        Log.i("===>","MainGCMTest.onResume.3");

        // clearing the notification tray
        NotificationUtils.clearNotifications();
        Log.i("===>","MainGCMTest.onResume.4");
    }

    @Override
    protected void onPause() {
        Log.i("===>","MainGCMTest.onPause.1");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        Log.i("===>","MainGCMTest.onPause.2");
        super.onPause();
    }

    // starting the service to register with GCM
    private void registerGCM() {
        Log.i("===>","MainGCMTest.registerGCM.1");
        Intent intent = new Intent(this, GcmIntentService.class);
        intent.putExtra("key", "register");
        startService(intent);
        Log.i("===>","MainGCMTest.registerGCM.2");
    }

    private boolean checkPlayServices() {
        Log.i("===>","MainGCMTest.registerGCM.2");
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported. Google Play Services not installed!");
                Toast.makeText(getApplicationContext(), "This device is not supported. Google Play Services not installed!", Toast.LENGTH_LONG).show();
                finish();
            }
            Log.i("===>","MainGCMTest.checkPlayServices.false");
            return false;
        }
        Log.i("===>","MainGCMTest.checkPlayServices.true");
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("===>","MainGCMTest.onCreateOptionsMenu.2");
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        Log.i("===>","MainGCMTest.onCreateOptionsMenu.2");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Log.i("===>","MainGCMTest.onOptionsItemSelected.1");
        switch (menuItem.getItemId()) {
            case R.id.action_logout:
                MyApplication.getInstance().logout();
                break;
        }
        Log.i("===>","MainGCMTest.onOptionsItemSelected.2");
        return super.onOptionsItemSelected(menuItem);
    }
}
