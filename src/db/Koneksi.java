package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
    
    private final String URL = "jdbc:mysql://localhost:3306/ppdb";
    private final String USER = "root";
    private final String PASS = "";
    private static Koneksi instance = null;
    private Connection kon;
    
    public Koneksi(){
        
    }
    
    public Connection getConnection(){
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Koneksi Gagal");
            return con = null;
        }
    }
    
    public static Koneksi getInstance(){
        if(instance == null){
            instance = new Koneksi();
        }
        return instance;
    }
    
    public void connectDatabase() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        kon = DriverManager.getConnection(URL,USER,PASS);
    }
    
    public Connection openConnection(){
        try {
            connectDatabase();
            System.out.println("Koneksi Berhasil");
            return kon;
        } catch(Exception e){
            System.err.println("Koneksi Gagal pada file Koneksi method openConnection");
            return kon = null;
        }
    }
    
    public static void main(String[] args) {
        Koneksi koneksi = new Koneksi();
        koneksi.getConnection();
    }
}

