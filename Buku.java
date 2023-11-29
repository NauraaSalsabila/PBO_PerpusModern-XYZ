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
public class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private String nomorISBN;
    private boolean statusKetersediaan;

    public Buku(int idBuku, String judul, String pengarang, String nomorISBN, boolean statusKetersediaan) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.nomorISBN = nomorISBN;
        this.statusKetersediaan = statusKetersediaan;
    }

    public boolean cek() {
        return statusKetersediaan;
    }

    public String displayInfo() {
        return String.format("ID Buku: %d, Judul: %s, Pengarang: %s, Nomor ISBN: %s, Ketersediaan: %s",
                idBuku, judul, pengarang, nomorISBN, statusKetersediaan ? "Tersedia" : "Dipinjam");
    }

    public String getJudul() {
        return judul;
    }
}



