import java.util.Scanner;
public class Bol2_Ejer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double num1;
        int num2;

        System.out.println("introduce un numero entero: ");
        num2 = sc.nextInt();
        System.out.println("introduce un numero real: ");
        num1 = sc.nextDouble();

        System.out.printf("%d %05o %X \n%7.3f " , num2 , num2 , num2, num1);
    }
}
