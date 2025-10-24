import java.util.Scanner;
public class PruebaArray {

    public static void cambio(double[] vector){ //funcion que establece un cambio en un array
        vector[2] = 40;
    }

    public static void mostrarVector(double[] vector){ //funcion que sirve para mostrar cualquier vector de doubles
        for(int cont=0;cont<vector.length;cont++){

            System.out.printf("temperaturas[%d] = %7.2fºC \n",cont, vector[cont]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] temperaturas; //Se establece el array con los corchetes al lado del tipo de dato

        temperaturas = new double[50]; //una vez establecido, se debe declarar de esta manera

        temperaturas[0] = 7.5;
        temperaturas[1] = 4.5;
        temperaturas[2] = 6;
        temperaturas[3] = 8;

        int eleccion = 2;
        System.out.println(temperaturas[eleccion]); //Los arrays permiten tanto variables numericas y operaciones como numeros para seleccionar valores

        for(int cont=0;cont<temperaturas.length;cont++){ //Forma en la que con un unico bucle se pueden sacar una gran cantidad de valores, en este caso, con temperaturas.length, el bucle avanza desde 0 hasta lenght

            System.out.printf("temperaturas[%d] = %7.2fºC \n",cont, temperaturas[cont]);
        }

        char[] dias;

        dias = new char[] {'1', '2', '3', '4'}; //se añaden valores directamente sin tener que escribir todas las lineas

        //bucle for mejorado o foreach, coge directamente el valor del array y hace 

        for(double numero : temperaturas){
            System.out.println(numero);
        }
        
    }
}
