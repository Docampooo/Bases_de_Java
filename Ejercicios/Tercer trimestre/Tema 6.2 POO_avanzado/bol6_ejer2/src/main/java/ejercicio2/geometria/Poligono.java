package ejercicio2.geometria;

import java.util.InputMismatchException;
import java.util.Scanner;

import ejercicio2.interfaz.Libreria;

public class Poligono extends Figura{
    
    public Punto[] conjunto; 
    
    public Poligono(String nombre, Punto origen, int total){

        super(origen, nombre);
        conjunto = new Punto[total];

        for(int i = 0; i < conjunto.length; i++){
            Punto punto = new Punto();

            punto.x = Math.random()*15;
            punto.y = Math.random()*15;

            conjunto[i] = punto;
        }
    }

    public Poligono(){
        this("equilatero", new Punto(), 3);
        
        conjunto[0] = new Punto(0,0);
        conjunto[1] = new Punto(1,0);
        conjunto[2] = new Punto(1,1);
    }

    @Override
    public void pedirDatos() {
        Scanner sc = new Scanner(System.in);

        super.pedirDatos();
        boolean error;

        System.out.println("Introduce las cordenadas de los puntos del poligono, este tiene " + this.conjunto.length + " puntos");
        for(int i = 0; i < this.conjunto.length;i++){
            
            System.out.println("\t" + (i+1) + ":");
            
            conjunto[i].x = Libreria.pedirReal();
            conjunto[i].y = Libreria.pedirReal();
        }
    }

    @Override
    public void mostrarDatos() {
        
        super.mostrarDatos();

        System.out.println("Los puntos del polígono son: ");

        for(int i = 0; i < this.conjunto.length; i++){
            System.out.printf("\t p%d %s \n",i+1,conjunto[i].toString());//Mas elegante toString
        }
    }

}
