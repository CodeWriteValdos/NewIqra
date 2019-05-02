package com.rplwikrama.a7win64.newiqra.api;

import com.rplwikrama.a7win64.newiqra.response.ResponseModels;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseModels> userLogin(
            @Field("nopol") String nopol,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseModels> userRegis(
            @Field("nopol") String nopol,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("main.php")
    Call<ResponseModels> getData(
            @Field("nopol") String nopol
    );

    @FormUrlEncoded
    @POST("riwayatNT.php")
    Call<ResponseModels> getRiwayatNT(
            @Field("nomor_polis") String nomor_polis
    );

    @FormUrlEncoded
    @POST("riwayatPK.php")
    Call<ResponseModels> getRiwayatPK(
            @Field("nopol") String nopol
    );

    @FormUrlEncoded
    @POST("laporanKlaim.php")
    Call<ResponseModels> getLaporan(
            @Field("nopol") String nopol
    );
}
