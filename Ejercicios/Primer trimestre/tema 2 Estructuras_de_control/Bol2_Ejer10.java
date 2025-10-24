import java.util.Scanner;
public class Bol2_Ejer10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1;
        double num2;
        double vaso;
        
        System.out.println("introduce 2 numeros distintos: ");
        num1 = sc.nextDouble();
        num2 = sc.nextDouble();
        
        vaso = num1;
        num1 = num2;
        num2 = vaso;

        System.out.println("los numeros cambiados son " + num1 +"  "+ num2 );
    }
}
