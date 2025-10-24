package ejercicio7.principal;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio7.libreria.*;
import ejercicio7.listaPedidos.*;

public class Principal {

    public static int elegirProducto() {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Elige el producto que quieras");
            System.out.println("\t1º BOCADILLO");
            System.out.println("\t2º PIZZA");
            System.out.println("\t3º REFRESCO");
            System.out.println("\t4º HELADO");
            System.out.println("\t5º VOLVER ATRAS");

            opcion = Libreria.pedirEntero();
            switch (opcion) {
                case 1:
                    System.out.println("Has elegido un bocadillo");

                    break;
                case 2:
                    System.out.println("Has elegido una pizza");

                    break;
                case 3:
                    System.out.println("Has elegido un refresco");

                    break;
                case 4:
                    System.out.println("Has elegido un helado");

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        } while (opcion == 5);

        return opcion;
    }

    public static int crearCodigo(ArrayList<Integer> codigos) {

        int codigo = 0;
        boolean error;
        do {
            error = false;
            codigo = 1122330 + (int) (Math.random() * 100);

            if (codigos.contains(codigo)) {
                error = true;
            } else {
                codigos.add(codigo);
            }
        } while (error);

        return codigo;
    }

    public static void mostrartipo(ArrayList<Pedido> listaPedidos){

        if(listaPedidos.size() == 0){
            System.out.println("La lista está vacía");
        }else{
            for(int i = 0; i < listaPedidos.size(); i++){
                System.out.printf("%2d %s", i, listaPedidos.get(i).getTipo());
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<Integer> codigos = new ArrayList<>();

        boolean error;
        int opcion;
        int eleccion;
        int codigo;
        do {
            System.out.println("Buenas, desea algo de nuestros servicios?");
            System.out.println("\t 1º Nuevo pedido");
            System.out.println("\t 2º Anular pedido");
            System.out.println("\t 3º Mostrar pedidos");
            System.out.println("\t 4º ");
            System.out.println("\t 5º SALIR");

            opcion = Libreria.pedirEntero();
            switch (opcion) {
                case 1:
                    switch (elegirProducto()) {
                        case 1:
                            codigo = 0;
                            codigo = crearCodigo(codigos);
                            codigos.add(codigo);

                            Bocadillo bocadillo = new Bocadillo(codigo);
                            eleccion = 0;

                            int cont = listaPedidos.size();
                            do {
                                System.out.println("Elige el bocadillo que quieras");
                                System.out.println("\t1º VEGETAL");
                                System.out.println("\t2º JAMON Y QUESO");
                                System.out.println("\t3º CARNIVORO");
                                System.out.println("\t4º LOMO ASADO");
                                System.out.println("\t5º PERSONALIZADO");

                                eleccion = Libreria.pedirEntero();
                                switch (eleccion) {
                                    case 1:
                                        bocadillo.setTipo("VEGETAL");
                                        break;
                                    case 2:
                                        bocadillo.setTipo("JAMON Y QUESO");

                                        break;
                                    case 3:
                                        bocadillo.setTipo("CARNIVORO");

                                        break;
                                    case 4:
                                        bocadillo.setTipo("LOMO ASADO");

                                        break;
                                    case 5:
                                        bocadillo.añadirIngredientes();

                                        break;

                                    default:
                                        System.out.println("Opcion fuera de rango");
                                        break;
                                }
                            } while (eleccion > 5 || eleccion < 1);

                            eleccion = 0;
                            do {

                                System.out.println("Selecciona el tipo de pedido");
                                System.out.println("1º Domicilio");
                                System.out.println("2º Local");
                                System.out.println("3º Recoger");

                                eleccion = Libreria.pedirEntero();

                            } while (eleccion < 1 || eleccion > 3);

                            bocadillo.setTipoDeVenta(eleccion);// 1 --> domicilio 2--> local 3 --> recoger

                            System.out.println("Cuantas unidades quieres?");
                            bocadillo.setCantidad(Libreria.pedirEntero());

                            eleccion = 0;
                            do {

                                System.out.println("Pan artesanal o sin gluten?");
                                System.out.println("1º Artesanal");
                                System.out.println("2º Sin gluten");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        bocadillo.setPan(false);
                                        break;

                                    case 2:
                                        bocadillo.setPan(true);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            eleccion = 0;
                            do {

                                System.out.println("grande o pequeño?");
                                System.out.println("1º Grande");
                                System.out.println("2º Pequeño");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        bocadillo.setTamaño(true);
                                        break;

                                    case 2:
                                        bocadillo.setTamaño(false);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            bocadillo.setTiempoEntrega(10);

                            bocadillo.setPrecio(bocadillo.calcularPrecio());

                            listaPedidos.add(bocadillo);
                            break;

                        case 2:

                            codigo = 0;
                            codigo = crearCodigo(codigos);
                            codigos.add(codigo);
                            Pizza pizza = new Pizza(codigo);

                            eleccion = 0;
                            do {
                                System.out.println("Elige el bocadillo que quieras");
                                System.out.println("\t1º CUATRO QUESOS");
                                System.out.println("\t2º BARBACOA");
                                System.out.println("\t3º TROPICAL");
                                System.out.println("\t4º MARGARITA");
                                System.out.println("\t5º PERSONALIZADO");

                                eleccion = Libreria.pedirEntero();
                                switch (eleccion) {
                                    case 1:
                                        pizza.setTipo("CUATRO QUESOS");
                                        break;
                                    case 2:
                                        pizza.setTipo("BARBACOA");

                                        break;
                                    case 3:
                                        pizza.setTipo("TROPICAL");

                                        break;
                                    case 4:
                                        pizza.setTipo("MARGARITA");

                                        break;
                                    case 5:
                                        pizza.añadirIngredientes();

                                        break;

                                    default:
                                        System.out.println("Opcion fuera de rango");
                                        break;
                                }
                            } while (eleccion > 5 || eleccion < 1);

                            System.out.println("Cuantas unidades quieres?");
                            pizza.setCantidad(Libreria.pedirEntero());

                            eleccion = 0;
                            do {

                                System.out.println("Selecciona el tipo de pedido");
                                System.out.println("1º Domicilio");
                                System.out.println("2º Local");
                                System.out.println("3º Recoger");

                                eleccion = Libreria.pedirEntero();

                            } while (eleccion < 1 || eleccion > 3);

                            pizza.setTipoDeVenta(eleccion);// 1 --> domicilio 2--> local 3 --> recoger

                            eleccion = 0;
                            do {

                                System.out.println("Masa artesanal o sin gluten?");
                                System.out.println("1º Artesanal");
                                System.out.println("2º Sin gluten");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        pizza.setMasa(false);
                                        break;

                                    case 2:
                                        pizza.setMasa(true);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            eleccion = 0;
                            do {

                                System.out.println("grande o pequeño?");
                                System.out.println("1º Grande");
                                System.out.println("2º Pequeño");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        pizza.setTamaño(true);
                                        break;

                                    case 2:
                                        pizza.setTamaño(false);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            pizza.setTiempoEntrega(20);

                            pizza.setPrecio(pizza.calcularPrecio());

                            listaPedidos.add(pizza);

                            break;
                        case 3:

                            codigo = 0;
                            codigo = crearCodigo(codigos);
                            codigos.add(codigo);
                            Refresco refresco = new Refresco(codigo);

                            eleccion = 0;
                            do {
                                System.out.println("Elige el refresco que quieras");
                                System.out.println("\t1º MANZANA");
                                System.out.println("\t2º SANDIA");
                                System.out.println("\t3º NARANJA");
                                System.out.println("\t4º LIMON");

                                eleccion = Libreria.pedirEntero();
                                switch (eleccion) {
                                    case 1:
                                        refresco.setTipo("CUATRO QUESOS");
                                        break;
                                    case 2:
                                        refresco.setTipo("BARBACOA");

                                        break;
                                    case 3:
                                        refresco.setTipo("TROPICAL");

                                        break;
                                    case 4:
                                        refresco.setTipo("MARGARITA");

                                        break;

                                    default:
                                        System.out.println("Opcion fuera de rango");
                                        break;
                                }
                            } while (eleccion > 4 || eleccion < 1);

                            System.out.println("Cuantas unidades quieres?");
                            refresco.setCantidad(Libreria.pedirEntero());

                            eleccion = 0;
                            do {

                                System.out.println("Con o sin gas?");
                                System.out.println("1º Con gas");
                                System.out.println("2º Sin gas");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        refresco.setGas(true);
                                        break;

                                    case 2:
                                        refresco.setGas(false);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            eleccion = 0;
                            do {

                                System.out.println("grande o pequeño?");
                                System.out.println("1º Grande");
                                System.out.println("2º Pequeño");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        refresco.setTamaño(true);
                                        break;

                                    case 2:
                                        refresco.setTamaño(false);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            eleccion = 0;
                            do {

                                System.out.println("Selecciona el tipo de pedido");
                                System.out.println("1º Domicilio");
                                System.out.println("2º Local");
                                System.out.println("3º Recoger");

                                eleccion = Libreria.pedirEntero();

                            } while (eleccion < 1 || eleccion > 3);

                            refresco.setTipoDeVenta(eleccion);// 1 --> domicilio 2--> local 3 --> recoger

                            refresco.setTiempoEntrega(2);

                            refresco.setPrecio(refresco.calcularPrecio());

                            listaPedidos.add(refresco);

                            break;
                        case 4:

                            codigo = 0;
                            codigo = crearCodigo(codigos);
                            codigos.add(codigo);

                            Helado helado = new Helado(codigo);

                            eleccion = 0;
                            do {
                                System.out.println("Elige el helado que quieras");
                                System.out.println("\t1º AVELLANA");
                                System.out.println("\t2º FRESA");
                                System.out.println("\t3º CHOCOLATE");
                                System.out.println("\t4º OREO");
                                System.out.println("\t5º COOKIES");

                                eleccion = Libreria.pedirEntero();
                                switch (eleccion) {
                                    case 1:
                                        helado.setTipo("AVELLANA");
                                        break;
                                    case 2:
                                        helado.setTipo("FRESA");

                                        break;
                                    case 3:
                                        helado.setTipo("CHOCOLATE");

                                        break;
                                    case 4:
                                        helado.setTipo("OREO");

                                        break;
                                    case 5:
                                        helado.setTipo("COOKIES");

                                        break;

                                    default:
                                        System.out.println("Opcion fuera de rango");
                                        break;
                                }
                            } while (eleccion > 5 || eleccion < 1);

                            System.out.println("Cuantas unidades quieres?");
                            helado.setCantidad(Libreria.pedirEntero());

                            eleccion = 0;
                            do {

                                System.out.println("El helado de tarrina o cucurucho?");
                                System.out.println("1º Con gas");
                                System.out.println("2º Sin gas");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        helado.setHielo(true);
                                        break;

                                    case 2:
                                        helado.setHielo(false);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            eleccion = 0;
                            do {

                                System.out.println("grande o pequeño?");
                                System.out.println("1º Grande");
                                System.out.println("2º Pequeño");

                                eleccion = Libreria.pedirEntero();

                                switch (eleccion) {
                                    case 1:
                                        helado.setTamaño(true);
                                        break;

                                    case 2:
                                        helado.setTamaño(false);

                                        break;

                                    default:
                                        System.out.println("opcion fuera de rango");
                                        break;
                                }

                            } while (eleccion < 1 || eleccion > 2);

                            eleccion = 0;
                            do {

                                System.out.println("Selecciona el tipo de pedido");
                                System.out.println("1º Domicilio");
                                System.out.println("2º Local");
                                System.out.println("3º Recoger");

                                eleccion = Libreria.pedirEntero();

                            } while (eleccion < 1 || eleccion > 3);

                            helado.setTipoDeVenta(eleccion);// 1 --> domicilio 2--> local 3 --> recoger

                            helado.setTiempoEntrega(5);

                            helado.setPrecio(helado.calcularPrecio());

                            listaPedidos.add(helado);

                            break;

                        default:
                            System.out.println("Opcion fuera de rango");
                            break;
                    }

                case 2:

                    if(listaPedidos.size() == 0){
                        System.out.println("La colección está vacía");
                    }else{
                        eleccion = 0;
                        do{
                            error = false;
                            System.out.println("Introduce el índice del pedido que quieres eliminar");
                            mostrartipo(listaPedidos);
                            eleccion = Libreria.pedirEntero();
                            if(eleccion < 0 || eleccion > listaPedidos.size()){
                                System.out.println("El indice ha de pertenecer a la colección");
                                error = true;
                            }
                        }while(error);

                        System.out.println("Has eliminado:");
                        System.out.printf("\t%s: %s %f \n",listaPedidos.get(eleccion).toString(), listaPedidos.get(eleccion).getTipo(), listaPedidos.get(eleccion).getPrecio());
    
                        listaPedidos.remove(eleccion);
                    }
                    break;

                case 3:
                    
                    System.out.println("Los pedidos son: ");
                    for(int i = 0; i < listaPedidos.size(); i++){

                        System.out.printf("\tCod: %d %s %s %f cant: %d",codigos.get(i), listaPedidos.get(i).toString(), listaPedidos.get(i).getTipo(), listaPedidos.get(i).getPrecio(), listaPedidos.get(i).getCantidad());
                    }
                    break;

                case 4:
                    System.out.println("Muchas gracias!");
                    break;
            }
        } while (opcion != 4);
    }
}
