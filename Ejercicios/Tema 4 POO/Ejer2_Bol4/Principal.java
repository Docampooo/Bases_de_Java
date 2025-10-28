import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Fecha f1 = new Fecha();
        
        Fecha f2 = new Fecha();

        System.out.println("Introduce un día del año");
        f1.setDia(sc.nextInt());
        System.out.println("Introduce un mes del año");
        f1.setMes(sc.nextInt());
        System.out.println("Introduce un año");
        f1.setAño(sc.nextInt());

        System.out.println("Introduce otro día del año");
        f2.setDia(sc.nextInt());
        System.out.println("Introduce otro mes del año");
        f2.setMes(sc.nextInt());
        System.out.println("Introduce otro año");
        f2.setAño(sc.nextInt());

        System.out.println("Las fechas son:");
        System.out.printf(" \t %s %s \n", f1.fechaFormateada(false));
        
        System.out.printf(" \t %s %s \n", f2.fechaFormateada(false));

        System.out.printf("La diferencia de años entre las fechas es: %d \n",Fecha.diferenciaFechas(f1,f2));
        
    }
}
