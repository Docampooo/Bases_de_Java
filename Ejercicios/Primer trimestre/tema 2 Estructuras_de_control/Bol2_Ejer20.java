import java.util.Scanner;
public class Bol2_Ejer20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int cont4=-1;

        System.out.println("introduce el numero de filas que quieras que tenga tu pirámide: ");
        n = sc.nextInt();
        System.out.println("-----------------------------------------------------------------------------------");

        for(int cont5=0;cont5<n;cont5++){
            for(int cont6=0;cont6<cont5;cont6++){
                System.out.print("*");
            }
            System.out.println("*");
        }
        
        System.out.println("---------------------------------------------------");

        for(int cont=n; cont<2*n;cont++){
            cont4++;
            for(int cont3=0; cont3<n-cont4;cont3++){
                System.out.print(" ");
            }
            for(int cont2=n-cont4; cont2<n+cont4;cont2++){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
