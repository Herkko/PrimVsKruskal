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

 
   @Test
    public void testPrimInsertYksi() {
        System.out.println("lisataan yksi solmu");
        Solmu uusisolmu = new Solmu();
        uusisolmu.etaisyysverkkoon=4;
        uusisolmu.setNimi(2);
        Keko instance = new Keko();
        instance.PrimInsert(uusisolmu);
      
    }

   @Test
    public void testPrimInsertUseampi() {
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
    public void testPrimUpdate() {
        System.out.println("paivitetaan Prim solmuja");

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

   @Test
   public void testPrimUpdateErit(){
   System.out.println("solmutunnus on sama, mutta parentti on eri, joten ei pitäisi päivittyä.");

   }


   @Test
   public void testPrimUpdatesolmunimella(){
          System.out.println("lisataan yksi solmu ja paivitetaan");
         Solmu ekasolmu = new Solmu();
         ekasolmu.setNimi(3);
         ekasolmu.setEtaisyys(4);


        Solmu uusisolmu = new Solmu();
        uusisolmu.setEtaisyys(7);
        uusisolmu.setNimi(2);
        uusisolmu.setParentTunnus(1);

        Keko instance = new Keko();
        instance.PrimInsert(uusisolmu);
        instance.PrimInsert(ekasolmu);


        instance.tulostaKeko();
        instance.updateSolmuNumero(2, 2, 3);
        instance.tulostaKeko();
        instance.PoistaMinimi();
        instance.tulostaKeko();

   }

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
       // instance.tulostaKeko();
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
            System.out.println("Poistettiin: "+ (instance.PoistaMinimi()).getNimi() );
        instance.tulostaKeko();
        }

    }


        @Test
        public void testKruskalPoistaMinimi(){
        System.out.println("poistetaan kruskal keosta solmu");
        Keko instance = new Keko();

        for (int i=1; i<6; i++){
        Solmu uusisolmu = new Solmu();
        uusisolmu.setEtaisyys(i*2);
        uusisolmu.setNimi(i);
        instance.KruskalInsert(uusisolmu);
        }
        instance.tulostaKeko();
        instance.heapify(1);
        instance.tulostaKeko();

        }


        @Test
        public void SwapTest(){
        System.out.println("swap test");
          Keko instance = new Keko();

        for (int i=1; i<6; i++){
        Solmu uusisolmu = new Solmu();
        uusisolmu.setEtaisyys(i*2);
        uusisolmu.setNimi(i);
        instance.KruskalInsert(uusisolmu);
        }
        instance.tulostaKeko();
        instance.swap(1, 2);
        instance.tulostaKeko();

        }

}