package com.rplwikrama.a7win64.newiqra.response;

import java.util.List;

public class ResponseModels {
    String kode, pesan, nopol;
    List<DataModels> result;

    public List<DataModels> getResult() {
        return result;
    }

    public void setResult(List<DataModels> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }
}
