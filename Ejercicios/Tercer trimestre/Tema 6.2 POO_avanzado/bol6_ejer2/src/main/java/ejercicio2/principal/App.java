package ejercicio2.principal;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio2.geometria.*;
import ejercicio2.interfaz.Libreria;

public class App {

    public static void mostrarPoligonos(ArrayList<Figura> poligonos) {

        if (poligonos.size() == 0) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("L I S T A");
            for (int i = 0; i < poligonos.size(); i++) {
                System.out.printf("%d: %s \n", i + 1, poligonos.get(i).getNombre());
            }
        }
    }

    public static int pedirTipo() {

        int eleccion = 0;
        System.out.println("Introduce el índice del tipo de polígono que quieras borrar");

        System.out.println("1º Línea");
        System.out.println("2º Poligono");
        System.out.println("3º Circunferencia");

        do {
            eleccion = Libreria.pedirEntero();
            if (eleccion < 0 || eleccion > 3) {
                System.out.println("opcion fuera de rango");
            }
        } while (eleccion < 0 || eleccion > 3);

        return eleccion;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        ArrayList<Figura> poligonos = new ArrayList<>();

        int opcion;
        int eleccion;
        boolean error;
        do {
            System.out.println("Elige una de las opciones");
            System.out.println("1º Insertar un polígono");
            System.out.println("2º Mostrar los elementos de la colección");
            System.out.println("3º Mostrar datos de un polígono");
            System.out.println("4º Borrar polígono");
            System.out.println("5º Salir");

            opcion = Libreria.pedirEntero();
            switch (opcion) {
                case 1:
                    eleccion = 0;
                    System.out.println("Qué quires insertar?");
                    System.out.println("1º Línea");
                    System.out.println("2º Triángulo");
                    System.out.println("3º Cuadrado");
                    System.out.println("4º Circunferencia");

                    eleccion = Libreria.pedirEntero();
                    switch (eleccion) {
                        case 1:
                            Linea linea = new Linea();
                            linea.pedirDatos();

                            poligonos.add(linea);
                            break;
                        case 2:
                            Poligono triangulo = new Poligono();
                            triangulo.pedirDatos();

                            poligonos.add(triangulo);
                            break;
                        case 3:
                            Poligono cuadrado = new Poligono("cuadrado", new Punto(0, 0), 4);
                            cuadrado.pedirDatos();

                            poligonos.add(cuadrado);
                            break;
                        case 4:
                            Circunferencia circunferencia = new Circunferencia();
                            circunferencia.pedirDatos();

                            poligonos.add(circunferencia);
                            break;

                        default:
                            System.out.println("Opcion fuera de rango");
                            break;
                    }
                    break;

                case 2:

                    if(poligonos.size() == 0){
                        System.out.println("La coleccion esta vacia");
                    }else{
                        for (int i = 0; i < poligonos.size(); i++) {
                            System.out.printf("%d:", i + 1);
                            poligonos.get(i).mostrarDatos();
                        }
                    }
                    break;

                case 3:
                    eleccion = 0;
                    if (poligonos.size() == 0) {
                        System.out.println("La lista está vacía");
                    } else {
                        System.out.println("Introduce el índice del polígono del que quieres saber sus datos");
                        mostrarPoligonos(poligonos);

                        do {
                            error = false;
                            try {
                                eleccion = Libreria.pedirEntero();
                                poligonos.get(eleccion - 1).mostrarDatos();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("El valor está fuera del rango de la colección");
                                error = true;
                            }
                        } while (error);
                    }

                    break;
                case 4: // todo borrar solo elementos de un tipo
                    eleccion = 0;
                    if (poligonos.size() == 0) {
                        System.out.println("La lista está vacía");
                    } else {

                        int cont = 0;

                        switch (pedirTipo()) {
                            case 1:
                                for (int i = poligonos.size()-1; i >= 0; i--) {//TODo decre
                                    if (poligonos.get(i).getClass() == Linea.class) {
                                        cont++;
                                        System.out.printf("%s Ha sido eliminado\n", poligonos.get(i).getNombre());
                                        poligonos.remove(i);
                                    }
                                }
                                if (cont == 0) {
                                    System.out.println("No hay ningun elemento de este tipo en tu colección");
                                }

                                break;
                            case 2:
                                for (int i = poligonos.size()-1; i >= 0; i--) {
                                    if (poligonos.get(i).getClass() == Poligono.class) {
                                        cont++;
                                        System.out.printf("%s Ha sido eliminado\n", poligonos.get(i).getNombre());
                                        poligonos.remove(i);
                                    }
                                }
                                if (cont == 0) {
                                    System.out.println("No hay ningun elemento de este tipo en tu colección");
                                }
                                break;
                            case 3:
                                for (int i = poligonos.size()-1; i >= 0; i--) {
                                    if (poligonos.get(i).getClass() == Circunferencia.class) {
                                        cont++;
                                        System.out.printf("%s Ha sido eliminado\n", poligonos.get(i).getNombre());
                                        poligonos.remove(i);
                                    }
                                }
                                if (cont == 0) {
                                    System.out.println("No hay ningun elemento de este tipo en tu colección");
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Has salido");
                    break;

                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        } while (opcion != 5);
        sc.close();
    }
}
