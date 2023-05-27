/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.naufalmf.view;

import java.sql.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.naufalmf.conMan.Connect;
import com.naufalmf.controller.AdminController;
import com.naufalmf.controller.BuyerController;
import com.naufalmf.controller.LoginController;
import com.naufalmf.controller.TransaksiController;
import com.naufalmf.entity.Admin;
import com.naufalmf.entity.Buyer;
import com.naufalmf.entity.Login;
import com.naufalmf.entity.Transaksi;


/**
 *
 * @author lenovo
 */
public class Main extends javax.swing.JFrame {
    
    Connection con;
    Statement stm;
    ResultSet rs;
    String SQL;
    
    Random rdm = new Random();
    
    int id_transaksi;
    String uname;
    int id_buyer;
    int id_provider;
    String no_telp;
    String pembayaran;
    int harga;
    int total;

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(int id_buyer) {
        this.id_buyer = id_buyer;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
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
    
    
    

    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        getDataAccount();
        getDataTransaksi();
        
        Connect conn = new Connect();
        conn.logOn();
        con = conn.logOn();
        stm = conn.stm;
        
        
        cl = (CardLayout) Main.getLayout();

        
        //login card
        exitBtn.setBackground(new Color(0, 0, 0, 0));
        loginBtn.setBackground(new Color(0, 0, 0, 0));
        regBtn.setBackground(new Color(0, 0, 0, 0));
        
        //admin card
        backAdminBtn.setBackground(new Color(0, 0, 0, 0));
        addAdminBtn.setBackground(new Color(0, 0, 0, 0));
        dbBtn.setBackground(new Color(0, 0, 0, 0));
        edtBtn.setBackground(new Color(0, 0, 0, 0));
        
        //regAdm card
        pwRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        pwRegAdmTxt2.setBackground(new Color(0, 0, 0, 0));
        unameRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        nextRegAdmBtn.setBackground(new Color(0, 0, 0, 0));
        backRegAdmBtn.setBackground(new Color(0, 0, 0, 0));
        
        //regAdm2 card
        noHpRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        namaRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        genderRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        emailRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        tglRegAdmTxt.setBackground(new Color(0, 0, 0, 0));
        backRegAdmBtn2.setBackground(new Color(0, 0, 0, 0));
        contRegAdmBtn.setBackground(new Color(0, 0, 0, 0));
        
        //reg3 card
        nextRegBtn2.setBackground(new Color(0, 0, 0, 0));
        
        //user card
        backUserBtn.setBackground(new Color(0, 0, 0, 0));
        namaUsrTxt.setBackground(new Color(0, 0, 0, 0));
        unameUsrTxt.setBackground(new Color(0, 0, 0, 0));
        genderUsrTxt.setBackground(new Color(0, 0, 0, 0));
        noHpUsrTxt.setBackground(new Color(0, 0, 0, 0));
        tglUsrTxt.setBackground(new Color(0, 0, 0, 0));
        emailUsrTxt.setBackground(new Color(0, 0, 0, 0));
        edtUsrBtn.setBackground(new Color(0, 0, 0, 0));
        delBtn.setBackground(new Color(0, 0, 0, 0));
        
        //reg1 card
        pwRegTxt1.setBackground(new Color(0, 0, 0, 0));
        pwRegTxt2.setBackground(new Color(0, 0, 0, 0));
        unameRegTxt.setBackground(new Color(0, 0, 0, 0));
        nextRegBtn.setBackground(new Color(0, 0, 0, 0));
        signRegBtn.setBackground(new Color(0, 0, 0, 0));
        
        //reg2 card
        noHpRegTxt.setBackground(new Color(0, 0, 0, 0));
        namaRegTxt.setBackground(new Color(0, 0, 0, 0));
        genderRegTxt.setBackground(new Color(0, 0, 0, 0));
        emailRegTxt.setBackground(new Color(0, 0, 0, 0));
        tglRegTxt.setBackground(new Color(0, 0, 0, 0));
        
        backRegBtn.setBackground(new Color(0, 0, 0, 0));
        contRegBtn.setBackground(new Color(0, 0, 0, 0));
        
        //reg3 card
        nextReg2Btn.setBackground(new Color(0, 0, 0, 0));
        
        //provider card
        backProvBtn.setBackground(new Color(0, 0, 0, 0));
        xlBtn.setBackground(new Color(0, 0, 0, 0));
        indoBtn.setBackground(new Color(0, 0, 0, 0));
        telkomBtn.setBackground(new Color(0, 0, 0, 0));
        triBtn.setBackground(new Color(0, 0, 0, 0));
        
        //transaksi card
        backTransBtn.setBackground(new Color(0, 0, 0, 0));
        noHpTransTxt.setBackground(new Color(0, 0, 0, 0));
        nomCbb.setBackground(new Color(0, 0, 0, 0));
        pembCbb.setBackground(new Color(0, 0, 0, 0));
        confirmBtn.setBackground(new Color(0, 0, 0, 0));
        payBtn.setBackground(new Color(0, 0, 0, 0));
        
        //transaksi2 card
        doneTransBtn.setBackground(new Color(0, 0, 0, 0));
        menuTransBtn.setBackground(new Color(0, 0, 0, 0));
        
        //db card
        backDbBtn.setBackground(new Color(0, 0, 0, 0));
    }
    
    private CardLayout cl;
    private String pv;
    
    
    
