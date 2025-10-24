import java.util.Scanner;

public class Bol2_Ejer13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double acu2;

        System.out.println("------------------------------------------------------------------------------");
        do {
            System.out.println("introduce un numero del 1 al 4");
            System.out.println("1º Suma de numeros pares entre 0 y N");
            System.out.println("2º Suma de numeros impares entre 0 y N");
            System.out.println("3º Suma de numeros pares por una parte e impares por otra entre 0 y N");
            System.out.println("4º salir");
            opcion = sc.nextInt();

            System.out.println("introduce un numero: ");
            double n = sc.nextDouble();

            double acu;

            switch (opcion) {

                case 1:
                    acu = 0;

                    if (n < 0) {
                        for (int cont = 0; cont > n; cont = cont - 2) {

                            acu = acu + cont;
                        }
                        System.out.println("La suma de nuemros pares entre el 0 y el nuemro es:  " + acu);
                    } else {
                        for (int cont = 0; cont < n; cont = cont + 2) {

                            acu = acu + cont;
                        }
                    }
                    System.out.println("La suma de nuemros pares entre el 0 y el nuemro es:  " + acu);
                    break;
                case 2:
                    acu = 0;

                    if (n < 0) {
                        for (int cont = 1; cont > n; cont = cont - 2) {

                            acu = acu + cont;
                        }
                        System.out.println("La suma de nuemros pares entre el 0 y el nuemro es:  " + acu);
                    } else {
                        for (int cont = 1; cont < n; cont = cont + 2) {

                            acu = acu + cont;
                        }
                    }
                    System.out.println("La suma de nuemros pares entre el 0 y el nuemro es:  " + acu);
                    break;
                case 3:
                    acu = 0;
                    acu2 = 0;
                
                    for (int cont = 0; cont < n; cont = cont+1) {
                        if (cont % 2 == 0) {
                            acu = acu + cont;
                        } else {
                            acu2 = acu2 + cont;
                        }
                    }
                    System.out.println(acu);
                    System.out.println(acu2);
                    break;
                case 4:
                    System.out.println("has salido");
                    break;
                default:
                    System.out.println("el numero no está en la lista");
            }

        } while (opcion != 4);
    }
}
