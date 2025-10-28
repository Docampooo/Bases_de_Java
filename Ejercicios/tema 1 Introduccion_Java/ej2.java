import java.util.Scanner;
public class ej2{
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    int numero1;
    int numero2;
    int suma;

    System.out.println("escribe un número aleatorio");
    numero1 = sc.nextInt();
    System.out.println("escribe un segundo número aleatorio");
    numero2 = sc.nextInt();
    suma = (numero1 + numero2);
    System.out.println("la suma de los dos números es: " + suma);

    }
}