package Data;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import User.User;
import User.Password;
import Collection.Music;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DataAccessObjectImpl implements DataAccessObject {

    private final DBConnector conn;
    PreparedStatement stmt;
    Password pass = new Password();

    public DataAccessObjectImpl() throws Exception {
        this.conn = new DBConnector();
    }

    @Override
    public User getUserByName(String username) throws SQLException {
        User user = null;
        try {
            stmt = conn.getConnection().prepareStatement("SELECT * FROM user WHERE username = (?);");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int UID = rs.getInt("UID");
                String usernameRetrieved = rs.getString("username");
                String passwordRetrieved = rs.getString("password");
                String saltRetrieved = rs.getString("salt");
                String emailRetrieved = rs.getString("email");
                String userString = rs.getString("userstring");

                user = new User(UID, usernameRetrieved, passwordRetrieved, saltRetrieved, emailRetrieved, userString);
            }
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public int getUIDByUserString(String userString) throws SQLException {
        int UID = 0;
        try {
            stmt = conn.getConnection().prepareStatement("SELECT UID FROM user WHERE userstring = (?);");
            stmt.setString(1, userString);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                UID = rs.getInt("UID");
            }
        } catch (Exception e) {
        }
        return UID;
    }

    @Override
    public ArrayList<Music> getAlbumByUID(int UID) throws SQLException {
        ArrayList<Music> albumCollection = new ArrayList();
        try {
            stmt = conn.getConnection().prepareStatement("SELECT * FROM music WHERE UID = (?);");
            stmt.setInt(1, UID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Music music = null;
                String identifier = rs.getString("identifier");
                String album = rs.getString("album");
                String artist = rs.getString("artist");
                music = new Music(UID, identifier, artist, album);
                albumCollection.add(music);
            }
        } catch (Exception e) {
        }
        albumCollection.sort((o1, o2) -> o1.getArtist().compareTo(o2.getArtist()));
        return albumCollection;
    }

    @Override
    public void registerUser(String username, String password, String email) throws SQLException, UnsupportedEncodingException {
        try {
            String passSalt = pass.getSaltString();
            stmt = conn.getConnection().prepareStatement("INSERT INTO user (username, email, password, salt, userstring) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, pass.get_SHA_512_SecurePassword(password, passSalt));
            stmt.setString(4, passSalt);
            stmt.setString(5, pass.getSaltString());
            stmt.executeUpdate();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public boolean addAlbum(int UID, String artist, String album) throws SQLException {
        try {
            stmt = conn.getConnection().prepareStatement("INSERT INTO music VALUES (?, ?, ?, ?)");
            stmt.setString(1, getNewIdentifier());
            stmt.setInt(2, UID);
            stmt.setString(3, artist);
            stmt.setString(4, album);
            stmt.executeUpdate();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    private boolean checkIdentifier(String identifier) throws SQLException {
        try {
            stmt = conn.getConnection().prepareStatement("SELECT * FROM music WHERE identifier = (?);");
            stmt.setString(1, identifier);
            ResultSet rs = stmt.executeQuery();
            return !rs.next();
        } catch (Exception e) {
        }
        return false;
    }

    private String getNewIdentifier() throws SQLException {
        boolean unique = false;
        String identifier = "";
        while (unique == false) {
            identifier = pass.getSaltString();
            if (checkIdentifier(identifier)) {
                unique = true;
            }
        }
        return identifier;
    }

    @Override
    public void removeAlbum(String identifier) throws SQLException {
        try {
            stmt = conn.getConnection().prepareStatement("DELETE FROM music WHERE identifier = (?);");
            stmt.setString(1, identifier);
            stmt.executeUpdate();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
