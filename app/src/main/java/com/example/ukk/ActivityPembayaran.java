package com.example.ukk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityPembayaran extends AppCompatActivity {

    EditText jumlah;
    Spinner nama, tanggal;
    Button submit;
    String entry, apawelah, entryu, apawelahh;
    ArrayList<String> arrayentry, arrayentryu;
    DatabaseReference createentry, siswa, tanggalspp;
    ModelEntry modelEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        nama = (Spinner) findViewById(R.id.namasiswa);
        tanggal = (Spinner)findViewById(R.id.tanggalbyr);
        jumlah = (EditText)findViewById(R.id.jumlahbyr);
        submit = (Button)findViewById(R.id.buttonsbayar);
        createentry = FirebaseDatabase.getInstance().getReference("Pembayaran");
        siswa = FirebaseDatabase.getInstance().getReference("Siswa");
        tanggalspp = FirebaseDatabase.getInstance().getReference("SPP");
        modelEntry = new ModelEntry();
        arrayentry = new ArrayList<>();
        arrayentryu = new ArrayList<>();
        tanggalspp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot forsnapp:dataSnapshot.getChildren()){
                    entryu = forsnapp.child("tahun").getValue(String.class);
                    arrayentryu.add(entryu);

                    ArrayAdapter<String> arrayvare = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayentryu);
                    arrayvare.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    tanggal.setAdapter(arrayvare);
                    tanggal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            apawelahh = adapterView.getItemAtPosition(i).toString();
                            Toast.makeText(ActivityPembayaran.this, apawelahh, Toast.LENGTH_SHORT).show();;
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        siswa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot forsnap:dataSnapshot.getChildren()){

                    entry = forsnap.child("nama").getValue(String.class);
                    arrayentry.add(entry);

                    ArrayAdapter<String> arrayvar = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayentry);
                    arrayvar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    nama.setAdapter(arrayvar);
                    nama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            apawelah = adapterView.getItemAtPosition(i).toString();
                            Toast.makeText(ActivityPembayaran.this, apawelah, Toast.LENGTH_SHORT).show();;
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEntry();
            }
        });
    }

    private void createEntry(){
        String jumlahe = modelEntry.setJumlah(jumlah.getText().toString());

        String id = createentry.push().getKey();
        ModelEntry me = new ModelEntry(id,apawelah ,apawelahh, jumlahe);
        createentry.child(id).setValue(me).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ActivityPembayaran.this, "Create Pembayaran Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), ActivityEntry.class));
            }
        });
    }
}
