import java.util.Scanner;

public class IUEmpleado {

    public Empleado e;

    public IUEmpleado(Empleado e) {
        this.e = e;
    }

    public void mostrar(int eleccion) {
        Scanner sc = new Scanner(System.in);
        switch (eleccion) {
            case 1:
                System.out.printf("%s \n", e.getNombre() + " " + e.getApellidos());
                break;
            case 2:
                System.out.printf("Edad: %d \n", e.getEdad());
                break;
            case 3:
                System.out.printf("DNI: %s \n", e.getDNI());
                break;
            case 4:
                System.out.printf("El salario anual es: %.2f \n", e.getSalarioAnual());
                break;
            case 5:
                System.out.printf("La cantidad que se lleva hacienda es: %.2f \n", Empleado.hacienda(e.getSalarioAnual(), e.getIrpf(e.getSalarioAnual())));
                break;

            default:
                break;
        }
    }

    public void mostrar() {
        System.out.printf(
                "El nombre completo del empleado es %s, tiene %d años, con DNI %s, un salario de %.2f, y un IRPF de %.2f \n",
                e.getNombre() + " " + e.getApellidos(), e.getEdad(), e.getDNI(), e.getSalarioAnual(),
                Empleado.hacienda(e.getSalarioAnual(), e.getIrpf(e.getSalarioAnual())));
    }

    public void pedir() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del empleado: ");
        e.setNombre(sc.nextLine());
        System.out.println("Ahora los apellidos: ");
        e.setApellidos(sc.nextLine());
        System.out.println("ahora la edad: ");
        e.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.println("ahora su DNI: ");
        e.setDNI(sc.nextLine());
        System.out.println("ahora su salario: ");
        e.setSalarioAnual(sc.nextDouble());
    }
}
