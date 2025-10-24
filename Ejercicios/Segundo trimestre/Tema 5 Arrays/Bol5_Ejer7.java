import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bol5_Ejer7 {

    /**
     * limpia una coleccion y la rellena con 6 valores aleatorios entre 1 y 49
     * 
     * @param col colección con la que actúa
     */
    public static void rellenaCol(ArrayList<Integer> col) {// TODO revisar repetidos
        col.clear();

        int n;
        for (int i = 0; i < 6; i++) {
            n = (int) (Math.random() * 49 + 1); // comprobar
            while(col.contains(n)){
                n = (int) (Math.random() * 49 + 1);
            }
            col.add(n);
        }
    }

    /**
     * se le pasan 2 colecciones de enteros y comprueba cuántos valores hay
     * repetidos entre los valores de ambas colecciones
     * 
     * @param vector  coleccion de enteros 1
     * @param vector2 coleccion de enteros 2
     * @return devuelve el número de valores repetidos
     */
    public static int compara(ArrayList<Integer> vector, ArrayList<Integer> vector2) {

        int result = 0;
        for (int i = 0; i < vector.size(); i++) {
            if (vector.contains(vector2.get(i))) {
                result++;
            }
        }
        return result;
    }

    /**
     * Comprueba si en un String de números, todos estén entre el 0 y el 49
     * separados por espacios o comas
     * 
     * @param cadena cadena con números a comprobar
     * @return true si se cumple la comprobacion y false si no se cumple
     */
    public static boolean comprobacion(String cadena) {
        ArrayList<Integer> comprobar = new ArrayList<>();

        int num = 0;

        String[] linea = cadena.split("[,]");

        if (linea.length != 6) {
            System.out.println("Cantidad de valores errónea\n");
            return false;
        }
        try {
            for (int cont = 0; cont < linea.length; cont++) {
                num = Integer.parseInt(linea[cont].trim());
                if (comprobar.contains(num)) {
                    System.out.println("Valor repetido");
                    return false;
                } else {
                    comprobar.add(Integer.parseInt(linea[cont].trim()));
                }
                if (num <= 0 || num > 49) {
                    System.out.println("Valor fuera de rango\n");
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor no válido");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {// TODO no dejar rep. 1-49

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> coleccion = new ArrayList<Integer>();

        String valores;
        do {
            System.out
                    .println("Introduce 6 números enteros entre el 0 y el 49 en la misma línea y separados por comas");
            valores = sc.nextLine();
        } while (!comprobacion(valores));

        for (String c : valores.split("[,]")) {
            coleccion.add(Integer.parseInt(c.trim()));
        }

        ArrayList<Integer> loteria = new ArrayList<>();
        int[] aciertos = { 0, 0, 0, 0, 0, 0, 0 };

        for (int cont = 0; cont < 1000000; cont++) {
            rellenaCol(loteria);
            aciertos[compara(coleccion, loteria)] = aciertos[compara(coleccion, loteria)] + 1;
        }
        System.out.printf("Aciertos: ");
        for (int i = 0; i <= loteria.size(); i++) {
            System.out.printf(" [%d] ", aciertos[i]);
        }
    }
}
