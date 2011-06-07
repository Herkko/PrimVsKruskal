package primkruskal;

/**
 *
 * @author Herkko
 */
public class Keko {

    Solmu[] keko = new Solmu[100];
    int top;
    int heapSize;
    Solmu[] solmulista = new Solmu[1000];
    int solmujenmaara = 0;

    public void Keko() {
        heapSize = 1000;
        keko = new Solmu[heapSize];
        top = 1;
        solmulista = new Solmu[heapSize];
        Solmu parent = new Solmu();
        parent.setPaikkakeossa(0);
        parent.setEtaisyys(1000);
        keko[0] = parent;
    }

    public void Keko(int maara) {
        heapSize = maara;
        keko = new Solmu[heapSize];
        top = 0;
        solmulista = new Solmu[heapSize];
    }

    //onko tarvetta  palauttaa olio vai pelkästään arvo?
    public int PoistaMinimi() {
     
        Solmu minimi = keko[1];
        keko[1] = keko[top];
        top--;

        //Toimiiko oikeasti?
        int poistettava = minimi.tunnus;
        solmulista[poistettava] = null;
        heapify(1);

        return minimi.getEtaisyys();
    }

    private void heapify(int indeksi) {

        if ((indeksi * 2 + 1) < top) {
            //tarkistettava ettei tule nullpointteri, kun menee yli

            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int oikeankoko = (keko[(indeksi * 2 + 1)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();

            if (tarkistettavasolmu < Math.max(vasemmankoko, oikeankoko)) {
                swap(tarkistettavasolmu, Math.max(vasemmankoko, oikeankoko));
                heapify(Math.max(vasemmankoko, oikeankoko));
            }
        } else if ((indeksi * 2) == top) {
            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();
            if (tarkistettavasolmu < vasemmankoko) {
                swap(tarkistettavasolmu, vasemmankoko);
                //tahan ei varmaan tarvitse enaa heapifya, koska oikeaa lastakaan ei ole.
            }

        }

    }

    public void PrimInsert(Solmu uusisolmu) {
        int solmuTunnus = uusisolmu.getNimi();

        if (solmulista[1] == uusisolmu) {
            updateSolmu(uusisolmu);
        }
        else {

            if (solmujenmaara > 0) {
                solmujenmaara++;
                this.top++;

                solmulista[solmuTunnus] = uusisolmu;
                keko[top] = uusisolmu;
                
                int solmu = top;
                int solmuParent = top / 2; // jos eka, niin ei parenttia. null pointter

                Solmu vertailtavalapsi = keko[top];
                Solmu vertailtavaParent = keko[solmuParent];

                while ((vertailtavalapsi.getEtaisyys()) > (vertailtavaParent.getEtaisyys()) && (vertailtavaParent.getPaikka()) > 1) {
                    swap(vertailtavalapsi.paikkaKeossa, vertailtavaParent.paikkaKeossa);
                    int uusiVanhempi = ((vertailtavalapsi.paikkaKeossa) / 2);
                    vertailtavaParent = keko[uusiVanhempi];
                }
            } else {
                keko[top] = uusisolmu;
                top++;
            }
        }
    }


    public void KruskalInsert(Solmu uusisolmu){
    this.top++;
    keko[top] = uusisolmu;
    int parent = top/2;
    int child = top;

    if(top>3){

        while((keko[parent]).getEtaisyys() > ((keko[child]).getEtaisyys()) && parent!=1  ){
        swap(parent, child);
        parent = (parent/2);
        child = (child/2);
        }
    }

    }



    private void swap(int solmu, int lapsi) {
        Solmu valiaikainenLapsi = keko[lapsi];
        Solmu valiaikainenSolmu = keko[solmu];

        valiaikainenLapsi.setPaikkakeossa(solmu); //paivitetaan paikkakeossa arvoa.
        valiaikainenSolmu.setPaikkakeossa(lapsi);

        //paivitettava vielä parent arvot

        keko[lapsi] = valiaikainenSolmu;
        keko[solmu] = valiaikainenLapsi;

    }

    public void tulostaKeko() {

        for (int i = 1; i < top; i++) {
            System.out.print("[" +(keko[i]).getNimi() + "]" );
            System.out.print((keko[i]).getEtaisyys()+ ", "   );

        }
        System.out.println();
    }

    public void updateSolmu(Solmu uusiSolmu) {
        int solmutunnus = uusiSolmu.getNimi();
        Solmu paivitettava = solmulista[solmutunnus];
        int paivitettavaEtaisyys = paivitettava.getEtaisyys(); // tällä hetkellä ei saa oikeaa viitettä taulukosta
        int uusietaisyys = paivitettava.getEtaisyys();


        if ((paivitettava.getEtaisyys()) > (uusiSolmu.getEtaisyys())) {
            paivitettava.setEtaisyys(uusiSolmu.getEtaisyys());

            Solmu paivitettavaParent = paivitettava.getParent();


            while (paivitettavaParent.getEtaisyys() < paivitettava.getEtaisyys() && paivitettava.paikkaKeossa > 1) {
                swap(paivitettava.paikkaKeossa, paivitettavaParent.paikkaKeossa);
            }

        }



    }
}
