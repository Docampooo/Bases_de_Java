package ejercicio7.libreria;

public class ExcesoDePedidosException extends IndexOutOfBoundsException{
    
    public ExcesoDePedidosException(){
        super("Lo siento, no se puede añadir el pedido, se ha llegado al número máximo de pedidos");
    }
}
