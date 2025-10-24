package ejercicio10;

import java.util.InputMismatchException;

public class Persona {
    
    private String nombre;
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    private String apellidos;
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String getApellidos(){
        return apellidos;
    }

    private String DNI;
    public void setDNI(String DNI){

        if(DNI.length() != 9 || (DNI.charAt(DNI.length()) < 65 || DNI.charAt(DNI.length()) > 90)){
            throw new InputMismatchException("El DNI no coincide");
        }
        this.DNI = DNI;
    }
    public String getDNI(){
        return DNI;
    }

    private int edad;
    public void setEdad(int edad){

        if(edad < 0){
            throw new InputMismatchException();
        }

        this.edad = edad;
    }
    public int getEdad(){
        return edad;
    }

    private Integer sexo;
    public void setSexo(Integer sexo){
        if(sexo <= 0 || sexo >= 3){
            throw new InputMismatchException("Solo se aceptan valores del 1 al 3");
        }

        this.sexo = sexo;
    }
    public Integer getSexo(){
        return sexo;
    }

    @Override
    public String toString() {

        if(getNombre().length() >= 10){
            String aux = getNombre().substring(0,7) + "...";
            return String.format("%10s:%s", aux, getDNI());
        }
        return String.format("%10s:%s", getNombre(), getDNI());
    }
}
