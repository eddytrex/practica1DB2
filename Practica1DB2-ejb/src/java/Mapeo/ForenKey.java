/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

/**
 *
 * @author eddytrex
 */
public class ForenKey {
    
    public String campo;
    public String tablaPadre;
    public String campoPadre;
    
    public ForenKey (String  [] fila) {
        campo = fila [1];
        campoPadre = fila [0];
        tablaPadre = fila [2];
    }
    
    
}
