package com.example.app2;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MyService extends Service {
    private final String TAG = getClass().getSimpleName();
    private static BroadcastReceiver mReceiver;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        registerMyReceiver();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        mReceiver = null;
    }

    private void registerMyReceiver() {
        mReceiver = new MyBroadcastReceiver(this);

        IntentFilter filter = new IntentFilter("com.example.broadcast.MY_TOAST");
        registerReceiver(mReceiver, filter);
    }
}

