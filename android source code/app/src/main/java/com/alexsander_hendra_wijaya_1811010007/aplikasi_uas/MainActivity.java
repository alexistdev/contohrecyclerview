package com.alexsander_hendra_wijaya_1811010007.aplikasi_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity {
    private RecyclerView tanamanView;
    private TanamanAdapter tanamanAdapter;
    private List<TanamanModel> tanamanModels;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupRecyclerView();
        getData(getApplicationContext());
    }
    public void getData(Context mContext) {
        try {
            tampilLoading();
            Call<GetTanaman> call = APIService.Factory.create(mContext).dapatTanaman();
            call.enqueue(new Callback<GetTanaman>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetTanaman> call, Response<GetTanaman> response) {
                    hideLoading();
                    if(response.isSuccessful()){
                        if(response.body() != null){
                            tanamanModels = response.body().getListTanaman();
                            tanamanAdapter.replaceData(tanamanModels);
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetTanaman> call, Throwable t) {
                    if(t instanceof NoConnectivityException) {
                        hideLoading();
                        tampilPesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch (Exception e){
            hideLoading();
            e.printStackTrace();
            tampilPesan(e.getMessage());
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        tanamanAdapter = new TanamanAdapter(this,new ArrayList<>());
        tanamanView.setLayoutManager(linearLayoutManager);
        tanamanView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
        tanamanView.setAdapter(tanamanAdapter);
    }

    private void init(){
        tanamanView = findViewById(R.id.rcTanaman);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
    }

    private void tampilLoading(){
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    private void hideLoading(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    public void tampilPesan(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}