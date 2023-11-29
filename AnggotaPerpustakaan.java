class AnggotaPerpustakaan {
    private static int counter = 1;

    private int idAnggota;
    private String nama;
    private String nomorAnggota;
    private String alamat;
    private String sejarahPeminjaman;

    public AnggotaPerpustakaan(String nama, String alamat) {
        this.idAnggota = counter++;
        this.nama = nama;
        this.nomorAnggota = "AGT" + String.format("%04d", idAnggota);
        this.alamat = alamat;
        this.sejarahPeminjaman = "";
    }

    public void registerAnggota() {
        System.out.println("Pendaftaran anggota berhasil!");
        System.out.println("Nomor Anggota: " + nomorAnggota);
    }

    public String displaySejarahPeminjaman() {
        return sejarahPeminjaman;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }
}
