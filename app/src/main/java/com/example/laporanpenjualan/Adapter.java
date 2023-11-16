package com.example.laporanpenjualan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Data> mList;
    lihatActivity context;

    public Adapter (List<Data> mList, lihatActivity context){
        this.mList = mList;
        this.context = context;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        final Data item = mList.get(position);
        holder.tvtanggal.setText("Tanggal :" +item.getTanggal());
        holder.tvpack.setText("Packing :" +item.getPacking());
        holder.tvbandrol.setText("Bandrol :" +item.getBandrol());
        holder.tvkaryawanp.setText("Karyawan Packing :" +item.getKaryawan_Packing());
        holder.tvbatang.setText("Batang :" +item.getBatang());
        holder.tvkaryawanl.setText("Karyawan Linting :" +item.getKaryawan_Linting());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtanggal, tvpack, tvbandrol, tvkaryawanp, tvbatang, tvkaryawanl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtanggal = itemView.findViewById(R.id.tanggal);
            tvpack = itemView.findViewById(R.id.pack);
            tvbandrol = itemView.findViewById(R.id.bandrol);
            tvkaryawanp = itemView.findViewById(R.id.karyawanp);
            tvbatang = itemView.findViewById(R.id.batang);
            tvkaryawanl = itemView.findViewById(R.id.karyawanl);
        }
    }
}
