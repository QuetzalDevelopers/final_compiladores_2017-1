package compilador;

import java.util.ArrayList;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class TablaCadenas {
   //Lista de las cadenas del programa
   ArrayList<Cadena> tabla;
   
   //Constructor que inicializa la tabla de cadenas del programa
   public TablaCadenas( ){
       tabla = new ArrayList<>( );
   }
   
   //Método que agrega una cadena a la tabla de cadenas
   public void putStr(String cadena){
       tabla.add(new Cadena(tabla.size( )));
   }
   
   //Método que regresa el valor de una cadena de una posición de la tabla
   public String getStr(int pos){
       return tabla.get(pos).cadena;
   }
   
   //Método que regresa la posición de la tabla de una cadena
   public int getPos(String cadena){
       for(int i=0; i<tabla.size( ); i++){
           Cadena objetoCadena = tabla.get(i);
           if(cadena.equals(objetoCadena.cadena))
               return objetoCadena.posicion;
       }
       return -1;
   }
}