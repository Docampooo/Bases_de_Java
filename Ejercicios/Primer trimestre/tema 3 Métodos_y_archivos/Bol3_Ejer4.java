import java.util.Scanner;

public class Bol3_Ejer4 {
    /**
     * Comprueba si un año es bisisesto
     * 
     * @param año año a comprobar
     * @return devuelve true si dicho año es
     *         bisiesto y false en caso contrario.
     */
    public static boolean bisiesto(int año) {
        return ((año % 4 == 0 && año % 100 != 0 || año % 400 == 0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int año;
        boolean bandera;

        do {
            System.out.println(
                    "introduce diferentes años. Si es bisiesto, saldrá true, si no false, el programa acaba cuando se introduzca el 0");
            año = sc.nextInt();
            if (bisiesto(año)) {
                System.out.println("el año es bisiesto");
            } else {
                System.out.println("el año no es bisiesto");
            }
        } while (año != 0);
    }
}