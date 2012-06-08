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
public class Entidad {
     String nombre;
     ArrayList<String[]> atributos=new ArrayList();
     
     ArrayList<ForenKey> FK=new ArrayList();
     
     ArrayList<String[]> PK=new ArrayList();
     
     
     public Entidad(String Nombre)
     {
         this.nombre=Nombre;
         cargarAtributos(this.nombre);
     }
     
     public void setPrimaryKey()
     {
                String consulta="SELECT distinct a.column_name Campo_Llave  "
                    + "FROM information_schema.constraint_column_usage a, information_schema.key_column_usage b, information_schema.table_constraints c   "
                    + "WHERE a.constraint_name=b.constraint_name and c.constraint_name=a.constraint_name and c.constraint_type='PRIMARY KEY' and  a.table_name=\'"+nombre+"\';";
             
              ArrayList<String[]> query2 = new Sql ().consulta(consulta);
              Iterator<String[]> listaPK = query2.iterator();         
             listaPK.next();
             while(listaPK.hasNext())
             {
                 PK.add(listaPK.next());
             }
     }
     
     public void  cargarAtributos(String nombre)
     {
         String consulta1="SELECT column_name Nombre,data_type Tipo  "
                 + " FROM information_schema.columns "
                 + "WHERE table_name =\'"+nombre+"\';";
         
     
         
         ArrayList<String[]> query = new Sql ().consulta(consulta1);
         Iterator<String[]> i = query.iterator();
         
         
         
         i.next();
         while(i.hasNext())
         {
                String[] fila = i.next();
                atributos.add(fila);
         }
         
         this.setPrimaryKey();
         
         this.setForenKey ();
         
     
     }
     
     public void setForenKey () {
         String consulta=" SELECT a.column_name Campo_Origen , b.column_name Campo_Destino , a.table_name Tabla_Origen  "
                                    + " FROM information_schema.constraint_column_usage a, information_schema.key_column_usage b, information_schema.table_constraints c  "
                                    + " WHERE a.constraint_name=b.constraint_name and c.constraint_name=a.constraint_name and c.constraint_type='FOREIGN KEY'"
                                    + " and b.table_name=\'"+nombre+"\';";

         ArrayList<String[]> query = new Sql ().consulta(consulta);
              Iterator<String[]> listaFK = query.iterator();         
             listaFK.next();
             while(listaFK.hasNext())
             {
                 FK.add(new ForenKey(listaFK.next()));
             }
     }
     
     
}
