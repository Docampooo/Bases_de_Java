import java.util.Scanner;
public class ej4{
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    String nombre;
    String apellidos;
    int edad;

    nombre = sc.nextLine();
    apellidos = sc.nextLine();
    edad = sc.nextInt();
    System.out.println(nombre + "\n\t" + apellidos + "\t" + "\"" + edad + "\"");

    }
}