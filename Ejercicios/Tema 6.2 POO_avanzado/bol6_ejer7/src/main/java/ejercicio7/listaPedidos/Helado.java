package ejercicio7.listaPedidos;

import java.util.InputMismatchException;

public class Helado extends Pedido{
    
    private boolean hielo;
    public void setHielo(boolean hielo){
        this.hielo = hielo;
    }
    public boolean getHielo(){
        return hielo;
    }

    public double calcularPrecio(){

        double precio = 0;

        if(!getHielo()){
            precio = precio + 0.5;
        }
        
        if (getTipoDeVenta() == 1) {
            precio = precio + 4;
        }

        if (getTamaño()) {
            precio = precio + 2;
        }

        if(getTipo().equals("AVELLANA") || getTipo().equals("FRESA")){
            precio = precio + 3;
        }else if(getTipo().equals("CHOCOLATE") || getTipo().equals("OREO") || getTipo().equals("COOKIES")){
            precio = precio + 4;
        }
        
        return precio * getCantidad();
    }

    public Helado(String tipo, String domicilio, int cantidad, int codigo, int tipoDeVenta, double precio, double tiempoEntrega, boolean tamaño, boolean hielo) {
        super(tipo, domicilio, cantidad, codigo,tipoDeVenta, precio, tiempoEntrega, tamaño);
        setHielo(hielo);
    }

    public Helado(int codigo) {
        super("", "", 0, codigo, 0, 0, 0, false);
        setHielo(false);
    }

    @Override
    public String toString() {
        return String.format("Helado");
    }
}
