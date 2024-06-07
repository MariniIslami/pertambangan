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
public class kenderaan1 {
    private String databaseName = "2210010690_Mariniislami";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    
    public kenderaan1 (){
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
    
    public void simpanKenderaan1 (int no_polisi, String jenis, String muatan, String supir){
        try {
            String sql = "insert into kenderaan1 (no_polisi, jenis, muatan, supir) value(?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, no_polisi);
            perintah.setString(2, jenis);
            perintah.setString(3, muatan);
            perintah.setString(4, supir);
            
            perintah.executeUpdate();
            System.out.println("data berhasil tersimpan");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahKenderaan1 (int no_polisi, String jenis, String muatan, String supir){
        try {
            String sql = "update kenderaan1 set jenis = ?, muatan = ?, supir = ? where no_polisi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, jenis);
            perintah.setString(2, muatan);
            perintah.setString(3, supir);
            perintah.setInt(4, no_polisi);
            
            perintah.executeUpdate();
            System.out.println("data berhasil terubah");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusKenderaan1 (int no_polisi){
        try {
            String sql = "delete from kenderaan1 where no_polisi = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setInt(1, no_polisi);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariKenderaan1(int paramno_polisi){
        try {
            String SQL ="SELECT*FROM kenderaan1 WHERE no_polisi=?";
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setInt(1,paramno_polisi);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("Nomor polisi :"+data.getInt("no_polisi"));
                System.out.println("jenis :"+data.getString("jenis"));
                System.out.println("muatan :"+data.getString("muatan"));
                System.out.println("supir :"+data.getString("supir"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataKenderaan1 () {
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT*FROM kenderaan1 ORDER BY no_polisi ASC");
            while(baris.next()){
                System.out.println(baris.getInt("no_polisi")+" | "+
                        baris.getString("jenis")+" | "+
                        baris.getString("muatan")+" | "+
                        baris.getString("supir"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
