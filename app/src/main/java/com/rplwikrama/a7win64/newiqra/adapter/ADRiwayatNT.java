package com.rplwikrama.a7win64.newiqra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rplwikrama.a7win64.newiqra.R;
import com.rplwikrama.a7win64.newiqra.response.DataModels;

import java.util.List;

public class ADRiwayatNT extends RecyclerView.Adapter<ADRiwayatNT.ViewHolder1> {
    private Context context;
    private List<DataModels> list;

    public ADRiwayatNT(Context context, List<DataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_riwayat_nt, viewGroup, false);
        ViewHolder1 holder1 = new ViewHolder1(v);

        return holder1;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder, int i) {
        DataModels dm = list.get(i);
        viewHolder.nopol.setText(dm.getNopol());
        viewHolder.nama_lengkap.setText(dm.getNama_lengkap());
        viewHolder.tgl_mulai_asuransi.setText(dm.getTgl_mulai_asuransi());
        viewHolder.macam_asuransi.setText(dm.getMacam_asuransi());
        viewHolder.masa_asuransi.setText(dm.getMasa_asuransi());
        viewHolder.masa_pembayaran_premi.setText(dm.getMasa_pembayaran_premi());
        viewHolder.cara_bayar.setText(dm.getCara_bayar());
        viewHolder.manfaat_awal.setText(dm.getManfaat_awal());
        viewHolder.nilai_premi_tabaru.setText(dm.getNilai_premi_tabaru());
        viewHolder.nilai_premi_total.setText(dm.getNilai_premi_total());
        viewHolder.cara_pembayaran_premi.setText(dm.getCara_pembayaran_premi());
        viewHolder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView nopol, nama_lengkap, tgl_mulai_asuransi, masa_asuransi, masa_pembayaran_premi, cara_bayar, manfaat_awal, cara_pembayaran_premi,
                macam_asuransi, nilai_premi_tabaru, nilai_premi_total;
        DataModels dm;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);

            nopol = itemView.findViewById(R.id.lblNopol);
            nama_lengkap = itemView.findViewById(R.id.lblNamaP);
            tgl_mulai_asuransi = itemView.findViewById(R.id.lblMulaiAsuransi);
            macam_asuransi = itemView.findViewById(R.id.lblMacamAsuransi);
            masa_asuransi = itemView.findViewById(R.id.lblMasaAsuransi);
            masa_pembayaran_premi = itemView.findViewById(R.id.lblMasaPK);
            cara_bayar = itemView.findViewById(R.id.lblCaraBayar);
            manfaat_awal = itemView.findViewById(R.id.lblManfaatAwal);
            nilai_premi_tabaru = itemView.findViewById(R.id.lblIuranTabaru);
            nilai_premi_total = itemView.findViewById(R.id.lblNilaiKontribusi);
            cara_pembayaran_premi = itemView.findViewById(R.id.lblInves);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
