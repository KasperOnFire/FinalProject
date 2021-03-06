package User;

public class User {

    private String username;
    private String password;
    private String passwordSalt;
    private String email;
    private String userString;
    private int UID;
    
    public User(int UID, String username, String password, String passwordSalt, String email, String userString) {
        this.UID = UID;
        this.username = username;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.userString = userString;
    }
    
    public User(String username, String password, String passwordSalt, String email, String userString) {
        this.username = username;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.userString = userString;
    }
    
    public int getUID(){
        return UID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public String getEmail() {
        return email;
    }
    
    public String getUserString() {
        return userString;
    }
}
