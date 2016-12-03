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
public class TablaTipos {
    private ArrayList<Tipo> tabla;
    
    public TablaTipos( ){
        tabla = new ArrayList<Tipo>( );
    }
    
    public int putType(int tipo, int dimension, int tamanio, int tipoBase){
        Tipo tipoAuxiliar = new Tipo(tabla.size( ), tipo, dimension, tamanio, tipoBase);
        tabla.add(tipoAuxiliar);
        return tipoAuxiliar.posicion;
    }
    
    public int getBaseType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
               return tipoAuxiliar.tipoBase;
        }
        return -1;
    }
    
    public int getWidthType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
                return tipoAuxiliar.ancho;
        }
        return -1;
    }
    
    public int getDimType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
                return tipoAuxiliar.dimension;
        }
        return -1;
    }
    
    public int getType(int type){
        for(int i=0; i<tabla.size( ); i++){
            Tipo tipoAuxiliar = tabla.get(i);
            if(tipoAuxiliar.posicion == type)
                return tipoAuxiliar.tipo;
        }
        return -1;
    }
}