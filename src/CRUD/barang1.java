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
public class barang1 {
    private String databaseName = "2210010690_mariniislami";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    public barang1 (){
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
    
    public void simpanBarang1 (int id_barang, String nama_barang, String spesifikasi, long harga_satuan){
        try {
            String sql = "insert into barang1 (id_barang, nama_barang, spesifikasi, harga_satuan) value(?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, id_barang);
            perintah.setString(2, nama_barang);
            perintah.setString(3, spesifikasi);
            perintah.setLong(4, harga_satuan); // Menggunakan setLong untuk BIGINT
            
            perintah.executeUpdate();
            System.out.println("data berhasil tersimpan");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahBarang1 (int id_barang, String nama_barang, String spesifikasi, long harga_satuan){
        try {
            String sql = "update barang1 set nama_barang = ?, spesifikasi = ?, harga_satuan = ? where id_barang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama_barang);
            perintah.setString(2, spesifikasi);
            perintah.setLong(3, harga_satuan); // Menggunakan setLong untuk BIGINT
            perintah.setInt(4, id_barang); 
            
            perintah.executeUpdate();
            System.out.println("data berhasil terubah");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusBarang1(int id_barang){
        try {
            String sql = "delete from barang1 where id_barang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, id_barang);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariBarang1(int paramid_barang){
        try {
            String SQL ="SELECT*FROM barang1 WHERE id_barang=?";
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setInt(1,paramid_barang);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("Id Barang :"+data.getInt("id_barang"));
                System.out.println("Nama Barang :"+data.getString("nama_barang"));
                System.out.println("spesifikasi :"+data.getString("spesifikasi"));
                System.out.println("Harga Satuan :"+data.getLong("harga_satuan"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataBarang1 () {
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT*FROM barang1 ORDER BY id_barang ASC");
            while(baris.next()){
                System.out.println(baris.getInt("id_barang")+" | "+
                        baris.getString("nama_barang")+" | "+
                        baris.getString("spesifikasi")+" | "+
                        baris.getLong("harga_satuan"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
