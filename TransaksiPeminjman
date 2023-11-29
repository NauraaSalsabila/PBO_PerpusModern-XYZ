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

public class TransaksiPeminjaman {
    private static int counter = 1;
    private int idTransaksi;
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    Date tanggalPinjam;
    int durasiPinjam;

    public TransaksiPeminjaman(AnggotaPerpustakaan anggota, Buku buku, int durasiPinjam) {
        this.idTransaksi = counter++;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = new Date();
        this.durasiPinjam = durasiPinjam;

        System.out.println(anggota.displayPeminjaman() + "ID Transaksi: " + idTransaksi + "\nBuku: " + buku.displayInfo() +
                "\nTanggal Pinjam: " + tanggalPinjam + "\nDurasi Pinjam: " + durasiPinjam + " hari\n");
    }

    public String displayInfo() {
        return "ID Transaksi: " + idTransaksi + "\nAnggota: " + anggota.displayPeminjaman() +
                "\nBuku: " + buku.displayInfo() + "\nTanggal Pinjam: " + tanggalPinjam +
                "\nDurasi Pinjam: " + durasiPinjam + " hari";
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        TransaksiPeminjaman.counter = counter;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public AnggotaPerpustakaan getAnggota() {
        return anggota;
    }

    public void setAnggota(AnggotaPerpustakaan anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public int getDurasiPinjam() {
        return durasiPinjam;
    }

    public void setDurasiPinjam(int durasiPinjam) {
        this.durasiPinjam = durasiPinjam;
    }
    
}
