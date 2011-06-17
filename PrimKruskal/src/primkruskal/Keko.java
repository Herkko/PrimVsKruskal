package primkruskal;

/**
 *
 * @author Herkko Virolainen
 */
public class Keko {

    Solmu[] keko = new Solmu[1000000];
    int top;
    int heapSize;
    Solmu[] solmulista = new Solmu[10001];
    int solmujenmaara = 0;

    public void Keko() {
        heapSize = 10001;
        keko = new Solmu[heapSize];
        top = 0;
        solmulista = new Solmu[heapSize];
        Solmu parent = new Solmu();
        parent.setPaikkakeossa(0);
        parent.setEtaisyys(1000);
        keko[0] = parent;
    }

    public Solmu PoistaMinimi() {
     if(top==0)return null;
        Solmu minimi = keko[1];
        top--;
        keko[1] = keko[top];
        

     
        int poistettava = minimi.tunnus;
        solmulista[poistettava] = null;
        heapify(1);

       // tulostaKeko();
        return minimi;
    }


    public void heapify(int indeksi) {

        if ((indeksi * 2 + 1) < top) {
         
            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int oikeankoko = (keko[(indeksi * 2 + 1)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();


            if (tarkistettavasolmu > (Math.min(vasemmankoko, oikeankoko))) {
                
                if (vasemmankoko<oikeankoko) {
                    swap(indeksi, (indeksi*2));
                    heapify((indeksi*2));
                }          
                
                else {
                swap(indeksi, (indeksi*2+1));
                heapify(indeksi*2+1);
                }
               
            }

        } else if ((indeksi * 2) < top) {
            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();
            if (tarkistettavasolmu > vasemmankoko) {
                
                swap(indeksi, (indeksi*2));
           }

        }

    }

    public void PrimInsert(Solmu uusisolmu) {
        int solmuTunnus = uusisolmu.getNimi();

            if (solmujenmaara > 1) {
                

                solmulista[solmuTunnus] = uusisolmu;
                keko[top] = uusisolmu;
                
                int solmu = top;
                int solmuParent = top / 2; // jos eka, niin ei parenttia. null pointter

                Solmu vertailtavalapsi = keko[top];
                Solmu vertailtavaParent = keko[solmuParent];
                uusisolmu.setPaikkakeossa(top);
                
                while ((vertailtavalapsi.getEtaisyys()) < (vertailtavaParent.getEtaisyys()) && (vertailtavaParent.getPaikka()) > 1) {
                    swap(vertailtavalapsi.paikkaKeossa, vertailtavaParent.paikkaKeossa);
                    int uusiVanhempi = ((vertailtavalapsi.paikkaKeossa) / 2);
                    vertailtavaParent = keko[uusiVanhempi];
                }
                solmujenmaara++;
                this.top++;

            } else {
                keko[top] = uusisolmu;
                solmulista[solmuTunnus]=uusisolmu;
                uusisolmu.setPaikkakeossa(top);
                top++;
                solmujenmaara++;

            }
        }
    
    public void KruskalInsert(Solmu uusisolmu){
    this.top++;
    keko[top] = uusisolmu;
    int parent = top/2;
    int child = top;

   if(parent>0 && child>0){

        while((keko[parent]).getEtaisyys() > ((keko[child]).getEtaisyys())  ){
        swap(parent, child);
        parent = (parent/2);
        child = (child/2);

        if (parent<1 || child<1) break;
        }
  
   }

    }



    public void swap(int solmu, int lapsi) {
        Solmu valiaikainenLapsi = keko[lapsi];
        Solmu valiaikainenSolmu = keko[solmu];

        valiaikainenLapsi.setPaikkakeossa(solmu); 
        valiaikainenSolmu.setPaikkakeossa(lapsi);

        keko[lapsi] = valiaikainenSolmu;
        keko[solmu] = valiaikainenLapsi;

    }

    public void tulostaKeko() {
        //vähän eri versio pitäisi olla Kruskalille ja Primille :D
        //Kruskal 1 ja Prim 0.
        for (int i = 1; i < top; i++) {
            System.out.print("[" +(keko[i]).getNimi() + "]" );
            System.out.print((keko[i]).getEtaisyys()+ ", "   );

        }
        System.out.println();
    }

    // tätä ei tässä versiossa oikeasti edes käytetä missään vaiheessa.
    public void updateSolmu(Solmu solmu) {
        int solmutunnus = solmu.getNimi();
        Solmu paivitettava = solmulista[solmutunnus];
        int paivitettavaEtaisyys = solmu.getEtaisyys(); 
        int uusietaisyys = paivitettava.getEtaisyys();


        if ((paivitettava.getEtaisyys()) > (solmu.getEtaisyys())) {
            paivitettava.setEtaisyys(solmu.getEtaisyys());



                Solmu vertailtavaParent = solmulista[paivitettava.parentTunnus];

                if (solmujenmaara>1){
                while ((paivitettava.getEtaisyys()) < (vertailtavaParent.getEtaisyys()) && (vertailtavaParent.getPaikka()) > 1) {
                    swap(paivitettava.paikkaKeossa, vertailtavaParent.paikkaKeossa);
                    int uusiVanhempi = ((paivitettava.paikkaKeossa) / 2);
                    vertailtavaParent = keko[uusiVanhempi];
                   }
                }
           

        }



    }

    void updateSolmuNumero(int solmu, int vanhempi, int paino) {

    Solmu paivitettava = solmulista[solmu];
    if (paivitettava==null)return;
    int paivitettavapaino = paivitettava.getEtaisyys();
    
    if(paivitettavapaino>paino){
    paivitettava.setEtaisyys(paino);
    paivitettava.setParentTunnus(vanhempi);
    }

    int paivitettavaPaikka = paivitettava.getPaikka();
    Solmu solmuVanhempi = solmulista[paivitettavaPaikka/2];
    if (solmuVanhempi!=null){
    while(paivitettava.getEtaisyys() < solmuVanhempi.getEtaisyys() && solmuVanhempi.getPaikka()>1){
        swap(paivitettava.paikkaKeossa, solmuVanhempi.paikkaKeossa);
        solmuVanhempi = keko[(paivitettava.paikkaKeossa/2)];
    }
    }
    }
}
