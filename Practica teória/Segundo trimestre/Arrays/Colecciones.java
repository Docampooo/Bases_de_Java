import java.util.ArrayList;
public class Colecciones {
    
    public static void main(String[] args) {
        
        //Las colecciones son arrays con un tamaño que puede cambiar, no es fijo 

        ArrayList<String> nombres= new ArrayList<String>();

        //No se pueden hacer colecciones de datos primitivos(int, double, char...)

        //se usan asi:

        Integer n;
        Double m;
        Character c;

        //Metodos de las colecciones

        System.out.println("Tamaño: "+nombres.size()); //tamaño de la coleccion
        nombres.add("a"); //0
        nombres.add("b"); //1

        
        System.out.println("Tamaño: "+nombres.size());

        nombres.add(1,"T"); //Añade la T a la posicion 1 y mueve la b a la posicion 2

        System.out.println(nombres.get(1)); //muestra el valor indicado de la coleccion

        nombres.set(1, "Pablo vaz");//substituye el contenido de la posicion 1, por "Pablo vaz"

        System.out.println(nombres.get(1));


    }

}
