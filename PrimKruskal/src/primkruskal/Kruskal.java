
package primkruskal;

import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herkko Virolainen
 */
public class Kruskal {

    Keko KruskalKeko = new Keko();
    int[] pala;
    Solmu[] solmut;
    public static Scanner lukija = new Scanner(System.in);
    int solmuindeksi = 0;
    int solmujenmaara = 0;

    public void Kruskal() {
    }

    //Alusta metodia käytetään jos halutaan lisätä käsin jokin verkko
    public Keko alusta() {

        /* tehdään kysely kuinka monta solmua halutaan lisätä
        ja sitten sen mukaan tehdään taulu ja sitten voi lisätä niin monta solmua
        kuin haluaa?
         *
         */
        System.out.println("kuinka monta solmua haluat lisätä? ");
        int[] KruskalLista = new int[5];
        solmujenmaara = 5;

        for (int i = 0; i < 10; i++) {
            Solmu lisattava = uusiKaari();
            KruskalKeko.KruskalInsert(lisattava);
        }

        return KruskalKeko;
    }

    public Keko alustatiedostosta(String tiedosto, int maara, int tiheys) {
        Keko Kruskali = new Keko();
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

                Solmu uusisolmu = new Solmu();
                uusisolmu.setNimi(alkupiste);
                uusisolmu.setParentTunnus(loppupiste);
                uusisolmu.setEtaisyys(paino);

                Kruskali.KruskalInsert(uusisolmu);
             
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kruskal.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        pala = new int[maara];
        solmut = new Solmu[maara*tiheys];

     //   Kruskali.tulostaKeko();
        return Kruskali;

    }

    public void SetVerkko(Keko asetettava) {
        KruskalKeko = asetettava;

    }

    public void laskeKruskal() {
        int tyhjat = pala.length;
        tyhjat--; 


        while (tyhjat > 0) {
            //poistetaan sen jälkeen solmuja yksi kerrallaan
            Solmu virittava = KruskalKeko.PoistaMinimi();
            int solmuNimi = virittava.getNimi();
            int solmuParentNimi = virittava.getParentTunnus();

            // tapaus missä 2 palaa pitää yhdistää yhteen
            if (pala[solmuNimi] != 0 && pala[solmuParentNimi] != 0 && pala[solmuNimi] != pala[solmuParentNimi]) {
                yhdista(solmuNimi, solmuParentNimi);
                solmut[solmuindeksi] = virittava;
                solmuindeksi++;
                }

            // tapaus missä palaan lisätään solmu
            else if ((pala[solmuNimi] != 0 || pala[solmuParentNimi] != 0) && pala[solmuNimi] != pala[solmuParentNimi] ) {

                if (pala[solmuNimi] != 0) {
                    pala[solmuParentNimi] = solmuNimi;
                    }
                else
                    {
                    pala[solmuNimi] = solmuParentNimi;
                    }

                solmut[solmuindeksi] = virittava;
                solmuindeksi++;
                solmujenmaara--;
            }

            // tapaus jossa verkot kuuluvat jo samaan palaseen
            else if (pala[solmuNimi] != 0 && pala[solmuParentNimi] != 0 && solmuNimi == solmuParentNimi) {
                
            } else if (pala[solmuNimi] == 0 && pala[solmuParentNimi] == 0) {
                pala[solmuNimi] = solmuNimi;
                pala[solmuParentNimi] = solmuNimi;
                solmut[solmuindeksi] = virittava;
                solmuindeksi++;
            }

            pala[virittava.getNimi()] = virittava.getNimi();

            tyhjat = (pala.length-1);

            for (int i = 1; i < pala.length; i++) {
                if (pala[i] != 0) {
                    tyhjat--;
                }

            }


        }

          // tulostaKruskal();

    }

    private Solmu uusiKaari() {
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

    private void yhdista(int arvo, int yhdistettavat) {
        for (int i = 0; i < pala.length; i++) {
            if (pala[i] == yhdistettavat) {
                solmujenmaara--; 
                pala[i] = arvo;
            }
        }

    }

    private void tulostaKruskal() {
    System.out.println("Pienin virittävä puu");
        for (int i = 0; i < solmuindeksi; i++) {
            System.out.print("Mistä: " + (solmut[i]).getNimi() + " Mihin : ");
            System.out.print((solmut[i]).getParentTunnus());
            System.out.print(" paino: ");
            System.out.print((solmut[i]).getEtaisyys() + ", ");
            System.out.println();
        }

    }

    public int paloitteleAlku(String apurivi, int monesko) {

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
}
