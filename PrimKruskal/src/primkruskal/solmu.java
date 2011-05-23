
package primkruskal;

/**
 *
 * @author Herkko
 */
public class solmu {
   int tunnus;
    int etaisyysverkkoon = -1;
    int[] mihinpaasee = new int[1000];
    int maara=0;
    solmu parent;

    public void solmu(int nimi){
    tunnus = nimi;
      
    }

    public int getEtaisyys(){
        return this.etaisyysverkkoon;
    }

    public void setEtaisyys(int etaisyys){
    etaisyysverkkoon = etaisyys;
    }

}
