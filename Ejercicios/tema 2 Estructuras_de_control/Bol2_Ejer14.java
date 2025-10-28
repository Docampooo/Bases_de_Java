import java.util.Scanner;
public class Bol2_Ejer14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num;
        int cont = -1;
        double acu = 0;

        System.out.println("introduce todos los numeros que quieras y pon el 0 para finalizar el programa");
        System.out.println("-----------------------------------------------------------------------------");
        do{
            num = sc.nextDouble();
            cont++;
            if(num < 0){
                acu = acu + 1;
            }
        } while (num != 0);
        System.out.printf("se introdujeron %f numeros negativos de un total de %d ",acu, cont);
    }
}
