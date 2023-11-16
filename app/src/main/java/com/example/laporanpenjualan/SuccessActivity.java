package com.example.laporanpenjualan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    Button web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        web = findViewById(R.id.btlink);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoUrl("https://docs.google.com/spreadsheets/d/1f0sq318YmFbOB6ILiRep6vy23JI1kdChH4rGNMKgGuU/edit?usp=sharing");
            }
        });
    }

    void gotoUrl(String s){
        try {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "No website link", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickExit(View v){
        finish();
    }
}
