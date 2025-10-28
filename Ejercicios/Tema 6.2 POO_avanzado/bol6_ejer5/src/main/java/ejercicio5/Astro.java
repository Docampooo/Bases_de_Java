package ejercicio5;

import java.util.InputMismatchException;

public class Astro {
    
    private String nombre;
    public void setNombre(String nombre){
        
        this.nombre = nombre.toUpperCase().trim();
    }
    public String getNombre(char separador){ //comprobar esto
        String acu = "";
        for(int i = 0; i < nombre.length(); i++){
            acu = acu + nombre.charAt(i) + separador;
        }
        return acu;
    }

    public String getNombre(){
        return nombre;
    }

    private double radio;
    public void setRadio(double radio){
        if(radio <= 0){
            throw new RadioNegativoException();
        }else{
            this.radio = radio;
        }
    }
    public double getRadio(){
        return radio;
    }

    public Astro(String nombre, double radio){
        setNombre(nombre);
        setRadio(radio);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f",getNombre(), getRadio());
    }

    @Override
    public boolean equals(Object obj) { //TODO comprobar este apartado 
        if(obj.getClass() == Astro.class){
            Astro astro = (Astro) obj;
            if(this.toString().equals(astro.toString())){
                return true;
            }
        }
        return false;
    }
}
