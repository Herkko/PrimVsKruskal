

package primkruskal;

/**
 *
 * @author herkko
 */
public class Main {


    public static void main(String[] args) {


double prim1 = primiTesti("verkko.txt");
double prim2 =primiTesti("verkko100-4.txt");
double prim3 =primiTesti("verkko100-100.txt");


double kruskal1 = kruskalTesti("verkko.txt", 6, 6);
double kruskal2 = kruskalTesti("verkko100-4.txt", 100, 4);
double kruskal3 = kruskalTesti("verkko100-100.txt", 100, 100);
//double kruskal4 = kruskalTesti("verkko10000-100.txt", 10000, 100);
// vikassa verkossa on samojen solmujen välillä useampi kaari tai jotain
// muuta outoa mikä kaataa Primin.

    System.out.println();
    System.out.println("                         Prim   Kruskal     millisekuntia");
    System.out.println("5 solmua                  "+ prim1+ "    " +  kruskal1);
    System.out.println("100 solmu, 4 kaarta       " +prim2+ "    " +  kruskal2);
    System.out.println("100 solmua, 100 kaarta    " +prim3+ "    " +  kruskal3);




    }

    private static double primiTesti(String tiedostonimi){
     Prim primi = new Prim();
    Keko Primalustettu = primi.alustatiedostosta(tiedostonimi);
    double aloitusaika = System.currentTimeMillis();
    primi.laskePrim();
    double lopetusaika = System.currentTimeMillis();
    double aika = lopetusaika-aloitusaika;
    System.out.println("aikaa kului: " + aika + "millisekuntia");
    System.out.println();
    double primiAika2 = aika;
    return aika;
    }

    private static double kruskalTesti(String tiedostonimi, int koko, int tiheys){
    //System.out.println("Kruskal laskee verkon jossa "+koko+ " solmua ja kaikista lähtee "+tiheys+" kaarta");
    Kruskal kruskali = new Kruskal();
    Keko Kruskalalustettu = kruskali.alustatiedostosta(tiedostonimi, koko , tiheys);
    kruskali.SetVerkko(Kruskalalustettu);
    double aloitusaika = System.currentTimeMillis();
    kruskali.laskeKruskal();
    double lopetusaika = System.currentTimeMillis();
    double aika = lopetusaika-aloitusaika;
    System.out.println("aikaa kului: " + aika + "millisekuntia");
    System.out.println();
    double kruskalAika1 = aika;
    return aika;
    }

}
