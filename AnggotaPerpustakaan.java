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
import java.util.ArrayList;
import java.util.List;

public class AnggotaPerpustakaan {
    private int idAnggota;
    private int nomorAnggota;
    private String nama;
    private String alamat;
    private List<TransaksiPeminjaman> sejarahPeminjaman;

    public AnggotaPerpustakaan(int idAnggota, int nomorAnggota, String nama, String alamat) {
        this.idAnggota = idAnggota;
        this.nomorAnggota = nomorAnggota;
        this.nama = nama;
        this.alamat = alamat;
        this.sejarahPeminjaman = new ArrayList<>();
    }

    public void register() {
        System.out.println("Anggota berhasil diregistrasi");
    }

    public String displayPeminjaman() {
        StringBuilder result = new StringBuilder("Sejarah Peminjaman:\n");
        for (TransaksiPeminjaman transaksi : sejarahPeminjaman) {
            result.append(transaksi.displayInfo()).append("\n");
        }
        return result.toString();
    }

    public void tambahPeminjaman(TransaksiPeminjaman transaksi) {
        sejarahPeminjaman.add(transaksi);
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public int getNomorAnggota() {
        return nomorAnggota;
    }

    public String getNama() {
        return nama;
    }

}



