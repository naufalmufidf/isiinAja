package com.naufalmf.controller;

import com.naufalmf.conMan.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    
    
    public int addAccount(String uname, String pw, String role){
        int hasil = 0;
        Connect conMan = new Connect();
        Connection conn = conMan.logOn();
        String query = "INSERT INTO login(uname,pw,role) values('" + uname + "', '" + pw + "', '" + role + "')";
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
