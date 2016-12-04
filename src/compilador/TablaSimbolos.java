package compilador;

import java.util.ArrayList;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class TablaSimbolos{
    //Definiendo la tabla de símbolos como una lista ligada
    private final ArrayList<Simbolo> tabla;
    
    //Constructor que inicializa la tabla de símbolos
    public TablaSimbolos( ){
        tabla = new ArrayList< >( );
    }
    
    //Método que busca el valor de un identificador en la tabla de símbolos
    private int barrido(String id){
        for(int i = 0; i < tabla.size( ); i++){
            String cadena = (tabla.get(i)).identificador;
            if(cadena.equals(id))
                return 0;
        }
        return -1;
    }
    
    //Método que define si un identificador ya esta definido en la tabla de símbolos
    public int get(String id){
        if(barrido(id) != 0)
            return -1;
        else{
            System.out.println("El identificador "+id+" ya existe en la tabla de simbolos");
            return 0;
        }
    }
    
    //Método que agrega un identificador a la tabla de símbolos
    public int put(String id){
        if(barrido(id) != 0){
            tabla.add(new Simbolo(id));
            return 0;
        }else{
            System.out.println("El identificador "+id+" ya existe en la tabla de simbolos");
            return -1;
        }
    }
    
    //Método que asigna el tipo a un identificador de la tabla de símbolos
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
    
    //Método que asigna el tipo variable a un identificador de la tabla de símbolos
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
    
    //Método que asigna la lista de parámetros a un identificador de la tabla de símbolos
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
    
    //Método que asigna el número de parámetros a un identificador de la tabla de símbolos
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
    
    //Método que obtiene el tipo de un identificador de la tabla de símbolos
    public int getType(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.tipoIdentificador;
        }
        return -1;
    }
    
    //Método que obtiene el tipo variable de un identificador de la tabla de símbolos
    public int getTypeVar(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.tipoVariable;
        }
        return -1;
    }
    
    //Método que obtiene la lista de parámetros de un identificador de la tabla de símbolos
    public ArrayList<Parametros> getParam(String id){
        for(int i = 0; i < tabla.size( ); i++){
            Simbolo simbolo = tabla.get(i);
            String cadena = simbolo.identificador;
            if(cadena.equals(id))
                return simbolo.listaParametros;
        }
        return null;
    }
    
    //Método que obtiene el numero de parámetros de un identificador de la tabla de símbolos
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