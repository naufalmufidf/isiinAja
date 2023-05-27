package com.naufalmf.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.naufalmf.conMan.Connect;

public class Buyer {
    private int id_buyer;
    private String nama_buyer, jenis_kelamin, no_telp, tgl_lahir, email;
    private Login uname;

    public Buyer() {
    }

    public Buyer(int id_buyer, String nama_buyer, String jenis_kelamin, String no_telp, String tgl_lahir, String email, Login uname) {
        this.id_buyer = id_buyer;
        this.nama_buyer = nama_buyer;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
        this.tgl_lahir = tgl_lahir;
        this.email = email;
        this.uname = uname;
    }

    public int getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(int id_buyer) {
        this.id_buyer = id_buyer;
    }

    public String getNama_buyer() {
        return nama_buyer;
    }

    public void setNama_buyer(String nama_buyer) {
        this.nama_buyer = nama_buyer;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getUname() {
        return uname;
    }

    public void setUname(Login uname) {
        this.uname = uname;
    }
}
