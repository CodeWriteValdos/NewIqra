package com.rplwikrama.a7win64.newiqra.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Nopol implements Serializable {

    @SerializedName("NOMOR_POLIS")
    String nopol;

    public Nopol(String nopol) {
        this.nopol = nopol;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    @Override
    public String toString() {
        return nopol;
    }
}
