package User;

import Data.DataAccessObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class Validate {
    Password pass = new Password();
    DataAccessObject DAO = null;
    User user = null;
    
    private String hashedPassword;
    private boolean loggedIn;
    private boolean debug = true;
    
    public Validate() {
        try {
            DAO = new DataAccessObject();
        } catch (Exception ex) {
        }    
    }
    
//    public String login(String username, String password) throws SQLException{
//        user = DAO.getUserByName(username);
//        
//        try {
//            hashedPassword = pass.get_SHA_512_SecurePassword(password, user.getPasswordSalt());
//        } catch (UnsupportedEncodingException ex) {
//        }
//        
//        if(hashedPassword.equals(user.getPassword())){
//            loggedIn = true;
//            if(debug == true){
//                return "User logged in: " + user.getUsername() + " <br>With the following password: " + user.getPassword() + " <br>And the following salt: " + user.getPasswordSalt();
//            }else{
//                return "User logged in: " + user.getUsername();
//            }
//        }else{
//            loggedIn = false;
//            return "Wrong password!";
//        }
//    }
    
    public User login(String username, String password) throws SQLException{
        user = DAO.getUserByName(username);
        
        try {
            hashedPassword = pass.get_SHA_512_SecurePassword(password, user.getPasswordSalt());
        } catch (Exception e) {
        }
        
        if(hashedPassword.equals(user.getPassword())){
            if(debug == true){
                System.out.println("User logged in: " + user.getUsername() + " <br>With the following password: " + user.getPassword() + " <br>And the following salt: " + user.getPasswordSalt());
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
}