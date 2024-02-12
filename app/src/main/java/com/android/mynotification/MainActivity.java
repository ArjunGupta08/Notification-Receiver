package com.android.mynotification;

import static com.android.mynotification.Constants.TOPIC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    TextView title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        title = findViewById(R.id.title);
        message = findViewById(R.id.message);

        String titleTxt = getIntent().getStringExtra("title");
        String messageTxt = getIntent().getStringExtra("message");

        title.setText("Title: " + titleTxt);
        message.setText("Message: " + messageTxt);

    }
}