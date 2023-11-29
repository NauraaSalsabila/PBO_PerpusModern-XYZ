class Admin {
    private int idAdmin;
    private String namaAdmin;
    private String username;
    private String password;

    public Admin(int idAdmin, String namaAdmin, String username, String password) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
