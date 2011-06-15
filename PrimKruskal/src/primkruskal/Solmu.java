
package primkruskal;
/**
 *
 * @author Herkko
 */

public class Solmu {
    int tunnus;
    int etaisyysverkkoon;
    int paikkaKeossa;
    int parentTunnus;
    Solmu parent;

    public void Solmu(){
    
    }

    public void solmu(int nimi){
    tunnus = nimi;
    paikkaKeossa = 1000; // onko paras mahdollinen valinta
    parent = null;
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

    public int getParentTunnus(){
    return this.parentTunnus;
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

    public void setNimi(int nimi){
    this.tunnus = nimi;    
    }

    public void setParentTunnus(int nimi){
    parentTunnus = nimi;
    }
  

}
