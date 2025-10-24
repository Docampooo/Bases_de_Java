import java.util.Scanner;

public class Principal {

    public static void datosempleado(Empresa emp) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("Que datos quieres ver?");
            System.out.println("1º Nombre y apellidos");
            System.out.println("2º Edad");
            System.out.println("3º DNI");
            System.out.println("4º Salario anual");
            System.out.println("5º Cantidad para Hacienda");
            System.out.println("6º ver todos los datos de ambos empleados");
            System.out.println("7º Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    emp.iue1.mostrar(opcion);
                    emp.iue2.mostrar(opcion);
                    break;
                case 6:
                    emp.iue1.mostrar();
                    emp.iue2.mostrar();
                    break;
                case 7:
                break;
                
                default:
                System.out.println("opcion fuera de rango");
                break;
            }
        } while (opcion != 7);
        System.out.println("has salido");
    }

    public static void datosDirector(Empresa emp) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("Que datos quieres ver?");
            System.out.println("1º Nombre y apellidos");
            System.out.println("2º Edad");
            System.out.println("3º DNI");
            System.out.println("4º Departamento");
            System.out.println("5º Beneficios");
            System.out.println("6º Todos los datos");
            System.out.println("7º Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    emp.iud.mostrar(opcion);
                    break;
                case 6:
                    emp.iud.mostrar();
                    break;
                case 7:
                    System.out.println("has salido");
                    break;

                default:
                    System.out.println("opcion fuera de rango");
                    break;
            }
        } while (opcion != 7);
    }

    public static void modificarDatos(Empresa emp) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Cuál quieres modificar?");
            System.out.println("1º Empleado");
            System.out.println("2º Directivo");
            System.out.println("3º salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int opcion2 = 0;
                    do {
                        System.out.println("elige un empleado para modificarlo");
                        System.out.printf("1º ");
                        emp.iue1.mostrar(1);
                        System.out.printf(" \n2º ");
                        emp.iue2.mostrar(1);
                        System.out.printf("\n3º salir \n");
                        opcion2 = sc.nextInt();
                        switch (opcion2) {
                            case 1:
                                emp.iue1.pedir();
                                break;
                            case 2:
                                emp.iue2.pedir();
                                break;
                            case 3:
                                System.out.println("has salido");
                                break;
                            default:
                                System.out.println("opcion fuera de rango");
                                break;
                        }
                    } while (opcion2 != 3);
                    break;
                case 2:
                    emp.iud.pedir();
                    break;
                case 3:
                    System.out.println("has salido");
                    break;

                default:
                    System.out.println("opcion fuera de rango");
                    break;
            }
        } while (opcion != 3);
    }

    public static void pagar(Empresa emp) {
        System.out.printf(
                "Los beneficios de la empresa son: %.2f el salario anual de los empleados es: %s %.2f, %s %.2f \n",
                emp.d.getBeneficios(), emp.e1.getNombre() + " " + emp.e1.getApellidos(), emp.e1.getSalarioAnual(),
                emp.e2.getNombre() + " " + emp.e2.getApellidos(), emp.e2.getSalarioAnual());
        emp.setGanacias(emp.getGanancias() - (emp.e1.getSalarioAnual() + emp.e1.getSalarioAnual()));
        System.out.println("las ganancias tras el pago son: " + emp.getGanancias());
    }

    public static void cobrar(Empresa emp){
        Scanner sc = new Scanner(System.in);

        System.out.printf("Las gananciasa son: %f \n", emp.d.getBeneficios());
        System.out.println("introduce la cantidad que quieras ingresar");
        double ingresar = sc.nextDouble();
        System.out.printf("Tras el ingreso, las ganancias son: %f \n", emp.d.getBeneficios() + ingresar);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empleado e1 = new Empleado("Alberto", "Carril", 24, "87936258p", 22000);
        Empleado e2 = new Empleado("Pablo", "Vaz", 20, "8444378u", 28000);
        Directivo d = new Directivo("Nicolas", "Docampo", 18, "3728723q", "Reposteria", 63000);

        Empresa emp = new Empresa(d, e1, e2, 18000);

        int opcion = 0;
        do {
            System.out.println("Selecciona una de las siguientes opciones");
            System.out.println("1º Ver datos Empleado");
            System.out.println("2º Ver datos directivo");
            System.out.println("3º Modificar datos");
            System.out.println("4º Pagar");
            System.out.println("5º Cobrar");
            System.out.println("6º Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    datosempleado(emp);
                    break;
                case 2:
                    datosDirector(emp);
                    break;
                case 3:
                    modificarDatos(emp);
                    break;
                case 4:
                    pagar(emp);
                    break;
                case 5:
                    cobrar(emp);
                    break;
                case 6:
                    System.out.println("Has salido");
                    break;

                default:
                    System.out.println("Valor fuera de rango");
                    break;
            }
        } while (opcion != 6);
    }
}