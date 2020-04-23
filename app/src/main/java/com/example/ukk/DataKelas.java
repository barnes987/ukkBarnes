package com.example.ukk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataKelas extends AppCompatActivity {

    RecyclerView rView;
    List<ModelKelas> mKelas;
    ModelKelas modelkelas;
    AdapterKelasData mAdapter;
    DatabaseReference dReference;
    ValueEventListener vListener;
    ImageView btnck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kelas);
        rView = (RecyclerView)findViewById(R.id.rDataKelas);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        modelkelas = new ModelKelas();
        mKelas = new ArrayList<>();
        mAdapter = new AdapterKelasData(getApplicationContext(),mKelas);
        rView.setAdapter(mAdapter);
        dReference = FirebaseDatabase.getInstance().getReference("Kelas");
        datakelas();

        btnck = (ImageView)findViewById(R.id.buttonck);
        btnck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataKelas.this, ActivityKelasCreate.class);
                startActivity(intent);
            }
        });
    }

    private void datakelas  (){
        vListener = dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mKelas.clear();
                for (DataSnapshot siswasnapshot:dataSnapshot.getChildren()){
                    ModelKelas mk = siswasnapshot.getValue(ModelKelas.class);
                    mKelas.add(mk);
                }mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DataKelas.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
