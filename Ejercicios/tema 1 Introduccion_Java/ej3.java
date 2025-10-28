import java.util.Scanner;
public class ej3{
    public static void main (String[] args){
        
        int numero1;
        int numero2;
        int suma;
        int division;
        int resto;
        Scanner sc = new Scanner(System.in);

        System.out.println("inserta un numero entero");
        numero1 = sc.nextInt();
        System.out.println("inserta otro numero entero");
        numero2 = sc.nextInt();
        suma = (numero1 + numero2);
        division = (numero1 / numero2);
        resto = (numero1 % numero2);

        System.out.println("el resultado de la suma de estos dos números es: " + suma);
        System.out.println("su division es: " + division + " y su resto es: " + resto);

    }

}