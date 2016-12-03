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
public class Simbolo {
    String identificador;
    int tipoIdentificador;
    int tipoVariable;
    int direccion;
    int apuntadorTablaSimbolos;
    int numeroParametros;
    ArrayList<Parametros> listaParametros;
    
    public Simbolo(String identificador){
        this.identificador = identificador;
    }
    
    public String toString( ){
        return identificador +"\t"+direccion+"\t"+tipoVariable;
    }
}