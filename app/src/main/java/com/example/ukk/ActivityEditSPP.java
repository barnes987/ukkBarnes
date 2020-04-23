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

public class ActivityEditSPP extends AppCompatActivity {

    String utahun, unominal, IdSpp, id;
    EditText tahun, nominal;
    Button updatespp;
    DatabaseReference createspp;
    ModelSPP modelspp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_s_p_p);

        tahun = (EditText)findViewById(R.id.edittahun);
        nominal = (EditText)findViewById(R.id.editnominal);
        updatespp = (Button)findViewById(R.id.buttonedit);
        createspp = FirebaseDatabase.getInstance().getReference("SPP");
        modelspp = new ModelSPP();

        updatespp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSPP();
            }
        });

        utahun = getIntent().getStringExtra("tahun");
        unominal = getIntent().getStringExtra("nominal");

        tahun.setText(utahun);
        nominal.setText(unominal);
    }

    private void updateSPP() {
        String tahunp = modelspp.setTahun(tahun.getText().toString());
        String nominalp = modelspp.setNominal(nominal.getText().toString().trim());

        id = IdSpp;
        ModelSPP ms = new ModelSPP(id, tahunp, nominalp);
        createspp.child(id).setValue(ms).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ActivityEditSPP.this, "Update SPP Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DataSPP.class));
            }
        });
    }
}
