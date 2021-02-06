package com.alexsander_hendra_wijaya_1811010007.aplikasi_uas;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIService {
    //API untuk menampilkan jurusan di halaman admin
    @GET("Api/tanaman")
    Call<GetTanaman> dapatTanaman();

    class Factory{
        public static APIService create(Context mContext){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.connectTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            builder.addInterceptor(new NetworkConnectionInterceptor(mContext));

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Konfig.URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);
        }
    }
}
