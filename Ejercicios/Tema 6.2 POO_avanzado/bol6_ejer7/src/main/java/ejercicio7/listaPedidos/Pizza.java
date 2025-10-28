package ejercicio7.listaPedidos;

import java.util.ArrayList;

import ejercicio7.libreria.Libreria;

public class Pizza extends Pedido {

    private boolean masa;

    public void setMasa(boolean masa) {
        this.masa = masa;
    }

    public boolean getMasa() {
        return masa;
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
            System.out.println("\t1º PEPPERONI");
            System.out.println("\t2º CHAMPINONES");
            System.out.println("\t3º BARBACOA");
            System.out.println("\t4º ACEITUNAS");
            System.out.println("\t5º POLLO");
            System.out.println("\t6º PIMIENTOS");
            System.out.println("\t7º - - FINALIZAR - -");

            eleccion = Libreria.pedirEntero();
            switch (eleccion) {
                case 1:
                    ingredientes.add("PEPPERONI");

                    break;
                case 2:
                    ingredientes.add("CHAMPINONES");

                    break;
                case 3:
                    ingredientes.add("BARBACOA");

                    break;
                case 4:
                    ingredientes.add("ACEITUNAS");

                    break;
                case 5:
                    ingredientes.add("POLLO");

                    break;
                case 6:
                    ingredientes.add("PIMIENTOS");

                    break;
                case 7:
                    if (cont <= 3) {
                        System.out.println("Tienes que seleccionar al menos 2 ingredientes para tu pizza");
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

        double precio = 7; // precio base de la pizza

        if (masa == true) {
            precio = precio + 1;
        }

        if (getTipoDeVenta() == 1) {
            precio = precio + 4;
        }

        if (getTamaño()) {
            precio = precio + 2;
        }

        if (getTipo().equals("CUATRO QUESOS")) {
            precio = precio + 0.5;
        } else if (getTipo().equals("BARBACOA")) {
            precio = precio + 2;
        } else if (getTipo().equals("TROPICAL")) {
            precio = precio + 1;
        } else if (getTipo().equals("MARGARITA")) {
            precio = precio + 1;
        } else {

            if (ingredientes.size() == 0) {
                return precio * getCantidad();
            } else {
                for (int i = 0; i < ingredientes.size(); i++) {

                    if (ingredientes.get(i).equals("PEPPERONI") || ingredientes.get(i).equals("BARBACOA")
                            || ingredientes.get(i).equals("POLLO")) {
                        precio = precio + 0.5;
                    } else if (ingredientes.get(i).equals("CHAMPINONES") || ingredientes.get(i).equals("PIMIENTOS")
                            || ingredientes.get(i).equals("ACEITUNAS")) {
                        precio = precio + 0.25;
                    }
                }
            }
        }
        return precio * getCantidad();
    }

    public Pizza(String nombre, String tipo, String domicilio, int cantidad, int codigo, int tipoDeVenta, double precio,
            double tiempoEntrega, boolean tamaño, boolean masa) {
        super(tipo, domicilio, cantidad, codigo, tipoDeVenta, precio, tiempoEntrega, tamaño);
        setMasa(masa);

    }

    public Pizza(int codigo) {
        super("", "", 0, codigo, 0, 0, 0, false);
        setMasa(false);
    }

    @Override
    public String toString() {
        return String.format("Pizza");
    }
}
