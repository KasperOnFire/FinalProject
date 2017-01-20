package Collection;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManageMusicTest {
    
    public ManageMusicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAlbum method, of class ManageMusic.
     */
    @Test
    public void testAddAlbum() throws Exception {
        System.out.println("addAlbum");
        int UID = 1;
        String artist = "jUnit";
        String album = "jUnit";
        ManageMusic instance = new ManageMusic();
        boolean result = instance.addAlbum(UID, artist, album);
        assertEquals(true, result);
    }

    /**
     * 
     * Test of removeAlbum method, of class ManageMusic.
     */
    @Test
    public void testRemoveAlbum() throws Exception {
        ManageMusic instance = new ManageMusic();
        System.out.println("removeAlbum");
        String identifier = instance.getAlbums(1).get(0).getIdentifier();
        System.out.println("Identifier : " + identifier);
        instance.removeAlbum(identifier);
        assertEquals(0, instance.getAlbums(1).size());
    }

    /**
     * Test of getAlbums method, of class ManageMusic.
     */
    @Test
    public void testGetAlbums() throws Exception {
        System.out.println("getAlbums");
        ManageMusic instance = new ManageMusic();
        ArrayList<Music> result = instance.getAlbums(1);
        assertEquals(1, result.size());
    }    
}