public class pruebafunciones {
    public static void estrellitas() {
        System.out.println("***********************");
    }
    public static void etrellitas2(int NumeroEstrellas) {

        // int n = 23;
        for(int i = 0; i < NumeroEstrellas; i++){
            System.out.print("*");
        }
        System.out.println();
    }
    public static int suma(int sumando1, int sumando2){ //funcion de devolución, no saca los resultados por pantalla
        return sumando1 + sumando2;        
    }

    public static void main(String[] args) {

        estrellitas();
        etrellitas2(40);
        etrellitas2(20);
        etrellitas2(10);

        suma(32,54);
        System.out.println(suma(32,54));
    }
}
