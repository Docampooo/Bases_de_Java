import java.util.Scanner;
public class ej5{
    public static void main( String[]args){
    Scanner sc = new Scanner(System.in);
    String nombre;
    int edad;
    double temperatura;

    System.out.println("escribe tu nombre: ");
    nombre = sc.nextLine();
    System.out.println("escribe tu edad ");
    edad = sc.nextInt();
    System.out.println("inserta la temperatura actual ");
    temperatura = sc.nextDouble();
    System.out.println(nombre + "\n" + edad + "\n" + temperatura + "grados centígrados");
    }
}