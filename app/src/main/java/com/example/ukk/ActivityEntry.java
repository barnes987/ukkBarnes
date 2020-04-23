package com.example.ukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityEntry extends AppCompatActivity {

    Button btnPembayaran, btnDatasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        Button btnPembayaran = findViewById(R.id.pembayaran);
        btnPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityEntry.this, ActivityDataPembayaran.class);
                startActivity(intent);
            }
        });

        Button btnDatasiswa = findViewById(R.id.datasiswa);
        btnDatasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityEntry.this, DataSiswaPetugas.class);
                startActivity(intent);
            }
        });
    }
}
