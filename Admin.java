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
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private static int counter = 1;
    private int idAdmin;
    private String nama;
    private String username;
    private String password;

    public Admin(String nama, String username, String password) {
        this.idAdmin = counter++;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public boolean Login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void tambahBuku(Buku buku) {
        List<Buku> daftarBuku = new ArrayList<>();
        daftarBuku.add(buku);
    }

    public static void setCounter(int counter) {
        Admin.counter = counter;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getCounter() {
        return counter;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    
}
