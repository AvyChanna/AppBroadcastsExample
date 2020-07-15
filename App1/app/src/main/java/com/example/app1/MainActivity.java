package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private final Context context = this;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);
    }

    public void sendBroadcast(View view) {
        String text = mEditText.getText().toString();
        if (text.equals("")) {
            text = "No text input";
        }
        final Intent intent = new Intent();
        intent.setAction("com.example.broadcast.MY_TOAST");
        intent.putExtra("data", text);
        sendBroadcast(intent);

        intent.setComponent(new ComponentName("com.example.App2", "com.example.App2.MainActivity"));
        sendBroadcast(intent);
    }
}