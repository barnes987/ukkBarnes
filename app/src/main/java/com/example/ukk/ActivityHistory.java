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

public class ActivityHistory extends AppCompatActivity {

    RecyclerView rView;
    List<ModelSiswa> mEntry;
    ModelEntry modelEntry;
    AdapterPembayaranData mAdapter;
    DatabaseReference dReference;
    ValueEventListener vListener;
    ImageView buttoncs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rView = (RecyclerView)findViewById(R.id.rDataHistory);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        modelEntry = new ModelEntry();
        mEntry = new ArrayList<>();
        mAdapter = new AdapterPembayaranData(getApplicationContext(),mEntry);
        rView.setAdapter(mAdapter);
        dReference = FirebaseDatabase.getInstance().getReference("Pembayaran");
//        dataentry();
        buttoncs = (ImageView)findViewById(R.id.buttonck);
        buttoncs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ActivitySiswaCreate.class));
            }
        });
    }

    //INI UNTUK HISTORY TAPI MASIH ADA YANG ERROR (MUNGKIN BUG)

//    private void dataentry (){
//        vListener = dReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                mEntry.clear();
//                for (DataSnapshot entrysnapshot:dataSnapshot.getChildren()){
//                    ModelEntry me = entrysnapshot.getValue(ModelEntry.class);
//                    mEntry.add(me);
//                }
//                mAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(ActivityHistory.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}
