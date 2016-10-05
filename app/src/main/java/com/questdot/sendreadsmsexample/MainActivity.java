package com.questdot.sendreadsmsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText edPhone;
    EditText edMessage;
    public static MainActivity mThis = null;
    @Override
    protected void onResume() {
        super.onResume();
        mThis = this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        mThis = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        edPhone = (EditText) findViewById(R.id.editTextPhoneNo);
        edMessage = (EditText) findViewById(R.id.editTextSMS);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });


    }

    protected void sendSMS() {
        String toPhoneNumber = edPhone.getText().toString();
        String smsMessage = edMessage.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(toPhoneNumber, null, smsMessage, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent success.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Sending SMS failed.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}
