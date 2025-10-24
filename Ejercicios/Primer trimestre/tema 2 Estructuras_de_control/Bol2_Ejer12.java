import java.util.Scanner;

public class Bol2_Ejer12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("introduce un numero del 1 al 6");
            System.out.println("1º numeros del 0 al 50");
            System.out.println("2º numeros del 50 al 0");
            System.out.println("3º numeros pares menores que 20 por orden creciente");
            System.out.println("4º número(s impares entre lo 90 y el 130 por orden creciente");
            System.out.println("5º Los múltiplos de 5 entre el 70 y el 25 por orden decreciente");
            System.out.println("6º salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("los numeros del 1 al 50 son: ");
                    for (int cont = 1; cont < 51; cont++) {
                        System.out.println(cont);
                    }
                    break;
                case 2:
                    System.out.println("los nuemros del 50 al 1 son: ");
                    for (int cont = 50; cont > 0; cont--) {
                        System.out.println(cont);
                    }
                    break;
                case 3:
                    System.out.println("Los números pares menores que 20 por orden creciente son: ");
                    for (int cont = 2; cont < 20; cont = cont + 2) {
                        System.out.println(cont);
                    }
                    break;
                case 4:
                    System.out.println("Los números impares entre lo 90 y el 130 por orden creciente son ");//Revisar
                    for (int cont = 91; cont < 131; cont = cont + 2) {
                        System.out.println(cont);
                    }
                    break;
                case 5:
                    System.out.println("Los múltiplos de 5 entre el 70 y el 25 por orden decreciente son: ");
                    for (int cont = 70; cont > 24; cont = cont - 5) {
                        System.out.println(cont);
                    }
                    break;
                case 6:
                    System.out.println("has salido");
                    break;
                default:
                    System.out.println("el numero no esta en la lista");
            }
        } while (opcion != 6);
    }
}