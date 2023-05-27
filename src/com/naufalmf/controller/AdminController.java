package com.naufalmf.controller;

import com.naufalmf.conMan.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController {
    
    
    public int addDataAdmin(int id, String nama, String jenis_kelamin, String no_telp, String tgl_lahir, String email, String uname){
        int hasil = 0;
        Connect conMan = new Connect();
        Connection conn = conMan.logOn();
        String query = "INSERT INTO admin(id_admin,nama_admin,jenis_kelamin,no_telp,tgl_lahir,email,uname) values('" + id + "', '" + nama + "', '" + jenis_kelamin + "', '" + no_telp + "', '" + tgl_lahir + "', '" + email + "', '" + uname + "')";
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        conMan.logOff();
        
        return hasil;
    } 
}
