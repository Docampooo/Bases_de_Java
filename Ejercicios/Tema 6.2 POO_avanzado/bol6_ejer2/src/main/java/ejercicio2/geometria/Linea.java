package ejercicio2.geometria;

import java.util.Scanner;

import ejercicio2.interfaz.Libreria;

public class Linea extends Figura{
    
    private Punto puntoFinal;
    public void setPuntoFinal(Punto puntoFinal){
        this.puntoFinal = puntoFinal;
    }
    public Punto getPuntoFinal(){
        return puntoFinal;
    }

    @Override
    public void pedirDatos() {
        Scanner sc = new Scanner(System.in);

       super.pedirDatos();

       System.out.println("Ahora las del siguiente punto");
       
       puntoFinal.x = Libreria.pedirReal();
       puntoFinal.y = Libreria.pedirReal();

    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();

        System.out.printf("\t%s \n",puntoFinal.toString());
    }

    public Linea(Punto origen, Punto puntoFinal){

        super.setNombre(nombre);
        origen=new Punto(origen.x, origen.y);
        this.puntoFinal = puntoFinal;
    }

    public Linea(){
        this(new Punto(), new Punto(1,1)); //ab = b - a --> (1, 1)
    }
}
