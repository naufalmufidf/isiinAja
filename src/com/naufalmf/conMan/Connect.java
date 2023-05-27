package com.naufalmf.conMan;

import java.sql.*;

public class Connect {
    private Connection con;
    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/isiinajav2";  // myDB --> nama database 
    private String username = "root";       // user name DMBS
    private String password = "";    // pswd DMBS
    public Statement stm;

    public Connection logOn(){
        try {
            //Load JDBC Driver
            Class.forName(JDBC_DRIVER).newInstance();
            //Buat object Connection
            con = DriverManager.getConnection( url, username, password );
            stm = con.createStatement();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    public void logOff(){
        try {
            //Tutup Koneksi
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

    
