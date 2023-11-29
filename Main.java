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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();
        AnggotaPerpustakaan anggotaLogin = null;
        Admin adminLogin = null;

        boolean inginLogin = true;

        while (inginLogin) {
            System.out.println("Selamat datang di Perpustakaan XYZ");
            System.out.println("1. Login");
            System.out.println("2. Daftar sebagai Anggota");
            System.out.print("Pilih jenis aksi (1/2): ");

            int jenisAksi = scanner.nextInt();

            if (jenisAksi == 1) {
                System.out.println("1. Login sebagai Anggota");
                System.out.println("2. Login sebagai Admin");
                System.out.print("Pilih jenis login (1/2): ");
                int jenisLogin = scanner.nextInt();

                if (jenisLogin == 1) {
                    System.out.print("Masukkan nomor anggota: ");
                    String nomorAnggota = scanner.next();

                    anggotaLogin = null;
                    for (AnggotaPerpustakaan anggota : perpustakaan.getDaftarAnggota()) {
                        if (anggota.getNomorAnggota().equals(nomorAnggota)) {
                            anggotaLogin = anggota;
                            break;
                        }
                    }

                    if (anggotaLogin != null) {
                        System.out.println("Selamat datang, " + anggotaLogin.getNama() + "!");
                        tampilkanMenuAnggota(anggotaLogin, perpustakaan, scanner);
                    } else {
                        System.out.println("Nomor anggota tidak ditemukan.");
                    }
                } else if (jenisLogin == 2) {
                    System.out.print("Masukkan username admin: ");
                    String usernameAdmin = scanner.next();
                    System.out.print("Masukkan password admin: ");
                    String passwordAdmin = scanner.next();

                    adminLogin = null;
                    for (Admin admin : perpustakaan.getDaftarAdmin()) {
                        if (admin.getUsername().equals(usernameAdmin) && admin.getPassword().equals(passwordAdmin)) {
                            adminLogin = admin;
                            break;
                        }
                    }

                    if (adminLogin != null) {
                        System.out.println("Selamat datang, Admin!");
                        tampilkanMenuAdmin(adminLogin, perpustakaan, scanner);
                    } else {
                        System.out.println("Username atau password admin salah.");
                    }
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } else if (jenisAksi == 2) {
                System.out.print("Masukkan nama: ");
                String namaAnggota = scanner.next();
                System.out.print("Masukkan alamat: ");
                String alamatAnggota = scanner.next();

                AnggotaPerpustakaan anggotaBaru = new AnggotaPerpustakaan(namaAnggota, alamatAnggota);
                anggotaBaru.register();
                perpustakaan.tambahAnggota(anggotaBaru);

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

    private static void tampilkanMenuAnggota(AnggotaPerpustakaan anggota, Perpustakaan perpustakaan, Scanner scanner) {
        boolean inginLogout = false;

        while (!inginLogout) {
            clearScreen();
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
                    // (Implementasi logika peminjaman buku)
                    break;
                case 2:
                    System.out.println("Riwayat Peminjaman:");
                    System.out.println(anggota.displayPeminjaman());
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    inginLogout = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void tampilkanMenuAdmin(Admin admin, Perpustakaan perpustakaan, Scanner scanner) {
        boolean inginLogout = false;

        while (!inginLogout) {
            clearScreen();
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Riwayat Transaksi");
            System.out.println("3. Logout");
            System.out.print("Pilih nomor menu (1-3): ");

            int pilihanMenu = scanner.nextInt();

            switch (pilihanMenu) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judulBuku = scanner.next();
                    System.out.print("Masukkan pengarang buku: ");
                    String pengarangBuku = scanner.next();
                    System.out.print("Masukkan nomor ISBN buku: ");
                    String nomorISBNBuku = scanner.next();

                    Buku bukuBaru = new Buku(judulBuku, pengarangBuku, nomorISBNBuku);
                    perpustakaan.tambahBuku(bukuBaru);

                    System.out.println("Buku berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.println("Riwayat Transaksi:");
                    System.out.println(perpustakaan.displayRiwayatTransaksi());
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    inginLogout = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

