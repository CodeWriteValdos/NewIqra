package com.rplwikrama.a7win64.newiqra.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rplwikrama.a7win64.newiqra.MainActivity;
import com.rplwikrama.a7win64.newiqra.R;
import com.rplwikrama.a7win64.newiqra.response.DataModels;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolder> {
    private Context context;
    private List<DataModels> list;

    public AdapterData(Context context, List<DataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterData.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_main, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.ViewHolder viewHolder, int i) {
        DataModels dm = list.get(i);
        viewHolder.noCif.setText(dm.getNoCif());
        viewHolder.nama.setText(dm.getNama());
        viewHolder.jk.setText(dm.getJk());
        viewHolder.kotaKelahiran.setText(dm.getKotaKelahiran());
        viewHolder.tglLahir.setText(dm.getTglLahir());
        viewHolder.macamAsuransi.setText(dm.getMacamAsuransi());
        viewHolder.mulaiAsuransi.setText(dm.getMulaiAsuransi());
        viewHolder.akhirAsuransi.setText(dm.getAkhirAsuransi());
        viewHolder.masaAsuransi.setText(dm.getMasaAsuransi());
        viewHolder.nilaiKontribusi.setText(dm.getNilaiKontribusi());
        viewHolder.masaPK.setText(dm.getMasaPK());
        viewHolder.caraBayar.setText(dm.getCaraBayar());
        viewHolder.manfaatAwal.setText(dm.getManfaatAwal());
        viewHolder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noCif, nama, jk, kotaKelahiran, tglLahir, macamAsuransi, mulaiAsuransi, akhirAsuransi, masaAsuransi, nilaiKontribusi,
                masaPK, caraBayar, manfaatAwal;
        DataModels dm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            noCif = itemView.findViewById(R.id.noCif);
            nama = itemView.findViewById(R.id.nama);
            jk = itemView.findViewById(R.id.jk);
            kotaKelahiran = itemView.findViewById(R.id.kotaKelahiran);
            tglLahir = itemView.findViewById(R.id.tglLahir);
            macamAsuransi = itemView.findViewById(R.id.macamAsuransi);
            mulaiAsuransi = itemView.findViewById(R.id.mulaiAsuransi);
            akhirAsuransi = itemView.findViewById(R.id.akhirAsuransi);
            masaAsuransi = itemView.findViewById(R.id.masaAsuransi);
            nilaiKontribusi = itemView.findViewById(R.id.nilaiKontribusi);
            masaPK = itemView.findViewById(R.id.masaPK);
            caraBayar = itemView.findViewById(R.id.caraBayar);
            manfaatAwal = itemView.findViewById(R.id.manfaatAwal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
