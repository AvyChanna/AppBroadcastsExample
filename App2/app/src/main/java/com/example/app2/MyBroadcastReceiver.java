package com.example.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private Context c;
    public MyBroadcastReceiver(){super();}
    public MyBroadcastReceiver(Context ctx){
        super();
        c = ctx;
    }
    private final String TAG = getClass().getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra("data");
        if (text == null || text.equals(""))
            text = "No text input";
//            Log.d(TAG, text);
        Toast.makeText(c, text, Toast.LENGTH_LONG).show();
    }
}
