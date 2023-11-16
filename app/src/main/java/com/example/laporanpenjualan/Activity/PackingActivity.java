package com.example.laporanpenjualan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.laporanpenjualan.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PackingActivity extends AppCompatActivity {
    private DatabaseReference database;
    EditText epack, ebandrol, ekaryawanp;
    Button btKirim, exit, btTotal;
    ProgressDialog progressDialog;
    private TextView date, Total;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packing);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://laporanpenjualan-b6b42-default-rtdb.firebaseio.com/");
        Calendar calendar = Calendar.getInstance();
        date = findViewById(R.id.text_view_date);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        date.setText(currentDate);


        epack = findViewById(R.id.tpack);
        ebandrol = findViewById(R.id.tbandrol);
        ekaryawanp = findViewById(R.id.tkaryawanp);
        btKirim = findViewById(R.id.btKirim);
        exit = findViewById(R.id.btExit);
        btTotal = findViewById(R.id.btTotal);
        Total = findViewById(R.id.tvtotal);

        progressDialog = new ProgressDialog(PackingActivity.this);
        progressDialog.setMessage("Loading...");

        btTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(epack.getText().toString());
                int b = Integer.parseInt(ebandrol.getText().toString());
                int c = a * b;
                Total.setText(String.valueOf(c));
            }
        });

        btKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (epack.getText().toString().isEmpty() ||Total.getText().toString().isEmpty() || ebandrol.getText().toString().isEmpty() || ekaryawanp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Mohon Lengkapi Data !", Toast.LENGTH_LONG).show();
                }else {
                    addDataProduksi();
                    database = FirebaseDatabase.getInstance().getReference().child("Packing").push();

                    database.child("Tanggal").setValue(currentDate.toString());
                    database.child("pack").setValue(epack.getText().toString());
                    database.child("bandrol").setValue(ebandrol.getText().toString());
                    database.child("karyawanp").setValue(ekaryawanp.getText().toString());
                    database.child("Total").setValue(Total.getText().toString());
                    progressDialog.show();

                }

            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                finish();
            }
        });

    }
    public void addDataProduksi(){
        String sdate = date.getText().toString();
        String spack = epack.getText().toString();
        String sbandrol = ebandrol.getText().toString();
        String skaryawanp = ekaryawanp.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbyyS9GI0gVSm7w2pQo9dPtsHfvi6cBf2weW_JqnkAb2-uod7PQ1DB9_iMJt45qAwjhA/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Tersimpan", Toast.LENGTH_SHORT).show();
                progressDialog.hide();
                epack.setText("");
                ebandrol.setText("");
                ekaryawanp.setText("");
                startActivity(new Intent(getApplicationContext(), ViewPackingActivity.class));
                finish();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("action", "addData");
                params.put("vdate",sdate);
                params.put("vpack",spack);
                params.put("vbandrol",sbandrol);
                params.put("vkaryawanp",skaryawanp);

                return params;
            }
        };

        int socketTimeOut = 5000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }
}