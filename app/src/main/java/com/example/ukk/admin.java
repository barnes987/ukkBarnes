package com.example.ukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {

    Button btnSiswa, btnSPPSiswa, btnKelas, btnPetugas, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button btnSiswa = findViewById(R.id.datasiswa);
        btnSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, ActivityDataSiswa.class);
                startActivity(intent);
            }
        });

        Button btnSPPSiswa = findViewById(R.id.dataspp);
        btnSPPSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, DataSPP.class);
                startActivity(intent);
            }
        });

        Button btnKelas = findViewById(R.id.datakelas);
        btnKelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, DataKelas.class);
                startActivity(intent);
            }
        });

        Button btnPetugas = findViewById(R.id.datapetugas);
        btnPetugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, DataPetugas.class);
                startActivity(intent);
            }
        });

        Button btnHistory = findViewById(R.id.historyspp);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, HistorySPP.class);
                startActivity(intent);
            }
        });

    }
}
