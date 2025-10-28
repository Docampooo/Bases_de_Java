package ejercicio7.listaPedidos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.function.Predicate;

import ejercicio7.libreria.Libreria;

public class Bocadillo extends Pedido {

    private boolean pan;

    public void setPan(boolean pan) { //sin gluten o normal
        this.pan = pan;
    }
    public boolean getPan() {
        return pan;
    }

    public void añadirIngredientes() {

        ingredientes.clear();

        int eleccion = 0;
        System.out.println("Selecciona los ingredientes por su indice");
        int cont = 0;
        boolean error;
        do {
            cont++;
            error = false;
            System.out.println("\t1º POLLO");
            System.out.println("\t2º TOMATE");
            System.out.println("\t3º QUESO");
            System.out.println("\t4º HUEVO");
            System.out.println("\t5º LECHUGA");
            System.out.println("\t6º JAMON");
            System.out.println("\t7º - - FINALIZAR - -");

            eleccion = Libreria.pedirEntero();
            switch (eleccion) {
                case 1:
                    ingredientes.add("POLLO");

                    break;
                case 2:
                    ingredientes.add("TOMATE");

                    break;
                case 3:
                    ingredientes.add("QUESO");

                    break;
                case 4:
                    ingredientes.add("HUEVO");

                    break;
                case 5:
                    ingredientes.add("LECHUGA");

                    break;
                case 6:
                    ingredientes.add("JAMON");

                    break;
                case 7:
                    if (cont <= 3) {
                        System.out.println("Tienes que seleccionar por lo menos 2 ingredientes para tu bocadillo");
                        error = true;
                        cont = cont - 1;
                    }

                    break;

                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        } while (eleccion == 7 && error);
    }

    public double calcularPrecio() {

        double precio = 4; // precio base del bocadillo

        if(getTipoDeVenta() == 1){
            precio = precio + 4;
        }

        if(getTamaño()){
            precio = precio + 2;
        }

        if (pan) {
            precio = precio + 1;
        }

        if (getTipo().equals("VEGETAL")) {
            precio =  precio + 0.5;
        } else if (getTipo().equals("CARNIVORO")) {
            precio =  precio + 2;
        } else if (getTipo().equals("JAMON Y QUESO")) {
            precio =  precio + 1;
        } else if (getTipo().equals("LOMO ASADO")) {
            precio =  precio + 1;
        } else {

            if (ingredientes.size() == 0) {
                return precio * getCantidad();
            } else {
                for (int i = 0; i < ingredientes.size(); i++) {

                    if (ingredientes.get(i).equals("POLLO") || ingredientes.get(i).equals("JAMON")) {
                        precio = precio + 1;
                    } else if (ingredientes.get(i).equals("TOMATE") || ingredientes.get(i).equals("LECHUGA")) {
                        precio = precio + 0.5;
                    } else if (ingredientes.get(i).equals("HUEVO") || ingredientes.get(i).equals("QUESO")) {
                        precio = precio + 0.25;
                    }
                }
            }
        }
        return precio * getCantidad();
    }

    public Bocadillo(String tipo, String domicilio, int cantidad, int codigo, int tipoDeVenta, double precio,
            double tiempoEntrega, boolean tamaño, boolean pan) {
        super(tipo, domicilio, cantidad, codigo, tipoDeVenta, precio, tiempoEntrega, tamaño);
        setPan(pan);
    }

    public Bocadillo(int codigo) {
        super("", "", 0, codigo, 0, 0, 0, false);
        setPan(false);
    }

    @Override
    public String toString() {
        return String.format("Bocadillo");
    }
}
