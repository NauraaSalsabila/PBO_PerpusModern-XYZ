/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboteori;
public class PBOTeori {
    public static void main(String[] args) {
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









