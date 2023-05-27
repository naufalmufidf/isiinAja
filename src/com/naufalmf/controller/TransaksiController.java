package com.naufalmf.controller;

import com.naufalmf.conMan.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaksiController {
    
    public int addTransaksi(int id, String uname, int id_buyer, int id_provider, String no_telp, String pembayaran, int harga, int total){
        int hasil = 0;
        Connect conMan = new Connect();
        Connection conn = conMan.logOn();
        String query = "INSERT INTO transaksi(id_transaksi,uname,id_buyer,id_provider,no_telp,pembayaran,harga,total) values('" + id + "', '" + uname + "', '" + id_buyer + "', '" + id_provider + "', '" + no_telp + "', '" + pembayaran + "', '" + harga + "', '" + total + "')";
        
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
