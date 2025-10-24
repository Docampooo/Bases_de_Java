import java.util.Scanner;

public class Bol3_Ejer3 {
    /**
     * Pide dato al usuario comprobando que sea positivo

     * @return devuelve el numero positivo introducido
     */
    public static double pedirDato() {
        Scanner sc = new Scanner(System.in);
        double n;

        System.out.println("Dime un numero");
        n=sc.nextDouble();
        while (n<0) {
            System.out.println("Valor negativo");
            n = sc.nextDouble();
        } 
        return n;
    }
    /**
     * Calcula el area de un cilindro
     * @param radio Radio del cil
     * @param altura Altura del cil
     * @return devuelve la superficie
     */
    public static double superficieCilindro(double radio, double altura) {
        double superficie;
        superficie = 2 * Math.PI * radio * altura;
        return superficie;
       // return 2 * Math.PI * radio * altura;
    }
    /**
     * función que muestra ujn dato con 3 decimales y un mensaje
     * @param n dato
     * @param msg cadena de texto
     */
    public static void mostrarDatos(double n, String msg) {
        System.out.printf( "%s     %.3f",msg,  n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double radio;
        double altura;
        radio = pedirDato();
        altura = pedirDato();
        superficieCilindro(radio, altura);
        double superficie = superficieCilindro(radio, altura);

        mostrarDatos(superficie, "resultado:");  //introducir el resulatdo de superficie cilindro
    }
}
