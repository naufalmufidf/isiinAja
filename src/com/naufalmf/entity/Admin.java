package com.naufalmf.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.naufalmf.conMan.Connect;

public class Admin {
    private int id_admin;
    private String nama_admin, jenis_kelamin, no_telp, tgl_lahir, email;
    private Login uname;

    public Admin() {
    }

    public Admin(int id_admin, String nama_admin, String jenis_kelamin, String no_telp, String tgl_lahir, String email, Login uname) {
        this.id_admin = id_admin;
        this.nama_admin = nama_admin;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
        this.tgl_lahir = tgl_lahir;
        this.email = email;
        this.uname = uname;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNama_admin() {
        return nama_admin;
    }

    public void setNama_admin(String nama_admin) {
        this.nama_admin = nama_admin;
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
