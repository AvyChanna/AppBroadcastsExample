package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BroadcastReceiver receiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter("com.example.broadcast.MY_TOAST");
        this.registerReceiver(receiver, filter);

    }

    public class MyBroadcastReceiver extends BroadcastReceiver {
        private final String TAG = getClass().getSimpleName();

        @Override
        public void onReceive(Context c, Intent intent) {
            String text = intent.getStringExtra("data");
            if (text.equals(""))
                text = "No text input";
            Log.d(TAG, text);
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        }
    }

}