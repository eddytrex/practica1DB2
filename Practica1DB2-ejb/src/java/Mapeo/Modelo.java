/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author eddytrex
 */
public class Modelo {
     ArrayList <Entidad> entidades=new ArrayList();
    
     
     public void cargarEntidades(){
         
         // Crear las Entidades con sus Atributos
         
         String consulta="SELECT table_name  "
            + "FROM information_schema.tables "
            + "WHERE table_schema = 'public';";
         
        ArrayList<String[]> query = new Sql ().consulta(consulta);
        Iterator<String[]> i = query.iterator();
        i.next();
        while (i.hasNext()){
            String[] fila = i.next();
            
            Entidad entidad=new Entidad(fila[0]);
            int a = 132;
            entidades.add(entidad);
        }
        
        // Asociar las Primary Key a cada Entidad
        
       int fd = 212;
       fd= 181;
            
     }
     
     public Entidad BuscarEntidad(String Nombre)
     {
         Entidad result=null;
         
         Iterator<Entidad> i=this.entidades.iterator();
         
         while(i.hasNext())
         {
             Entidad al=null;
             al=i.next();
             if(al.nombre.equals(Nombre)){result=al; return result;}
         }       
            
         return result;
     }
     
     
     
     
}
