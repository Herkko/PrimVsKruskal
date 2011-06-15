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
public class PrimTest {

    public PrimTest() {
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
     * Test of laskePrim method, of class Prim.
     */
    @Test
    public void testLaskePrim() {
        System.out.println("laskePrim");
        Prim instance = new Prim();
        instance.alustatiedostosta("verkko.txt");
        instance.laskePrim();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of alustatiedostosta method, of class Prim.
     */
    @Test
    public void testAlustatiedostosta() {
        System.out.println("PrimKeko alustatiedostosta");
        String tiedosto = "verkko.txt";
        Prim instance = new Prim();

        Keko result = instance.alustatiedostosta(tiedosto);
 
    }

}