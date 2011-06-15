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
 * @author herkko
 */
public class VieruslistaTest {

    public VieruslistaTest() {
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
     * Test of vieruslista method, of class Vieruslista.
     */
    @Test
    public void testVieruslista() {
        System.out.println("vieruslista");
        Vieruslista instance = new Vieruslista();
        instance.vieruslista();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of lisaaKaari method, of class Vieruslista.
     */
    @Test
    public void testLisaaKaari() {
        System.out.println("lisaaKaari");
        int alku = 1;
        int loppu = 2;
        int paino = 3;
        Vieruslista instance = new Vieruslista();
        instance.lisaaKaari(alku, loppu, paino);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of haeKaaret method, of class Vieruslista.
     */
    @Test
    public void testHaeKaaret() {
        System.out.println("haeKaaret");
        int alku = 0;
        Vieruslista instance = new Vieruslista();
        instance.lisaaKaari(1, 2, 1);
        instance.lisaaKaari(1, 3, 5);
        instance.lisaaKaari(2, 3, 3);


       
        int[] result = instance.haeKaaret(1);
        for (int i=0; i<result.length; i++){
            System.out.print(result[i]);
            System.out.print(", ");
            System.out.println(result[i+1]);
            i++;
        }



    }

    /**
     * Test of haeSolmut method, of class Vieruslista.
     */
    @Test
    public void testHaeSolmut() {
        System.out.println("haeSolmut");
        Vieruslista instance = new Vieruslista();
        instance.lisaaKaari(1, 2, 1);
        instance.lisaaKaari(1, 3, 5);
        instance.lisaaKaari(2, 3, 3);
        int expResult = 3;
        int result = instance.haeSolmut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

}