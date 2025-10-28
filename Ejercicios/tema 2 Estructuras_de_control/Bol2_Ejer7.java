import java.util.Scanner;

public class Bol2_Ejer7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num;
        double acu = 0;
        int option;
        int cont = 1;

        do {
            System.out.println("introduce los numeros que quieras:  ");
            acu = 0;
            cont = 0;
            do {
                num = sc.nextDouble();
                if (num > 0) {
                    acu = acu + num;
                    cont++;
                }

            } while (num != 0);

            double media = acu / cont;
            System.out.println("la suma es " + acu);
            System.out.println("La media es: " + media);

            System.out.println("pulsa 2 para salir y cualquier otro numero para repetir el programa");
            option = sc.nextInt();
        } while (option != 2);
    }
}
