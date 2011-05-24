
package primkruskal;

/**
 *
 * @author herkko
 */
public class Vieruslista {
Kaari[][] lista;
int top;


    public void vieruslista(){
    lista = new Kaari[1000][1000];

    }


    public void uusiKaari(Kaari uusikaari){
    int aloituskohta = uusikaari.getAloitus();
    lista[aloituskohta][1] = uusikaari;

    }

    public void uusiSolmu(){
    top++;
    
    }


}
