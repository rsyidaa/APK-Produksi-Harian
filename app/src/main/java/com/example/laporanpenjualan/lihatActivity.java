package com.example.laporanpenjualan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class lihatActivity extends AppCompatActivity {

    private DatabaseReference database;
    private Adapter adapter;
    private ArrayList<Data> arrayList;
    TextView atas;
    RecyclerView rvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        atas = findViewById(R.id.atas);
        rvdata = findViewById(R.id.rvData);

        database = FirebaseDatabase.getInstance().getReference();
        rvdata.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvdata.setLayoutManager(layoutManager);
        rvdata.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }

    private void tampilData() {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList = new ArrayList<>();

                for (DataSnapshot item : snapshot.getChildren()){
                    Data his = new Data();
                    his.setTanggal(item.child("Tanggal").getValue(String.class));
                    his.setPacking(item.child("pack").getValue(String.class));
                    his.setBandrol(item.child("bandrol").getValue(String.class));
                    his.setKaryawan_Packing(item.child("karyawanp").getValue(String.class));
                    his.setBatang(item.child("batang").getValue(String.class));
                    his.setKaryawan_Linting(item.child("karyawanl").getValue(String.class));
                    arrayList.add(his);
                }
                adapter = new Adapter(arrayList,lihatActivity.this);
                        rvdata.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}