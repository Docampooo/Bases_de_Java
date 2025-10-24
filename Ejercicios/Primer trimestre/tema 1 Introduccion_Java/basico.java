import java.util.Scanner;
public class basico {
    public static void main (String[] args){
        String nombre;
        String direccion;
        int edad;
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenidos a mi superprograma!");
        System.out.println("Ahora unas preguntas");
        System.out.println("Dime tu nombre");
        nombre = sc.nextLine();
        System.out.println("Dime tu direccion");
        direccion = sc.nextLine();
        System.out.println("Dime tu edad");
        edad = sc.nextInt();
        System.out.println("Hola " + nombre + " vives en " + direccion + " y ademas tienes " + edad + "años de edad");
    };
 }