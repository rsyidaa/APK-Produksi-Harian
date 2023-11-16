package com.example.laporanpenjualan.Embed;

public class DataLinting {

    private String Tanggal, Batang, Karyawan_Linting;

    public DataLinting() {

    }

    public DataLinting(String tanggal, String batang, String karyawan_Linting) {
        Tanggal = tanggal;
        Batang = batang;
        Karyawan_Linting = karyawan_Linting;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getBatang() {
        return Batang;
    }

    public void setBatang(String batang) {
        Batang = batang;
    }

    public String getKaryawan_Linting() {
        return Karyawan_Linting;
    }

    public void setKaryawan_Linting(String karyawan_Linting) {
        Karyawan_Linting = karyawan_Linting;
    }
}

