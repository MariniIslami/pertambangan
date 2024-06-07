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
public class gudang1 {
    private String databaseName = "2210010690_Mariniislami";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    public gudang1 (){
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
    
    public void simpanGudang1 (int id_gudang, String alamat_gudang){
        try {
            String sql = "insert into gudang1 (id_gudang, alamat_gudang) value(?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, id_gudang);
            perintah.setString(2, alamat_gudang);
            
            perintah.executeUpdate();
            System.out.println("data berhasil tersimpan");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahGudang1(int id_gudang, String alamat_gudang){
        try {
            String sql = "update gudang1 set alamat_gudang = ? where id_gudang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, alamat_gudang);
            perintah.setInt(2, id_gudang);
            
            perintah.executeUpdate();
            System.out.println("data berhasil terubah");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusGudang1 (int id_barang){
        try {
            String sql = "delete from gudang1 where id_barang = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, id_barang);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariGudang1(int paramid_gudang){
        try {
            String SQL ="SELECT*FROM gudang1 WHERE id_gudang=?";
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setInt(1,paramid_gudang);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("Id Gudang :"+data.getInt("id_gudang"));
                System.out.println("Alamat gudang :"+data.getString("alamat_gudang"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataGudang1 () {
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT*FROM gudang1 ORDER BY id_gudang ASC");
            while(baris.next()){
                System.out.println(baris.getInt("id_gudang")+" | "+
                        baris.getString("alamat_gudang"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
