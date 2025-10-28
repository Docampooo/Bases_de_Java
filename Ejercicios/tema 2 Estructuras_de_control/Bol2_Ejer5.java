import java.util.Scanner;

public class Bol2_Ejer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selector;
        double C;
        String conversion;
        System.out.println("introduce la temperatura en grados Celsius:  ");
        C = sc.nextDouble();

        do {
            System.out.println("1º convertir a Farenheit");
            System.out.println("2º convertir a Kelvin");
            System.out.println("3º salir");
            System.out.println("teclee una opcion del 1 al 3");

            selector = sc.nextInt();

            switch (selector) {
                case 1:
                    double F = 1.8 * C + 32;
                    System.out.printf("los grados en Farenheit son %.3f ºF", F);

                    break;
                case 2:
                    double K = C + 273.15;
                    System.out.printf("los grados en Kelvin son %.3f", K);

                    break;
                case 3:
                    System.out.println("has salido ");
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        } while (selector != 3);
    }
}
