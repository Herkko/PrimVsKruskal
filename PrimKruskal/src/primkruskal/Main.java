

package primkruskal;

/**
 *
 * @author herkko
 */
public class Main {


    public static void main(String[] args) {
  double aloitusaika=0;
  double lopetusaika =0;
  double aika=0;

   System.out.println("Primi laskee verkon:");
    Prim primi = new Prim();
    Keko Primalustettu = primi.alustatiedostosta("verkko.txt");
    aloitusaika = System.currentTimeMillis();
    primi.laskePrim();
    lopetusaika = System.currentTimeMillis();
    aika = lopetusaika-aloitusaika;
    System.out.println("aikaa kului: " + aika + "millisekuntia");
    System.out.println("");

    System.out.println("Kruskal laskee verkon");
    Kruskal kruskali = new Kruskal();
    Keko Kruskalalustettu = kruskali.alustatiedostosta("verkko.txt");
    kruskali.SetVerkko(Kruskalalustettu);
    aloitusaika = System.currentTimeMillis();
    kruskali.laskeKruskal();
    lopetusaika = System.currentTimeMillis();
    aika = lopetusaika-aloitusaika;
    System.out.println("aikaa kului: " + aika + "millisekuntia");
        

    }

}
