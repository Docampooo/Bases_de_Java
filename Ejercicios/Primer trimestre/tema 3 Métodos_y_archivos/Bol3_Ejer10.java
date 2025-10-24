import java.util.Scanner;

public class Bol3_Ejer10 {
    /**
     * función que calcula áreas en tri y rectángulos
     * @param interruptor valor en boolean para diferenciar entre triángulos false,  y rect true
     * @param i primer parámetro que introduce el usuario
     * @param k segundo parámetro que introduce le usuario
     * @return devuelve el área calculada
     */
    public static double area(boolean interruptor, double i, double k) {
        double area;
        if (interruptor) {
            area = i * k;
        } else {
            area = i * k / 2;
        }
        return area;
    }
    /**
     * función que calcula el área de un círculo 
     * @param radio valor   como el radio de la circunferencia
     * @return devuelve el área 
     */
    public static double area2(double radio){
        double area;
        area = radio*radio*Math.PI;
        
        return area;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base;
        double altura;
        boolean bandera;
        int option;

        do {
            System.out.println("elige una de las 5 opciones para calcular el area");
            System.out.println("------------------------------------------------");
            System.out.println("1º Area triángulo");
            System.out.println("2º Area rectángulo");
            System.out.println("3º Area cuadrado");
            System.out.println("4º Area círculo");
            System.out.println("5º Salir");
            System.out.println("------------------------------------------------");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    bandera = false;
                    System.out.println("introduce una base y una altura");
                    base = sc.nextDouble();
                    altura = sc.nextDouble();
                    System.out.println(area(false, base, altura));
                    break;
                case 2:
                    bandera = true;
                    System.out.println("introduce una base y una altura");
                    base = sc.nextDouble();
                    altura = sc.nextDouble();
                    System.out.println(area(true, base, altura));
                    break;
                case 3:
                    bandera = true;
                    System.out.println("introduce el lado del cuadrado");
                    double lado = sc.nextDouble();
                    System.out.println(area(true, lado, lado));
                    break;
                case 4:
                    System.out.println("introduce el radio del circulo");
                    double radio = sc.nextDouble();
                    System.out.println(area2(radio));
                    break;
                case 5:
                    System.out.println("has salido");
                    break;
                default:
                    System.out.println("valor fuera de rango");
                    break;
            }
        } while (option != 5);

    }
}
