class TransaksiPeminjaman {
    private int idTransaksi;
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    private Date tanggalPinjam;
    private int durasiPinjam;

    public TransaksiPeminjaman(int idTransaksi, AnggotaPerpustakaan anggota, Buku buku, Date tanggalPinjam, int durasiPinjam) {
        this.idTransaksi = idTransaksi;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.durasiPinjam = durasiPinjam;
    }
    
    public Date getTanggalKembali() {
        long waktuPinjam = tanggalPinjam.getTime();
        long waktuKembali = waktuPinjam + (durasiPinjam * 24L * 60L * 60L * 1000L);
        return new Date(waktuKembali);
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public AnggotaPerpustakaan getAnggota() {
        return anggota;
    }

    public void setAnggota(AnggotaPerpustakaan anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public int getDurasiPinjam() {
        return durasiPinjam;
    }

    public void setDurasiPinjam(int durasiPinjam) {
        this.durasiPinjam = durasiPinjam;
    }
    
    
}
