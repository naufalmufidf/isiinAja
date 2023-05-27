package com.naufalmf.controller;

import com.naufalmf.conMan.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuyerController {
    
    public int addDataBuyer(int id, String nama, String jenis_kelamin, String no_telp, String tgl_lahir, String email, String uname){
        int hasil = 0;
        Connect conMan = new Connect();
        Connection conn = conMan.logOn();
        String query = "INSERT INTO buyer(id_buyer,nama_buyer,jenis_kelamin,no_telp,tgl_lahir,email,uname) values('" + id + "', '" + nama + "', '" + jenis_kelamin + "', '" + no_telp + "', '" + tgl_lahir + "', '" + email + "', '" + uname + "')";
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
    
    public int delBuyer(String nama_buyer){
        int hasil = 0;
        String query = "delete from buyer where nama_buyer = '" + nama_buyer + "'";
        Connect conMan = new Connect();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        
        return hasil;
    }
    
    public int updateBuyer(String username, String nama, String gender, String noHp, String tglLahir, String email){
        int hasil = 0;
        String query = "update buyer set uname ='" + username + "', nama_buyer = '" + 
                nama + "', jenis_kelamin = '" + gender + "', no_telp = '" + noHp + "', tgl_Lahir = '" + tglLahir + "', email = '" + email + "' where uname = '" + username + "'";
        Connect conMan = new Connect();
        Connection conn = conMan.logOn();
        
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
