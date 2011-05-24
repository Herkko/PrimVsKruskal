
package primkruskal;

/**
 *
 * @author Herkko
 */

public class Keko {
Solmu[] keko;
int top;
int heapSize;


    public void keko(){
    heapSize = 1000;
    keko = new Solmu[heapSize];
    top=0;
    
    }

    public void luokeko(int maara){
    heapSize = maara;
    keko = new Solmu[heapSize];
    top=0;
    
    }

    //onko tarvetta  palauttaa olio vai pelkästään arvo?
    public int PoistaMinimi(){
   tulostaKeko();
   Solmu minimi = keko[1];
   keko[1] = keko[top];
   top--;
   heapify(1);
   tulostaKeko();
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
    if (uusisolmu.getPaikka()<Integer.MAX_VALUE){
    // solmu on jo keossa
   


    }
        else{
        top++;
        keko[top] = uusisolmu;
       
        }
    }

    private void swap(int solmu, int lapsi) {
    Solmu valiaikainen = keko[lapsi];
    keko[lapsi] = keko[solmu];
    keko[solmu] = valiaikainen;

    }

    private void tulostaKeko(){

    for (int i=0; i<top; i++){
        System.out.println((keko[i]).getEtaisyys());
    }
    }


}
