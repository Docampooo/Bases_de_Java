import java.util.Scanner;

public class Bol2_Ejer6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double num1;

        do {
            System.out.println("introduce un numero del 1 al 6");
            System.out.println("1º se aplica el cuadrado del numero real");
            System.out.println("2º se aplica el inverso del numero con 4 decimales de aproximacion");
            System.out.println("3º se aplica la raiz cuadrada del numero");
            System.out.println("4º se aplica la operacion AND a nivel de bit con dos enteros y resultado en EXA");
            System.out.println(
                    "5º se aplica la operacion OR a nivel de bit entre dos numeros enteros y resultado en EXA");
            System.out.println("6º salir");
            System.out.println("------------------------");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("introduce un numero real: ");

                    num1 = sc.nextDouble();
                    double cuadrado = num1 * num1;
                    System.out.printf("el cuadrado es %.2f \n", cuadrado);
                    break;
                case 2://Bucle
                        do{
                            System.out.println("introduce un numero real diferente de 0: ");
                            
                            num1 = sc.nextDouble();
                            double inverso = 1 / num1;
                            System.out.printf("el inverso es %.4f \n", inverso);
                        }while (num1 == 0);
                    break;
                case 3://Bucle
                        do{
                            System.out.println("introduce un numero real diferente de 0: ");
                            
                            num1 = sc.nextDouble();
                            System.out.printf( "la raíz es %.4f \n", Math.sqrt(num1));
                        }while (num1 == 0);
                    break;
                case 4:
                    System.out.println("introduce dos numeros enteros: ");
                    int num2 = sc.nextInt();
                    int num3 = sc.nextInt();
                    int and = ((num2) & (num3));
                    System.out.printf("la operacion AND entre estos dos enteros es: %X \n", and);
                    break;
                case 5:
                    System.out.println("introduce dos numeros enteros: ");
                    int num4 = sc.nextInt();
                    int num5 = sc.nextInt();
                    int or = ((num4) | (num5));
                    System.out.printf("la operacion OR entre estos dos enteros es: %X \n", or);
                    break;
                case 6:
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opcion != 6);
    }
}
