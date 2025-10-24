import java.util.Scanner;

public class Bol2_Ejer17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int cont;
        int acu;
        int multi;
        int option = 0;

        do {
            acu = 0;
            cont = 0;
            multi = 0;
            System.out.println("introduzca un numero entre 1 y 50: ");
            n = sc.nextInt();
            System.out.println("-----------------------------------------");
            while ((n < 0) || (n > 50)) {
                System.out.println("el numero introducido está fuera de rango, introduce otro");
                n = sc.nextInt();
            }
            while (multi < 100 - n){
                cont++;
                multi = n * cont;
                acu = acu + multi;
                System.out.println(multi + ",");
            }
            System.out.println("La suma de los multiplos es: " + acu);
            System.out.println("introduce el numero 1 para repetir el programa");
            option = sc.nextInt();
        } while (option == 1);
    }
}