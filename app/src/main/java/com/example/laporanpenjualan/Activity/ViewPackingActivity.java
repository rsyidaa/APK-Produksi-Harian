package com.example.laporanpenjualan.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.laporanpenjualan.Embed.AdapterPacking;
import com.example.laporanpenjualan.Embed.DataPacking;
import com.example.laporanpenjualan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewPackingActivity extends AppCompatActivity {

    private DatabaseReference database;
    private AdapterPacking adapter;
    private ArrayList<DataPacking> arrayList;
    RecyclerView rvdatapack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_packing);

        rvdatapack = findViewById(R.id.rvDataPacking);

        database = FirebaseDatabase.getInstance().getReference().child("Packing");
        rvdatapack.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvdatapack.setLayoutManager(layoutManager);
        rvdatapack.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }

    private void tampilData() {

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList = new ArrayList<>();

                for (DataSnapshot item : snapshot.getChildren()){
                    DataPacking his = new DataPacking();
                    his.setTanggal(item.child("Tanggal").getValue(String.class));
                    his.setPacking(item.child("pack").getValue(String.class));
                    his.setBandrol(item.child("bandrol").getValue(String.class));
                    his.setKaryawan_Packing(item.child("karyawanp").getValue(String.class));
                    his.setTotal(item.child("Total").getValue(String.class));
                    arrayList.add(his);
                }
                adapter = new AdapterPacking(arrayList,ViewPackingActivity.this);
                rvdatapack.setAdapter(adapter);
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