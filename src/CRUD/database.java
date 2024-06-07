/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql (CRUD)
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author LENOVO
 */
public class database {
    private String databaseName = "2210010690_Mariniislami";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    
    public database (){
        try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver" );
            connectionDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanUji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "insert into uji (nik, nama, telp, alamat) value(?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, alamat);
            
            perintah.executeUpdate();
            System.out.println("data berhasil tersimpan");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahUji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "update uji set nama = ?, telp = ?, alamat = ? where nik = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            
            perintah.executeUpdate();
            System.out.println("data berhasil terubah");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusUji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "delete from uji where nik = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nik);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariUji (String paramnik) {
        try {
            String SQL="Select*from uji where nik =?";
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setString(1,paramnik);
            ResultSet data = perintah.executeQuery();
            while (data.next()){
                System.out.println("NIK :"+data.getString("nik"));
                System.out.println("Nama Karyawan :"+data.getString("nama"));
                System.out.println("Telp :"+data.getString("telp"));
                System.out.println("Alamat :"+data.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataUji () {
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("select*from uji ORDER BY nik ASC");
            while(baris.next()){
                System.out.println(baris.getString("nik")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("telp")+" | "+
                        baris.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
