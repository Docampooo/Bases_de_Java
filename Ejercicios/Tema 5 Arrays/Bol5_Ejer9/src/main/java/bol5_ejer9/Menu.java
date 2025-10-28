package bol5_ejer9;

import java.util.Scanner;

public class Menu {

    Aula clase = new Aula(10, 5);


    public static int mostrarLista(Aula clase){
        Scanner sc = new Scanner(System.in);

        String[] alumnos = clase.getAlumnos();
        String[][] notas = clase.listaAlumnos();

        System.out.printf("%8s", "lista");
        System.out.printf("%10s", "Alumno");
        System.out.println();
        System.out.println("------------------------------");

        for (int fila = 0; fila < alumnos.length; fila++) {
            for (int columna = 0; columna < 2; columna++) {
                if (columna == 0) {
                    System.out.printf("%8s", notas[fila][columna]);
                } else {
                    System.out.printf("%10s", notas[fila][columna]);
                }
            }
            System.out.println();
        }
        System.out.println("Introduce el numero de lista del alumno");
        int eleccion = sc.nextInt();
        return eleccion;
    }

    public static int mostrarAsignaturas(Aula clase){
        Scanner sc = new Scanner(System.in);

        String[] asignaturas = clase.getMaterias();
        String[][] notas = clase.listaAlumnos();

        System.out.printf("%8s", "lista");
        System.out.printf("%16s", "Asignatura");
        System.out.println();
        System.out.println("------------------------------");
        
        for(int fila=1; fila<=asignaturas.length;fila++){
            System.out.printf("%8d",fila);
            System.out.printf("%16s",asignaturas[fila-1]);
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Elige la asignatura por su indice");
        int eleccion = sc.nextInt();
        return eleccion;
    }


    public static void tablaNotas(Aula clase) {

        String[] alumnos = clase.getAlumnos();
        String[] materias = clase.getMaterias();
        int[][] notas = clase.getNotas();

        System.out.printf("%5s", "LISTA");
        System.out.printf("%14s", "ALUMNOS");
        for (int i = 0; i < notas[0].length; i++) {// nombre de la asignatura
            System.out.printf("%16s", materias[i]);
        }
        System.out.println();

        for (int fila = 0; fila < notas.length; fila++) {
            System.out.printf("%3d", fila + 1);
            for (int columna = 0; columna <= notas[fila].length; columna++) {
                if (columna == 0) {// nombre de los alumnos
                    System.out.printf("%16s", alumnos[fila]);
                } else {// nota de la asignatura
                    System.out.printf("%16s", notas[fila][columna - 1]);
                }
            }
            System.out.println();
        }
    }

    public static void notasIndividuales(Aula clase, int eleccion) { //TODO mostrar la nota del alumno

        String[] alumnos = clase.getAlumnos();

        for (int columna = 0; columna <= clase.getNotas()[eleccion-1].length; columna++){
            if (columna == 0) {
                System.out.printf("%10s", alumnos[eleccion-1]);
            } else {
                System.out.printf("%16s", clase.getNotas()[eleccion-1][columna-1]);
            }
        }
        System.out.println();
    }

    public static void notasMateria(Aula clase, int eleccion){
        Scanner sc = new Scanner(System.in);

        String[] alumnos = clase.getAlumnos();
        String[] asignaturas = clase.getMaterias();
        String[][] notas = clase.listaAlumnos();

        System.out.printf("%16s", "");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.printf("%10s", alumnos[i]);
        }
        System.out.println();

        for (int columna = 0; columna <= notas.length; columna++){
            if (columna == 0) {
                System.out.printf("%16s", asignaturas[eleccion-1]);
            } else {
                System.out.printf("%10s", clase.getNotas()[columna-1][eleccion-1]);//buscar el array que es
            }
        }
        System.out.println("\n");
    }

    public static void mediaNotas(Aula clase){
        
        System.out.printf("La nota media de los alumnos es: %.3f \n",clase.mediaNotas());
    }

    public static void mediaAlumno(Aula clase, int n){

        System.out.printf("La nota media del alumno es: %.3f \n",clase.mediaAlumnos(n));
    }

    public static void mediaAsignatura(Aula clase, int n){

        System.out.printf("La nota media de la asignatura es: %.3f \n",clase.mediaMateria(n));
    }

    public static void maximosMinimos(Aula clase, int n){

        System.out.printf("La nota minima de la asignatura es: %2d y la maxima: %2d \n",clase.maximosMinimos(n)[2],clase.maximosMinimos(n)[1]);
    }

    public static void modificarNota(Aula clase, int fila, int columna, int valor){

        clase.setNotas(fila-1, columna-1, valor);
    }



    public static void menu(Aula clase) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int eleccion;
        do {
            eleccion = 0;
            System.out.println("Elige una de las opciones\n");

            System.out.println("1º Ver tabla de notas");
            System.out.println("2º Ver notas de un alumno");
            System.out.println("3º Ver notas de una asignatura");
            System.out.println("4º Calcular la media de notas globales");
            System.out.println("5º Media de un alumno");
            System.out.println("6º Media de una asignatura");
            System.out.println("7º Nota máxima y mínima de una asignatura");
            System.out.println("8º Modificar una nota");
            System.out.println("9º Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    tablaNotas(clase);
                    break;
                case 2:
                    eleccion = mostrarLista(clase);
                    notasIndividuales(clase,eleccion);
                    break;
                case 3:
                    eleccion = mostrarAsignaturas(clase);
                    notasMateria(clase, eleccion);
                    break;
                case 4:
                    mediaNotas(clase);
                    break;
                case 5:
                    eleccion = mostrarLista(clase);
                    mediaAlumno(clase, eleccion);
                    break;
                case 6:
                    eleccion = mostrarAsignaturas(clase);
                    mediaAsignatura(clase, eleccion);
                    break;
                case 7:
                    eleccion = mostrarAsignaturas(clase);
                    maximosMinimos(clase, eleccion);
                    break;
                case 8:
                    eleccion = mostrarLista(clase);
                    int eleccion2 = mostrarAsignaturas(clase);

                    System.out.println("Introduce la nota por la que la quieres cambiar:");
                    int nota = sc.nextInt();

                    modificarNota(clase, eleccion, eleccion2, nota);
                    break;
                case 9:
                    System.out.println("Has salido");
                    break;

                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        } while (opcion != 9);
    }
}
