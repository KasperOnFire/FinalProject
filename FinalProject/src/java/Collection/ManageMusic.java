package Collection;

import Data.DataAccessObject;
import java.sql.SQLException;

public class ManageMusic {

    DataAccessObject DAO = null;
      
    public ManageMusic() {
        try {
            DAO = new DataAccessObject();
        } catch (Exception ex) {
        }    
    }
    
    public void addAlbum(int UID, String artist, String album) throws SQLException{
        DAO.addAlbum(UID, artist, album);
    }
    
    public void removeAlbum(String identifier){
        DAO.removeAlbum(identifier);
    }
    
}
