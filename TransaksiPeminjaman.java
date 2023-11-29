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

    public int Denda() {
        // Implementasi perhitungan denda
        return 0;
    }

    public String displayInfo() {
        // Implementasi tampilan informasi transaksi peminjaman
        return "";
    }
}

