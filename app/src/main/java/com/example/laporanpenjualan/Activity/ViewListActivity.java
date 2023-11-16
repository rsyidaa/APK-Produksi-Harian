package com.example.laporanpenjualan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.laporanpenjualan.R;
import com.example.laporanpenjualan.databinding.ActivityViewListBinding;

public class ViewListActivity extends AppCompatActivity {

    ActivityViewListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Lihathispack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewPackingActivity.class));
                finish();
            }
        });
        binding.Lihathislin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewLintingActivity.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }
}