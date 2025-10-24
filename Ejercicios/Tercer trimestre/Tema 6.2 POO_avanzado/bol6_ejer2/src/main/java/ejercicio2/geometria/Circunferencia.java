package ejercicio2.geometria;

import java.util.Scanner;

import ejercicio2.interfaz.Libreria;

public class Circunferencia extends Figura{

    private double radio;
    public void setRadio(double radio){

        if(radio < 0){
            throw new IllegalArgumentException();
        }else{
            this.radio = radio;
        }
    }
    public double getRadio(){
        return radio;
    }

    public Circunferencia(Punto centro, double radio){
                super(centro, "circunferencia");
        setRadio(radio);
    }

    public Circunferencia(){

        this(new Punto(0,0), 1);
    }
    
    @Override
    public void pedirDatos() {
        Scanner sc = new Scanner(System.in);
        
        super.pedirDatos();

        System.out.println("Introduce el radio de la circunferencia");

        setRadio(Libreria.pedirReal());
    }

    @Override
    public void mostrarDatos() {
        
        super.mostrarDatos();
        
        System.out.printf("El radio de la circunferencia es: %.3f \n",getRadio());
    }

}
