package com.example.ukk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterPembayaranData extends RecyclerView.Adapter <com.example.ukk.AdapterPembayaranData.PembayaranViewHolder>{

    Context mcontext;
    List<ModelEntry> mentry;
    DatabaseReference dRef;

    public AdapterPembayaranData( Context context, List<ModelSiswa> msiswa) {
        this.mcontext = context;
        this.mentry = mentry;
    }

    @NonNull
    @Override
    public AdapterPembayaranData.PembayaranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rowe,parent,false);
        return new AdapterPembayaranData.PembayaranViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterPembayaranData.PembayaranViewHolder holder, int position) {
        final ModelEntry modelEntry = mentry.get(position);
        holder.namae.setText(modelEntry.getNama());
        holder.jumlahe.setText(modelEntry.getJumlah());
    }

    @Override
    public int getItemCount() {
        return mentry.size();
    }

    public class PembayaranViewHolder extends RecyclerView.ViewHolder {
        TextView namae, jumlahe;
        View mView;
        ImageView deletep, ubahp;

        public PembayaranViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            namae = (TextView)itemView.findViewById(R.id.textnama);
            jumlahe = (TextView)itemView.findViewById(R.id.textjumlah);
            dRef = FirebaseDatabase.getInstance().getReference("Pembayaran");
        }
    }

    private void deleteInfo(String id) {
        DatabaseReference dInfo = FirebaseDatabase.getInstance().getReference("Pembayaran").child(id);
        dInfo.removeValue();
        Toast.makeText(mcontext, "Delete Succed", Toast.LENGTH_SHORT).show();
    }
}
