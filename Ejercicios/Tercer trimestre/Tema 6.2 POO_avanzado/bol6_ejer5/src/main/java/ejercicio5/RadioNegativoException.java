package ejercicio5;

import java.util.InputMismatchException;

public class RadioNegativoException extends InputMismatchException{
    
    public RadioNegativoException(){
        super("El radio ha de ser positivo");
    }
}
