package ejercicio5.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ejercicio5.*;

public class Principal {

    public static int pedirEntero() {
        Scanner sc = new Scanner(System.in);

        boolean error;
        int num = 0;
        do {
            error = false;
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo se permiten numeros enteros");
                error = true;
            }
        } while (error);

        return num;
    }

    public static double pedirReal() {
        Scanner sc = new Scanner(System.in);

        boolean error;
        double num = 0;
        do {
            error = false;
            try {
                num = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Solo se permiten numeros reales");
                error = true;
            }
        } while (error);

        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Astro> planetas = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Elige una de las opciones");

            System.out.println("\t 1º Añadir planeta");
            System.out.println("\t 2º Añadir un astro");
            System.out.println("\t 3º Mostrar datos");
            System.out.println("\t 4º Eliminar repetidos");
            System.out.println("\t 5º Salir");

            opcion = pedirEntero();

            switch (opcion) {
                case 1:

                    System.out.println("Introduce un nombre para tu planeta, no puede ser nulo");
                    String nombre = sc.nextLine();

                    System.out.println("Cuál es el radio de tu planeta?");
                    double radio = pedirReal();

                    boolean gaseoso = false;

                    int eleccion = 0;
                    do {

                        System.out.println("Es un planeta gaseoso?");
                        System.out.println("1º Si");
                        System.out.println("2º No");
                        eleccion = pedirEntero();

                        switch (eleccion) {
                            case 1:
                                gaseoso = true;
                                break;
                            case 2:
                                gaseoso = false;
                                break;

                            default:
                                System.out.println("Opcion fuera de rango");
                                break;
                        }
                    } while (eleccion != 1 && eleccion != 2);

                    Planeta planeta = new Planeta(nombre, radio, gaseoso);

                    System.out.println("Cuantas lunas quieres que tenga tu planeta?");
                    int lunas = pedirEntero();
                    for (int i = 0; i < lunas; i++) {

                        System.out.println("Introduce un astro, asignale un nombre");
                        String nombreAstro = sc.nextLine();

                        System.out.println("Cuál es su radio?");
                        double radioAstro = pedirEntero();

                        Astro astro = new Astro(nombreAstro, radioAstro);

                        planeta.satelites.add(astro);
                    }

                    planetas.add(planeta);

                    break;
                case 2:

                    System.out.println("Introduce un astro, asignale un nombre");
                    String nombreAstro = sc.nextLine();

                    System.out.println("Cuál es su radio?");
                    double radioAstro = pedirEntero();

                    Astro astro = new Astro(nombreAstro, radioAstro);

                    planetas.add(astro);

                    break;
                case 3:
                    if (planetas.size() == 0) {
                        System.out.println("La coleccion está vacía");
                    } else {
                        for (int i = 0; i < planetas.size(); i++) {

                            if (planetas.get(i).getClass() == Planeta.class) { // importante este casteo para acceder a
                                                                               // planetas

                                System.out.printf("PLANETA\t%s ", planetas.get(i).toString());
                                if (((Planeta) planetas.get(i)).getGaseoso()) {
                                    System.out.printf("gaseoso \n");
                                } else {
                                    System.out.printf("no gaseoso \n");
                                }

                            } else {
                                System.out.println("ASTRO\t" + planetas.get(i).toString());
                            }
                        }

                    }
                    break;
                case 4:
                    if (planetas.size() == 0) {
                        System.out.println("La coleccion está vacía");
                    } else {
                        for (int i = 0; i < planetas.size(); i++) {

                            for (int f = 0; f < planetas.size(); f++) {
                                if ((planetas.get(i).equals(planetas.get(f)) && (i != f))) {
                                    System.out.printf("Se ha eliminado: %s en la posicion %d",
                                            planetas.get(f).getNombre(), f);
                                    planetas.remove(f);
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.println("Opcion fuera de rango");
            }
        } while (opcion != 5);
        sc.close();
        // Astro a = new Astro("aaaa", 1);
        // a.equals(a);    
    }
}
