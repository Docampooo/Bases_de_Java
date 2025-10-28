/*-
 * =====LICENSE-START=====
 * Java 11 Application
 * ------
 * Copyright (C) 2020 - 2025 Organization Name
 * ------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====LICENSE-END=====
 */
package bol5_ej8;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter;

public class Coleccion {

    private ArrayList<Videojuego> videojuegos = new ArrayList<>();

    /**
     * según el String que se le pasa, comprueba si está compuesto por 3 cadenas divididas por ;, divide cada dato y lo introduce cada uno en los sets del objeto tipo videojuego
     * @param linea String que se le pasa
     * @return si se cumplen las condiciones del String,devuelve el objeto videojuego con sus sets integrados, de lo contrario devuelve null
     */
    public static Videojuego comprobacion(String linea) {
        Videojuego juego = new Videojuego();

        String[] fila = linea.split("[;]");

        if (fila.length == 3) {
            juego.setTitulo(fila[0]);
            if (fila[1].length() == 4) {
                juego.setAno(Integer.parseInt(fila[1]));
            } else {
                return null;
            }   
            juego.setFabricante(fila[2]);
        } else {
            return null;
        }

        return juego;
    }
    /**
     * Se le pasa una cadena String y comprueba si dicha cadena se puede pasar a INT
     * @param cadena String a comprobar
     * @return devuelve true si dicho String es parseable a INT y de lo contrario false
     */
    public static boolean comprobarAno(String cadena){
        if(cadena.trim().equals("")){
            System.out.println("No se permite un año nulo");
            return false;
        }
        try{
            Integer.parseInt(cadena);
        } catch (NumberFormatException e){
            System.out.println("En este campo solo se pueden introducir años, prueba de nuevo");
            return false;
        }
        int num = Integer.parseInt(cadena);
        if(num < 1950){
            System.out.println("En esa epoca aun no se habia creado ni el primer videojuego, prueba otra vez");
            return false;
        }
        return true;
    }
    /**
     * Comprueba si el String que se le pasa es una cadena vacia
     * @param cadena String a comprobar
     * @return si la cadena está vacia, devuelve false, sino, true
     */
    public static boolean comprobarCadena(String cadena){
        if(cadena.trim().equals("")){
            return false;
        }else{
            return true;
        }
    }

