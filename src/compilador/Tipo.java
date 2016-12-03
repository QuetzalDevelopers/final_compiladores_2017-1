/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

/**
 *
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class Tipo {
   int posicion;
   int tipo;
   int dimension;
   int ancho;
   int tipoBase;
   
    public Tipo(int posicion, int tipo, int dimension, int ancho, int tipoBase){
       this.posicion = posicion;
       this.tipo = tipo;
       this.dimension = dimension;
       this.ancho = ancho;
       this.tipoBase = tipoBase;
    }
}
