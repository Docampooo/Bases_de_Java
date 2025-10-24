import java.util.Scanner;
public class IntroduccionArrays {

    public static double medias(int[] vector){
        double acu = 0;
        int cont =0;
        for( int n: vector){
            acu = acu + n;
            System.out.printf("numeros[%d] = %d \n",cont,n);
            cont++;
        }
        return acu/10;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("introduce 10 numeros enteros");
        
        int[] numeros;
        numeros = new int[10];
        
        for(int cont = 0; cont < numeros.length;cont++){
            System.out.println("Numero:");
            int numero = sc.nextInt();
            numeros[cont] = numero;
        }
        
        double acu = 0;
        for(int cont: numeros){
            acu = cont + acu;
        }
        acu = acu / 10;
        System.out.println("la media es: "+ acu);

        acu = 0;
        int cont =0;
        for( int n: numeros){
            acu = acu + n;
            System.out.printf("numeros[%d] = %d \n",cont,n);
            cont++;
        }
        acu = acu / 10;
        System.out.println("la media es: "+ acu);

        System.out.println(medias(numeros));
    }    
}
