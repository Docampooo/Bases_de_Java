package ejercicio7.listaPedidos;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Refresco extends Pedido{
    
    private boolean gas;
    public void setGas(boolean gas){
        this.gas = gas;
    }
    public boolean getGas(){
        return gas;
    }

    public double calcularPrecio(){

        double precio = 0; //precio base del refresco

        if(getGas()){
            precio = precio + 0.5;
        }

        if (getTipoDeVenta() == 1) {
            precio = precio + 4;
        }

        if (getTamaño()) {
            precio = precio + 2;
        }

        if(getTipo().equals("MANZANA") || getTipo().equals("SANDIA")){
            precio = 2.5;
        }else if(getTipo().equals("NARANJA") || getTipo().equals("LIMON")){
            precio = 3;
        }
        
        return precio * getCantidad();
    }

    public Refresco(String tipo, String domicilio, int cantidad, int codigo, int tipoDeVenta, double precio, double tiempoEntrega, boolean tamaño, boolean gas, String sabor) {
        super(tipo, domicilio, cantidad, codigo, tipoDeVenta, precio, tiempoEntrega, tamaño);
        setGas(gas);
    }

    public Refresco(int codigo) {
        super("", "", 0, codigo, 0, 0, 0, false);
        setGas(false);
    }

    @Override
    public String toString() {
        return String.format("Refresco");
    }
}
