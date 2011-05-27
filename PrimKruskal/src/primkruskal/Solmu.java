
package primkruskal;
/**
 *
 * @author Herkko
 */

public class Solmu {
    int tunnus;
    int etaisyysverkkoon;
    int paikkaKeossa;
    Solmu parent;


    public void Solmu(int nimi){
    tunnus = nimi;
    paikkaKeossa = Integer.MAX_VALUE; // onko paras mahdollinen valinta
    }

    public int getEtaisyys(){
    return this.etaisyysverkkoon;
    }

    public int getPaikka(){
    return this.paikkaKeossa;
    }

    public Solmu getParent(){
    return this.parent;
    }
    public int getNimi(){
    return tunnus;
    }

    public void setEtaisyys(int etaisyys){
    etaisyysverkkoon = etaisyys;
    }
    
    public void setPaikkakeossa(int paikka){
    this.paikkaKeossa = paikka;    
    }

}
