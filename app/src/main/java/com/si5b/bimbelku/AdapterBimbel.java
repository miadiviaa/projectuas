package com.si5b.bimbelku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterSalon extends RecyclerView.Adapter<AdapterSalon.VHSalon> {
    private ArrayList<ModelSalon> dataSalon;
    private Context ctx;

    public AdapterSalon(ArrayList<ModelSalon> dataSalon,Context ctx){
        this.dataSalon=dataSalon;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public VHSalon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View VW = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new VHSalon(VW);
    }

    @Override
    public void onBindViewHolder(@NonNull VHSalon holder, int position) {
        ModelSalon salon = dataSalon.get(position);
        holder.tvNama.setText(salon.getNama());
        holder.tvDeskripsi.setText(salon.getDeskripsi());
        holder.tvAlamat.setText(salon.getAlamat());
        holder.tvKoordinat.setText(salon.getKoordinat());

        Glide
                .with(ctx)
                .load(salon.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xNama,xDeskripsi,xFoto,xAlamat,xKoordinat;
                xNama = salon.getNama();
                xDeskripsi = salon.getDeskripsi();
                xFoto = salon.getFoto();
                xAlamat = salon.getAlamat();
                xKoordinat = salon.getKoordinat();

                Intent send = new Intent(ctx, DetailActivity.class);
                send.putExtra("xNama",xNama);
                send.putExtra("xDeskripsi",xDeskripsi);
                send.putExtra("xFoto",xFoto);
                send.putExtra("xAlamat",xAlamat);
                send.putExtra("xKoordinat",xKoordinat);
                ctx.startActivity(send);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSalon.size();
    }

    public class VHSalon extends RecyclerView.ViewHolder {
        TextView tvNama,tvDeskripsi,tvAlamat,tvKoordinat;
        ImageView ivFoto;


        public VHBimbel(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvKoordinat = itemView.findViewById(R.id.tv_koordinat);
        }
    }
}
