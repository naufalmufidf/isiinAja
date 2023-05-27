package com.naufalmf.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.naufalmf.conMan.Connect;

public class Login {
    private String uname, pw, role;

    public Login() {
    }

    public Login(String uname, String pw, String role) {
        this.uname = uname;
        this.pw = pw;
        this.role = role;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }    
}
