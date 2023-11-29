/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboteori;

/**
 *
 * @author PRADYA
 */
public class Notifikasi {
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
        System.out.println("Notifikasi untuk " + anggota.displayPeminjaman() + ": " + isi);
    }

    public String displayNotifikasi() {
        return "ID Notifikasi: " + idNotifikasi + "\nAnggota: " + anggota.displayPeminjaman() +
                "\nIsi: " + isi;
    }
}
