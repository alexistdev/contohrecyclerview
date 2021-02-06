package com.alexsander_hendra_wijaya_1811010007.aplikasi_uas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class TanamanAdapter extends RecyclerView.Adapter<TanamanAdapter.MyTanamanHolder> {
    public List<TanamanModel> mTanamanList;
    private final Context context;

    public TanamanAdapter(Context context,List<TanamanModel> dataTanaman) {
        this.mTanamanList = dataTanaman;
        this.context = context;
    }

    @NonNull
    @Override
    public TanamanAdapter.MyTanamanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_tanaman, parent, false);
        TanamanAdapter.MyTanamanHolder holder;
        holder = new TanamanAdapter.MyTanamanHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TanamanAdapter.MyTanamanHolder holder, int position) {
        Glide.with(context)
                .load(Konfig.IMAGES_URL+mTanamanList.get(position).getGambar())
                .apply(new RequestOptions().error(R.drawable.plant))
                .into(MyTanamanHolder.mGambar);
        holder.mNama.setText(mTanamanList.get(position).getNama_tanaman());
        holder.mIlmiah.setText(mTanamanList.get(position).getNama_ilmiah());
    }

    @Override
    public int getItemCount() {
        return mTanamanList.size();
    }

    public static class MyTanamanHolder extends RecyclerView.ViewHolder {

        private final TextView mNama,mIlmiah;
        @SuppressLint("StaticFieldLeak")
        private static ImageView mGambar;
        MyTanamanHolder(@NonNull View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.txt_nama);
            mIlmiah = itemView.findViewById(R.id.txt_ilmiah);
            mGambar = itemView.findViewById(R.id.gambar);
        }
    }

    public void replaceData(List<TanamanModel> dataTanaman) {
        this.mTanamanList = dataTanaman;
        notifyDataSetChanged();
    }
}
