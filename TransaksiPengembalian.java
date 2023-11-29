class TransaksiPengembalian {
    private int idTransaksi;
    private TransaksiPeminjaman transaksiPeminjaman;
    private Date tanggalKembali;

    public TransaksiPengembalian(int idTransaksi, TransaksiPeminjaman transaksiPeminjaman, Date tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.transaksiPeminjaman = transaksiPeminjaman;
        this.tanggalKembali = tanggalKembali;
    }
}

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
