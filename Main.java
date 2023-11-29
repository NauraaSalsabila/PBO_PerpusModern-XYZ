/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboteori;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PBOTeori {
    private static List<AnggotaPerpustakaan> daftarAnggota = new ArrayList<>();
    private static List<Buku> daftarBuku = new ArrayList<>();
    private static List<TransaksiPeminjaman> daftarPeminjaman = new ArrayList<>();
    private static List<TransaksiPengembalian> daftarPengembalian = new ArrayList<>();
    private static List<Notifikasi> daftarNotifikasi = new ArrayList<>();
    private static List<Admin> daftarAdmin = new ArrayList<>();

    // Menambahkan data admin
    static {
        Admin admin1 = new Admin(1, "Admin1", "admin1", "password1");
        Admin admin2 = new Admin(2, "Admin2", "admin2", "password2");

        daftarAdmin.add(admin1);
        daftarAdmin.add(admin2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnggotaPerpustakaan anggotaLogin = null;
        Admin adminLogin = null;

        boolean inginLogin = true;

        while (inginLogin) {
            // Menu login atau pendaftaran
            System.out.println("Selamat datang di Perpustakaan XYZ");
            System.out.println("1. Login");
            System.out.println("2. Daftar sebagai Anggota");
            System.out.print("Pilih jenis aksi (1/2): ");

            int jenisAksi = scanner.nextInt();

            if (jenisAksi == 1) {
                // Login
                System.out.println("1. Login sebagai Anggota");
                System.out.println("2. Login sebagai Admin");
                System.out.print("Pilih jenis login (1/2): ");
                int jenisLogin = scanner.nextInt();

                if (jenisLogin == 1) {
                    // Login sebagai Anggota
                    System.out.print("Masukkan nomor anggota: ");
                    String nomorAnggota = scanner.next();

                    anggotaLogin = null;
                    for (AnggotaPerpustakaan anggota : daftarAnggota) {
                        if (anggota.getNomorAnggota().equals(nomorAnggota)) {
                            anggotaLogin = anggota;
                            break;
                        }
                    }

                    if (anggotaLogin != null) {
                        System.out.println("Selamat datang, " + anggotaLogin.getNama() + "!");
                        // Setelah login, tampilkan menu pilihan untuk anggota
                        tampilkanMenuAnggota(anggotaLogin, scanner);
                    } else {
                        System.out.println("Nomor anggota tidak ditemukan.");
                    }
                } else if (jenisLogin == 2) {
                    // Login sebagai Admin
                    System.out.print("Masukkan username admin: ");
                    String usernameAdmin = scanner.next();
                    System.out.print("Masukkan password admin: ");
                    String passwordAdmin = scanner.next();

                    adminLogin = null;
                    for (Admin admin : daftarAdmin) {
                        if (admin.getUsername().equals(usernameAdmin) && admin.getPassword().equals(passwordAdmin)) {
                            adminLogin = admin;
                            break;
                        }
                    }

                    if (adminLogin != null) {
                        System.out.println("Selamat datang, Admin!");
                        // Setelah login, tampilkan menu pilihan untuk admin
                        tampilkanMenuAdmin(adminLogin, scanner);
                    } else {
                        System.out.println("Username atau password admin salah.");
                    }
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } else if (jenisAksi == 2) {
                // Pendaftaran Anggota
                System.out.print("Masukkan nama: ");
                String namaAnggota = scanner.next();
                System.out.print("Masukkan alamat: ");
                String alamatAnggota = scanner.next();

                // Buat objek AnggotaPerpustakaan dan tambahkan ke dalam daftar anggota perpustakaan
                AnggotaPerpustakaan anggotaBaru = new AnggotaPerpustakaan(namaAnggota, alamatAnggota);
                anggotaBaru.registerAnggota();
                daftarAnggota.add(anggotaBaru);

                // Tanyakan apakah ingin login lagi atau tidak
                boolean pilihanValid = false;
                while (!pilihanValid) {
                    System.out.print("Apakah ingin login lagi? (y/n): ");
                    char jawaban = scanner.next().charAt(0);

                    if (jawaban == 'y' || jawaban == 'Y') {
                        inginLogin = true;
                        pilihanValid = true;
                    } else if (jawaban == 'n' || jawaban == 'N') {
                        inginLogin = false;
                        pilihanValid = true;
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tampilkanMenuAnggota(AnggotaPerpustakaan anggota, Scanner scanner) {
    boolean inginLogout = false;

    while (!inginLogout) {
        // Menampilkan menu pilihan untuk anggota
        System.out.println("Menu Anggota:");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Lihat Riwayat Peminjaman");
        System.out.println("3. Logout");
        System.out.print("Pilih nomor menu (1-3): ");

        int pilihanMenu = scanner.nextInt();

        switch (pilihanMenu) {
            case 1:
                System.out.print("Masukkan nomor ISBN buku yang ingin dipinjam: ");
                    String nomorISBN = scanner.next();

                    Buku bukuDipinjam = null;
                    for (Buku buku : daftarBuku) {
                        if (buku.getNomorISBN().equals(nomorISBN) && buku.cekKetersediaan()) {
                            bukuDipinjam = buku;
                            break;
                        }
                    }

                    if (bukuDipinjam != null) {
                        // Proses peminjaman
                        System.out.print("Masukkan durasi peminjaman (dalam hari): ");
                        int durasiPinjam = scanner.nextInt();
                        TransaksiPeminjaman transaksiPeminjaman = new TransaksiPeminjaman(
                            generateIdTransaksi(), anggota, bukuDipinjam, new Date(), durasiPinjam
                        );

                        // Menandai buku sebagai tidak tersedia
                        bukuDipinjam.setStatusKetersediaan(false);

                        // Menambahkan transaksi peminjaman ke daftar
                        daftarPeminjaman.add(transaksiPeminjaman);

                        // Memberikan notifikasi kepada anggota
                        Notifikasi notifikasi = new Notifikasi(
                            generateIdNotifikasi(), anggota, "Peminjaman berhasil. Terima kasih!" );
                        daftarNotifikasi.add(notifikasi);

                        System.out.println("Peminjaman berhasil. Terima kasih!");
                    } else {
                        System.out.println("Buku tidak tersedia atau nomor ISBN tidak valid.");
                    }



                break;
            case 2:
                // Implementasi lihat riwayat peminjaman
                System.out.println("Riwayat Peminjaman:");
                System.out.println(anggota.displaySejarahPeminjaman());
                
                // Cek durasi peminjaman dan berikan notifikasi
                cekNotifikasiDurasiPeminjaman(anggota);
                break;
            case 3:
                // Logout
                System.out.println("Logout berhasil.");
                inginLogout = true;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}

private static void cekNotifikasiDurasiPeminjaman(AnggotaPerpustakaan anggota) {
    String riwayatPeminjaman = anggota.displaySejarahPeminjaman();

    // Hitung jumlah buku yang belum dikembalikan
    int jumlahBukuBelumKembali = 0;
    if (riwayatPeminjaman.length() > 7) {
        jumlahBukuBelumKembali++;
    }

    // Jika ada buku yang belum dikembalikan, berikan notifikasi
    if (jumlahBukuBelumKembali > 0) {
        System.out.println("Notifikasi: Anda memiliki buku yang belum dikembalikan lebih dari 7 hari.");
    }
    
    for (TransaksiPeminjaman transaksi : daftarPeminjaman) {
        if (transaksi.getAnggota().equals(anggota)) {
            Date tanggalKembali = transaksi.getTanggalPinjam();
            int durasiPinjam = transaksi.getDurasiPinjam();
            long waktuSekarang = new Date().getTime();
            long waktuKembali = tanggalKembali.getTime() + (durasiPinjam * 24L * 60L * 60L * 1000L);

            // Jika waktu kembali telah lewat, berikan notifikasi dan hitung denda
            if (waktuSekarang > waktuKembali) {
                long selisihHari = (waktuSekarang - waktuKembali) / (24L * 60L * 60L * 1000L);
                int denda = (int) (selisihHari * Buku.getDendaPerHari());

                // Tampilkan notifikasi
                System.out.println("Notifikasi: Buku " + transaksi.getBuku().getJudul() +
                        " melewati batas waktu pengembalian. Denda: " + denda + " rupiah.");

                // Simpan notifikasi
                Notifikasi notifikasi = new Notifikasi(generateIdNotifikasi(), anggota,
                        "Buku " + transaksi.getBuku().getJudul() +
                        " melewati batas waktu pengembalian. Denda: " + denda + " rupiah.");
                daftarNotifikasi.add(notifikasi);
            }
        }
    }
}




    private static void tampilkanMenuAdmin(Admin admin, Scanner scanner) {
        boolean inginLogout = false;

        while (!inginLogout) {
            // Menampilkan menu pilihan untuk admin
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Riwayat Transaksi");
            System.out.println("3. Logout");
            System.out.print("Pilih nomor menu (1-3): ");

            int pilihanMenu = scanner.nextInt();

            switch (pilihanMenu) {
                case 1:
                    // Implementasi tambah buku
                    System.out.print("Masukkan judul buku: ");
                    String judulBuku = scanner.next();
                    System.out.print("Masukkan pengarang buku: ");
                    String pengarangBuku = scanner.next();
                    System.out.print("Masukkan nomor ISBN buku: ");
                    String nomorISBNBuku = scanner.next();

                    // Membuat objek buku baru
                    Buku bukuBaru = new Buku(generateIdBuku(), judulBuku, pengarangBuku, nomorISBNBuku);

                    // Menambahkan buku ke daftar buku
                    daftarBuku.add(bukuBaru);

                    System.out.println("Buku berhasil ditambahkan ke perpustakaan.");
                    break;
                case 2:
    // Implementasi lihat riwayat transaksi
                System.out.println("Riwayat Peminjaman:");
                // Tampilkan riwayat peminjaman untuk setiap anggota
                for (AnggotaPerpustakaan anggota : daftarAnggota) {
                    System.out.println("Nama Anggota: " + anggota.getNama());
                    System.out.println(anggota.displaySejarahPeminjaman());
                    // Cek durasi peminjaman dan berikan notifikasi
                    cekNotifikasiDurasiPeminjaman(anggota);
                    System.out.println();
                }
                break;
                case 3:
                    // Logout
                    System.out.println("Logout berhasil.");
                    inginLogout = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    // Metode-metode bantu untuk menghasilkan ID unik
    private static int generateIdTransaksi() {
        // Implementasi logika untuk menghasilkan ID transaksi
        return daftarPeminjaman.size() + 1;
    }

    private static int generateIdNotifikasi() {
        // Implementasi logika untuk menghasilkan ID notifikasi
        return daftarNotifikasi.size() + 1;
    }

    private static int generateIdBuku() {
        // Implementasi logika untuk menghasilkan ID buku
        return daftarBuku.size() + 1;
    }
  
}
