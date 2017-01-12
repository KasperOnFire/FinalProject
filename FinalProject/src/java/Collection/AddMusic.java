package Collection;

import Data.DataAccessObject;
import java.sql.SQLException;

public class AddMusic {

    DataAccessObject DAO = null;
      
    public AddMusic() {
        try {
            DAO = new DataAccessObject();
        } catch (Exception ex) {
        }    
    }
    
    public void addMusic(int UID, String artist, String album, String image, int year, String song, int time) throws SQLException{
        DAO.addSong(UID, artist, album, image, year, song, time);
    }
    
}
