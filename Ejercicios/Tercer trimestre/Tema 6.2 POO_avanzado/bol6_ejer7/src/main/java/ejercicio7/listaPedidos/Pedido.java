package ejercicio7.listaPedidos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import ejercicio7.libreria.*;

public class Pedido{

    // private String nombre;
    // public void setNombre(String nombre){
    //     if(nombre == ""){
    //         throw new InputMismatchException();
    //     }else{
    //         this.nombre = nombre;
    //     }
    // }
    // public String getNombre(){
    //     return nombre;
    // }
    
    private double precio;
    public void setPrecio(double precio){
        if(precio < 0){
            throw new NumeroNegativoException();
        }else{
            this.precio = precio;
        }
    }
    public double getPrecio(){
        return precio;
    }

    private double tiempoEntrega;
    public void setTiempoEntrega(double tiempoEntrega){
        if(tiempoEntrega < 0){
            throw new NumeroNegativoException();
        }else{
            
            if(getTipoDeVenta() == 1){
                this.tiempoEntrega = tiempoEntrega + 45;
            }else{
                this.tiempoEntrega = tiempoEntrega;
            }
        }
    }
    public double getTiempoEntrega(){
        return tiempoEntrega;
    }

    private String tipo;
    public void setTipo(String tipo){
        this.tipo = tipo.toUpperCase();
    }
    public String getTipo(){
        return tipo;
    }

    private int cantidad;
    public void setCantidad(int cantidad){
        if(cantidad < 0){
            throw new NumeroNegativoException();
        }else{
            this.cantidad = cantidad;
        }
    }
    public int getCantidad(){
        return cantidad;
    }

    private boolean tamaño;
    public void setTamaño(boolean tamaño){
        this.tamaño = tamaño;
    }
    public boolean getTamaño(){
        return tamaño;
    }

    private int tipoDeVenta;
    public void setTipoDeVenta(int tipoDeVenta){
        if(tipoDeVenta < 0){
            throw new NumeroNegativoException();
        }else{
            this.tipoDeVenta = tipoDeVenta;
        }
    }
    public int getTipoDeVenta(){
        return tipoDeVenta;
    }

    private String domicilio;
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
    public String getDomicilio(){
        return domicilio;
    }

    public ArrayList<Integer> codigos = new ArrayList<>();

    private int codigo;
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }

    public ArrayList<String> ingredientes = new ArrayList<>();

    public Pedido(String tipo , String domicilio, int cantidad, int codigo, int tipoDeVenta, double precio, double tiempoEntrega, boolean tamaño){

        // setNombre(nombre);
        setTipo(tipo);
        setCantidad(cantidad);
        setTipoDeVenta(tipoDeVenta);
        setPrecio(precio);
        setTiempoEntrega(tiempoEntrega);
        setTamaño(tamaño);
        setDomicilio(domicilio);
        setCodigo(codigo);
    }

    public Pedido(){
        this("", "", 0, 0, 0, 0, 0, false);
    }

}
