package com.rplwikrama.a7win64.newiqra;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.rplwikrama.a7win64.newiqra.adapter.AdapterData;
import com.rplwikrama.a7win64.newiqra.api.Api;
import com.rplwikrama.a7win64.newiqra.api.RetrofitClient;
import com.rplwikrama.a7win64.newiqra.response.DataModels;
import com.rplwikrama.a7win64.newiqra.response.ResponseModels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataModels> item = new ArrayList<>();

    public String strNopol = "", strNama;
    public TextView txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNama = findViewById(R.id.nama);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                strNopol = null;
            } else {
                strNopol = extras.getString("nopol");
            }
        }

        recyclerView1 = findViewById(R.id.main_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager);

        Api api = RetrofitClient.getClient().create(Api.class);
        Call<ResponseModels> call = api.getData(strNopol);
        call.enqueue(new Callback<ResponseModels>() {
            @Override
            public void onResponse(Call<ResponseModels> call, Response<ResponseModels> response) {
                Log.d("RETRO", response.body().toString());

                item = response.body().getResult();

                adapter = new AdapterData(MainActivity.this, item);
                recyclerView1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModels> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout) {
            showDialog();
        } else if(item.getItemId() == R.id.riwayatNT) {
            Intent riwayat_nt = new Intent(MainActivity.this, RiwayatNTActivity.class);
            riwayat_nt.putExtra("nopol", strNopol);
            startActivity(riwayat_nt);
        } else if(item.getItemId() == R.id.riwayatPK) {
            Intent riwayat_pk = new Intent(MainActivity.this, RiwayatPKActivity.class);
            riwayat_pk.putExtra("nopol", strNopol);
            startActivity(riwayat_pk);
        } else if(item.getItemId() == R.id.laporanKlaim) {
            Intent laporan_klaim = new Intent(MainActivity.this, LaporanKlaimActivity.class);
            laporan_klaim.putExtra("nopol", strNopol);
            startActivity(laporan_klaim);
        }

        return true;
    }

    @Override
    public void onBackPressed() {

    }

    public void showDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Konfirmasi")
                .setIcon(R.drawable.ic_exit_to_app)
                .setMessage("Yakin ingin keluar ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(logout);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog ad = adb.create();
        ad.show();
    }
}
