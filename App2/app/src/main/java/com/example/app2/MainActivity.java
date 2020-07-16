package com.example.app2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BroadcastReceiver receiver = new MyBroadcastReceiver();
//        IntentFilter filter = new IntentFilter("com.example.broadcast.MY_TOAST");
//        registerReceiver(receiver, filter);
        Intent svIntent = new Intent(context, MyService.class);
        context.startService(svIntent);
//        Intent service = new Intent(context, MyService.class);
//        context.stopService(service);
    }
}