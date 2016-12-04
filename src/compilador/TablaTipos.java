package compilador;

import java.util.ArrayList;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class TablaTipos {
    //Definiendo la tabla de tipos como una lista ligada
    private final ArrayList<Tipo> tabla;
    
    //Inicializando la tabla de tipos en el constructor
    public TablaTipos( ){
        tabla = new ArrayList< >( );
    }
    
    //Método que asigna un tipo a la tabla de símbolos
    public int putType(int tipo, int dimension, int tamanio, int tipoBase){
        Tipo tipoAuxiliar = new Tipo(tabla.size( ), tipo, dimension, tamanio, tipoBase);
        tabla.add(tipoAuxiliar);
        return tipoAuxiliar.posicion;
    }
    
    //Método que obtienen el tipo base de un tipo de la tabla de tipos
    public int getBaseType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
               return tipoAuxiliar.tipoBase;
        }
        return -1;
    }
    
    //Método que obtiene el ancho de un tipo de la tabla de tipos
    public int getWidthType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
                return tipoAuxiliar.ancho;
        }
        return -1;
    }
    
    //Método que obtiene la dimension de un tipo de la tabla de tipos
    public int getDimType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
                return tipoAuxiliar.dimension;
        }
        return -1;
    }
    
    //Método que obtiene un tipo de la tabla de tipos
    public int getType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
                return tipoAuxiliar.tipo;
        }
        return -1;
    }
}