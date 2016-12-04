package compilador;

/**
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class Tipo {
    //Constantes que nos ayudan a identificar los distintos tipos
    public static final int VOID = 0;
    public static final int CHAR = 1;
    public static final int INT = 2;
    public static final int FLOAT = 3;
    public static final int STRING = 4;
    public static final int DOUBLE = 4;
   
    //Atributos de un tipo
    int posicion;
    int tipo;
    int dimension;
    int ancho;
    int tipoBase;
    
    //Constructor que inicializa todos los atributos de un tipo
    public Tipo(int posicion, int tipo, int dimension, int ancho, int tipoBase){
       this.posicion = posicion;
       this.tipo = tipo;
       this.dimension = dimension;
       this.ancho = ancho;
       this.tipoBase = tipoBase;
    }
}