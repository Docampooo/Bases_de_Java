package ejercicio1;

public class StringTooLongException extends IllegalArgumentException{
    
    public StringTooLongException(){
        super("La cadena es demasiado larga");
    }
}
