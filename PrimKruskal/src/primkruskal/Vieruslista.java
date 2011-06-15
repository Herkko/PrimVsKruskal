
package primkruskal;

/**
 *
 * @author herkko
 */
public class Vieruslista {
int[][] lista = new int[1000][1000];
int top;
int indeksi;


    public void vieruslista(){


    }
    //listassa on nollakohdassa määrä kuinka monta alkiota listassa on ja 
    //lisääminen sekä hakeminen onnistuu sen mukaan.
    public void lisaaKaari(int alku, int loppu, int paino){
    if (lista[alku][0]!=0){
        //etsitaan kohta missä ei vielä ole tavaraa
        int i=(lista[alku][0])*2;
        i++;
   
        lista[alku][i]=loppu;
        i++;
        lista[alku][i]=paino;
        
        lista[alku][0]=(lista[alku][0])+1;
    }
    else{
        lista[alku][1]=loppu;
        lista[alku][2]=paino;
        lista[alku][0]=1;
    }

    }

    public int[] haeKaaret(int alku){
    int maara = lista[alku][0];
    maara = maara*2;
    int[] palautettava = new int[maara];

    for (int i=1; i<maara+1; i++){
    palautettava[i-1]=lista[alku][i];

    }
    return palautettava;
    }

    public int haeSolmut(){
    int i=1;
        while(lista[i][0]!=0){
        i++;
        }
   return i;


    }

//    public void uusiSolmu(Solmu uusiSolmu){
//    //lisätään aloitus ja lopetuskohtiin samat kaaret, jotta taulu pysyy sellaisena että molempiin suuntiin pääsee
//    int aloituskohta = (uusiSolmu.getParent()).getNimi();
//    (lista[aloituskohta]).lisaaAlkio(uusiSolmu);
//
//    int lopetuskohta = uusiSolmu.getNimi();
//    (lista[lopetuskohta]).lisaaAlkio(uusiSolmu);
//    }

//    public Kaari getKaari(int aloituskohta){
//    Kaari palautettava = (lista[aloituskohta]).getSeuraavaKaari();
//    return palautettava;
//    }


}
