package User;

public class User {

    private String username;
    private String password;
    private String passwordSalt;
    private String email;
    private String userString;
    
    public User(String username, String password, String passwordSalt, String email, String userString) {
        this.username = username;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.userString = userString;
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
