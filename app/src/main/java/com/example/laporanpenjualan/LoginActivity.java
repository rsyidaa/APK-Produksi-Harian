package com.example.laporanpenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText inputUser, inputPass;
    Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUser = findViewById(R.id.user);
        inputPass = findViewById(R.id.password);
        btLogin = findViewById(R.id.buttonLogin);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputUser.getText().toString())){
                    Toast.makeText(getApplicationContext(),"isi email", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(inputPass.getText().toString())){
                    Toast.makeText(getApplicationContext(),"isi password", Toast.LENGTH_SHORT).show();
                }else{
                    if (inputUser.getText().toString().equals("admin") || inputPass.getText().toString().equals("admin")){
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"email / katasandi salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
