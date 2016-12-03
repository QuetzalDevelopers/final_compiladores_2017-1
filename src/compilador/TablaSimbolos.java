/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class TablaSimbolos{
    private ArrayList<Simbolo> tabla;
    
    public TablaSimbolos( ){
        tabla = new ArrayList<Simbolo>( );
    }
    
    private int barrido(String id){
        for(int i = 0; i < tabla.size( ); i++){
            String cadena = (tabla.get(i)).identificador;
            if(cadena.equals(id)){
                System.out.println("El identificador "+cadena+" ya existe en la tabla de simbolos");
                return 0;
            }
        }
        return -1;
    }
    
    public int get(String id){
        if(barrido(id) != 0)
            return -1;
        else
            return 0;
    }
    
    public int put(String id){
        if(barrido(id) != 0){
            tabla.add(new Simbolo(id));
            return 0;
        }else
            return -1;
    }
    
    public void setType(String id, int type){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id)){
                simbolo.tipoIdentificador = type;
                tabla.set(i, simbolo);
                break;
            }
        }
    }
    
    public void setTypeVar(String id, int typeVar){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id)){
                simbolo.tipoVariable = typeVar;
                tabla.set(i, simbolo);
                break;
            }
        }
    }
    
    public void setParam(String id, ArrayList lista){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id)){
                simbolo.listaParametros = lista;
                tabla.set(i, simbolo);
                break;
            }
        }
    }
    
    public void setNumParam(String id, int num){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id)){
                simbolo.numeroParametros = num;
                tabla.set(i, simbolo);
                break;
            }
        }
    }
    
    public int getType(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.tipoIdentificador;
        }
        return -1;
    }
    
    public int getTypeVar(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.tipoVariable;
        }
        return -1;
    }
    
    public ArrayList<Parametros> getParam(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.listaParametros;
        }
        return new ArrayList<Parametros>( );
    }
    
    public int getNumParam(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.numeroParametros;
        }
        return -1;
    }
}