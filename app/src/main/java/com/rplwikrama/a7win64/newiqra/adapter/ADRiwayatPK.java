package com.rplwikrama.a7win64.newiqra.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rplwikrama.a7win64.newiqra.R;
import com.rplwikrama.a7win64.newiqra.RiwayatPKActivity;
import com.rplwikrama.a7win64.newiqra.response.DataModels;

import java.util.List;

public class ADRiwayatPK extends RecyclerView.Adapter<ADRiwayatPK.ViewHolder2> {
    private Context context;
    private List<DataModels> list;

    public ADRiwayatPK(Context context, List<DataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_riwayat_pk, viewGroup, false);
        ViewHolder2 holder = new ViewHolder2(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 viewHolder2, int i) {
        DataModels dm = list.get(i);
        viewHolder2.array.setText(dm.getArray());
        viewHolder2.tgl_jatuh_tempo.setText(dm.getTgl_jatuh_tempo());
        viewHolder2.io_tgl_pembayaran.setText(dm.getIo_tgl_pembayaran());
        viewHolder2.tabungan.setText(dm.getTabungan());
        viewHolder2.tabaru.setText(dm.getTabaru());
        viewHolder2.biaya.setText(dm.getBiaya());
        viewHolder2.nilai_premi_waiver.setText(dm.getNilai_premi_waiver());
        viewHolder2.nilai_premi_raider.setText(dm.getNilai_premi_raider());
        viewHolder2.nilai_premi_aviasi.setText(dm.getNilai_premi_aviasi());
        viewHolder2.nilai_premi_ekstra.setText(dm.getNilai_premi_ekstra());
        viewHolder2.nilai_titipan_premi.setText(dm.getNilai_titipan_premi());
        viewHolder2.nilai_premi_total2.setText(dm.getNilai_premi_total2());
        viewHolder2.dm = dm;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView array, tgl_jatuh_tempo, io_tgl_pembayaran, tabungan, tabaru, biaya, nilai_premi_waiver, nilai_premi_raider,
                nilai_premi_aviasi, nilai_premi_ekstra, nilai_titipan_premi, nilai_premi_total2;
        DataModels dm;

        public ViewHolder2(View view) {
            super(view);

            array = view.findViewById(R.id.lblArray);
            tgl_jatuh_tempo = view.findViewById(R.id.lblJth_tempo);
            io_tgl_pembayaran = view.findViewById(R.id.lblTgl_bayar);
            tabungan = view.findViewById(R.id.lblTabungan);
            tabaru = view.findViewById(R.id.lblTabaru);
            biaya = view.findViewById(R.id.lblBiaya);
            nilai_premi_waiver = view.findViewById(R.id.lblWaiver);
            nilai_premi_raider = view.findViewById(R.id.lblRaider);
            nilai_premi_aviasi = view.findViewById(R.id.lblAviasi);
            nilai_premi_ekstra = view.findViewById(R.id.lblEkstra);
            nilai_titipan_premi = view.findViewById(R.id.lblTitipan);
            nilai_premi_total2 = view.findViewById(R.id.lblNilaiKontribusi);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(context, RiwayatPKActivity.class);
                    goInput.putExtra("array", dm.getArray());
                    goInput.putExtra("tgl_jatuh_tempo", dm.getTgl_jatuh_tempo());
                    goInput.putExtra("io_tgl_pembayaran", dm.getIo_tgl_pembayaran());
                    goInput.putExtra("tabungan", dm.getTabungan());
                    goInput.putExtra("tabaru", dm.getTabaru());
                    goInput.putExtra("biaya", dm.getBiaya());
                    goInput.putExtra("nilai_premi_waiver", dm.getNilai_premi_waiver());
                    goInput.putExtra("nilai_premi_raider", dm.getNilai_premi_raider());
                    goInput.putExtra("nilai_premi_aviasi", dm.getNilai_premi_aviasi());
                    goInput.putExtra("nilai_premi_ekstra", dm.getNilai_premi_ekstra());
                    goInput.putExtra("nilai_titipan_premi", dm.getNilai_titipan_premi());
                    goInput.putExtra("nilai_premi_total2", dm.getNilai_premi_total2());

                    context.startActivity(goInput);
                }
            });
        }
    }
}
