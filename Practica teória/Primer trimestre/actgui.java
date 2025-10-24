import java.util.Scanner;

public class actgui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int precio;
        precio = 300;
        int edad;
        double carne;

        System.out.println("Escribe tu edad: ");
        edad = sc.nextInt();
        System.out.println("Escribe también tus años con carné: ");
        carne = sc.nextDouble();

        if (edad < 21) {
            precio = 400;
            System.out.println("El seguro de tu coche cuesta: " + precio);
        } else {
            if (carne <= 10) {
                precio = 300;
                System.out.println("El seguro de tu coche cuesta: " + precio);
            } else {
                precio = 270;
                System.out.println("El seguro de tu coche cuesta: " + precio);
            }
        }

    }
}