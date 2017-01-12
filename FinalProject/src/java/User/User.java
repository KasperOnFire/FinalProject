package User;

public class User {

    private String Username;
    private String Password;
    private String passwordSalt;
    private String Email;
    private int PhoneNo;

    public User(String Username, String Password, String passwordSalt, String Email, int PhoneNo) {
        this.Username = Username;
        this.Password = Password;
        this.passwordSalt = passwordSalt;
        this.Email = Email;
        this.PhoneNo = PhoneNo;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public String getEmail() {
        return Email;
    }

    public int getPhoneNo() {
        return PhoneNo;
    }
    
    
}
