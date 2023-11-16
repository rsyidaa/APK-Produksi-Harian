package com.example.laporanpenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LintingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linting);
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }
}
