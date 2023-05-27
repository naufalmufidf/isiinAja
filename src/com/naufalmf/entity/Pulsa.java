package com.naufalmf.entity;

public class Pulsa {
    private int id_provider, harga;
    private String nama_provider;

    public Pulsa() {
    }

    public Pulsa(int id_provider, int harga, String nama_provider) {
        this.id_provider = id_provider;
        this.harga = harga;
        this.nama_provider = nama_provider;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_provider() {
        return nama_provider;
    }

    public void setNama_provider(String nama_provider) {
        this.nama_provider = nama_provider;
    }
}
