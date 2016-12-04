package compilador;

import java.util.Stack;

/**
 *
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class PilaTablaTipos {
    //Definiendo la pila de la tabla de tipos
    Stack<TablaTipos> pila;
    
    //Inizializando la pila de la tabla de tipos
    public PilaTablaTipos( ){
        pila = new Stack< >( );
    }
   
    //Método que retorna la última tabla de tipos de la pila
   public TablaTipos getTop( ){
       return pila.lastElement( );
   }
   
   //Método que retorna la tabla de tipos global
   public TablaTipos getGlobalSymbol( ){
       return pila.firstElement( );
   }
   
   //Método que saca el último elemento de la pila de la tabla de tipos
   public TablaTipos popSymbol( ){
       return pila.pop( );
   }
   
   //Método que agrega una tabla de tipos a la pila
   public void pushSymbol(TablaTipos TypeTable){
       pila.push(TypeTable);
   }
}