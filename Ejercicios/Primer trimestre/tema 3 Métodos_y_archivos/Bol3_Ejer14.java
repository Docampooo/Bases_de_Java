import java.util.Scanner;

public class Bol3_Ejer14 {

    public static int tirada() {
        int d1 = (int) (Math.random() * 6 + 1);
        int d2 = (int) (Math.random() * 6 + 1);
        System.out.printf("Los dados sacaron: %d %d \n", d1, d2);

        int suma = d1 + d2;

        return suma;
    }

    public static int comprobacion(int valor) {
        int result = 0;
        if ((valor == 7) || (valor == 11)) {
            result = 0;
        } else if ((valor == 2) || (valor == 3) || (valor == 12)) {
            result = -1;
        } else {
            result = valor;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de craps!");
        System.out.println("Tu turno de tirar");
        int djug = tirada();
        int result1 = comprobacion(djug);
        if (result1 == 0) {
            System.out.println("Ganador!");
        } else if (result1 == -1) {
            System.out.println("Perdedor!");
        } else {
            System.out.println("turno de la máquina");
            int dmaq = tirada();
            int result2 = comprobacion(dmaq);
            if (result2 == 0) {
                System.out.println("Ganador!");
            } else if (result2 == -1) {
                System.out.println("Perdedor!");
            } else {
                if ((result2 != 0) && (result2 != -1)) {
                    System.out.println("los puntos de la máquina son: " + result2);
                    System.out.printf("tus puntos son: %d  \n", result1);
                    if (result1 > result2) {
                        System.out.println("Has ganado!");
                    } else if (result1 < result2) {
                        System.out.println("Gana la máquina!");
                    } else {
                        System.out.println("empate");
                    }
                }
            }
        }
    }
}
