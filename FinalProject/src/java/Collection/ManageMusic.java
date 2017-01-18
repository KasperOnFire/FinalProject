package Collection;

import Data.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMusic {

    DataAccessObject DAO = null;
      
    public ManageMusic() {
        try {
            DAO = new DataAccessObjectImpl();
        } catch (Exception ex) {
        }    
    }
    
    public boolean addAlbum(int UID, String artist, String album) throws SQLException{
        return DAO.addAlbum(UID, artist, album);
    }
    
    public void removeAlbum(String identifier) throws SQLException{
        DAO.removeAlbum(identifier);
    }
    
    public ArrayList<Music> getAlbums(int UID) throws SQLException{
        return DAO.getAlbumByUID(UID);
    }
    
}
