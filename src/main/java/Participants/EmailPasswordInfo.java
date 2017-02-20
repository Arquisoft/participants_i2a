package Participants;

/**
 * Created by yy on 15-Feb-17.
 */
public class EmailPasswordInfo {

    private String email;
    private String password;

    protected EmailPasswordInfo() {
        email="";
        password = "";
    }

    public EmailPasswordInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}