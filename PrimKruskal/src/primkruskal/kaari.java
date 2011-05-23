/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primkruskal;

/**
 *
 * @author herkko
 */
public class kaari {

    int kaaripaino;
    int etaisyys;
    int aloituskohta;
    int lopetuskohta;

    public void kaari(int aloitus, int lopetus, int paino){
    this.kaaripaino = paino;
    this.aloituskohta = aloitus;
    this.lopetuskohta = lopetus;

    }

    public int getPaino(){
    return this.kaaripaino;
    }

    public void setEtaisyys(int etaisyys){
    this.etaisyys = etaisyys;
    }
}
