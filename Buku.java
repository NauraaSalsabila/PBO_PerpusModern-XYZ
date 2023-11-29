/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboteori;

import java.util.List;

/**
 *
 * @author PRADYA
 */
public class Buku {
    private String judul;
    private String pengarang;
    private String nomorISBN;
    private boolean statusKetersediaan;

    public Buku(String judul, String pengarang, String nomorISBN, boolean statusKetersediaan) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.nomorISBN = nomorISBN;
        this.statusKetersediaan = statusKetersediaan;
    }

    public boolean cek() {
        return statusKetersediaan;
    }

    public String displayInfo() {
        return "\nJudul: " + judul + "\nPengarang: " + pengarang +
                "\nNomor ISBN: " + nomorISBN + "\nStatus Ketersediaan: " + (statusKetersediaan ? "Tersedia" : "Tidak Tersedia");
    }
}
