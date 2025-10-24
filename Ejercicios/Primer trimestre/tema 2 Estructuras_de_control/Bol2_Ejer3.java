import java.util.Scanner;
public class Bol2_Ejer3 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        int num1;
        int cont = 0;
        int acu = 0;

        System.out.println("Introduce un numero:  ");
        num1 = sc.nextInt();

        if(num1 > 0){
            do {
                cont = cont + 1;
                acu = cont + acu;
            }
            while(cont<num1);
            System.out.println(acu);
            
        }

    }
}
