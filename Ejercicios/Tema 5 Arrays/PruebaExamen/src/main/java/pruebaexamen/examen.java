package pruebaexamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class examen {
  public static void main(String[] args) {

    Mago mago = new Mago();

    int[][] matrizMagos = mago.creaMatriz(11);

    mago.muestraMatriz(matrizMagos);

    Scanner sc = new Scanner(System.in);

    System.out.println();
    boolean error;
    int eleccion=0;
    do{
      error = false;
      System.out.println("Introduce el indice del mago del que quieras ver su poder");
      try{
        eleccion = sc.nextInt();
      }catch(NumberFormatException | InputMismatchException e){
        System.out.println("El dato ha de ser un entero");
        error = true;
      }
      sc.nextLine();
    }while(error);

    System.out.println("El poder del mago " + eleccion + " es: " + mago.poderMago(matrizMagos, eleccion));

    System.out.println();
    mago.intercambioDePoder(matrizMagos, 0, 10);

    mago.muestraMatriz(matrizMagos);
  }
}
