import java.util.Scanner;

public class Bol2_Ejer16 {
    public static void main(String[] args) {// Poder repetir juego
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int num2;
        int volver;
        int cont;
        do{
            cont=0;
            System.out.println("jugador 1, introduce un numero entero del 0 al 100");
            int num1 = sc.nextInt();
            
            while ((num1 < 0) || (num1 > 100)) {
                
                System.out.println("el numero tiene que entrar en el rango de 1 y 100, prueba otra vez");
                num1 = sc.nextInt();
            }
            do {
                System.out.println(" \n ");
                x = x + 1;
            } while (x < 100);
            System.out.println("jugador 2, debes adivinar el numero en tan solo 5 intentos \n");
            System.out.println("adivina el numero: ");
            
            num2 = sc.nextInt();
            while ((num1 != num2) && (cont < 5 )){
                
                System.out.println("prueba otra vez");
                cont = cont + 1;
                int resta = 5 - cont;
                System.out.println("te quedan " + resta + " intentos");
                if(num2 < num1){
                    System.out.println("el numero es más grande");
                } else{
                    System.out.println("el numero es más pequeño");
                }
                num2 = sc.nextInt();
            }
            System.out.println("has acertado!");
            System.out.println("introduce el numero 3 para volver a jugar");
            volver = sc.nextInt();

        }while(volver == 3);
     }
}
