import java.util.Scanner;

public class Bol2_Ejer18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        double n;
        double acu;
        
        do {
            acu=1;
            System.out.println("introduce un numero positivo del que quieras saber su factorial");
            n = sc.nextDouble();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("elige el bucle por el que quieras realizar la operacion");
            System.out.println("1º while");
            System.out.println("2º do while");
            System.out.println("3º for");
            System.out.println("4º salir");
            System.out.println("----------------------------------------------------------------------------------");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    while(n>1){
                        acu = acu*n;
                        n--;
                    }
                    System.out.printf("el factorial es: %f ",acu);
                    break;
                case 2:
                    int x = 0;
                    do{
                        x++;
                        acu = acu * x;
                    }while((n>1)&&(x<n));
                    System.out.printf("el factorial es: %f ",acu);
                    break;
                case 3:
                    for(acu=1;n>1;n--){
                        acu = acu*n;
                    }
                    System.out.printf("el factorial es: %f ",acu);
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