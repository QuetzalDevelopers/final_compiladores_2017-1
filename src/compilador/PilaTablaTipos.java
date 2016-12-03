/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    Stack<TablaTipos> pila;
    
    public PilaTablaTipos( ){
        pila = new Stack< >( );
    }
   
   public TablaTipos getTop( ){
       return pila.lastElement( );
   }
   
   public TablaTipos getGlobalSymbol( ){
       return pila.firstElement( );
   }
   
   public TablaTipos popSymbol( ){
       return pila.pop( );
   }
   
   public void pushSymbol(TablaTipos TypeTable){
       pila.push(TypeTable);
   }
}