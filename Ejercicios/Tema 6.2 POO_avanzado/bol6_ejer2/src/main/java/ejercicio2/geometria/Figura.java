package ejercicio2.geometria;

import java.util.InputMismatchException;
import java.util.Scanner;
import ejercicio2.interfaz.*;

public class Figura implements InterfazUsuario {

    protected Punto origen;

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public Punto getOrigen() {
        return origen;
    }

    protected String nombre; // Esto está público para poder hacer la lista y ver el nombre de los poligonos
                             // desde el Main

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase().trim();
    }

    public String getNombre() {
        return nombre;
    }

    public Figura(Punto origen, String nombre) {
        this.origen = origen;
        this.nombre = nombre;
    }

    public Figura() {
        this(new Punto(), "");
    }

    /**
     * comprueba si la cadena que se le pasa es una cadena vacia
     * 
     * @param nombre cadena pasada
     * @return false si la cadena está vacía y true en caso contrario
     */
    public boolean comprobarNombre(String nombre) {

        if (nombre.trim().equals("")) {
            System.out.println("El nombre no puede ser una cadena vacia");
            return false;
        } else {
            return true;
        }
    }

    public void pedirDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre de la figura");
        do {
            nombre = sc.nextLine();
        } while (!comprobarNombre(nombre));

        this.setNombre(nombre);

        System.out.println("Introduce las cordenadas (x;y) del punto origen");

        origen.x = Libreria.pedirReal();
        origen.y = Libreria.pedirReal();
    }

    public void mostrarDatos() {

        System.out.printf("%s %s", nombre, origen.toString());
    }
}
