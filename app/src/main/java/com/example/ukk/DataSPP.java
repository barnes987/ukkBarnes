package com.example.ukk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
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

public class DataSPP extends AppCompatActivity {

    RecyclerView rView;
    List<ModelSPP> mspp;
    ModelSPP modelSPP;
    AdapterSPPData mAdapter;
    DatabaseReference dReference;
    ValueEventListener vListener;
    ImageView btnspp;
    Dialog dialogmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_s_p_p);

        rView = (RecyclerView)findViewById(R.id.rDataSPP);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        modelSPP = new ModelSPP();
        mspp = new ArrayList<>();
        mAdapter = new AdapterSPPData(getApplicationContext(),mspp);
        rView.setAdapter(mAdapter);
        dReference = FirebaseDatabase.getInstance().getReference("SPP");
        dataSPP();
        btnspp = (ImageView)findViewById(R.id.buttoncp);
        btnspp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataSPP.this, ActivitySPPCreate.class);
                startActivity(intent);
            }
        });
    }

    private void dataSPP (){
        vListener = dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mspp.clear();
                for (DataSnapshot sppsnapshot:dataSnapshot.getChildren()){
                    ModelSPP mp = sppsnapshot.getValue(ModelSPP.class);
                    mspp.add(mp);
                }mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DataSPP.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
