import java.util.*;
public class positivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println("Introduce un número entero: ");
        numero = sc.nextInt();
        
        if (numero > 0) {
            System.out.println("El numero es positivo: ");
        } else {
            if (numero == 0) {
                System.out.println("El numero es 0");
            } else {
                System.out.println("El numero es negativo");
            }
        }
    }
}