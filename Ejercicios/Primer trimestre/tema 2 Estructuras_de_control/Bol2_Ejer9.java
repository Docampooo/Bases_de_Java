import java.util.Scanner;

public class Bol2_Ejer9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int eleccion;
        int cont = 1;
        double num;
        double max;

        System.out.println("cuantos numeros quieres introducir? ");
        eleccion = sc.nextInt();
        if (eleccion < 0) {
            System.out.println("No puedes introducir negativos");
        } else {
            System.out.println("introduce  los numeros: ");
            max = sc.nextDouble();

            do {
                num = sc.nextDouble();
                cont++;
                if (num > max) {
                    max = num;
                }

            } while (cont != eleccion);
            System.out.println("el numero más grande es: " + max);
        }
    }
}
