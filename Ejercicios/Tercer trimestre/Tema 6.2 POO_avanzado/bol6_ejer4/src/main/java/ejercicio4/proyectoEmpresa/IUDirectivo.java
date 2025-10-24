package ejercicio4.proyectoEmpresa;

import java.util.Scanner;

public class IUDirectivo {

    public Directivo d;

    public IUDirectivo(Directivo d) {
        this.d = d;
    }

    public void mostrar(int eleccion) {
        Scanner sc = new Scanner(System.in);
        switch (eleccion) {
            case 1:
                System.out.printf("%s \n", d.getNombre() + " " + d.getApellidos());
                break;
            case 2:
                System.out.printf("Edad: %d \n", d.getEdad());
                break;
            case 3:
                System.out.printf("DNI: %s \n", d.getDNI());
                break;
            case 4:
                System.out.printf("Departamento: %s \n", d.getDepartamento());
                break;
            case 5:
                System.out.printf("Los beneficios son: %.2f \n", d.getBeneficios());
                break;
            default:
                break;
        }
    }

    public void mostrar() {
        System.out.printf(
                "El nombre del directivo es %s, tiene %d años, su DNI es %s, está en el departamento de %s y tiene unos beneficios de %.2f \n",
                d.getNombre() + " " + d.getApellidos(), d.getEdad(), d.getDNI(), d.getDepartamento(),
                d.getBeneficios());
    }

    public void pedir() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del directivo: ");
        d.setNombre(sc.nextLine());
        System.out.println("Ahora los apellidos: ");
        d.setApellidos(sc.nextLine());
        System.out.println("ahora la edad: ");
        d.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.println("ahora su DNI: ");
        d.setDNI(sc.nextLine());
        System.out.println("ahora su departamento: ");
        d.setDepartamento(sc.nextLine());
        System.out.println("ahora sus beneficios: ");
        d.setBeneficios(sc.nextDouble());
    }
}

