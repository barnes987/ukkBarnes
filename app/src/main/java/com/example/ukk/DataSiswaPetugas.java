package com.example.ukk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataSiswaPetugas extends AppCompatActivity {

    RecyclerView rView;
    List<ModelSiswa> mSiswa;
    ModelSiswa modelsiswa;
    AdapterSiswaData mAdapter;
    DatabaseReference dReference;
    ValueEventListener vListener;
    ImageView buttoncs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_siswa_petugas);
        rView = (RecyclerView)findViewById(R.id.rDataSiswa);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        modelsiswa = new ModelSiswa();
        mSiswa = new ArrayList<>();
        mAdapter = new AdapterSiswaData(getApplicationContext(),mSiswa);
        rView.setAdapter(mAdapter);
        dReference = FirebaseDatabase.getInstance().getReference("Siswa");
        datasiswa();
        buttoncs = (ImageView)findViewById(R.id.buttoncs);
        buttoncs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ActivitySiswaCreate.class));
            }
        });
    }

    private void datasiswa  (){
        vListener = dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mSiswa.clear();
                for (DataSnapshot siswasnapshot:dataSnapshot.getChildren()){
                    ModelSiswa ms = siswasnapshot.getValue(ModelSiswa.class);
                    mSiswa.add(ms);
                }mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DataSiswaPetugas.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
