package ejercicio7.libreria;

import java.util.InputMismatchException;

public class NumeroNegativoException extends InputMismatchException{
    
    public NumeroNegativoException(){
        super("El valor no puede ser negativo");
    }
}