    public DefaultTableModel model;
    public DefaultTableModel trans;
    Connect conMan = new Connect();
    Connection conn = conMan.logOn();
    
    
    public void getDataAccount( ){
         model = new DefaultTableModel();
         model.addColumn("ID Buyer");
         model.addColumn("Username");
         model.addColumn("Nama");
         model.addColumn("Jenis Kelamin");
         model.addColumn("No. Telp");
         model.addColumn("Tanggal Lahir");
         model.addColumn("Email");
         userTbl.setModel(model);
        try{
           java.sql.Statement stm = conn.createStatement();
           SQL = "Select * from buyer";
           java.sql.ResultSet res = stm.executeQuery(SQL);

           while(res.next ()){
               model.addRow(new Object[] {
                   res.getString("id_buyer"),
                   res.getString("uname"),
                   res.getString("nama_buyer"),
                   res.getString("jenis_kelamin"),
                   res.getString("no_telp"),
                   res.getString("tgl_Lahir"),
                   res.getString("email")}
               );  
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
    }
    
    public void getDataTransaksi( ){
         trans = new DefaultTableModel();
         trans.addColumn("ID Transaksi");
         trans.addColumn("Username");
         trans.addColumn("ID Buyer");
         trans.addColumn("ID Provider");
         trans.addColumn("No. Telp");
         trans.addColumn("Pembayaran");
         trans.addColumn("Harga");
         trans.addColumn("Total");
         transTbl.setModel(trans);
        try{
           java.sql.Statement stm = conn.createStatement();
           SQL = "Select * from transaksi";
           java.sql.ResultSet res = stm.executeQuery(SQL);

           while(res.next ()){
               trans.addRow(new Object[] {
                   res.getString("id_transaksi"),
                   res.getString("uname"),
                   res.getString("id_buyer"),
                   res.getString("id_provider"),
                   res.getString("no_telp"),
                   res.getString("pembayaran"),
                   res.getString("harga"),
                   res.getString("total")}
               );  
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
    }
    
    
    
    public void trans(String prov){
        struk.setText("");
        struk.append("                     ---isiinAja---                   \n");
        struk.append("              Isi pulsa dimana aja kapan aja          \n");
        struk.append("======================================================\n");
        
        
        String x = "";
        String x1 = "--- Pilih nominal ---";
        String x2 = "--- Pilih cara pembayaran---";
        
        if (noHpTransTxt.getText().equals(x) || nomCbb.getSelectedItem().equals(x1) || pembCbb.getSelectedItem().equals(x2)) {
            JOptionPane.showMessageDialog(null, "Isi form dengan benar!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (!x.equals(noHpTransTxt) && !x1.equals(nomCbb.getSelectedItem()) && !x2.equals(pembCbb.getSelectedItem())) {
            
            struk.setText("");
            struk.append("                     ---isiinAja---                   \n");
            struk.append("              Isi pulsa dimana aja kapan aja          \n");
            struk.append("======================================================\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("Struk Pembayaran Pulsa\n");
            struk.append("\n");
            struk.append("Provider      : " + prov + "\n");
            struk.append("Nomor HP      : " + noHpTransTxt.getText() + "\n");
            
            int harga = 0;
            int way = 0;
            int idProv;
            String xl = "Xl";
            String indosat = "Indosat";
            String Telkomsel = "Telkomsel";
            String tri = "3";
            
            //idProv struk
            if (nomCbb.getSelectedIndex() == 1 && pv.equals(xl)) {
                idProv = 62001;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 2 && pv.equals(xl)) {
                idProv = 62002;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 3 && pv.equals(xl)) {
                idProv = 62003;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 4 && pv.equals(xl)) {
                idProv = 62004;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 5 && pv.equals(xl)) {
                idProv = 62005;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 6 && pv.equals(xl)) {
                idProv = 62006;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 7 && pv.equals(xl)) {
                idProv = 62007;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 1 && pv.equals(indosat)) {
                idProv = 62008;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 2 && pv.equals(indosat)) {
                idProv = 62009;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 3 && pv.equals(indosat)) {
                idProv = 62010;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 4 && pv.equals(indosat)) {
                idProv = 62011;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 5 && pv.equals(indosat)) {
                idProv = 62012;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 6 && pv.equals(indosat)) {
                idProv = 62013;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 7 && pv.equals(indosat)) {
                idProv = 62014;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 1 && pv.equals(indosat)) {
                idProv = 62015;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 2 && pv.equals(indosat)) {
                idProv = 62016;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 3 && pv.equals(indosat)) {
                idProv = 62017;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 4 && pv.equals(indosat)) {
                idProv = 62018;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 5 && pv.equals(indosat)) {
                idProv = 62019;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 6 && pv.equals(indosat)) {
                idProv = 62020;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 7 && pv.equals(indosat)) {
                idProv = 62021;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 1 && pv.equals(tri)) {
                idProv = 62022;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 2 && pv.equals(tri)) {
                idProv = 62023;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 3 && pv.equals(tri)) {
                idProv = 62024;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 4 && pv.equals(tri)) {
                idProv = 62025;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 5 && pv.equals(tri)) {
                idProv = 62026;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 6 && pv.equals(tri)) {
                idProv = 62027;
                setId_provider(idProv);
            }
            else if (nomCbb.getSelectedIndex() == 7 && pv.equals(tri)) {
                idProv = 62028;
                setId_provider(idProv);
            }
            
            
            //harga struk
            if (nomCbb.getSelectedIndex() == 1) {
                struk.append("Nominal pulsa : Rp5.000\n");
                harga+= 5000;
                setHarga(harga);
            }
            else if (nomCbb.getSelectedIndex() == 2) {
                struk.append("Nominal pulsa : Rp10.000\n");
                harga+= 10000;
                setHarga(harga);
            }
            else if (nomCbb.getSelectedIndex() == 3) {
                struk.append("Nominal pulsa : Rp15.000\n");
                harga+= 15000;
                setHarga(harga);
            }
            else if (nomCbb.getSelectedIndex() == 4) {
                struk.append("Nominal pulsa : Rp25.000\n");
                harga+= 25000;
                setHarga(harga);
            }
            else if (nomCbb.getSelectedIndex() == 5) {
                struk.append("Nominal pulsa : Rp30.000\n");
                harga+= 30000;
                setHarga(harga);
            }
            else if (nomCbb.getSelectedIndex() == 6) {
                struk.append("Nominal pulsa : Rp50.000\n");
                harga+= 50000;
                setHarga(harga);
            }
            else if (nomCbb.getSelectedIndex() == 7) {
                struk.append("Nominal pulsa : Rp100.000\n");
                harga+= 100000;
                setHarga(harga);
            }
            
            //pembayaran struk
            if (pembCbb.getSelectedIndex() == 1) {
                struk.append("Pembayaran    : OPO\n");
                way+= 1000;
                setPembayaran("OPO");
            }
            else if (pembCbb.getSelectedIndex() == 2) {
                struk.append("Pembayaran    : Fulus\n");
                way+= 1000;
                setPembayaran("Fulus");
            }
            else if (pembCbb.getSelectedIndex() == 3) {
                struk.append("Pembayaran    : Asiapmart\n");
                way+= 2500;
                setPembayaran("Asiapmart");
            }
            
            int total = harga+way;
            setTotal(total);
            
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("------------------------------------------------------");
            struk.append("\n");
            struk.append("\n");
            
            
            
            if (nomCbb.getSelectedIndex() == 0) {
                struk.append("                           Subtotal         :   " + String.valueOf(harga) + "\n");
            }
            else if (nomCbb.getSelectedIndex() == 1 || nomCbb.getSelectedIndex() == 2 || nomCbb.getSelectedIndex() == 3 || nomCbb.getSelectedIndex() == 4 || nomCbb.getSelectedIndex() == 5 || nomCbb.getSelectedIndex() == 6) {
                struk.append("                           Subtotal         :  " + String.valueOf(harga) + "\n");
            }
            else if (nomCbb.getSelectedIndex() == 7) {
                struk.append("                           Subtotal         : " + String.valueOf(harga) + "\n");
            }
            
            struk.append("                           Biaya Penanganan :   " + String.valueOf(way) + "\n");
            struk.append("                              ------------------------\n");
            
            
            
            if (nomCbb.getSelectedIndex() == 0) {
                struk.append("                           Total            :   " + String.valueOf(total) + "\n");
            }
            else if (nomCbb.getSelectedIndex() == 1 || nomCbb.getSelectedIndex() == 2 || nomCbb.getSelectedIndex() == 3 || nomCbb.getSelectedIndex() == 4 || nomCbb.getSelectedIndex() == 5 || nomCbb.getSelectedIndex() == 6) {
                struk.append("                           Total            :  " + String.valueOf(total) + "\n");
            }
            else if (nomCbb.getSelectedIndex() == 7) {
                struk.append("                           Total            : " + String.valueOf(total) + "\n");
            }
            
            
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("\n");
            struk.append("======================================================\n");
            struk.append("              THANK YOU FOR TRUSTING US               \n");
            struk.append("                  www.isiinAja.ngok                   \n");
            struk.append("                     @palpedpad                       \n");
            struk.append("======================================================");
            
            JOptionPane.showMessageDialog(null, "Mohon lakukan pengecekan sebelum mengklik bayar agar tidak terjadi kesalahan dalam transaksi.", "Notice", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    //close window
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        Login = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        chkBox = new javax.swing.JCheckBox();
        unameTxt = new javax.swing.JTextField();
        pwTxt = new javax.swing.JPasswordField();
        regBtn = new javax.swing.JButton();
        LoginBg = new javax.swing.JLabel();
        Admin = new javax.swing.JPanel();
        dbBtn = new javax.swing.JButton();
        addAdminBtn = new javax.swing.JButton();
        backAdminBtn = new javax.swing.JButton();
        haiTxt1 = new javax.swing.JLabel();
        edtBtn = new javax.swing.JButton();
        AdminBg1 = new javax.swing.JLabel();
        RegisterAdmin = new javax.swing.JPanel();
        pwRegAdmTxt2 = new javax.swing.JTextField();
        unameRegAdmTxt = new javax.swing.JTextField();
        pwRegAdmTxt = new javax.swing.JTextField();
        nextRegAdmBtn = new javax.swing.JButton();
        backRegAdmBtn = new javax.swing.JButton();
        RegisterBg4 = new javax.swing.JLabel();
        RegisterAdmin2 = new javax.swing.JPanel();
        noHpRegAdmTxt = new javax.swing.JTextField();
        namaRegAdmTxt = new javax.swing.JTextField();
        genderRegAdmTxt = new javax.swing.JTextField();
        emailRegAdmTxt = new javax.swing.JTextField();
        tglRegAdmTxt = new javax.swing.JTextField();
        backRegAdmBtn2 = new javax.swing.JButton();
        contRegAdmBtn = new javax.swing.JButton();
        RegisterBg5 = new javax.swing.JLabel();
        RegisterAdmin3 = new javax.swing.JPanel();
        nextRegBtn2 = new javax.swing.JButton();
        RegisterBg6 = new javax.swing.JLabel();
        User = new javax.swing.JPanel();
        backUserBtn = new javax.swing.JButton();
        edtUsrBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        namaUsrTxt = new javax.swing.JTextField();
        genderUsrTxt = new javax.swing.JTextField();
        noHpUsrTxt = new javax.swing.JTextField();
        tglUsrTxt = new javax.swing.JTextField();
        emailUsrTxt = new javax.swing.JTextField();
        unameUsrTxt = new javax.swing.JTextField();
        delBtn = new javax.swing.JButton();
        AdminBg = new javax.swing.JLabel();
        Database = new javax.swing.JPanel();
        backDbBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        transTbl = new javax.swing.JTable();
        AdminBg2 = new javax.swing.JLabel();
        Register1 = new javax.swing.JPanel();
        pwRegTxt2 = new javax.swing.JTextField();
        unameRegTxt = new javax.swing.JTextField();
        pwRegTxt1 = new javax.swing.JTextField();
        nextRegBtn = new javax.swing.JButton();
        signRegBtn = new javax.swing.JButton();
        RegisterBg1 = new javax.swing.JLabel();
        Register2 = new javax.swing.JPanel();
        noHpRegTxt = new javax.swing.JTextField();
        namaRegTxt = new javax.swing.JTextField();
        genderRegTxt = new javax.swing.JTextField();
        emailRegTxt = new javax.swing.JTextField();
        tglRegTxt = new javax.swing.JTextField();
        backRegBtn = new javax.swing.JButton();
        contRegBtn = new javax.swing.JButton();
        RegisterBg2 = new javax.swing.JLabel();
        Register3 = new javax.swing.JPanel();
        nextReg2Btn = new javax.swing.JButton();
        RegisterBg3 = new javax.swing.JLabel();
        Provider = new javax.swing.JPanel();
        xlBtn = new javax.swing.JButton();
        indoBtn = new javax.swing.JButton();
        telkomBtn = new javax.swing.JButton();
        triBtn = new javax.swing.JButton();
        backProvBtn = new javax.swing.JButton();
        ProviderBg = new javax.swing.JLabel();
        Transaksi = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        noHpTransTxt = new javax.swing.JTextField();
        pembCbb = new javax.swing.JComboBox<>();
        nomCbb = new javax.swing.JComboBox<>();
        backTransBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        struk = new javax.swing.JTextArea();
        TransaksiBg = new javax.swing.JLabel();
        Transaksi2 = new javax.swing.JPanel();
        doneTransBtn = new javax.swing.JButton();
        menuTransBtn = new javax.swing.JButton();
        Transaksi2Bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main.setLayout(new java.awt.CardLayout());

        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBorder(null);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        Login.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 60, 180, 80));

        loginBtn.setBorder(null);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        Login.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 730, 250, 90));

        chkBox.setFont(new java.awt.Font("Tw Cen MT", 0, 22)); // NOI18N
        chkBox.setForeground(new java.awt.Color(255, 255, 255));
        chkBox.setText("  Show Password");
        chkBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxActionPerformed(evt);
            }
        });
        Login.add(chkBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 630, -1, -1));

        unameTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        unameTxt.setBorder(null);
        Login.add(unameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 390, 70));

        pwTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        pwTxt.setBorder(null);
        Login.add(pwTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 612, 390, 70));

        regBtn.setBorder(null);
        regBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regBtnActionPerformed(evt);
            }
        });
        Login.add(regBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 850, 80, 30));

        LoginBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/bgtes.png"))); // NOI18N
        Login.add(LoginBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Login, "Login");

        Admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dbBtn.setBorder(null);
        dbBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbBtnActionPerformed(evt);
            }
        });
        Admin.add(dbBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, 200, 210));

        addAdminBtn.setBorder(null);
        addAdminBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminBtnActionPerformed(evt);
            }
        });
        Admin.add(addAdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 210, 210));

        backAdminBtn.setBorder(null);
        backAdminBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backAdminBtnActionPerformed(evt);
            }
        });
        Admin.add(backAdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 50));

        haiTxt1.setFont(new java.awt.Font("HelveticaNeueLT Std Med", 0, 48)); // NOI18N
        haiTxt1.setForeground(new java.awt.Color(255, 255, 255));
        haiTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        haiTxt1.setText("Welcome back, admin!");
        Admin.add(haiTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 730, 90));

        edtBtn.setBorder(null);
        edtBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtBtnActionPerformed(evt);
            }
        });
        Admin.add(edtBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 190, 210));

        AdminBg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/admin.png"))); // NOI18N
        Admin.add(AdminBg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Admin, "Admin");

        RegisterAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pwRegAdmTxt2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        pwRegAdmTxt2.setBorder(null);
        pwRegAdmTxt2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin.add(pwRegAdmTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 290, 50));

        unameRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        unameRegAdmTxt.setBorder(null);
        unameRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin.add(unameRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 290, 50));

        pwRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        pwRegAdmTxt.setBorder(null);
        pwRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin.add(pwRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 290, 50));

        nextRegAdmBtn.setBorder(null);
        nextRegAdmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextRegAdmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextRegAdmBtnActionPerformed(evt);
            }
        });
        RegisterAdmin.add(nextRegAdmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 390, 70));

        backRegAdmBtn.setBorder(null);
        backRegAdmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backRegAdmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRegAdmBtnActionPerformed(evt);
            }
        });
        RegisterAdmin.add(backRegAdmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 50, 40));

        RegisterBg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/regAdm1.png"))); // NOI18N
        RegisterAdmin.add(RegisterBg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(RegisterAdmin, "RegisterAdmin");

        RegisterAdmin2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noHpRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        noHpRegAdmTxt.setBorder(null);
        noHpRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin2.add(noHpRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 290, 50));

        namaRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        namaRegAdmTxt.setBorder(null);
        namaRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin2.add(namaRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 290, 50));

        genderRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        genderRegAdmTxt.setBorder(null);
        genderRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin2.add(genderRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 290, 50));

        emailRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        emailRegAdmTxt.setBorder(null);
        emailRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailRegAdmTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRegAdmTxtActionPerformed(evt);
            }
        });
        RegisterAdmin2.add(emailRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 740, 290, 50));

        tglRegAdmTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        tglRegAdmTxt.setBorder(null);
        tglRegAdmTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegisterAdmin2.add(tglRegAdmTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 630, 290, 50));

        backRegAdmBtn2.setBorder(null);
        backRegAdmBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backRegAdmBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRegAdmBtn2ActionPerformed(evt);
            }
        });
        RegisterAdmin2.add(backRegAdmBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 40, 40));

        contRegAdmBtn.setBorder(null);
        contRegAdmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contRegAdmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contRegAdmBtnActionPerformed(evt);
            }
        });
        RegisterAdmin2.add(contRegAdmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 820, 390, 70));

        RegisterBg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/regAdm2.png"))); // NOI18N
        RegisterAdmin2.add(RegisterBg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(RegisterAdmin2, "RegisterAdmin2");

        RegisterAdmin3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nextRegBtn2.setBorder(null);
        nextRegBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextRegBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextRegBtn2ActionPerformed(evt);
            }
        });
        RegisterAdmin3.add(nextRegBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 260, 100));

        RegisterBg6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/RegBg3.png"))); // NOI18N
        RegisterAdmin3.add(RegisterBg6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(RegisterAdmin3, "RegisterAdmin3");

        User.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backUserBtn.setBorder(null);
        backUserBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backUserBtnActionPerformed(evt);
            }
        });
        User.add(backUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 50));

        edtUsrBtn.setBorder(null);
        edtUsrBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edtUsrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtUsrBtnActionPerformed(evt);
            }
        });
        User.add(edtUsrBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 810, 190, 80));

        userTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(userTbl);

        User.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 760, 480));

        namaUsrTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        namaUsrTxt.setBorder(null);
        namaUsrTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        User.add(namaUsrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 380, 50));

        genderUsrTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        genderUsrTxt.setBorder(null);
        genderUsrTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        genderUsrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderUsrTxtActionPerformed(evt);
            }
        });
        User.add(genderUsrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 380, 50));

        noHpUsrTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        noHpUsrTxt.setBorder(null);
        noHpUsrTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        User.add(noHpUsrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 380, 50));

        tglUsrTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        tglUsrTxt.setBorder(null);
        tglUsrTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        User.add(tglUsrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 380, 50));

        emailUsrTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        emailUsrTxt.setBorder(null);
        emailUsrTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        User.add(emailUsrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 740, 380, 50));

        unameUsrTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        unameUsrTxt.setBorder(null);
        unameUsrTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        User.add(unameUsrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 380, 50));

        delBtn.setBorder(null);
        delBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });
        User.add(delBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 810, 190, 80));

        AdminBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/user.png"))); // NOI18N
        User.add(AdminBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(User, "User");

        Database.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backDbBtn.setBorder(null);
        backDbBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backDbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backDbBtnActionPerformed(evt);
            }
        });
        Database.add(backDbBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 50));

        transTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        transTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transTblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(transTbl);

        Database.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 1440, 250));

        AdminBg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/db.png"))); // NOI18N
        Database.add(AdminBg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Database, "Database");

        Register1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pwRegTxt2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        pwRegTxt2.setBorder(null);
        pwRegTxt2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register1.add(pwRegTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 290, 50));

        unameRegTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        unameRegTxt.setBorder(null);
        unameRegTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register1.add(unameRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 290, 50));

        pwRegTxt1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        pwRegTxt1.setBorder(null);
        pwRegTxt1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register1.add(pwRegTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 290, 50));

        nextRegBtn.setBorder(null);
        nextRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextRegBtnActionPerformed(evt);
            }
        });
        Register1.add(nextRegBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 390, 70));

        signRegBtn.setBorder(null);
        signRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signRegBtnActionPerformed(evt);
            }
        });
        Register1.add(signRegBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 740, 70, 30));

        RegisterBg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/RegBg1.png"))); // NOI18N
        Register1.add(RegisterBg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Register1, "Register1");

        Register2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noHpRegTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        noHpRegTxt.setBorder(null);
        noHpRegTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register2.add(noHpRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 290, 50));

        namaRegTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        namaRegTxt.setBorder(null);
        namaRegTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register2.add(namaRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 290, 50));

        genderRegTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        genderRegTxt.setBorder(null);
        genderRegTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register2.add(genderRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 290, 50));

        emailRegTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        emailRegTxt.setBorder(null);
        emailRegTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailRegTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRegTxtActionPerformed(evt);
            }
        });
        Register2.add(emailRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 740, 290, 50));

        tglRegTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        tglRegTxt.setBorder(null);
        tglRegTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Register2.add(tglRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 630, 290, 50));

        backRegBtn.setBorder(null);
        backRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRegBtnActionPerformed(evt);
            }
        });
        Register2.add(backRegBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 40, 40));

        contRegBtn.setBorder(null);
        contRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contRegBtnActionPerformed(evt);
            }
        });
        Register2.add(contRegBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 820, 390, 70));

        RegisterBg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/RegBg2.png"))); // NOI18N
        Register2.add(RegisterBg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Register2, "Register2");

        Register3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nextReg2Btn.setBorder(null);
        nextReg2Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextReg2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextReg2BtnActionPerformed(evt);
            }
        });
        Register3.add(nextReg2Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 260, 100));

        RegisterBg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/RegBg3.png"))); // NOI18N
        Register3.add(RegisterBg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Register3, "Register3");

        Provider.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xlBtn.setBorder(null);
        xlBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xlBtnActionPerformed(evt);
            }
        });
        Provider.add(xlBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 280, 260));

        indoBtn.setBorder(null);
        indoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        indoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indoBtnActionPerformed(evt);
            }
        });
        Provider.add(indoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 290, 260));

        telkomBtn.setBorder(null);
        telkomBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        telkomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telkomBtnActionPerformed(evt);
            }
        });
        Provider.add(telkomBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 280, 260));

        triBtn.setBorder(null);
        triBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        triBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triBtnActionPerformed(evt);
            }
        });
        Provider.add(triBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 320, 290, 260));

        backProvBtn.setBorder(null);
        backProvBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backProvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backProvBtnActionPerformed(evt);
            }
        });
        Provider.add(backProvBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 50));

        ProviderBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/provider.png"))); // NOI18N
        Provider.add(ProviderBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Provider, "Provider");

        Transaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/indosat2.png"))); // NOI18N
        Transaksi.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 250, 190));

        noHpTransTxt.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 40)); // NOI18N
        noHpTransTxt.setBorder(null);
        Transaksi.add(noHpTransTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 540, 80));

        pembCbb.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 40)); // NOI18N
        pembCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih cara pembayaran---", "OPO", "Fulus", "Asiapmart" }));
        pembCbb.setBorder(null);
        Transaksi.add(pembCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 710, 540, 80));

        nomCbb.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 40)); // NOI18N
        nomCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih nominal ---", "Rp5.000", "Rp10.000", "Rp15.000", "Rp25.000", "Rp30.000", "Rp50.000", "Rp100.000" }));
        nomCbb.setBorder(null);
        Transaksi.add(nomCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 540, 80));

        backTransBtn.setBorder(null);
        backTransBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backTransBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTransBtnActionPerformed(evt);
            }
        });
        Transaksi.add(backTransBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 50));

        payBtn.setBorder(null);
        payBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });
        Transaksi.add(payBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 810, 260, 80));

        confirmBtn.setBorder(null);
        confirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        Transaksi.add(confirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 810, 300, 80));

        struk.setEditable(false);
        struk.setColumns(20);
        struk.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        struk.setRows(5);
        struk.setText("                     ---isiinAja---                   \n           Isi pulsa di mana aja, kapan aja. \n======================================================");
        jScrollPane2.setViewportView(struk);

        Transaksi.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 160, 400, 630));

        TransaksiBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/transaksiBG2.png"))); // NOI18N
        Transaksi.add(TransaksiBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Transaksi, "Transaksi");

        Transaksi2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doneTransBtn.setBorder(null);
        doneTransBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doneTransBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneTransBtnActionPerformed(evt);
            }
        });
        Transaksi2.add(doneTransBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 540, 270, 100));

        menuTransBtn.setBorder(null);
        menuTransBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTransBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTransBtnActionPerformed(evt);
            }
        });
        Transaksi2.add(menuTransBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 270, 100));

        Transaksi2Bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/transaksiSuccessBG.png"))); // NOI18N
        Transaksi2.add(Transaksi2Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(Transaksi2, "Transaksi2");

        getContentPane().add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        close();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void chkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxActionPerformed
        if (chkBox.isSelected()) {
            pwTxt.setEchoChar((char)0);
        } else {
            pwTxt.setEchoChar('*');
        }
    }//GEN-LAST:event_chkBoxActionPerformed

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
        cl.show(Main, "Register1");
    }//GEN-LAST:event_regBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        try {
                    SQL = "SELECT * FROM login WHERE uname='"+unameTxt.getText()+"' AND pw='"+pwTxt.getText()+"'";
                    rs = stm.executeQuery(SQL);
                    String buyer = "buyer";
                    String admin = "admin";

                     if(rs.next()){
                        if(unameTxt.getText().equals(rs.getString("uname")) && pwTxt.getText().equals(rs.getString("pw"))&& buyer.equals(rs.getString("role"))){
                            buyer = rs.getString("uname");
                            JOptionPane.showMessageDialog(null, "Welcome back, " + buyer + "!");
                            setUname(buyer);
                            cl.show(Main, "Provider");
                                
                                
                                
                        }else if(unameTxt.getText().equals(rs.getString("uname")) && pwTxt.getText().equals(rs.getString("pw"))&& admin.equals(rs.getString("role"))){
                            admin = rs.getString("uname");
                            JOptionPane.showMessageDialog(null, "Welcome back admin, " + admin + "!");
                            setUname(admin);
                            cl.show(Main, "Admin");
                        }

                    } else {
                            JOptionPane.showMessageDialog(null, "Username Atau Password Salah");
                        } 
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    System.out.println("SALAH");
                }
        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void signRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signRegBtnActionPerformed
        cl.show(Main, "Login");
        unameRegTxt.setText("");
        pwRegTxt1.setText("");
        pwRegTxt2.setText("");
    }//GEN-LAST:event_signRegBtnActionPerformed

    private void nextRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextRegBtnActionPerformed
        LoginController loginC = new LoginController();
        String x = "buyer";
        if(pwRegTxt1.getText().equals(pwRegTxt2.getText())){
            loginC.addAccount(unameRegTxt.getText(), pwRegTxt2.getText(), x);
            cl.show(Main, "Register2");
        }
        else{
            JOptionPane.showMessageDialog(null, "Password tidak sesuai!");
        }
        
    }//GEN-LAST:event_nextRegBtnActionPerformed

    private void backRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRegBtnActionPerformed
        cl.show(Main, "Register1");
    }//GEN-LAST:event_backRegBtnActionPerformed

    private void contRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contRegBtnActionPerformed
        BuyerController buyerC= new BuyerController();
        int x = 0;
        buyerC.addDataBuyer(x, namaRegTxt.getText(), genderRegTxt.getText(), noHpRegTxt.getText() , tglRegTxt.getText(), emailRegTxt.getText(), unameRegTxt.getText());
        
        namaRegTxt.setText("");       
        genderRegTxt.setText("");       
        noHpRegTxt.setText("");       
        tglRegTxt.setText("");       
        tglRegTxt.setText("");       
        emailRegTxt.setText("");
        cl.show(Main, "Register3");
    }//GEN-LAST:event_contRegBtnActionPerformed

    private void nextReg2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextReg2BtnActionPerformed
        cl.show(Main, "Login");
    }//GEN-LAST:event_nextReg2BtnActionPerformed

    private void emailRegTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRegTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailRegTxtActionPerformed

    private void xlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xlBtnActionPerformed
        pv = "Xl";
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/xl2.png")));
        cl.show(Main, "Transaksi");
    }//GEN-LAST:event_xlBtnActionPerformed

    private void indoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indoBtnActionPerformed
        pv = "Indosat";
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/indosat2.png")));
        cl.show(Main, "Transaksi");
    }//GEN-LAST:event_indoBtnActionPerformed

    private void telkomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telkomBtnActionPerformed
        pv = "Telkomsel";
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/rsz_telkom.png")));
        cl.show(Main, "Transaksi");
    }//GEN-LAST:event_telkomBtnActionPerformed

    private void triBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triBtnActionPerformed
        pv = "3";
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/naufalmf/stock/3.png")));
        cl.show(Main, "Transaksi");
    }//GEN-LAST:event_triBtnActionPerformed

    private void backProvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backProvBtnActionPerformed
        cl.show(Main, "Login");
        unameTxt.setText("");
        pwTxt.setText("");
    }//GEN-LAST:event_backProvBtnActionPerformed

    private void backTransBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTransBtnActionPerformed
        struk.setText("");
        struk.append("                     ---isiinAja---                   \n");
        struk.append("              Isi pulsa dimana aja kapan aja          \n");
        struk.append("======================================================\n");
        
        noHpTransTxt.setText("");
        nomCbb.setSelectedIndex(0);
        pembCbb.setSelectedIndex(0);
        cl.show(Main, "Provider");
    }//GEN-LAST:event_backTransBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        trans(pv);
        
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        
        struk.setText("");
        struk.append("                     ---isiinAja---                   \n");
        struk.append("              Isi pulsa dimana aja kapan aja          \n");
        struk.append("======================================================\n");
        
        String x = "";
        String x1 = "--- Pilih nominal ---";
        String x2 = "--- Pilih cara pembayaran---";
        
        
        if (noHpTransTxt.getText().equals(x) || nomCbb.getSelectedItem().equals(x1) || pembCbb.getSelectedItem().equals(x2)) {
            JOptionPane.showMessageDialog(null, "Mohon isi form dengan benar dan lakukan konfirmasi agar tidak ada kesalahan dalam pembayaran.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            TransaksiController transaksiC = new TransaksiController();
            int id = rdm.nextInt(9999999);
            try{
               java.sql.Statement stm = con.createStatement();
               SQL = "SELECT id_buyer FROM buyer WHERE uname='"+ unameTxt.getText() +"'";
               java.sql.ResultSet res = stm.executeQuery(SQL);
               if(res.next ()){
                   int idBuyer = res.getInt("id_buyer");
                   setId_buyer(idBuyer);
               } 
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage() );
            }
            
            transaksiC.addTransaksi(id, unameTxt.getText(), getId_buyer(), getId_provider(), noHpTransTxt.getText(), getPembayaran(), getHarga(), getTotal());
        
    
            
            noHpTransTxt.setText("");
            nomCbb.setSelectedIndex(0);
            pembCbb.setSelectedIndex(0);
            cl.show(Main, "Transaksi2");
        }
        
    }//GEN-LAST:event_payBtnActionPerformed

    private void doneTransBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneTransBtnActionPerformed
        unameTxt.setText("");
        pwTxt.setText("");
        cl.show(Main, "Login");
    }//GEN-LAST:event_doneTransBtnActionPerformed

    private void menuTransBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransBtnActionPerformed
        cl.show(Main, "Provider");
    }//GEN-LAST:event_menuTransBtnActionPerformed

    private void backUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backUserBtnActionPerformed
        cl.show(Main, "Admin");
    }//GEN-LAST:event_backUserBtnActionPerformed

    private void dbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbBtnActionPerformed
        cl.show(Main, "Database");
        getDataTransaksi();
    }//GEN-LAST:event_dbBtnActionPerformed

    private void addAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminBtnActionPerformed
        cl.show(Main, "RegisterAdmin");
    }//GEN-LAST:event_addAdminBtnActionPerformed

    private void backAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAdminBtnActionPerformed
        cl.show(Main, "Login");
        unameTxt.setText("");       
        pwTxt.setText("");
    }//GEN-LAST:event_backAdminBtnActionPerformed

    private void edtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtBtnActionPerformed
        cl.show(Main, "User");
        getDataAccount();
    }//GEN-LAST:event_edtBtnActionPerformed

    private void edtUsrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtUsrBtnActionPerformed
        BuyerController buyerC = new BuyerController();
        buyerC.updateBuyer(unameUsrTxt.getText(), namaUsrTxt.getText(), genderUsrTxt.getText(), noHpUsrTxt.getText(), tglUsrTxt.getText(), emailUsrTxt.getText());
        unameUsrTxt.setText("");       
        namaUsrTxt.setText("");       
        genderUsrTxt.setText("");       
        noHpUsrTxt.setText("");       
        tglUsrTxt.setText("");       
        emailUsrTxt.setText("");  
        JOptionPane.showMessageDialog(null, "Data berhasil diedit.", "Success", JOptionPane.INFORMATION_MESSAGE);
        getDataAccount();
    }//GEN-LAST:event_edtUsrBtnActionPerformed

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        int baris = userTbl.rowAtPoint(evt.getPoint());
        String uname = userTbl.getValueAt(baris, 1).toString();
        unameUsrTxt.setText(uname);
        String name = userTbl.getValueAt(baris, 2).toString();
        namaUsrTxt.setText(name);
        String gender = userTbl.getValueAt(baris, 3).toString();
        genderUsrTxt.setText(gender);
        String nohp = userTbl.getValueAt(baris, 4).toString();
        noHpUsrTxt.setText(nohp);
        String tgl = userTbl.getValueAt(baris, 5).toString();
        tglUsrTxt.setText(tgl);
        String email = userTbl.getValueAt(baris, 6).toString();
        emailUsrTxt.setText(email);
    }//GEN-LAST:event_userTblMouseClicked

    private void genderUsrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderUsrTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderUsrTxtActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        BuyerController buyerC = new BuyerController();
        buyerC.delBuyer(namaUsrTxt.getText());
        unameUsrTxt.setText("");       
        namaUsrTxt.setText("");       
        genderUsrTxt.setText("");       
        noHpUsrTxt.setText("");       
        tglUsrTxt.setText("");       
        emailUsrTxt.setText("");  
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Success", JOptionPane.INFORMATION_MESSAGE);
        getDataAccount();
    }//GEN-LAST:event_delBtnActionPerformed

    private void nextRegAdmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextRegAdmBtnActionPerformed
        LoginController loginC = new LoginController();
        String x = "admin";
        if(pwRegAdmTxt.getText().equals(pwRegAdmTxt2.getText())){
            loginC.addAccount(unameRegAdmTxt.getText(), pwRegAdmTxt2.getText(), x);
            cl.show(Main, "RegisterAdmin2");
        }
        else{
            JOptionPane.showMessageDialog(null, "Password tidak sesuai!");
        }
    }//GEN-LAST:event_nextRegAdmBtnActionPerformed

    private void backRegAdmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRegAdmBtnActionPerformed
        cl.show(Main, "Admin");
        unameRegAdmTxt.setText("");       
        pwRegAdmTxt.setText("");       
        pwRegAdmTxt2.setText(""); 
    }//GEN-LAST:event_backRegAdmBtnActionPerformed

    private void emailRegAdmTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRegAdmTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailRegAdmTxtActionPerformed

    private void backRegAdmBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRegAdmBtn2ActionPerformed
        cl.show(Main, "Register");
        namaRegAdmTxt.setText("");       
        genderRegAdmTxt.setText("");       
        noHpRegAdmTxt.setText("");
        tglRegAdmTxt.setText("");
        emailRegAdmTxt.setText("");
    }//GEN-LAST:event_backRegAdmBtn2ActionPerformed

    private void contRegAdmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contRegAdmBtnActionPerformed
        AdminController adminC = new AdminController();
        int x = 0;
        adminC.addDataAdmin(x, namaRegAdmTxt.getText(), genderRegAdmTxt.getText(), noHpRegAdmTxt.getText() , tglRegAdmTxt.getText(), emailRegAdmTxt.getText(), unameRegAdmTxt.getText());
        
        cl.show(Main, "RegisterAdmin3");
    }//GEN-LAST:event_contRegAdmBtnActionPerformed

    private void nextRegBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextRegBtn2ActionPerformed
        cl.show(Main, "Admin");
        unameTxt.setText("");       
        pwTxt.setText("");
    }//GEN-LAST:event_nextRegBtn2ActionPerformed

    private void backDbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backDbBtnActionPerformed
        cl.show(Main, "Admin");
    }//GEN-LAST:event_backDbBtnActionPerformed

    private void transTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_transTblMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admin;
    private javax.swing.JLabel AdminBg;
    private javax.swing.JLabel AdminBg1;
    private javax.swing.JLabel AdminBg2;
    private javax.swing.JPanel Database;
    private javax.swing.JPanel Login;
    private javax.swing.JLabel LoginBg;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Provider;
    private javax.swing.JLabel ProviderBg;
    private javax.swing.JPanel Register1;
    private javax.swing.JPanel Register2;
    private javax.swing.JPanel Register3;
    private javax.swing.JPanel RegisterAdmin;
    private javax.swing.JPanel RegisterAdmin2;
    private javax.swing.JPanel RegisterAdmin3;
    private javax.swing.JLabel RegisterBg1;
    private javax.swing.JLabel RegisterBg2;
    private javax.swing.JLabel RegisterBg3;
    private javax.swing.JLabel RegisterBg4;
    private javax.swing.JLabel RegisterBg5;
    private javax.swing.JLabel RegisterBg6;
    private javax.swing.JPanel Transaksi;
    private javax.swing.JPanel Transaksi2;
    private javax.swing.JLabel Transaksi2Bg;
    private javax.swing.JLabel TransaksiBg;
    private javax.swing.JPanel User;
    private javax.swing.JButton addAdminBtn;
    private javax.swing.JButton backAdminBtn;
    private javax.swing.JButton backDbBtn;
    private javax.swing.JButton backProvBtn;
    private javax.swing.JButton backRegAdmBtn;
    private javax.swing.JButton backRegAdmBtn2;
    private javax.swing.JButton backRegBtn;
    private javax.swing.JButton backTransBtn;
    private javax.swing.JButton backUserBtn;
    private javax.swing.JCheckBox chkBox;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton contRegAdmBtn;
    private javax.swing.JButton contRegBtn;
    private javax.swing.JButton dbBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton doneTransBtn;
    private javax.swing.JButton edtBtn;
    private javax.swing.JButton edtUsrBtn;
    private javax.swing.JTextField emailRegAdmTxt;
    private javax.swing.JTextField emailRegTxt;
    private javax.swing.JTextField emailUsrTxt;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField genderRegAdmTxt;
    private javax.swing.JTextField genderRegTxt;
    private javax.swing.JTextField genderUsrTxt;
    private javax.swing.JLabel haiTxt1;
    private javax.swing.JButton indoBtn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel logo;
    private javax.swing.JButton menuTransBtn;
    private javax.swing.JTextField namaRegAdmTxt;
    private javax.swing.JTextField namaRegTxt;
    private javax.swing.JTextField namaUsrTxt;
    private javax.swing.JButton nextReg2Btn;
    private javax.swing.JButton nextRegAdmBtn;
    private javax.swing.JButton nextRegBtn;
    private javax.swing.JButton nextRegBtn2;
    private javax.swing.JTextField noHpRegAdmTxt;
    private javax.swing.JTextField noHpRegTxt;
    private javax.swing.JTextField noHpTransTxt;
    private javax.swing.JTextField noHpUsrTxt;
    private javax.swing.JComboBox<String> nomCbb;
    private javax.swing.JButton payBtn;
    private javax.swing.JComboBox<String> pembCbb;
    private javax.swing.JTextField pwRegAdmTxt;
    private javax.swing.JTextField pwRegAdmTxt2;
    private javax.swing.JTextField pwRegTxt1;
    private javax.swing.JTextField pwRegTxt2;
    private javax.swing.JPasswordField pwTxt;
    private javax.swing.JButton regBtn;
    private javax.swing.JButton signRegBtn;
    private javax.swing.JTextArea struk;
    private javax.swing.JButton telkomBtn;
    private javax.swing.JTextField tglRegAdmTxt;
    private javax.swing.JTextField tglRegTxt;
    private javax.swing.JTextField tglUsrTxt;
    private javax.swing.JTable transTbl;
    private javax.swing.JButton triBtn;
    private javax.swing.JTextField unameRegAdmTxt;
    private javax.swing.JTextField unameRegTxt;
    private javax.swing.JTextField unameTxt;
    private javax.swing.JTextField unameUsrTxt;
    private javax.swing.JTable userTbl;
    private javax.swing.JButton xlBtn;
    // End of variables declaration//GEN-END:variables
}
