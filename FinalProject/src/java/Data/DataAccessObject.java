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
    
//    public Product getProduct(String productName){
//        Statement stmt = null;
//        try {
//            stmt = conn.getConnection().createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "select * from gsprice where product = '" + productName + "'";
//        Product product = null;
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                int price = rs.getInt("Price");
//                String productRetrieved = rs.getString("Product");
//                product = new Product(productRetrieved, price);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return product;    
//    }

    public User getUserByName(String username) throws SQLException{
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from gsusers where username = '" + username + "';";
        User user = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String usernameRetrieved = rs.getString("username");
                String passwordRetrieved = rs.getString("password");
                String saltRetrieved = rs.getString("salt");
                String emailRetrieved = rs.getString("email");
                int phoneNoRetrieved = rs.getInt("PhoneNo");
                
                user = new User(usernameRetrieved, passwordRetrieved, saltRetrieved, emailRetrieved, phoneNoRetrieved);
            }
        } catch (Exception ex) {
        }
        return user;    
    }
    
    public void registerUser(String username, String password, String email) throws SQLException, UnsupportedEncodingException{               
        Statement stmt = conn.getConnection().createStatement();
        String passalt = pass.getSaltString();
        String sql = "INSERT INTO user (username, email, password, salt) VALUES ('" + username + "','" + email + "','" + pass.get_SHA_512_SecurePassword(password, passalt) + "','" + passalt + "')"; //NULLPOINTER HER AF EN ELLER ANDEN GRUND!
        System.out.println("Test add user");
        System.out.println(sql);
        try{
            System.out.println("before user is added!");
            stmt.executeUpdate(sql);
            System.out.println("User added! Username : " + username);
        }catch(Exception e){
            System.out.println("ERROR : " + e);
        }
    }
    
    public void addSong(int UID, String artist, String album, String image, int year, String song, int time) throws SQLException{
        stmt = conn.getConnection().createStatement();
        String sql = "INSERT INTO music VALUES ('" + UID + "','" + artist + "','" + album + "','" + image + "','" + year + "','" + song + "','" + time + "')";
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void makeTable(String username) throws SQLException{
//        Statement stmt = conn.getConnection().createStatement();
//        String sqlMusic = "CREATE TABLE `collection`.`" + username + "_music` (`album` VARCHAR(255), `artist` VARCHAR(255), `image` VARCHAR(255), `year` int(255);";
//        //String sqlMovie = "CREATE TABLE `collection`.`" + username + "_movie` ( )";
//        try{
//            System.out.println("BLIN!");
//            stmt.executeUpdate(sqlMusic);
//        }catch(Exception e){
//            System.out.println("Error making user_music_table : " + e);
//        }
//    }    
}

//    public Order addOrder(String username, double width, double height, double glassBasePrice, double glassPrice, String frameType, double framePrice, double totalPrice) throws SQLException, UnsupportedEncodingException{               
//        Statement stmt = conn.getConnection().createStatement();
//        String sql = "INSERT INTO gsorders (Username, Width, Height, glassBasePrice, glassPrice, frameType, framePrice, totalPrice) VALUES ('" + username + "', '" + width + "', '" + height + "', '" + glassBasePrice + "', '" + glassPrice + "', '" + frameType + "', '" + framePrice + "', '" + totalPrice + "')";
//        Order order = null;
//        try{
//            stmt.executeUpdate(sql);
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        return order;
//    }
//    
//    public ArrayList<Order> getOrdersByUser(String username){
//        Statement stmt = null;
//        try {
//            stmt = conn.getConnection().createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql = "select * from gsorders where username = '" + username + "'";
//        ArrayList<Order> orders = new ArrayList<Order>();
//        Order order = null;
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                int orderID = rs.getInt("orderID");
//                String usernameRetrieved = rs.getString("username");
//                double width = rs.getDouble("width");
//                double height = rs.getDouble("height");
//                double glassBasePrice = rs.getDouble("glassBasePrice");
//                double glassPrice = rs.getDouble("glassPrice");
//                String frameType = rs.getString("frameType");
//                double framePrice = rs.getDouble("framePrice");
//                double totalPrice = rs.getDouble("totalPrice");
//                order = new Order(orderID, usernameRetrieved, width, height, glassBasePrice, glassPrice, frameType, framePrice, totalPrice);                
//                orders.add(order);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return orders;
//    }
//}
