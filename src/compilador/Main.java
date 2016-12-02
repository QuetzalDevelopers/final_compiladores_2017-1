/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Manu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        FileReader archivoEntrada;
        BufferedReader bufferEntrada;
        if(args.length < 1){
            System.out.print("Escribe la ruta o el nombre del archivo de entrada: ");
            try{
                archivoEntrada = new FileReader(teclado.nextLine());
                bufferEntrada = new BufferedReader(archivoEntrada);
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }else{
            try{
                archivoEntrada = new FileReader(args[1]);
                bufferEntrada = new BufferedReader(archivoEntrada);
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        System.out.println("Vamos a empezar el análisis");
    }
}
