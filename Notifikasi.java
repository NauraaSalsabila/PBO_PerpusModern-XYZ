class Notifikasi {
    private int idNotifikasi;
    private AnggotaPerpustakaan anggota;
    private String isiNotifikasi;

    public Notifikasi(int idNotifikasi, AnggotaPerpustakaan anggota, String isiNotifikasi) {
        this.idNotifikasi = idNotifikasi;
        this.anggota = anggota;
        this.isiNotifikasi = isiNotifikasi;
    }
}
