package com.rplwikrama.a7win64.newiqra;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rplwikrama.a7win64.newiqra.api.Api;
import com.rplwikrama.a7win64.newiqra.api.RetrofitClient;
import com.rplwikrama.a7win64.newiqra.response.ResponseModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText txtNopol, txtPass;
    private Button btnCek, btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Api api = RetrofitClient.getClient().create(Api.class);
        txtNopol = findViewById(R.id.txtPolis);
        txtPass = findViewById(R.id.txtPass);
        btnCek = findViewById(R.id.btnCek);
        btnRegis = findViewById(R.id.btnRegis);

        final Intent get = getIntent();
        if(get != null) {
            final String data = get.getStringExtra("nopol");
            txtNopol.setText(data);
        }

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String strNopol = txtNopol.getText().toString();
                String strPass = txtPass.getText().toString();


                if(strNopol.length() == 0) {
                    txtNopol.setError("Harap isi Nomor Polis !");
                } else if(strPass.length() == 0) {
                    txtPass.setError("Harap isi Password !");
                } else {
                    Call<ResponseModels> call = api.userLogin(strNopol, strPass);
                    call.enqueue(new Callback<ResponseModels>() {
                        @Override
                        public void onResponse(Call<ResponseModels> call, Response<ResponseModels> response) {
                            Log.d("RETRO", response.body().toString());
                            String kode = response.body().getKode();

                            if (kode.equals("1")) {
                                Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
                                Intent main = new Intent(LoginActivity.this, MainActivity.class);
                                main.putExtra("nopol", strNopol);
                                startActivity(main);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
                                adRegis();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseModels> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regis = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(regis);
            }
        });
    }

    private void adRegis() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Password Salah !")
                .setMessage("Belum Punya Password ?")
                .setCancelable(false)
                .setIcon(R.drawable.question)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent regis = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(regis);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }

    @Override
    public void onBackPressed() {

    }
}
