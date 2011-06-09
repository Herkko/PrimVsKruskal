/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primkruskal;
import java.util.Scanner;
/**
 *
 * @author hjvirola
 */
public class Kruskal {
Keko KruskalKeko = new Keko();
int[] pala = new int[1000];
Solmu[] solmut = new Solmu[1000];
public static Scanner lukija = new Scanner(System.in);
int solmuindeksi=0;
int solmujenmaara=0;


    public void Kruskal(){

    /* tehdään kysely kuinka monta solmua halutaan lisätä
    ja sitten sen mukaan tehdään taulu ja sitten voi lisätä niin monta solmua
    kuin haluaa?
    */
    System.out.println("kuinka monta solmua haluat lisätä? ");
    int[] KruskalLista = new int[5];
    solmujenmaara=5;

     // lisätään ensin kekoon solmuja.. vaihda whileksi 
    for (int i=0; i<10; i++){
       Solmu lisattava = uusiKaari(); 
       KruskalKeko.KruskalInsert(lisattava);
    }

    //poistetaan sen jälkeen solmuja yksi kerrallaan
     Solmu virittava = KruskalKeko.PoistaMinimi();
     int solmuNimi= virittava.getNimi();
     int solmuParentNimi = virittava.getParentTunnus();

     // tapaus missä 2 palaa pitää yhdistää yhteen
     if (pala[solmuNimi]!=0 && pala[solmuParentNimi]!=0 && solmuNimi != solmuParentNimi ){
     yhdista(solmuNimi, solmuParentNimi);
     solmut[solmuindeksi]=virittava;
     solmuindeksi++;
     }

     // tapaus missä palaan lisätään solmu
     else if (pala[solmuNimi]!=0 || pala[solmuParentNimi]!=0 ){

         if (pala[solmuNimi]!=0) pala[solmuParentNimi]=solmuNimi;
         else pala[solmuNimi] = solmuParentNimi;
         solmut[solmuindeksi]=virittava;
         solmuindeksi++;
         solmujenmaara--;
     }

     // tapaus jossa verkot kuuluvat jo samaan palaseen
     else if (pala[solmuNimi]!=0 && pala[solmuParentNimi]!=0 && solmuNimi == solmuParentNimi ){
     // tarvitseeko tehdä mitään?
     }

     else if (pala[solmuNimi]==0 && pala[solmuParentNimi]==0 ){
     pala[solmuNimi]=solmuNimi;
     pala[solmuParentNimi] = solmuNimi;
     solmut[solmuindeksi] = virittava;
     solmuindeksi++;
     }

     pala[virittava.getNimi()] = virittava.getNimi();


     tulostaKruskal();

    }

    private Solmu uusiKaari(){
    System.out.println("anna lähtöpiste: ");
    int lahtopiste = lukija.nextInt();
    System.out.println("Anna loppupiste: ");
    int loppupiste = lukija.nextInt();
    System.out.println("Anna paino; ");
    int paino = lukija.nextInt();

    Solmu uusisolmu = new Solmu();
    uusisolmu.setNimi(lahtopiste);
    uusisolmu.setParentTunnus(loppupiste);
    uusisolmu.setEtaisyys(paino);

    return uusisolmu;
    }


    private void yhdista(int arvo, int yhdistettavat){
    for (int i=0; i<pala.length; i++){
    if (pala[i] == yhdistettavat) {
        solmujenmaara--; // ei toimi näin :(
        pala[i]=arvo;
    }
    }

    }

    private void tulostaKruskal(){

    for (int i=0; i<solmut.length; i++){
      System.out.print("Mistä: " +(solmut[i]).getNimi() + " Mihin : " );
      System.out.print((solmut[i]).getParent() );
      System.out.print(" paino: ");
      System.out.print((solmut[i]).getEtaisyys()+ ", "   );
    }

    }


}
