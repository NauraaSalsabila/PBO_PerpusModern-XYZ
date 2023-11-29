/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahap2_pbo;

/**
 *
 * @author HP
 */
import java.util.Date;

public class TransaksiPeminjaman {
    private int idTransaksi;
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    private Date tanggalPinjam;
    private int durasiPinjam;

    public TransaksiPeminjaman(int idTransaksi, AnggotaPerpustakaan anggota, Buku buku, Date tanggalPinjam, int durasiPinjam) {
        this.idTransaksi = idTransaksi;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.durasiPinjam = durasiPinjam;
    }

    public int Denda() {
        int dendaPerHari = 100;
        Date currentDate = new Date();
        long selisihHari = (currentDate.getTime() - tanggalPinjam.getTime()) / (24 * 60 * 60 * 1000);
        int denda = (int) Math.max(0, selisihHari * dendaPerHari);
        return denda;
    }

    public String displayInfo() {
        return String.format("ID Transaksi: %d, Buku: %s, Tanggal Pinjam: %s, Durasi Pinjam: %d hari",
                idTransaksi, buku.getJudul(), tanggalPinjam.toString(), durasiPinjam);
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

}



