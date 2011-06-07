
package primkruskal;

/**
 *
 * @author herkko
 */
public class Vierusalkio {

    Solmu[] lista;
    int top;
    int haettu =0;

    public void Vierusalkio(){
    lista = new Solmu[1000];
    top=0;

    }

    public void lisaaAlkio(Solmu lisattava){
    top++;
    lista[top] = lisattava;

    }

    public Solmu getSeuraava(){
    Solmu palautettava = lista[haettu];
    haettu++;
    return palautettava;
    }

}
