package prueba;

public class RadioNegativoException extends IllegalArgumentException{
    
    public RadioNegativoException(){
        super("El radio de un Astro no puede ser negativo");
    }
}
