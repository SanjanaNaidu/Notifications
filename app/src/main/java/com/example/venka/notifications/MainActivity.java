package com.example.venka.notifications;

import android.annotation.SuppressLint;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextMessage;
    private Button Button;
    private Button Button2 ;
    private NotificationHelper mNoificationHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTitle =  findViewById(R.id.edittext_title1);
        editTextMessage =  findViewById(R.id.edittext_message1);
        Button = findViewById(R.id.Button1);
        Button2 = findViewById(R.id.Button2);
        mNoificationHelper = new NotificationHelper(this);
        Button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                send(editTextTitle.getText().toString(),editTextMessage.getText().toString());

            }

        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             receive(editTextTitle.getText().toString(),editTextMessage.getText().toString());
            }
        });
    }
    


    public void send(String Title,String Message) {
        NotificationCompat.Builder nb = mNoificationHelper.getChNotification(Title, Message);
        mNoificationHelper.getManager().notify(1,nb.build());
    }

    public void receive(String Title,String Message) {
        NotificationCompat.Builder nb = mNoificationHelper.getChNotification(Title, Message);
        mNoificationHelper.getManager().notify(2,nb.build());
    }
}
