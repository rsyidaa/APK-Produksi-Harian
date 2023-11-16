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

public class AdapterPacking extends RecyclerView.Adapter<AdapterPacking.MyViewHolder> {

    List<DataPacking> plist;

    Context pcontext;

    public AdapterPacking(List<DataPacking> plist, Context pcontext){
        this.plist = plist;
        this.pcontext = pcontext;
    }

    @NonNull
    @Override
    public AdapterPacking.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_packing,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPacking.MyViewHolder holder, int position) {

        final DataPacking item = plist.get(position);
        holder.tvtanggal.setText("Tanggal :" +item.getTanggal());
        holder.tvpack.setText("Packing :" +item.getPacking());
        holder.tvbandrol.setText("Bandrol :" +item.getBandrol());
        holder.tvkaryawanp.setText("Karyawan Packing :" +item.getKaryawan_Packing());
        holder.tvtotal.setText("Total :" +item.getTotal());
    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvtanggal, tvpack, tvbandrol, tvkaryawanp, tvtotal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtanggal = itemView.findViewById(R.id.tanggal);
            tvpack = itemView.findViewById(R.id.pack);
            tvbandrol = itemView.findViewById(R.id.bandrol);
            tvkaryawanp = itemView.findViewById(R.id.karyawanp);
            tvtotal = itemView.findViewById(R.id.ptotal);
        }
    }
}
