package Model;

/**
 * Created by vitinhHienAnh on 08-05-18.
 */

public class LoginItems {
    private String username;
    private String password;

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

    public LoginItems(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
