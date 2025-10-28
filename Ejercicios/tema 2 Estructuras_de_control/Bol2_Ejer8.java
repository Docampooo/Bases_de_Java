import java.util.Scanner;

public class Bol2_Ejer8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1;
        double num2;
        double num3;
        System.out.println("introduce 3 numeros");

        num1 = sc.nextDouble();
        num2 = sc.nextDouble();
        num3 = sc.nextDouble();
        System.out.println("introduce 3 numeros");

        if ((num1 >= num2) && (num1 >= num3)) {
            System.out.println("el numero mas grande es el: " + num1);
        } else {
            if (num2 >= num3){
                System.out.println("el numero mas grande es el: " + num2);
            } else {
                System.out.println(num3);

            }
        }
    }
}
