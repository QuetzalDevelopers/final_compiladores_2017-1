/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @authors
 * Banda Martínez César Eduardo
 * Martínez Rojas Jorge Antonio
 * Novas Santamaría José Manuel
 */
public class Main{
    static String nombreEntrada;
    static FileReader archivoEntrada = null;
    static BufferedReader bufferEntrada = null;
    static FileWriter archivoSalida = null;
    static BufferedWriter bufferSalida = null;
    //private int contadorDirecciones = 0;
    private int contadorTemporales = 0;
    
    public void gen(String cadena) throws IOException{
        bufferSalida.append(cadena);
    }
    
    public Direccion newTemp( ){
        Direccion temporal = new Direccion("t"+contadorTemporales);
        contadorTemporales++;
        return temporal;
    }
    
    public Direccion ampliar(Direccion a, Tipo t, Tipo w) throws IOException{
        if(w.tipo == t.tipo)
            return a;
        else if(t.tipo == Tipo.CHAR && w.tipo == Tipo.INT){
            Direccion t1 = newTemp( );
            t1.valor.entero = Character.getNumericValue(a.valor.caracter);
            t1.direccion = a.direccion;
            gen(t1.nombre+" = "+t1.valor.entero);
            return t1;
        }else if(t.tipo == Tipo.INT && w.tipo == Tipo.FLOAT){
            Direccion t1 = newTemp( );
            t1.valor.flotante = (float) a.valor.entero;
            t1.direccion = a.direccion;
            gen(t1.nombre+" = "+t1.valor.flotante);
            return t1;
        }else if(t.tipo == Tipo.FLOAT && w.tipo == Tipo.DOUBLE){
            Direccion t1 = newTemp( );
            t1.valor.doble = (double) a.valor.flotante;
            t1.direccion = a.direccion;
            gen(t1.nombre+" = "+t1.valor.doble);
            return t1;
        }else if(t.tipo == Tipo.INT && w.tipo == Tipo.DOUBLE){
            Direccion t1 = newTemp( );
            t1.valor.doble = (double) a.valor.entero;
            t1.direccion = a.direccion;
            gen(t1.nombre+" = "+t1.valor.doble);
            return t1;
        }
        return null;
    }
    
    public int compatibles(Tipo t, Tipo w){
        if(t.tipo == w.tipo)
            return 1;
        else if (t.tipo == Tipo.CHAR && w.tipo == Tipo.INT || t.tipo == Tipo.INT && w.tipo == Tipo.CHAR)
            return 1;
        else if (t.tipo == Tipo.INT && w.tipo == Tipo.FLOAT || t.tipo == Tipo.FLOAT && w.tipo == Tipo.INT)
            return 1;
        else if (t.tipo == Tipo.FLOAT && w.tipo == Tipo.DOUBLE || t.tipo == Tipo.DOUBLE && w.tipo == Tipo.FLOAT)
            return 1;
        else if (t.tipo == Tipo.INT && w.tipo == Tipo.DOUBLE || t.tipo == Tipo.DOUBLE && w.tipo == Tipo.INT)
            return 1;
        else
            return -1;
    }
    
    public Tipo max(Tipo t, Tipo w){
        if(t.tipo == w.tipo)
            return t;
        else if(t.tipo == Tipo.CHAR && w.tipo == Tipo.INT)
            return w;
        else if(t.tipo == Tipo.INT && w.tipo == Tipo.CHAR)
            return t;
        else if(t.tipo == Tipo.INT && w.tipo == Tipo.FLOAT)
            return w;
        else if(t.tipo == Tipo.FLOAT && w.tipo == Tipo.INT)
            return t;
        else if(t.tipo == Tipo.FLOAT && w.tipo == Tipo.DOUBLE)
            return w;
        else if(t.tipo == Tipo.DOUBLE && w.tipo == Tipo.FLOAT)
            return t;
        else if(t.tipo == Tipo.INT && w.tipo == Tipo.DOUBLE)
            return w;
        else if(t.tipo == Tipo.DOUBLE && w.tipo == Tipo.INT)
            return t;
        else
            return null;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[ ] args) throws IOException{
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        archivoSalida = new FileWriter(nombreEntrada+".ci");
        bufferSalida = new BufferedWriter(archivoSalida);
        
        if(args.length < 1){
            System.out.print("Escribe la ruta o el nombre del archivo de entrada: ");
            nombreEntrada = teclado.nextLine( );
            try{
                archivoEntrada = new FileReader(nombreEntrada);
                bufferEntrada = new BufferedReader(archivoEntrada);
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage( ));
                bufferEntrada.close( );
                archivoEntrada.close( );
                System.exit(0);
            }
        }else{
            try{
                archivoEntrada = new FileReader(args[1]);
                bufferEntrada = new BufferedReader(archivoEntrada);
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
                bufferEntrada.close( );
                archivoEntrada.close( );
                System.exit(0);
            }
        }
        System.out.println("Vamos a empezar el análisis");
        bufferEntrada.close( );
        archivoEntrada.close( );
        bufferSalida.close( );
        archivoSalida.close( );
    }
}