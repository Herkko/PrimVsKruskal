/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primkruskal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hjvirola
 */
public class KekoTest {

    public KekoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   
    /**
     * Test of PoistaMinimi method, of class Keko.
     */
    @Test
    public void testPoistaMinimi() {
        System.out.println("PoistaMinimi");
        Keko instance = new Keko();
        Solmu testisolmu = new Solmu();
        testisolmu.setEtaisyys(2);

        int expResult = 2;
        int result = instance.PoistaMinimi();
        assertEquals(expResult, result);
              
    }

    /**
     * Test of insert method, of class Keko.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Solmu uusisolmu = null;
        Keko instance = new Keko();
        instance.insert(uusisolmu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}