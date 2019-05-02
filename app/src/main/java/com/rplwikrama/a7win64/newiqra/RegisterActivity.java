package com.rplwikrama.a7win64.newiqra;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {
    private EditText txtNopol, txtPass;
    private Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtNopol = findViewById(R.id.txtPolis);
        txtPass = findViewById(R.id.txtPass);
        btnRegis = findViewById(R.id.btnRegis);
        final Api api = RetrofitClient.getClient().create(Api.class);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String strNopol = txtNopol.getText().toString();
                String strPass = txtPass.getText().toString();

                if(strNopol.length() == 0) {
                    txtNopol.setError("Harap isi Nomor Polis !");
                } else if(strPass.length() == 0) {
                    txtPass.setError("Harap isi Password !");
                } else {
                    Call<ResponseModels> call = api.userRegis(strNopol, strPass);
                    call.enqueue(new Callback<ResponseModels>() {
                        @Override
                        public void onResponse(Call<ResponseModels> call, Response<ResponseModels> response) {
                            Log.d("RETRO", response.body().toString());
                            String kode = response.body().getKode();

                            if (kode.equals("1")) {
                                Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                                login.putExtra("nopol", strNopol);
                                startActivity(login);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
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
    }
}
