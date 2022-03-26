public class Users {
    private int uang;
    private String username;
    private String password;
    private String nama;
//    private String initial;


    public Users(String username, String password, String nama) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        uang = 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUang() {
        return uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
