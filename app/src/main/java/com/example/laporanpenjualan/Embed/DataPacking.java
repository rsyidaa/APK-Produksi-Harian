package com.example.laporanpenjualan.Embed;

public class DataPacking {
    private String Tanggal, Packing, Bandrol, Karyawan_Packing, Total;

    public DataPacking() {

    }

    public DataPacking(String tanggal, String packing, String bandrol, String karyawan_Packing, String total) {
        Tanggal = tanggal;
        Packing = packing;
        Bandrol = bandrol;
        Karyawan_Packing = karyawan_Packing;
        Total = total;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getPacking() {
        return Packing;
    }

    public void setPacking(String packing) {
        Packing = packing;
    }

    public String getBandrol() {
        return Bandrol;
    }

    public void setBandrol(String bandrol) {
        Bandrol = bandrol;
    }

    public String getKaryawan_Packing() {
        return Karyawan_Packing;
    }

    public void setKaryawan_Packing(String karyawan_Packing) {
        Karyawan_Packing = karyawan_Packing;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
