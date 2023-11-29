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

public class TransaksiPengembalian {
    private int idTransaksi;
    private Date tglKembali;
    private TransaksiPeminjaman transaksiPeminjam;

    public TransaksiPengembalian(int idTransaksi, Date tglKembali, TransaksiPeminjaman transaksiPeminjam) {
        this.idTransaksi = idTransaksi;
        this.tglKembali = tglKembali;
        this.transaksiPeminjam = transaksiPeminjam;
    }

    public int Denda() {
        int dendaPerHari = 100;
        Date tanggalPinjam = transaksiPeminjam.getTanggalPinjam();
        long selisihHari = (tglKembali.getTime() - tanggalPinjam.getTime()) / (24 * 60 * 60 * 1000);
        int denda = (int) Math.max(0, selisihHari * dendaPerHari);
        return denda;
    }

    public String displayInfo() {
        return String.format("ID Transaksi Pengembalian: %d, Tanggal Kembali: %s, Denda: %d",
                idTransaksi, tglKembali.toString(), Denda());
    }
}




