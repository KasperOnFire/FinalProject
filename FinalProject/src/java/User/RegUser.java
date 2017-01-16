package User;

import Data.DataAccessObject;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegUser {

    DataAccessObject DAO = null;

    public RegUser() {
        try {
            System.out.println("DAO = NEW");
            DAO = new DataAccessObject();
            System.out.println("DAO = OLD");
        } catch (Exception e) {
            System.out.println("Blin : " + e);
        }
    }
      

    
    public void addUser(String username, String password, String email) throws UnsupportedEncodingException{
        System.out.println("Test1");
        try {
            System.out.println("Test2");
            DAO.registerUser(username, password, email);
            System.out.println("Test3");
        } catch (Exception e) {
            System.out.println("ERROR IN RegUser : " + e);
        }
    }
    
    public boolean usernameTaken(String username) throws SQLException{
        if(DAO.getUserByName(username) == null){
            return false;
        }else{
            return true;
        }
    }    
}
