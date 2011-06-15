/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primkruskal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herkko
 */
public class Prim {
int solmujenmaara;
int kaarienmaara;
Vieruslista Lista;
Keko PrimKeko;
Solmu[] solmut;
public static Scanner lukija = new Scanner(System.in);

    public void Prim(){

    }

    public void laskePrim(){
    solmujenmaara =  Lista.haeSolmut();
    int indeksi = 1;
    int poistettunimi=1;

    while (indeksi<solmujenmaara){
    int[] kaarilista = Lista.haeKaaret(poistettunimi);

    for(int i=0; i<kaarilista.length-1; i++){
    int solmu = kaarilista[i];
    int paino = kaarilista[(i+1)];
    PrimKeko.updateSolmuNumero(solmu,poistettunimi, paino);
    i++;
  
    }
    Solmu poistettu = PrimKeko.PoistaMinimi();
    solmut[poistettu.getNimi()] = poistettu;
    // nyt kaikki solmut löytyy listasta ja solmusta löytyy tieto parentista.
    // jolloin voidaan muodostaa tieto siitä mistä ja minne on menty.
    poistettunimi = poistettu.getNimi();
    indeksi++;

//    PrimKeko.tulostaKeko();
//    for (int i=0; i<kaarilista.length; i++){
//        System.out.print(kaarilista[i]);
//    }
//    System.out.println();

    }





//    Solmu nulli = PrimKeko.PoistaMinimi();
//    solmut[0] = nulli;
//
//    while(nulli != null ){
//    nulli = PrimKeko.PoistaMinimi();
//    if(nulli!= null)  solmut[indeksi] = nulli;
//    indeksi++;
//
//    }
//    solmujenmaara=indeksi;
    tulostaPrimi();

    }

    public Keko alustatiedostosta(String tiedosto){
           
        PrimKeko = new Keko();
        Lista = new Vieruslista();

        File tiedostosta = new File(tiedosto);
        Scanner syottotiedosto;
        try {
            syottotiedosto = new Scanner(tiedostosta);
            while (syottotiedosto.hasNextLine()) {
                String rivi = syottotiedosto.nextLine();
                String apurivi = rivi.toLowerCase();   //  samaistetaan isot ja pienet
                int alkupiste = paloitteleAlku(apurivi, 1);
                int loppupiste = paloitteleAlku(apurivi, 2);
                int paino = paloitteleAlku(apurivi, 3);
              //  System.out.println("alku: " +alkupiste + " loppu: " + loppupiste+ " paino: " +paino);
                Lista.lisaaKaari(alkupiste, loppupiste, paino);


            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kruskal.class.getName()).log(Level.SEVERE, null, ex);
        }

       int solmumaara = Lista.haeSolmut();

       for(int i=1; i<solmumaara+1; i++){
       Solmu uusisolmu = new Solmu();
       uusisolmu.setNimi(i);
       uusisolmu.setEtaisyys(Integer.MAX_VALUE);
       PrimKeko.PrimInsert(uusisolmu);
       }

        //PrimKeko.tulostaKeko();
        solmut = new Solmu[solmumaara+1];

        return PrimKeko;

    }
    
    
     private int paloitteleAlku(String apurivi, int monesko) {

        if (monesko == 1) {
            int indeksi = apurivi.indexOf(',');

            String alkuosa = apurivi.substring(0, indeksi);
            int alku = Integer.parseInt(alkuosa);
            return alku;
        }

        if (monesko == 2) {
            int indeksi = apurivi.indexOf(',');
            indeksi++;
            String loppuosa = apurivi.substring(indeksi);
            indeksi = loppuosa.indexOf(',');
            loppuosa = loppuosa.substring(0, indeksi);
            int alku = Integer.parseInt(loppuosa);
            return alku;
        }

        if (monesko == 3) {
            int indeksi = apurivi.indexOf(',');
            indeksi++;
            String loppuosa = apurivi.substring(indeksi);
            indeksi = loppuosa.indexOf(',');
            indeksi++;
            loppuosa = loppuosa.substring(indeksi);
            int numero = Integer.parseInt(loppuosa);
            return numero;
        }


        return -1;
    }

    private void tulostaPrimi() {

      for (int i=0; i<solmujenmaara+1; i++){
            if(solmut[i]!= null){
            System.out.print("Mistä: " + (solmut[i]).getParentTunnus() + " Mihin : ");
            System.out.print((solmut[i]).getNimi());
            System.out.print(" paino: ");
            System.out.print((solmut[i]).getEtaisyys() + ", ");
            System.out.println();
            }
      }

    }

}
