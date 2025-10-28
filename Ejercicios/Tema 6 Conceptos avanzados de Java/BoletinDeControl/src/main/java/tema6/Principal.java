package tema6;

import java.util.IllegalFormatException;
import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Geometria r = new Geometria(true,4,5);

        Geometria t = new Geometria();

        double valor;

        System.out.println("Inserta la altura del triángulo");
        valor = sc.nextDouble();
        if(valor <= 0){
            throw new IllegalArgumentException("No se permiten valores nulos ni negativos");
        }
        t.setAltura(valor);
        

        System.out.println("Inserta la basee del triángulo");
        valor = sc.nextDouble();
        if(valor <= 0){
            throw new IllegalArgumentException("No se permiten valores nulos ni negativos");
        }
        t.setBase(valor);
        

        System.out.printf("%s: base: %.2f altura: %.2f Perimetro: %.2f Diagonal: %.2f Area %.2f \n",r.tipo(), r.getBase(), r.getAltura(), r.perimetro() ,r.diagonal() , r.area());
        System.out.printf("%s: base: %.2f altura: %.2f Perimetro: %.2f Diagonal: %.2f Area %.2f \n",t.tipo(), t.getBase(), t.getAltura(), t.perimetro() ,t.diagonal() , t.area());
    }
}