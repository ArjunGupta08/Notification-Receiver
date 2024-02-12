package com.android.mynotification;

import static com.android.mynotification.Constants.TOPIC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mynotification.api.ApiUtilities;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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