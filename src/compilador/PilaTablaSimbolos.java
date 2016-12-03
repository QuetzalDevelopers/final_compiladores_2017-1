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
public class PilaTablaSimbolos {
   Stack<TablaSimbolos> pila;
   
   public PilaTablaSimbolos( ){
       pila = new Stack< >( );
   }
   
   public TablaSimbolos getTop( ){
       return pila.lastElement( );
   }
   
   public TablaSimbolos getGlobalSymbol( ){
       return pila.firstElement( );
   }
   
   public TablaSimbolos popSymbol( ){
       return pila.pop( );
   }
   
   public void pushSymbol(TablaSimbolos SymbolTable){
       pila.push(SymbolTable);
   }
}