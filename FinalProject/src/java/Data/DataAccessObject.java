package Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import User.User;
import User.Password;
import Collection.Music;
import java.util.ArrayList;
import java.util.Random;


public class DataAccessObject {

    private final DBConnector conn;
    Statement stmt;
    Password pass = new Password();
    
    public DataAccessObject() throws Exception {
        this.conn = new DBConnector();
    }

    public User getUserByName(String username) throws SQLException{
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user where username = '" + username + "';";
        User user = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int UID = rs.getInt("UID");
                String usernameRetrieved = rs.getString("username");
                String passwordRetrieved = rs.getString("password");
                String saltRetrieved = rs.getString("salt");
                String emailRetrieved = rs.getString("email");
                String userString = rs.getString("userstring");
                
                user = new User(UID, usernameRetrieved, passwordRetrieved, saltRetrieved, emailRetrieved, userString);
            }
        } catch (Exception ex) {
        }
        return user;    
    }
    
    public void registerUser(String username, String password, String email) throws SQLException, UnsupportedEncodingException{               
        Statement stmt = conn.getConnection().createStatement();
        String passSalt = pass.getSaltString();
        String sql = "INSERT INTO user (username, email, password, salt, userstring) VALUES ('" + username + "','" + email + "','" + pass.get_SHA_512_SecurePassword(password, passSalt) + "','" + passSalt + "','" + pass.getSaltString() + "')";
        try{
            stmt.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("ERROR : " + e);
        }
    }
    
    public void addAlbum(int UID, String artist, String album) throws SQLException{
        stmt = conn.getConnection().createStatement();
        String sql = "INSERT INTO music VALUES ('" + getNewIdentifier() + "','" + UID + "','" + artist + "','" + album + "')";
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean checkIdentifier(String identifier) throws SQLException{
        stmt = conn.getConnection().createStatement();
        String sql = "SELECT * FROM music WHERE identifier ='" + identifier + "';";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return !rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    private String getNewIdentifier() throws SQLException{
        boolean unique = false;
        String identifier = "";
        while(unique == false){
            identifier = pass.getSaltString();
            if(checkIdentifier(identifier)){
               unique = true; 
            }       
        }
        return identifier;
    }
    
    public void removeAlbum(String identifier) throws SQLException{
        stmt = conn.getConnection().createStatement();
        String sql = "DELETE FROM music WHERE identifier='" + identifier + "';";
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("blin! Cannot remove album : " + e);
        }
    }
    
}
