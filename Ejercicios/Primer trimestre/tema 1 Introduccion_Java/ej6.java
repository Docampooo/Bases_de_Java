import java.util.Scanner;
public class ej6{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    double num1;
    double num2;
    double suma;
    double resta;
    double division;
    double multiplicacion;
    
    System.out.println("Escribe un número real; ");
    num1 = sc.nextDouble();
    System.out.println("Escribe otro número real");
    num2 = sc.nextDouble();

    suma = (num1 + num2);
    resta = (num1 - num2);
    division = (num1 / num2);
    multiplicacion = (num1 * num2);
    System.out.println("La suma entre estos dos números es; " + suma + "\n" +  "su resta es: " + resta + "\n" + " su division es: " + division + "\n" +  "y su multiplicacion es: " + multiplicacion);
    
    if (num1 > num2) {
        System.out.println("El numero 1 es mayor que el numero 2");
    }  else {
        if (num1 < num2) {
            System.out.println("El numero 1 es menor que el numero 2");
        }
    }
    if (num2 = 0);
        System.out.println( la divisi)
    }
}