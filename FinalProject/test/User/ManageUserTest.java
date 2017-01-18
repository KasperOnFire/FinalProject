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
        
        ManageUser instance = new ManageUser();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class ManageUser.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");

        String username = "test2";
        String userString = "TRITT7OSQF2GWW0GDK";

        ManageUser instance = new ManageUser();
        String expResult = userString;
        String result = instance.getUser(username).getUserString();
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
