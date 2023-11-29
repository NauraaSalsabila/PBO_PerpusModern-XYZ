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

public class Perpustakaan {
    private List<AnggotaPerpustakaan> daftarAnggota;
    private List<Admin> daftarAdmin;
    private List<Buku> daftarBuku;
    private List<TransaksiPeminjaman> riwayatTransaksi;

    public Perpustakaan() {
        this.daftarAnggota = new ArrayList<>();
        this.daftarAdmin = new ArrayList<>();
        this.daftarBuku = new ArrayList<>();
        this.riwayatTransaksi = new ArrayList<>();
    }

    public List<AnggotaPerpustakaan> getDaftarAnggota() {
        return daftarAnggota;
    }

    public List<Admin> getDaftarAdmin() {
        return daftarAdmin;
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public List<TransaksiPeminjaman> getRiwayatTransaksi() {
        return riwayatTransaksi;
    }

    public void tambahAnggota(AnggotaPerpustakaan anggota) {
        daftarAnggota.add(anggota);
    }

    public void tambahAdmin(Admin admin) {
        daftarAdmin.add(admin);
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tambahTransaksi(TransaksiPeminjaman transaksi) {
        riwayatTransaksi.add(transaksi);
    }

    public String displayRiwayatTransaksi() {
        StringBuilder result = new StringBuilder();
        for (TransaksiPeminjaman transaksi : riwayatTransaksi) {
            result.append(transaksi.displayInfo()).append("\n");
        }
        return result.toString();
    }
}
