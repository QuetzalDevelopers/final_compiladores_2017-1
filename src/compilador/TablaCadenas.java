/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class TablaCadenas {
   ArrayList<Cadena> tabla;
   
   public TablaCadenas( ){
       tabla = new ArrayList<>( );
   }
   
   public void putStr(String cadena){
       tabla.add(new Cadena(tabla.size( )));
   }
   
   public String getStr(int pos){
       return tabla.get(pos).cadena;
   }
   
   public int getPos(String cadena){
       for(int i=0; i<tabla.size( ); i++){
           Cadena objetoCadena = tabla.get(i);
           if(cadena.equals(objetoCadena.cadena))
               return objetoCadena.posicion;
       }
       return -1;
   }
}