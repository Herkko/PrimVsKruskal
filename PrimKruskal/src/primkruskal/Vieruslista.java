
package primkruskal;

/**
 *
 * @author herkko
 */
public class Vieruslista {
Kaari[] lista;
int top;


    public void vieruslista(){
    lista = new Kaari[1000];

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
