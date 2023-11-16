package com.example.laporanpenjualan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laporanpenjualan.R;
import com.example.laporanpenjualan.databinding.ActivityLintingBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class LintingActivity extends AppCompatActivity {

    ActivityLintingBinding binding;

    private DatabaseReference database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLintingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://laporanpenjualan-b6b42-default-rtdb.firebaseio.com/");
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        binding.tvdate.setText(currentDate);

        progressDialog = new ProgressDialog(LintingActivity.this);
        progressDialog.setMessage("Loading...");

        binding.btKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.tkaryawanl.getText().toString().isEmpty() || binding.tbatang.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Mohon Lengkapi Data !", Toast.LENGTH_LONG).show();
                }else {

                    database = FirebaseDatabase.getInstance().getReference().child("Linting").push();

                    database.child("Tanggal").setValue(currentDate.toString());
                    database.child("Karyawan").setValue(binding.tkaryawanl.getText().toString());
                    database.child("Batang").setValue(binding.tbatang.getText().toString());
                    progressDialog.show();
                    Toast.makeText(getApplicationContext(), "Tersimpan", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                    binding.tkaryawanl.setText("");
                    binding.tbatang.setText("");
                    startActivity(new Intent(getApplicationContext(), ViewLintingActivity.class));
                    finish();

                }
            }
        });

        binding.btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
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
