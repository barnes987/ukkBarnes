package com.example.ukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginLevel extends AppCompatActivity {

    Button btnPetugas, btnSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_level);

        Button btnPetugas = findViewById(R.id.petugas);
        btnPetugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginLevel.this, ActivityLogin.class);
                startActivity(intent);
            }
        });

        Button btnSiswa = findViewById(R.id.siswa);
        btnSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginLevel.this, ActivityLoginSiswa.class);
                startActivity(intent);
            }
        });
    }
}
