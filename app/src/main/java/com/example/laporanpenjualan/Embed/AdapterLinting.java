package com.example.laporanpenjualan.Embed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laporanpenjualan.R;

import java.util.List;

public class AdapterLinting extends RecyclerView.Adapter<AdapterLinting.MyViewHolder> {

    List<DataLinting> linlist;
    Context lincontext;

    public AdapterLinting (List<DataLinting> linlist, Context lincontext) {
        this.linlist = linlist;
        this.lincontext = lincontext;
    }
    @NonNull
    @Override
    public AdapterLinting.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_linting,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLinting.MyViewHolder holder, int position) {

        final DataLinting item = linlist.get(position);
        holder.tvtanggal.setText("Tanggal :" +item.getTanggal());
        holder.tvbatang.setText("Batang :" +item.getBatang());
        holder.tvkaryawanl.setText("Karyawan Linting :" +item.getKaryawan_Linting());
    }

    @Override
    public int getItemCount() {
        return linlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvtanggal, tvbatang, tvkaryawanl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtanggal = itemView.findViewById(R.id.tanggal);
            tvbatang = itemView.findViewById(R.id.batang);
            tvkaryawanl = itemView.findViewById(R.id.karyawanl);
        }
    }
}
