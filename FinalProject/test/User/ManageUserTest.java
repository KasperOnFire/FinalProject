/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class ManageUserTest {
    
    public ManageUserTest() {
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
     * Test of login method, of class ManageUser.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");

        String username = "test2";
        String password = "test2";
        String passString = "ee4abeaf2b3b4f19310a91aef4c7c8e323d45339e18baa998db5b93558128e66ef42b4232ee6cc2b2a6caeed9970f6e579b33758436f0d6af3a7911a6559a40c";
        String salt = "W5RTQB3X2YU2NF41S8   ";
        String email = "test2";
        String userString = "TRITT7OSQF2GWW0GDK";
        
        ManageUser instance = new ManageUser();
        User expResult = new User(3, username, passString, salt, email, userString);
        User result = instance.login(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class ManageUser.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");

        String username = "test2";
        String passString = "ee4abeaf2b3b4f19310a91aef4c7c8e323d45339e18baa998db5b93558128e66ef42b4232ee6cc2b2a6caeed9970f6e579b33758436f0d6af3a7911a6559a40c";
        String salt = "W5RTQB3X2YU2NF41S8";
        String email = "test2";
        String userString = "TRITT7OSQF2GWW0GDK";

        ManageUser instance = new ManageUser();
        User expResult = new User(3, username, passString, salt, email, userString);
        User result = instance.getUser(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUID method, of class ManageUser.
     */
    @Test
    public void testGetUID() {
        System.out.println("getUID");
        String userString = "TRITT7OSQF2GWW0GDK";
        ManageUser instance = new ManageUser();
        int expResult = 3;
        int result = instance.getUID(userString);
        assertEquals(expResult, result);
    }
    
}
