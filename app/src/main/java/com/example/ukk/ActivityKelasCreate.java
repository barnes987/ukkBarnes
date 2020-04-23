package com.example.ukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityKelasCreate extends AppCompatActivity {

    EditText kelas;
    Button sumbitcs;
    DatabaseReference createkelas;
    ModelKelas modelkelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas_create);

        kelas = (EditText)findViewById(R.id.kelascreate);
        sumbitcs = (Button)findViewById(R.id.buttonsubmits);
        createkelas = FirebaseDatabase.getInstance().getReference("Kelas");
        modelkelas = new ModelKelas();
        sumbitcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createKelas();
            }
        });
    }

    private void createKelas() {
        String kelassiswa = modelkelas.setKelas(kelas.getText().toString().trim());


        String id = createkelas.push().getKey();
        ModelKelas mk = new ModelKelas(kelassiswa, id);
        createkelas.child(id).setValue(mk).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ActivityKelasCreate.this, "Create Siswa Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DataKelas.class));
            }
        });
    }
}
