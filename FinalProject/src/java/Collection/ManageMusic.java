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
            System.out.println("ERROR ManageMusic 1:");
            ex.printStackTrace();
        }    
    }
    
    public boolean addAlbum(int UID, String artist, String album){
        try {
            return DAO.addAlbum(UID, artist, album);
        } catch (SQLException ex) {
            System.out.println("ERROR ManageMusic 2:");
            ex.printStackTrace();
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
