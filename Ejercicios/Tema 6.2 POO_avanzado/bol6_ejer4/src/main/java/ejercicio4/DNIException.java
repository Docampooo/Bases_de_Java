package ejercicio4;

public class DNIException extends IllegalArgumentException{
    
    public DNIException(){
        super("Los parámetros introducidos en el DNI no coinciden o son erroneos");
    }
}