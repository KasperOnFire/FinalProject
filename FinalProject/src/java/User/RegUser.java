package User;

import Data.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class RegUser {

    DataAccessObject DAO = null;

    public RegUser() {
        try {
            DAO = new DataAccessObjectImpl();
        } catch (Exception e) {
            System.out.println("ERROR RegUser 1:");
            e.printStackTrace();
        }
    }

    public void addUser(String username, String password, String email) throws UnsupportedEncodingException {
        try {
            DAO.registerUser(username, password, email);
        } catch (UnsupportedEncodingException | SQLException e) {
            System.out.println("ERRORRegUser 2:");
            e.printStackTrace();
        }
    }

    public boolean usernameTaken(String username) {
        try {
            return DAO.getUserByName(username) == null;
        } catch (Exception e) {
            System.out.println("ERROR ManageMusic 3:");
            e.printStackTrace();
            return false;
        }
    }
}
