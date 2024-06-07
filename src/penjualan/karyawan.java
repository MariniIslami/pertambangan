/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penjualan;

/**
 *
 * @author LENOVO
 */
public class karyawan {
    private String idKaryawan;
    private String nama;
    private String alamat;
    private String bagian;

    public karyawan(String idKaryawan, String nama, String alamat, String bagian) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.alamat = alamat;
        this.bagian = bagian;
    }

    // Getter dan Setter
    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    @Override
    public String toString() {
        return "Karyawan{" + "idKaryawan=" + idKaryawan + ", nama=" + nama + ", alamat=" + alamat + ", bagian=" + bagian + '}';
    }
}