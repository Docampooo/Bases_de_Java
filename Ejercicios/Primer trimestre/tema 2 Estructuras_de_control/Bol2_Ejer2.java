import java.util.Scanner;

public class Bol2_Ejer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;

        System.out.println("introduce un numero entero:  ");
        num1 = sc.nextInt();
        System.out.println("introduce otro numero entero:  ");
        num2 = sc.nextInt();

        if (num1 < num2) {
            System.out.println("El numero mas grande es el " + num2);
        } else {
            if (num1 > num2) {
                System.out.println("El numero mas grande es el " + num1);
            } else {
                System.out.println("los numeros son iguales");
            }
        }
        if (num1 % num2 == 0 || num2 % num1 ==0)

        {
            System.out.println("Los numeros son multiplos");

        }
    }
}
