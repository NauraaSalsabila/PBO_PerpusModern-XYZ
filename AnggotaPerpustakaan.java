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

import java.util.ArrayList;
import java.util.List;

public class AnggotaPerpustakaan {
    private static int counter = 1;
    private int idAnggota;
    private int nomorAnggota;
    private String nama;
    private String alamat;
    private String sejarahPeminjaman;

    public AnggotaPerpustakaan(int nomorAnggota, String nama, String alamat) {
        this.idAnggota = counter++;
        this.nomorAnggota = nomorAnggota;
        this.nama = nama;
        this.alamat = alamat;
        this.sejarahPeminjaman = "";
    }

    public void register() {
        List<AnggotaPerpustakaan> anggotaList = new ArrayList<>();
        anggotaList.add(this);
    }
    

    public String displayPeminjaman() {
        return sejarahPeminjaman;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        AnggotaPerpustakaan.counter = counter;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public int getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(int nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSejarahPeminjaman() {
        return sejarahPeminjaman;
    }

    public void setSejarahPeminjaman(String sejarahPeminjaman) {
        this.sejarahPeminjaman = sejarahPeminjaman;
    }
    
    
}
