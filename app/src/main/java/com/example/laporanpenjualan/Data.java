package com.example.laporanpenjualan;

public class Data {
    private String Tanggal, Packing, Bandrol, Karyawan_Packing, Batang, Karyawan_Linting;

    public Data() {

    }

    public Data(String tanggal, String packing, String bandrol, String karyawan_Packing, String batang, String karyawan_Linting) {
        Tanggal = tanggal;
        Packing = packing;
        Bandrol = bandrol;
        Karyawan_Packing = karyawan_Packing;
        Batang = batang;
        Karyawan_Linting = karyawan_Linting;
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
