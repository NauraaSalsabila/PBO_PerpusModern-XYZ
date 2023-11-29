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
public class Admin {
    private int idAdmin;
    private String nama;
    private String username;
    private String password;

    public Admin(int idAdmin, String nama, String username, String password) {
        this.idAdmin = idAdmin;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public boolean Login() {
        return username.equals("admin") && password.equals("admin123");
    }

    public void tambahBuku(Buku buku) {
        System.out.println("Buku berhasil ditambahkan: " + buku.getJudul());
    }
}



