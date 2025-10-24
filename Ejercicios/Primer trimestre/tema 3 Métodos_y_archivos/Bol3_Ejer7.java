import java.util.Scanner;
import java.io.*;
 
public class Bol3_Ejer7 {
    /**
     * funcion que al introducir un archivo en forma de cadena, lee el archivo y lo devuelve como String
     * @param cadena Archivo introducido como cadena
     * @return devuelve el archivo como una variable tipo String
     * @throws Exception
     */
    public static String loadFile(String cadena) throws Exception{
        Scanner f = new Scanner(new File(cadena));
        String contenido="";
        while(f.hasNext()){
            contenido = contenido + "\n" + f.nextLine();
        }
        f.close();
        return contenido;
    }
    /**
     * funcion que guarda los datos de un archivo y añade una cadena introducida por el usuario
     * @param cadena archivo a leer
     * @param texto texto introducido por el usuario
 
     */
    public static void appendFile(String cadena, String texto) throws Exception{
        String contenido = loadFile(cadena); 
        PrintWriter p = new PrintWriter(cadena); //Apertura

        p.println(contenido + "\n" + texto);
        
        p.close();
    }
    /**
     * funcion que guarda los datos de un archivo y añade una cadena 
     * @param cadena archivo a leer
     * @param texto texto 
     * @throws Exception
     */
    public static void appendFile2(String cadena, String texto) throws Exception{
       
       PrintWriter f = new PrintWriter(new FileWriter(cadena , true));

       f.println(texto);

       f.close();
    }
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        String cadena;
        String texto;
        String texto2;

        System.out.println("introduce el nombre del archivo que quieras leer:  ");
        cadena = sc.nextLine();

        System.out.println(loadFile(cadena));//TODO
        
        System.out.println("introduce el texto que quieras añadir al archivo:  ");
        texto = sc.nextLine();

        appendFile(cadena ,texto);

        System.out.println("introduce otro texto que quieras añadir al archivo:  ");
        texto2=sc.nextLine();

        appendFile2(cadena, texto2);
    }
}
