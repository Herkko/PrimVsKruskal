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




    @Test
    public void testLuoKeko(){
    Keko uusiKeko = new Keko();    
    }

    /**
     * Test of PoistaMinimi method, of class Keko.
     */
//    @Test
//    public void testPoistaMinimi() {
//        System.out.println("PoistaMinimi");
//        Keko instance = new Keko();
//        Solmu testisolmu = new Solmu();
//        testisolmu.setEtaisyys(2);
//
//        int expResult = 2;
//        int result = instance.PoistaMinimi();
//        assertEquals(expResult, result);
//
//    }





   @Test
    public void testInsertYksi() {
        System.out.println("lisataan yksi solmu");
        Solmu uusisolmu = new Solmu();
        uusisolmu.etaisyysverkkoon=4;
        uusisolmu.setNimi(2);


        Keko instance = new Keko();
        instance.PrimInsert(uusisolmu);
        instance.tulostaKeko();
    }

   @Test
    public void testInsertUseampi() {
        System.out.println("lisataan useampi solmu");

        Keko instance = new Keko();

        for (int i=1; i<10; i++){
        Solmu uusisolmu = new Solmu();
        int etaisyys = (int)(Math.random()*i)*2;
        uusisolmu.etaisyysverkkoon=etaisyys;
        uusisolmu.setNimi(i);
        instance.PrimInsert(uusisolmu);
        }

         instance.tulostaKeko();

    }


   @Test
    public void testInsertSama() {
        System.out.println("lisataan samoja solmuja");

        Keko instance = new Keko();

        for (int i=1; i<3; i++){
        Solmu uusisolmu = new Solmu();
        int etaisyys = (int)(Math.random()*i)*10;
        uusisolmu.etaisyysverkkoon=etaisyys;
        uusisolmu.setNimi(2);
        instance.PrimInsert(uusisolmu);
        }

         instance.tulostaKeko();

    }


   @Test
    public void testUpdate() {
        System.out.println("paivitetaan solmuja");

        Keko instance = new Keko();

       Solmu uusisolmu = new Solmu();
       uusisolmu.setEtaisyys(3);
       uusisolmu.setNimi(2);
      instance.PrimInsert(uusisolmu);

       Solmu paivitettavasolmu = new Solmu();
       paivitettavasolmu.setEtaisyys(2);
       paivitettavasolmu.setNimi(2);
       instance.updateSolmu(paivitettavasolmu);

         instance.tulostaKeko();

    }


//    @Test
//    public void testUpdate() {
//        System.out.println("insert");
//        Solmu uusisolmu = null;
//        Keko instance = new Keko();
//        instance.insert(uusisolmu);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

   @Test
    public void testKruskalInsert() {
        System.out.println("lisataan Kruskal kekoon solmu");
        Keko instance = new Keko();
        Solmu uusisolmu = new Solmu();
        int etaisyys = 2;
        uusisolmu.etaisyysverkkoon=etaisyys;
        uusisolmu.setNimi(2);
        instance.KruskalInsert(uusisolmu);
         instance.tulostaKeko();

    }


    @Test
    public void testKruskalInsertMonta() {
        System.out.println("lisataan Kruskal kekoon solmuja");
        Keko instance = new Keko();

        for (int i =0; i<15; i++){
        Solmu uusisolmu = new Solmu();
        int etaisyys = (int)(Math.random()*i)*10;
        uusisolmu.etaisyysverkkoon=etaisyys;
        uusisolmu.setNimi(i+2);
        instance.KruskalInsert(uusisolmu);

        }
        instance.tulostaKeko();
    }


        @Test
         public void testKruskalpoista() {
        System.out.println("Poistetaan Kruskal keosta solmuja");
        Keko instance = new Keko();


        for (int i =0; i<15; i++){
        Solmu uusisolmu = new Solmu();
        int etaisyys = (int)(Math.random()*i)*10;
        uusisolmu.etaisyysverkkoon=etaisyys;
        uusisolmu.setNimi(i+2);
        instance.KruskalInsert(uusisolmu);

        }
        instance.tulostaKeko();

        for(int i=0; i<10;i++){
            System.out.println("Poistettiin: "+ instance.PoistaMinimi());
        instance.tulostaKeko();
        }



    }


}