package com.rplwikrama.a7win64.newiqra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.rplwikrama.a7win64.newiqra.adapter.ADRiwayatNT;
import com.rplwikrama.a7win64.newiqra.api.Api;
import com.rplwikrama.a7win64.newiqra.api.RetrofitClient;
import com.rplwikrama.a7win64.newiqra.response.DataModels;
import com.rplwikrama.a7win64.newiqra.response.ResponseModels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatNTActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataModels> item = new ArrayList<>();

    private String strNopol = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_nt);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                strNopol = null;
            } else {
                strNopol = extras.getString("nopol");
            }
        }

        recyclerView1 = findViewById(R.id.nt_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager);

        Api api = RetrofitClient.getClient().create(Api.class);
        Call<ResponseModels> call = api.getRiwayatNT(strNopol);
        call.enqueue(new Callback<ResponseModels>() {
            @Override
            public void onResponse(Call<ResponseModels> call, Response<ResponseModels> response) {
                Log.d("RETRO", response.body().toString());

                item = response.body().getResult();
                adapter = new ADRiwayatNT(RiwayatNTActivity.this, item);
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
    public void onBackPressed() {
        Intent main = new Intent(this, MainActivity.class);
        main.putExtra("nopol", strNopol);
        startActivity(main);
    }
}
