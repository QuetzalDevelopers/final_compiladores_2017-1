package compilador;

import java.util.Stack;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class PilaTablaSimbolos {
   //Definiendo la pila
   Stack<TablaSimbolos> pila;
   
   //Iniciando la pila de la tabla de símbolos
   public PilaTablaSimbolos( ){
       pila = new Stack< >( );
   }
   
   //Método que retorna el elemento del tope de la pila
   public TablaSimbolos getTop( ){
       return pila.lastElement( );
   }
   
   //Método que retorna la tabla de símbolos global
   public TablaSimbolos getGlobalSymbol( ){
       return pila.firstElement( );
   }
   
   //Método que retorna retira la última tabla de símbolos
   public TablaSimbolos popSymbol( ){
       return pila.pop( );
   }
   
   //Método que agrega una Tabla de Símbolos a la pila
   public void pushSymbol(TablaSimbolos SymbolTable){
       pila.push(SymbolTable);
   }
}