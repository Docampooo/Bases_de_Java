import java.util.Scanner;
public class Bol_2Ejer15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        double euro;
        double libra;

        do{
            System.out.println("---------------------------------------------------------------------------------------");

            System.out.println("inserta un numero del 1 al 3:  ");
            System.out.println("1º conversor de euros a libras");
            System.out.println("2º conversor de libras a euros");
            System.out.println("3º salir");
            System.out.println("---------------------------------------------------------------------------------------");
            opcion = sc.nextInt();
            
            switch(opcion){//No permitir neg

                case 1:
                        System.out.println("inserta la cantidad de euros que quieras pasar a libras:  ");
                        euro = sc.nextDouble();
                        while(euro < 0){
                            System.out.println("no se aceptan numeros negativos, introduce otro");
                            euro = sc.nextDouble();
                        }
                        libra = euro * 0.84;
                        System.out.printf("la conversion equivalent es la cantidad de %.2f  libras \n",libra);
                        break;
                        case 2:
                        System.out.println("inserta la cantidad de libras que quieras pasar a euros");
                        libra = sc.nextDouble();
                        while(libra < 0){
                            System.out.println("no se aceptan numeros negativos, introduce otro");
                            libra = sc.nextDouble();
                        }
                        euro = libra * 1.14;
                        System.out.printf("la conversion equivalente es la cantidad de %.2f  euros \n", euro);
                break;
                case 3:
                         System.out.println("has salido");
                break;
                default:
            }
        } while (opcion != 3);
    }
}
