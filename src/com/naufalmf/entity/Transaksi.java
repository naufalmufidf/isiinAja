package com.naufalmf.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.naufalmf.conMan.Connect;

public class Transaksi {
    private int id_transaksi;
    private Login uname;
    private Buyer idBuyer;
    private Pulsa idPulsa;
    private String no_telp, pembayaran;
    private int harga, total;

    public Transaksi() {
    }

    public Transaksi(int id_transaksi, Login uname, Buyer idBuyer, Pulsa idPulsa, String no_telp, String pembayaran, int harga, int total) {
        this.id_transaksi = id_transaksi;
        this.uname = uname;
        this.idBuyer = idBuyer;
        this.idPulsa = idPulsa;
        this.no_telp = no_telp;
        this.pembayaran = pembayaran;
        this.harga = harga;
        this.total = total;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Login getUname() {
        return uname;
    }

    public void setUname(Login uname) {
        this.uname = uname;
    }

    public Buyer getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(Buyer idBuyer) {
        this.idBuyer = idBuyer;
    }

    public Pulsa getIdPulsa() {
        return idPulsa;
    }

    public void setIdPulsa(Pulsa idPulsa) {
        this.idPulsa = idPulsa;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
