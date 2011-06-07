

package primkruskal;

/**
 *
 * @author herkko
 */
public class Main {


    public static void main(String[] args) {
  
        System.out.println("poistetaan kruskal keosta solmu");
        Keko instance = new Keko();

        for (int i=1; i<14; i++){
        Solmu uusisolmu = new Solmu();
        uusisolmu.setEtaisyys(100-(i*4));
        uusisolmu.setNimi(i);
        instance.KruskalInsert(uusisolmu);
        }
        instance.tulostaKeko();
        instance.PoistaMinimi();
        instance.tulostaKeko();
        
    }

}
