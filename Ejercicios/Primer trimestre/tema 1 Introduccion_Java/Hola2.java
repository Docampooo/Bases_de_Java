import java.util.Scanner;
public class Hola2 {
    public static void main(String args[]) {
        // Declaración de variables
        String nombre;
        int edad;
        Scanner sc = new Scanner(System.in);
        // Código
        System.out.print("Dime tu nombre: ");
        nombre = sc.nextLine(); //espera a la respuesta de la persona
        System.out.println("Ahora tu edad");
        edad = sc.nextInt();
        System.out.println(nombre + ", Welcome to the Java World");
        System.out.println("Nos vemos, ser humano de " + edad + " años");
    }
}