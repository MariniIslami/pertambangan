/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penjualan;

/**
 *
 * @author LENOVO
 */

public class invoice {
    private String noInvoice;
    private String noPo;
    private String tglInvoice;
    private double diskon;
    private double ppn;
    private double jumBayar;
    private String idKaryawan;
    private int jangkaPengiriman;

    public invoice(String noInvoice, String noPo, String tglInvoice, double diskon, double ppn, double jumBayar, String idKaryawan, int jangkaPengiriman) {
        this.noInvoice = noInvoice;
        this.noPo = noPo;
        this.tglInvoice = tglInvoice;
        this.diskon = diskon;
        this.ppn = ppn;
        this.jumBayar = jumBayar;
        this.idKaryawan = idKaryawan;
        this.jangkaPengiriman = jangkaPengiriman;
    }

    // Getter dan Setter
    public String getNoInvoice() {
        return noInvoice;
    }

    public void setNoInvoice(String noInvoice) {
        this.noInvoice = noInvoice;
    }

    public String getNoPo() {
        return noPo;
    }

    public void setNoPo(String noPo) {
        this.noPo = noPo;
    }

    public String getTglInvoice() {
        return tglInvoice;
    }

    public void setTglInvoice(String tglInvoice) {
        this.tglInvoice = tglInvoice;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getPpn() {
        return ppn;
    }

    public void setPpn(double ppn) {
        this.ppn = ppn;
    }

    public double getJumBayar() {
        return jumBayar;
    }

    public void setJumBayar(double jumBayar) {
        this.jumBayar = jumBayar;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public int getJangkaPengiriman() {
        return jangkaPengiriman;
    }

    public void setJangkaPengiriman(int jangkaPengiriman) {
        this.jangkaPengiriman = jangkaPengiriman;
    }

    @Override
    public String toString() {
        return "Invoice{" + "noInvoice=" + noInvoice + ", noPo=" + noPo + ", tglInvoice=" + tglInvoice + ", diskon=" + diskon + ", ppn=" + ppn + ", jumBayar=" + jumBayar + ", idKaryawan=" + idKaryawan + ", jangkaPengiriman=" + jangkaPengiriman + '}';
    }
}
