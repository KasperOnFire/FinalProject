package Collection;

import Data.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageMusic {

    DataAccessObject DAO = null;
      
    public ManageMusic() {
        try {
            DAO = new DataAccessObjectImpl();
        } catch (Exception ex) {
        }    
    }
    
    public boolean addAlbum(int UID, String artist, String album){
        try {
            return DAO.addAlbum(UID, artist, album);
        } catch (SQLException ex) {
            System.out.println("BLIN <.<");
            return false;
        }
    }
    
    public void removeAlbum(String identifier) throws SQLException{
        DAO.removeAlbum(identifier);
    }
    
    public ArrayList<Music> getAlbums(int UID) throws SQLException{
        return DAO.getAlbumByUID(UID);
    }
    
}
