import java.util.Scanner;

public class Bol3_Ejer6 {
    /**
     * funcion que calcula la potencia de un numero
     * @param base base  
     * @param exponente exponente  
     * @return devuelve la el resultado de la potencia
     */
    public static double potencia(double base, double exponente) {
        double potencia = 1;
        double cont;
        if (exponente >= 0) {

            for (cont = 0; cont < exponente; cont++) {
                potencia = potencia * base;
            }
        } else {
            for (cont = 0; cont > exponente; cont--) {
                potencia = potencia / base;
            }
        }
        return potencia;
    }

    /**
     *   muestra por pantalla los
     * primeros valores de la potencia
     * 
     * @param base número del que se muestran los valores
     * @param exponente exponente max  del numero
     */
    public static void pot2(double base, double exponente) {
        System.out.println("Las primeras potencias del numero son ");
        if (exponente < 0) {
            for (double cont = 0; cont >= exponente; cont--) {
                System.out.printf("%2f:  ", potencia(base, cont));
            }
        } else {
            if (exponente == 0) {
                for (double cont2 = 0; cont2 <= exponente; cont2++) {
                    System.out.printf("%2f:  ", potencia(base, cont2));
                }
            }
            for (double expo = 0; expo <= exponente; expo++) {
                System.out.printf("%2f:  ", potencia(base , expo));
                System.out.println();
            }
        }
    }
    /**
     * saca por pantalla la progresión geométrica de un número y su exponente
     * @param base número elegido por el usuario
     * @param exponente exponente de dicho número
     * @return devuelve la progresión geométrica
     */
    public static double pot3(double base, double exponente) {
       // System.out.println("la progresión geométrica es:");
        double resultado = 0;
        if (exponente < 0) {
            for (double cont = 0; cont >= exponente; cont--) {
                resultado = resultado + potencia(base, cont);
            }
        } else {
            if (exponente == 0) {
                for (double cont = 0; cont <= exponente; cont++) {
                    resultado = resultado + potencia(base, cont);
                }
            }
            for (double cont = 0; cont <= exponente; cont++) {
                resultado = resultado + potencia(base, cont);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base;
        double exponente;
        System.out.println("introduce un numero: ");
        base = sc.nextDouble();
        System.out.println("introduce el exponente: ");
        exponente = sc.nextDouble();
        System.out.println("-----------------------------------------------");

        System.out.println(potencia(base, exponente));

        pot2(base, exponente);

        System.out.println(pot3(base, exponente));

    }

}
