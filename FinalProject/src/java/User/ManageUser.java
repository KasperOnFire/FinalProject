package User;

import Data.*;
import java.sql.SQLException;

public class ManageUser {

    Password pass = new Password();
    DataAccessObject DAO = null;
    User user = null;

    private boolean loggedIn;
    private String hashedPassword;
    private boolean debug = false;

    public ManageUser() {
        try {
            DAO = new DataAccessObjectImpl();
        } catch (Exception ex) {
            System.out.println("ERROR ManageUser 1:");
            ex.printStackTrace();
        }
    }

    public User login(String username, String password) {
        try {
            user = DAO.getUserByName(username);
        } catch (Exception e) {
            System.out.println("ERROR ManageUser 2:");
            e.printStackTrace();
        }
        loggedIn = false;

        try {
            hashedPassword = pass.get_SHA_512_SecurePassword(password, user.getPasswordSalt());
        } catch (Exception e) {
            System.out.println("ERROR ManageUser 3:");
            e.printStackTrace();
        }
        if (user != null) {
            if (hashedPassword.equals(user.getPassword())) {
                if (debug == true) {
                    System.out.println("User logged in: " + user.getUsername() + " With the following password: " + user.getPassword() + " And the following salt: " + user.getPasswordSalt());
                    System.out.println("UID: " + user.getUID());
                } else {
                    System.out.println("User logged in: " + user.getUsername());
                }
                loggedIn = true;
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public User getUser(String username) throws SQLException {
        user = DAO.getUserByName(username);
        return user;
    }

    public int getUID(String userString) {
        try {
            return DAO.getUIDByUserString(userString);
        } catch (Exception e) {
            System.out.println("ERROR ManageUser 4:");
            e.printStackTrace();
        }
        return 0;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
