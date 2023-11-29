import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();
        AnggotaPerpustakaan anggotaLogin = null;
        Admin adminLogin = null;

        boolean inginLogin = true;

        while (inginLogin) {
            // Menampilkan menu login atau pendaftaran
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
                    for (AnggotaPerpustakaan anggota : perpustakaan.getDaftarAnggota()) {
                        if (anggota.getNomorAnggota().equals(nomorAnggota)) {
                            anggotaLogin = anggota;
                            break;
                        }
                    }

                    if (anggotaLogin != null) {
                        System.out.println("Selamat datang, " + anggotaLogin.getNama() + "!");
                        // Setelah login, tampilkan menu pilihan untuk anggota
                        tampilkanMenuAnggota(anggotaLogin, perpustakaan, scanner);
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
                    for (Admin admin : perpustakaan.getDaftarAdmin()) {
                        if (admin.getUsername().equals(usernameAdmin) && admin.getPassword().equals(passwordAdmin)) {
                            adminLogin = admin;
                            break;
                        }
                    }

                    if (adminLogin != null) {
                        System.out.println("Selamat datang, Admin!");
                        // Setelah login, tampilkan menu pilihan untuk admin
                        tampilkanMenuAdmin(adminLogin, perpustakaan, scanner);
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
                perpustakaan.tambahAnggota(anggotaBaru);

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

    // Metode untuk menampilkan menu pilihan untuk anggota setelah login
    private static void tampilkanMenuAnggota(AnggotaPerpustakaan anggota, Perpustakaan perpustakaan, Scanner scanner) {
        boolean inginLogout = false;

        while (!inginLogout) {
            // Membersihkan layar konsol
            clearScreen();

            // Menampilkan menu pilihan untuk anggota
            System.out.println("Menu Anggota:");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Lihat Riwayat Peminjaman");
            System.out.println("3. Logout");
            System.out.print("Pilih nomor menu (1-3): ");

            int pilihanMenu = scanner.nextInt();

            switch (pilihanMenu) {
                case 1:
                    // Implementasi pinjam buku
                    System.out.print("Masukkan nomor ISBN buku yang ingin dipinjam: ");
                    String nomorISBN = scanner.next();
                    // (Implementasi logika peminjaman buku)
                    break;
                case 2:
                    // Implementasi lihat riwayat peminjaman
                    System.out.println("Riwayat Peminjaman:");
                    System.out.println(anggota.displaySejarahPeminjaman());
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

    // Metode untuk menampilkan menu pilihan untuk admin setelah login
    private static void tampilkanMenuAdmin(Admin admin, Perpustakaan perpustakaan, Scanner scanner) {
        boolean inginLogout = false;

        while (!inginLogout) {
            // Membersihkan layar konsol
            clearScreen();

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
