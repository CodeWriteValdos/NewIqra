package com.rplwikrama.a7win64.newiqra.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rplwikrama.a7win64.newiqra.LaporanKlaimActivity;
import com.rplwikrama.a7win64.newiqra.R;
import com.rplwikrama.a7win64.newiqra.response.DataModels;

import java.util.List;

public class ADLaporanK extends RecyclerView.Adapter<ADLaporanK.ViewHolder3> {
    private Context context;
    private List<DataModels> list;

    public ADLaporanK(Context context, List<DataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_laporan_klaim, viewGroup, false);
        ViewHolder3 holder = new ViewHolder3(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder3 viewHolder3, int i) {
        DataModels dm = list.get(i);
        viewHolder3.jenis_klaim.setText(dm.getJenis_klaim());
        viewHolder3.tgl_pengajuan.setText(dm.getTgl_pengajuan());
        viewHolder3.tgl_otorisasi.setText(dm.getTgl_otorisasi());
        viewHolder3.nomor_bukti_kas.setText(dm.getNomor_bukti_kas());
        viewHolder3.status_klaim.setText(dm.getStatus_klaim());
        viewHolder3.nilai_klaim.setText(dm.getNilai_klaim());
        viewHolder3.nama_kantor.setText(dm.getNama_kantor());
        viewHolder3.nama_kantor_lain.setText(dm.getNama_kantor_lainnya());
        viewHolder3.dm = dm;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView jenis_klaim, tgl_pengajuan, tgl_otorisasi, nomor_bukti_kas, status_klaim, nilai_klaim, nama_kantor, nama_kantor_lain;
        DataModels dm;

        public ViewHolder3(View itemView) {
            super(itemView);

            jenis_klaim = itemView.findViewById(R.id.lblJenisKlaim);
            tgl_pengajuan = itemView.findViewById(R.id.lblTglPengajuan);
            tgl_otorisasi = itemView.findViewById(R.id.lblTglOtorisasi);
            nomor_bukti_kas = itemView.findViewById(R.id.lblNomorBK);
            status_klaim = itemView.findViewById(R.id.lblStatusKlaim);
            nilai_klaim = itemView.findViewById(R.id.lblNilaiKlaim);
            nama_kantor = itemView.findViewById(R.id.lblNamaKantor);
            nama_kantor_lain = itemView.findViewById(R.id.lblNamaKantor2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(context, LaporanKlaimActivity.class);
                    goInput.putExtra("jenis_klaim", dm.getJenis_klaim());
                    goInput.putExtra("tgl_pengajuan", dm.getTgl_pengajuan());
                    goInput.putExtra("tgl_otorisasi", dm.getTgl_otorisasi());
                    goInput.putExtra("nomor_bukti_kas", dm.getNomor_bukti_kas());
                    goInput.putExtra("status_klaim", dm.getStatus_klaim());
                    goInput.putExtra("nilai_klaim", dm.getNilai_klaim());
                    goInput.putExtra("nama_kantor", dm.getNama_kantor());
                    goInput.putExtra("nama_kantor_lain", dm.getNama_kantor_lainnya());

                    context.startActivity(goInput);
                }
            });
        }
    }
}
