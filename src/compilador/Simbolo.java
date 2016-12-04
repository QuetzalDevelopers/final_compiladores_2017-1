package compilador;

import java.util.ArrayList;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class Simbolo {
    //Atributos de la clase Símbolo
    String identificador;
    int tipoIdentificador;
    int tipoVariable;
    int direccion;
    int apuntadorTablaSimbolos;
    int numeroParametros;
    
    //Lista de los parámetros de una función
    ArrayList<Parametros> listaParametros;
    
    //Constructor que asigna el nombre del identificador
    public Simbolo(String identificador){
        this.identificador = identificador;
    }
    
    //Método que retorna el nombre del identificador, dirección y tipo como cadena
    public String to_String( ){
        return identificador +"\t"+direccion+"\t"+tipoVariable;
    }
}