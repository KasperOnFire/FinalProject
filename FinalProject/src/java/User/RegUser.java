package User;

import Data.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class RegUser {

    DataAccessObject DAO = null;

    public RegUser() {
        try {
            System.out.println("DAO = NEW");
            DAO = new DataAccessObjectImpl();
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
        } catch (UnsupportedEncodingException | SQLException e) {
            System.out.println("ERROR IN RegUser : " + e);
        }
    }
    
    public boolean usernameTaken(String username){
        try {
            return DAO.getUserByName(username) == null;
        } catch (Exception e) {
            return false;
        }
    }    
}
