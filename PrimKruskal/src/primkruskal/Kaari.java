/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primkruskal;

/**
 *
 * @author herkko
 */
public class Kaari {

    int kaaripaino;
    
    int aloituskohta;
    int lopetuskohta;

    public void kaari(int aloitus, int lopetus, int paino){
    this.kaaripaino = paino;
    this.aloituskohta = aloitus;
    this.lopetuskohta = lopetus;

    }

    public int getAloitus(){
    return this.aloituskohta;
    }

    public int getLopetus(){
    return this.lopetuskohta;
    }

    public int getPaino(){
    return this.kaaripaino;
    }

   
}
