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
public class karyawan1 {
    private String databaseName = "2210010690_Mariniislami";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    
    public karyawan1 (){
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
    
    public void simpanKaryawan1 (int id_karyawan, String nama, String alamat, String bagian){
        try {
            String sql = "insert into karyawan1 (id_karyawan, nama, alamat, bagian) value(?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, id_karyawan);
            perintah.setString(2, nama);
            perintah.setString(3, alamat);
            perintah.setString(4, bagian); 
            
            perintah.executeUpdate();
            System.out.println("data berhasil tersimpan");    
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahKaryawan1 (int id_karyawan, String nama, String alamat, String bagian){
        try {
            String sql = "update karyawan1 set nama = ?, alamat = ?, bagian = ? where id_karyawan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, alamat);
            perintah.setString(3, bagian);
            perintah.setInt(4, id_karyawan);
            
            perintah.executeUpdate();
            System.out.println("data berhasil terubah"); 
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusKaryawan1 (int id_karyawan){
        try {
            String sql = "delete from karyawan1 where id_karyawan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, id_karyawan);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariKaryawan1(int paramid_karyawan){
        try {
            String SQL ="SELECT*FROM karyawan1 WHERE id_karyawan=?";
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setInt(1,paramid_karyawan);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("Id Karyawan :"+data.getInt("id_karyawan"));
                System.out.println("Nama :"+data.getString("nama"));
                System.out.println("Alamat :"+data.getString("alamat"));
                System.out.println("Bagian :"+data.getString("bagian"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataKaryawan1 () {
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT*FROM karyawan1 ORDER BY id_karyawan ASC");
            while(baris.next()){
                System.out.println(baris.getInt("id_karyawan")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("alamat")+" | "+
                        baris.getString("bagian"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
