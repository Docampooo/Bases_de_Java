package ejercicio1;

public class IndiceFueraDeRango extends StringIndexOutOfBoundsException{
    
    public IndiceFueraDeRango(String cadena){
        super(cadena);
    }
}
