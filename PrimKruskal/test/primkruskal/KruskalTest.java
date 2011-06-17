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
public class KruskalTest {

    public KruskalTest() {
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

   
   
    @Test
    public void testPaloitteluFunktio(){
    System.out.println("testataan paloittelufunktion eka osa");
    Kruskal kruskali = new Kruskal();
    String paloiteltava = "123,456,678";

    int palautunut = kruskali.paloitteleAlku(paloiteltava, 1);
     System.out.println(palautunut);

    }

     @Test
    public void testPaloitteluFunktioToka(){
    System.out.println("testataan paloittelufunktion toka osa");
    Kruskal kruskali = new Kruskal();
    String paloiteltava = "123,456,678";

    int palautunut = kruskali.paloitteleAlku(paloiteltava, 2);
     System.out.println(palautunut);

    }

         @Test
    public void testPaloitteluFunktioKolmas(){
    System.out.println("testataan paloittelufunktion kolmas osa");
    Kruskal kruskali = new Kruskal();
    String paloiteltava = "123,456,678";

    int palautunut = kruskali.paloitteleAlku(paloiteltava, 3);
     System.out.println(palautunut);

    }

    @Test
    public void testAlustusTiedostosta(){
    System.out.println("testataan verkon alustus tiedostosta");

    Kruskal kruskali = new Kruskal();
    Keko alustettu = kruskali.alustatiedostosta("verkko.txt", 6,6);
    kruskali.SetVerkko(alustettu);
 

    }


    @Test
    public void testLaskeKruskal(){
    System.out.println("Alustetaan tiedostosta ja lasketaan");

    Kruskal kruskali = new Kruskal();
    Keko alustettu = kruskali.alustatiedostosta("verkko.txt", 6,6);
    kruskali.SetVerkko(alustettu);
    kruskali.laskeKruskal();


    }
}