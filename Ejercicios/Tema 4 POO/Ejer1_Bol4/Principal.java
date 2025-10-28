import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Geometria r = new Geometria(true,4,5);

        Geometria t = new Geometria();

        System.out.println("Inserta la altura del triángulo");
        t.setAltura(sc.nextDouble());

        System.out.println("Inserta la basee del triángulo");
        t.setBase(sc.nextDouble());

        System.out.printf("%s: base: %.2f altura: %.2f Perimetro: %.2f Diagonal: %.2f Area %.2f \n",r.tipo(), r.getBase(), r.getAltura(), r.perimetro() ,r.diagonal() , r.area());
        System.out.printf("%s: base: %.2f altura: %.2f Perimetro: %.2f Diagonal: %.2f Area %.2f \n",t.tipo(), t.getBase(), t.getAltura(), t.perimetro() ,t.diagonal() , t.area());
    }
}