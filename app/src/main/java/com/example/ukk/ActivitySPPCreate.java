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

public class ActivitySPPCreate extends AppCompatActivity {

    EditText tahunspp, nominal;
    Button submitspp;
    DatabaseReference createspp;
    ModelSPP modelspp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p_p_create);

        tahunspp = (EditText)findViewById(R.id.tahun);
        nominal = (EditText)findViewById(R.id.nominal);
        submitspp = (Button)findViewById(R.id.buttonsubmits);
        createspp = FirebaseDatabase.getInstance().getReference("SPP");
        modelspp = new ModelSPP();
        submitspp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createspp();
            }
        });
    }

    private void createspp(){
        String tahunsppp = modelspp.setTahun(tahunspp.getText().toString());
        String nominalsppp = modelspp.setNominal(nominal.getText().toString().trim());

        String id = createspp.push().getKey();
        ModelSPP mspp = new ModelSPP(tahunsppp, nominalsppp, id);
        createspp.child(id).setValue(mspp).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ActivitySPPCreate.this, "Create SPP Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DataSPP.class));
            }
        });
    }
}
