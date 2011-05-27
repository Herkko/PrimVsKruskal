
package primkruskal;

/**
 *
 * @author Herkko
 */

public class Keko {
Solmu[] keko = new Solmu[100];
int top;
int heapSize;
Solmu[] solmulista;
int solmujenmaara=0;


    public void Keko(){
    heapSize = 1000;
    keko = new Solmu[heapSize];
    top=1;
    solmulista = new Solmu[heapSize];
    Solmu parent = new Solmu();
    parent.setPaikkakeossa(0);
    parent.setEtaisyys(1000);
    keko[0] = parent;
    }

    public void Keko(int maara){
    heapSize = maara;
    keko = new Solmu[heapSize];
    top=0;
    solmulista = new Solmu[heapSize];
    }

    //onko tarvetta  palauttaa olio vai pelkästään arvo?
    public int PoistaMinimi(){
   tulostaKeko();
   Solmu minimi = keko[1];
   keko[1] = keko[top];
   top--;
   
   //Toimiiko oikeasti?
   int poistettava = minimi.tunnus;
   solmulista[poistettava] = null;
   heapify(1);

   return minimi.getEtaisyys();
   }

    private void heapify(int indeksi){
     
        if((indeksi*2+1)< top){
        //tarkistettava ettei tule nullpointteri, kun menee yli

        int vasemmankoko = (keko[(indeksi*2)]).getEtaisyys();
        int oikeankoko = (keko[(indeksi*2+1)]).getEtaisyys();
        int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();

            if (tarkistettavasolmu < Math.max(vasemmankoko,oikeankoko)){
            swap(tarkistettavasolmu, Math.max(vasemmankoko,oikeankoko));
            heapify(Math.max(vasemmankoko,oikeankoko));
            }
        }

        else if((indeksi*2)==top){
           int vasemmankoko = (keko[(indeksi*2)]).getEtaisyys();
           int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();
           if(tarkistettavasolmu<vasemmankoko){
               swap(tarkistettavasolmu, vasemmankoko);
               //tahan ei varmaan tarvitse enaa heapifya, koska oikeaa lastakaan ei ole.
           }

        }

    }

    public void insert(Solmu uusisolmu){
    int solmuTunnus = uusisolmu.getNimi();
//    if (solmulista[solmuTunnus] != null){
//       updateSolmu(uusisolmu);
//        }
//
//    else{

    if (solmujenmaara>0){



    top++;
    keko[top] = uusisolmu;
    int solmu=top;
    int solmuParent = top/2; // jos eka, niin ei parenttia. null pointter

    Solmu vertailtavalapsi = keko[top];
    Solmu vertailtavaParent = keko[solmuParent];

    while ((vertailtavalapsi.getEtaisyys()) > (vertailtavaParent.getEtaisyys()) && (vertailtavaParent.getPaikka())>1){
         swap(vertailtavalapsi.paikkaKeossa, vertailtavaParent.paikkaKeossa);
         int uusiVanhempi= ((vertailtavalapsi.paikkaKeossa)/2);
         vertailtavaParent = keko[uusiVanhempi];
     }

     }
    else {
    keko[top] =uusisolmu;
    top++;
    }
    }

    private void swap(int solmu, int lapsi) {
    Solmu valiaikainen = keko[lapsi];

    valiaikainen.setPaikkakeossa(solmu); //paivitetaan paikkakeossa arvoa.
    (keko[solmu]).setPaikkakeossa(lapsi);

    keko[lapsi] = keko[solmu];
    keko[solmu] = valiaikainen;

    }

    public void tulostaKeko(){

    for (int i=0; i<top; i++){
        System.out.println((keko[i]).getEtaisyys());
    }
    }


    private void updateSolmu(Solmu uusiSolmu) {
    int solmutunnus = uusiSolmu.getNimi();
    Solmu paivitettava = solmulista[solmutunnus];

    if (paivitettava.etaisyysverkkoon > uusiSolmu.etaisyysverkkoon ){
    paivitettava.etaisyysverkkoon = uusiSolmu.etaisyysverkkoon;

    Solmu paivitettavaParent = paivitettava.getParent();

        
        while (paivitettavaParent.getEtaisyys() < paivitettava.getEtaisyys() && paivitettava.paikkaKeossa>1){
        swap(paivitettava.paikkaKeossa, paivitettavaParent.paikkaKeossa);
        }

    }



    }

}