    public void menu() throws Exception {

        Scanner sc = new Scanner(System.in);

        File f = new File("videojuegos.txt");

        if (f.exists()) {
            Scanner t = new Scanner(new File("videojuegos.txt"));
            Videojuego juego = new Videojuego();

            String cadena = "";
            while (t.hasNext()) {
                cadena = t.nextLine();
                if (comprobacion(cadena) != null) {
                    videojuegos.add(comprobacion(cadena));
                }
            }
            t.close();
        }
        int eleccion;
        boolean error;
        do {
            System.out.println("Elige una de las opciones: \n");
            System.out.printf("\t 1º Insertar nuevo juego \n");
            System.out.printf("\t 2º Ver biblioteca de juegos \n");
            System.out.printf("\t 3º Buscar juego \n");
            System.out.printf("\t 4º Eliminar juego \n");
            System.out.printf("\t 5º Eliminar juegos de un año \n");
            System.out.printf("\t 6º Salir \n");
            eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    Videojuego juego = new Videojuego();

                    System.out.println("Nombre del juego?");
                    sc.nextLine();
                    String titulo = sc.nextLine();
                    if(comprobarCadena(titulo)){
                        juego.setTitulo(titulo.trim());
                    }else{
                        do{
                            System.out.println("El juego necesita un titulo, introduce uno");
                            titulo = sc.nextLine();
                        }while(!comprobarCadena(titulo));
                        juego.setTitulo(titulo.trim());
                    }

                    System.out.println("Año de lanzamiento?");
                    String ano = sc.nextLine();
                    if(comprobarAno(ano)){
                        juego.setAno(Integer.parseInt(ano));
                    }else{
                        do{
                            ano = sc.nextLine();
                        }while(!comprobarAno(ano));
                        juego.setAno(Integer.parseInt(ano));
                    }

                    System.out.println("Fabricante?");
                    String fabricante = sc.nextLine();
                    if(comprobarCadena(fabricante)){
                        juego.setFabricante(fabricante.trim());
                    }else{
                        do{
                            System.out.println("El juego necesita un fabricante, introduce uno");
                            fabricante = sc.nextLine();
                        }while(!comprobarCadena(fabricante));
                        juego.setFabricante(fabricante.trim());
                    }

                    if (videojuegos.size() != 0) {
                        int opcion2;
                        System.out.println("Donde quieres insertar el juego en la coleccion?");
                        System.out.println("1º Al principio");
                        System.out.println("2º Al final");
                        opcion2 = sc.nextInt();
                        switch (opcion2) {
                            case 1:
                                videojuegos.add(0, juego);
                                break;
                            case 2:
                                videojuegos.add(juego);
                                break;

                            default:
                                System.out.println("Opcion fuera de rango");
                                break;
                        }
                    } else {
                        videojuegos.add(juego);
                    }
                    break;
                case 2:
                    if (videojuegos.size() != 0) {
                        System.out.printf("%3s", "");
                        for (int i = 0; i < 3; i++) {
                            if (i == 0 || i == 2) {
                                System.out.printf("%23d", i + 1);
                            } else {
                                System.out.printf("%4d", i + 1);
                            }
                        }
                        System.out.println();

                        for (int fila = 0; fila < videojuegos.size(); fila++) {
                            System.out.printf("%3d", fila + 1);
                            for (int col = 0; col < 3; col++) {
                                if (col == 0) {
                                    int longTitulo = (int) (videojuegos.get(fila).getTitulo().length());
                                    if (longTitulo <= 23) {
                                        System.out.printf("%23s", videojuegos.get(fila).getTitulo());
                                    } else {
                                        System.out.printf("%.20s...", videojuegos.get(fila).getTitulo());
                                    }
                                } else if (col == 1) {
                                    System.out.printf("%5d", videojuegos.get(fila).getAno());
                                } else {
                                    int longFab = (int) (videojuegos.get(fila).getFabricante().length());
                                    if (longFab <= 23) {
                                        System.out.printf("%23s", videojuegos.get(fila).getFabricante());
                                    } else {
                                        System.out.printf("%.20s...", videojuegos.get(fila).getFabricante());
                                    }
                                }
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Tu coleccion esta vacia");
                    }
                    break;
                case 3:
                    // Según los 3 primeros caracteres del titulo introducidos por el usuario,
                    // busca con el substring los tres primeros caracteres del titulo del juego y
                    // despues repite lo hecho en el 2.
                    System.out.println("Introduce las primeras letras del título del juego");
                    sc.nextLine();
                    String letras = sc.nextLine();
                    if(letras.trim().equals("")){
                        do{
                            System.out.println("Para buscar el juego, se necesita al menos la primera letra del titulo");
                            letras = sc.nextLine();
                        }while(letras.trim().equals(""));
                    }
                    String inicio = "";
                    String union = "";
                    int longitud = letras.length();
                    for (int fila = 0; fila < videojuegos.size(); fila++) {
                        inicio = videojuegos.get(fila).getTitulo().substring(0, longitud);
                        if (inicio.equals(letras.toUpperCase())) {
                            union = union + "\n" + (videojuegos.get(fila).getTitulo() + " "
                                    + videojuegos.get(fila).getAno() + " " + videojuegos.get(fila).getFabricante());
                        }
                    }
                    if (union == "") {
                        System.out.printf("No se ha encontrado ningún juego que empiece por: \"%s\" \n", letras.trim());
                    } else {
                        System.out.println(union);
                    }
                    break;
                case 4:// borrar videojuego por su indice en la coleccion
                    System.out.println("Introduce el índice del juego que quieras borrar: ");
                    int indice = 0;

                    if(videojuegos.size() <= 0){
                        System.out.println("La coleccion está vacía");
                    }else{
                        do{
                            error = false;
                            try{
                                indice = sc.nextInt();
                            } catch(NumberFormatException | InputMismatchException e){
                                System.out.println("Error al introducir el indice, debe ser un parametro entero y estar dentro de los indices de la coleccion");
                                error = true;
                            }
                            sc.nextLine();
                        }while(error);
    
                        if (indice > videojuegos.size() + 1) {
                            System.out.println("No hay ningún juego con ese indice en la biblioteca");
                        } else {
                            videojuegos.remove(indice - 1);
                        }
                    }
                    break;
                case 5:// borrar videojuegos de un año

                    if(videojuegos.size() <= 0){
                        System.out.println("La colección está vacia");
                    }else{
                        
                        System.out.println("Introduce el año del que quieres eliminar los juegos");
                        int borrar = 0;
                        do{
                            error = false;
                            try{
                                borrar = sc.nextInt();
                            } catch(NumberFormatException | InputMismatchException e){
                                System.out.println("Error al introducir el año, debe ser un parametro entero");
                                error = true;
                            }
                            sc.nextLine();
                        }while(error);
    
                        for (int fila = videojuegos.size()-1; fila > 0; fila--) {
                            if(videojuegos.get(fila).getAno() == borrar){
                                videojuegos.remove(fila);
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Has salido");
                    String cadena="";
                    PrintWriter q = new PrintWriter("videojuegos.txt");

                    for (int fila = 0; fila < videojuegos.size(); fila++) {
                        cadena = cadena + videojuegos.get(fila).getTitulo() + ";" + videojuegos.get(fila).getAno() + ";"
                                + videojuegos.get(fila).getFabricante() + "\n";
                    }
                    q.println(cadena);
                    q.close();
                    
                    break;
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        } while (eleccion != 6);
        sc.close();
    }
}
