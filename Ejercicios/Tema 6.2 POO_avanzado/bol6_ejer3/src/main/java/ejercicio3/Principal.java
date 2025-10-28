package ejercicio3;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        Cadena cadena = new Cadena();

        System.out.println("introduce una cadena");
        String texto = sc.nextLine();

        cadena.setCadena(texto);

        System.out.println(cadena.toString());

        boolean error;
        String eleccion;
        do{
            error = false;
            System.out.println("Introduce el caracter que quieras eliminar de la coleccion");
            eleccion = sc.nextLine();
            if(eleccion.length() != 1 || eleccion == ""){
                error = true;
            }
        }while(error);

        char car = eleccion.charAt(0);

        System.out.println("Se han elimindado " + cadena.eliminar(car));

        System.out.println(cadena.toString());
        
    }
}
