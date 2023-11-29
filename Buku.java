class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private String nomorISBN;
    private boolean statusKetersediaan;
    private static final int DURASI_MAX_PINJAMAN = 7; // Contoh durasi maksimal 7 hari
    private static final int DENDA_PER_HARI = 500; // Contoh denda per hari 500

    public Buku(int idBuku, String judul, String pengarang, String nomorISBN) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.nomorISBN = nomorISBN;
        this.statusKetersediaan = true;
    }

    public boolean cekKetersediaan() {
        return statusKetersediaan;
    }

    public String getNomorISBN() {
        return nomorISBN;
    }

    public void setStatusKetersediaan(boolean statusKetersediaan) {
        this.statusKetersediaan = statusKetersediaan;
    }
    
    public static int getDurasiMaxPinjaman() {
        return DURASI_MAX_PINJAMAN;
    }

    public static int getDendaPerHari() {
        return DENDA_PER_HARI;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    
    
}
