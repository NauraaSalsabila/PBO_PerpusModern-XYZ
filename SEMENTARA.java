/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboteori;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class AnggotaPerpustakaan {
    private static int counter = 1;
    private int idAnggota;
    private int nomorAnggota;
    private String nama;
    private String alamat;
    private StringBuilder sejarahPeminjaman = new StringBuilder();

    public AnggotaPerpustakaan(int nomorAnggota, String nama, String alamat) {
        this.idAnggota = counter++;
        this.nomorAnggota = nomorAnggota;
        this.nama = nama;
        this.alamat = alamat;
    }

    public void register() {
        // Implementasi registrasi anggota
        // Misalnya, menyimpan data anggota ke dalam list
        // Sebaiknya gunakan database untuk penyimpanan yang lebih permanen
        // Namun, di sini kita menggunakan list sebagai contoh
        List<AnggotaPerpustakaan> anggotaList = new ArrayList<>();
        anggotaList.add(this);
    }

    public void tambahSejarahPeminjaman(String infoTransaksi) {
        sejarahPeminjaman.append(infoTransaksi).append("\n");
    }

    public String displayPeminjaman() {
        // Implementasi tampilan peminjaman anggota
        return sejarahPeminjaman.toString();
    }
}

class TransaksiPeminjaman {
    private static int counter = 1;
    private int idTransaksi;
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    private Date tanggalPinjam;
    private int durasiPinjam;

    public TransaksiPeminjaman(AnggotaPerpustakaan anggota, Buku buku, int durasiPinjam) {
        this.idTransaksi = counter++;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = new Date();
        this.durasiPinjam = durasiPinjam;

        // Menambahkan transaksi ke sejarah peminjaman anggota
        anggota.tambahSejarahPeminjaman("ID Transaksi: " + idTransaksi + "\nBuku: " + buku.displayInfo() +
                "\nTanggal Pinjam: " + tanggalPinjam + "\nDurasi Pinjam: " + durasiPinjam + " hari");
    }

    public int Denda() {
        // Implementasi perhitungan denda
        // Misalnya, menghitung denda berdasarkan durasi keterlambatan
        int dendaPerHari = 1000; // Contoh tarif denda per hari
        Date sekarang = new Date();
        long selisihHari = (sekarang.getTime() - tanggalPinjam.getTime()) / (24 * 60 * 60 * 1000);
        int denda = Math.max(0, (int) (selisihHari - durasiPinjam) * dendaPerHari);
        return denda;
    }

    public String displayInfo() {
        // Implementasi tampilan informasi transaksi peminjaman
        return "ID Transaksi: " + idTransaksi + "\nAnggota: " + anggota.displayPeminjaman() +
                "\nBuku: " + buku.displayInfo() + "\nTanggal Pinjam: " + tanggalPinjam +
                "\nDurasi Pinjam: " + durasiPinjam + " hari";
    }

    public int getDurasiPinjam() {
        return durasiPinjam;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }
}

class TransaksiPengembalian {
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
        // Implementasi perhitungan denda
        // Misalnya, menghitung denda berdasarkan durasi keterlambatan
        int dendaPerHari = 1000; // Contoh tarif denda per hari
        long selisihHari = (tglKembali.getTime() - transaksiPeminjam.getTanggalPinjam().getTime()) / (24 * 60 * 60 * 1000);
        int denda = Math.max(0, (int) (selisihHari - transaksiPeminjam.getDurasiPinjam()) * dendaPerHari);
        return denda;
    }

    public String displayInfo() {
        // Implementasi tampilan informasi transaksi pengembalian
        return "ID Transaksi: " + idTransaksi + "\nTanggal Kembali: " + tglKembali +
                "\nDenda: " + Denda() + "\nTransaksi Peminjam: " + transaksiPeminjam.displayInfo();
    }
}

class Notifikasi {
    private static int counter = 1;
    private int idNotifikasi;
    private AnggotaPerpustakaan anggota;
    private String isi;

    public Notifikasi(AnggotaPerpustakaan anggota, String isi) {
        this.idNotifikasi = counter++;
        this.anggota = anggota;
        this.isi = isi;
    }

    public void kirimNotifikasi() {
        // Implementasi pengiriman notifikasi
        // Misalnya, mencetak notifikasi ke layar
        System.out.println("Notifikasi untuk " + anggota.displayPeminjaman() + ": " + isi);
    }

    public String displayNotifikasi() {
        // Implementasi tampilan notifikasi
        return "ID Notifikasi: " + idNotifikasi + "\nAnggota: " + anggota.displayPeminjaman() +
                "\nIsi: " + isi;
    }
}

class Admin {
    private static int counter = 1;
    private int idAdmin;
    private String nama;
    private String username;
    private String password;

    public Admin(String nama, String username, String password) {
        this.idAdmin = counter++;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public boolean Login(String inputUsername, String inputPassword) {
        // Implementasi proses login
        // Misalnya, memverifikasi username dan password
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void tambahBuku(Buku buku) {
        // Implementasi penambahan buku
        // Misalnya, menambahkan buku ke dalam daftar buku
        // Sebaiknya gunakan database untuk penyimpanan yang lebih permanen
        // Namun, di sini kita menggunakan list sebagai contoh
        List<Buku> daftarBuku = new ArrayList<>();
        daftarBuku.add(buku);
    }
}

class Buku {
    private static int counter = 1;
    private int idBuku;
    private String judul;
    private String pengarang;
    private String nomorISBN;
    private boolean statusKetersediaan;

    public Buku(String judul, String pengarang, String nomorISBN, boolean statusKetersediaan) {
        this.idBuku = counter++;
        this.judul = judul;
        this.pengarang = pengarang;
        this.nomorISBN = nomorISBN;
        this.statusKetersediaan = statusKetersediaan;
    }

    public boolean cek() {
        // Implementasi pengecekan ketersediaan buku
        return statusKetersediaan;
    }

    public String displayInfo() {
        // Implementasi tampilan informasi buku
        return "ID Buku: " + idBuku + "\nJudul: " + judul + "\nPengarang: " + pengarang +
                "\nNomor ISBN: " + nomorISBN + "\nStatus Ketersediaan: " + (statusKetersediaan ? "Tersedia" : "Tidak Tersedia");
    }
}

public class PBOTeori {
    public static void main(String[] args) {
        // Contoh penggunaan class
        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(123, "John Doe", "Jl. Contoh No. 123");
        anggota.register();
        System.out.println("Peminjaman Anggota:\n" + anggota.displayPeminjaman());

        Buku buku1 = new Buku("Java Programming", "Jane Doe", "123-456-789", true);
        Buku buku2 = new Buku("Data Structures", "John Smith", "987-654-321", true);

        Admin admin = new Admin("Admin1", "admin", "admin123");
        if (admin.Login("admin", "admin123")) {
            admin.tambahBuku(buku1);
            admin.tambahBuku(buku2);
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password.");
        }

        TransaksiPeminjaman transaksiPeminjaman = new TransaksiPeminjaman(anggota, buku1, 7);
        System.out.println("\nInformasi Transaksi Peminjaman:\n" + transaksiPeminjaman.displayInfo());

        TransaksiPengembalian transaksiPengembalian = new TransaksiPengembalian(transaksiPeminjaman);
        System.out.println("\nInformasi Transaksi Pengembalian:\n" + transaksiPengembalian.displayInfo());

        Notifikasi notifikasi = new Notifikasi(anggota, "Buku Anda sudah harus dikembalikan.");
        notifikasi.kirimNotifikasi();
        System.out.println("\nNotifikasi:\n" + notifikasi.displayNotifikasi());
    }
}
