package com.example.laporanpenjualan.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.laporanpenjualan.Embed.AdapterLinting;
import com.example.laporanpenjualan.Embed.DataLinting;
import com.example.laporanpenjualan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewLintingActivity extends AppCompatActivity {

    private DatabaseReference database;
    private AdapterLinting adapter;
    private ArrayList<DataLinting> arrayList;
    RecyclerView rvdatalin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_linting);

        rvdatalin = findViewById(R.id.rvDataLinting);

        database = FirebaseDatabase.getInstance().getReference().child("Linting");
        rvdatalin.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvdatalin.setLayoutManager(layoutManager);
        rvdatalin.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }

    private void tampilData() {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList = new ArrayList<>();

                for (DataSnapshot item : snapshot.getChildren()){
                    DataLinting his = new DataLinting();
                    his.setTanggal(item.child("Tanggal").getValue(String.class));
                    his.setBatang(item.child("Batang").getValue(String.class));
                    his.setKaryawan_Linting(item.child("Karyawan").getValue(String.class));
                    arrayList.add(his);
                }
                adapter = new AdapterLinting(arrayList,ViewLintingActivity.this);
                rvdatalin.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }
}