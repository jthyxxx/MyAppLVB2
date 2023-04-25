package com.example.myapplvb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_SendSMSPage extends AppCompatActivity {

    Button btnSend;
    Button btnClear;
    EditText txtNumber;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smspage);

        btnSend = findViewById(R.id.btnSend);
        btnClear = findViewById(R.id.btnClear);
        txtNumber = findViewById(R.id.txtNumber);
        txtMessage = findViewById(R.id.txtMessage);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = txtNumber.getText().toString();
                String message = txtMessage.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNumber, null));
                intent.putExtra("sms_body", message);
                startActivity(intent);

                Toast.makeText(Activity_SendSMSPage.this, "SMS Sent", Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setText("");
                txtNumber.setText("");
            }
        });
    }
}