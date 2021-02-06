package com.alexsander_hendra_wijaya_1811010007.aplikasi_uas;

import com.google.gson.annotations.SerializedName;

public class TanamanModel {
    @SerializedName("nama_tanaman")
    private final String nama_tanaman;
    @SerializedName("nama_ilmiah")
    private final String nama_ilmiah;
    @SerializedName("gambar")
    private final String gambar;

    public TanamanModel(String nama_tanaman, String nama_ilmiah, String gambar) {
        this.nama_tanaman = nama_tanaman;
        this.nama_ilmiah = nama_ilmiah;
        this.gambar = gambar;
    }


    public String getNama_tanaman() {
        return nama_tanaman;
    }

    public String getNama_ilmiah() {
        return nama_ilmiah;
    }

    public String getGambar() {
        return gambar;
    }
}
