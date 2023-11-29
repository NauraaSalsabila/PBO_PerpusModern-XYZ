/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboteori;

import java.util.Date;

/**
 *
 * @author PRADYA
 */
import java.util.Date;

public class TransaksiPengembalian {
    private static int counter = 1;
    private int idTransaksi;
    private Date tglKembali;
    private TransaksiPeminjaman transaksiPeminjam;

    public TransaksiPengembalian(TransaksiPeminjaman transaksiPeminjam) {
        this.idTransaksi = counter++;
        this.tglKembali = new Date();
        this.transaksiPeminjam = transaksiPeminjam;
    }

    public int Denda() {
        int dendaPerHari = 1000;
        long selisihHari = (tglKembali.getTime() - transaksiPeminjam.tanggalPinjam.getTime()) / (24 * 60 * 60 * 1000);
        int denda = Math.max(0, (int) (selisihHari - transaksiPeminjam.durasiPinjam) * dendaPerHari);
        return denda;
    }

    public String displayInfo() {
        return "ID Transaksi: " + idTransaksi + "\nTanggal Kembali: " + tglKembali +
                "\nDenda: " + Denda() + "\nTransaksi Peminjam: " + transaksiPeminjam.displayInfo();
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        TransaksiPengembalian.counter = counter;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public TransaksiPeminjaman getTransaksiPeminjam() {
        return transaksiPeminjam;
    }

    public void setTransaksiPeminjam(TransaksiPeminjaman transaksiPeminjam) {
        this.transaksiPeminjam = transaksiPeminjam;
    }
    
    
}
