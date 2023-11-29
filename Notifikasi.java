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
public class Notifikasi {
    private int idNotifikasi;
    private AnggotaPerpustakaan anggota;
    private String isi;

    public Notifikasi(int idNotifikasi, AnggotaPerpustakaan anggota, String isi) {
        this.idNotifikasi = idNotifikasi;
        this.anggota = anggota;
        this.isi = isi;
    }

    public void kirimNotifikasi() {
        System.out.println("Notifikasi terkirim ke: " + anggota.getNama());
    }

    public String displayNotifikasi() {
        return String.format("ID Notifikasi: %d, Isi: %s", idNotifikasi, isi);
    }
}



