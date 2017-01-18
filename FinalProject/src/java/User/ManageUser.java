package User;

import Data.DataAccessObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class ManageUser {
    Password pass = new Password();
    DataAccessObject DAO = null;
    User user = null;
    
    private String hashedPassword;
    private boolean loggedIn;
    private boolean debug = true;
    
    public ManageUser() {
        try {
            DAO = new DataAccessObject();
        } catch (Exception ex) {
        }    
    }
       
    public User login(String username, String password) throws SQLException{
        user = DAO.getUserByName(username);
        
        try {
            hashedPassword = pass.get_SHA_512_SecurePassword(password, user.getPasswordSalt());
        } catch (Exception e) {
        }
        
        if(hashedPassword.equals(user.getPassword())){
            if(debug == true){
                System.out.println("User logged in: " + user.getUsername() + " <br>With the following password: " + user.getPassword() + " <br>And the following salt: " + user.getPasswordSalt());
                System.out.println("UID: " + user.getUID());
            }else{
                System.out.println("User logged in: " + user.getUsername());
            }
            return user;
        }else{
            return null;
        }
    }
    
    public User getUser(String username) throws SQLException{
        user = DAO.getUserByName(username);
        return user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public int getUID(String userString){
        try {
            return DAO.getUIDByUserString(userString);
        } catch (Exception e) {
        }
        return 0;
    }
}