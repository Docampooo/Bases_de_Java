package tema6;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Geometria r = new Geometria(true,4,5);

        Geometria t = new Geometria();

        double valor = 0;
        boolean error;
        do{
            error = false;
            try{
                System.out.println("Inserta la altura del triángulo");
                valor = sc.nextDouble();
            }catch (IllegalArgumentException | InputMismatchException e){
                error = true;
                System.out.println("Solo se admiten numeros");
            }
            sc.nextLine();

        } while(error);

        t.setAltura(valor);
        
        do{
            error = false;
            try{
                System.out.println("Inserta la base del triángulo");
                valor = sc.nextDouble();

            }catch(IllegalArgumentException | InputMismatchException e){
                error = true;
                System.out.println("Solo se admiten numeros");
            }
            sc.nextLine();
        }while(error);
        t.setBase(valor);
        

        System.out.printf("%s: base: %.2f altura: %.2f Perimetro: %.2f Diagonal: %.2f Area %.2f \n",r.tipo(), r.getBase(), r.getAltura(), r.perimetro() ,r.diagonal() , r.area());
        System.out.printf("%s: base: %.2f altura: %.2f Perimetro: %.2f Diagonal: %.2f Area %.2f \n",t.tipo(), t.getBase(), t.getAltura(), t.perimetro() ,t.diagonal() , t.area());
    }
}