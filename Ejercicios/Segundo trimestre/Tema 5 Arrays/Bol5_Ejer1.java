import java.util.Scanner;

public class Bol5_Ejer1 {

    public static int[] aleatorios(int n) {

        int[] vector = new int[n];
        for (int cont = 0; cont < vector.length; cont++) {
            vector[cont] = (int) (Math.random() * 4001 + 1000);
        }
        return vector;
    }

    public static void mostrar(int[] vector){
        for(int valor:vector){
            System.out.printf("%d \n",valor);
        }
    }

    public static int mayor(int[] vector) {

        int acu = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > acu) {
                acu = vector[i];
            }
        }
        return acu;
    }

    public static int menor(int[] vector) {

        int acu = vector[0];
        for (int valor : vector) {
            if (valor < acu) {
                acu = valor;
            }
        }
        return acu;
    }

    public static boolean intercambio(int vector[], int num1, int num2){
        boolean bandera = true; 
        if((num1 < 0 || num1 >= vector.length) || (num2 < 0 || num2 >= vector.length)){
            bandera = false;
        }else{
            int recipiente = vector[num1];
            vector[num1] = vector[num2];
            vector[num2] = recipiente;
        }

        return bandera;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros=aleatorios(10);

        System.out.println("---------------------------------");

        mostrar(numeros);

        System.out.println("---------------------------------");
        
        System.out.println("Mayor");
        System.out.println(mayor(numeros));
        
        System.out.println("Menor");
        System.out.println(menor(numeros));

        System.out.println("---------------------------------");

        intercambio(numeros, 4, 2);
        mostrar(numeros);
    }
}
