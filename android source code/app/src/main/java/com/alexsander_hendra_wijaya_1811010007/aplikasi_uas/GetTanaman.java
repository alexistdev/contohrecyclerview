package com.alexsander_hendra_wijaya_1811010007.aplikasi_uas;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTanaman {
    @SerializedName("result")
    List<TanamanModel> listTanaman;

    public List<TanamanModel> getListTanaman() {
        return listTanaman;
    }
}
