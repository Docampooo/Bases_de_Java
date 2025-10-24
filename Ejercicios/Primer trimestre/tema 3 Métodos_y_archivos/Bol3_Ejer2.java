import java.util.Scanner;
import java.io.PrintWriter;
public class Bol3_Ejer2 {
/**
 * función que deja un número de líneas por pantalla
 * @param n n es el numero de líneas
 */
    public static void lineas(int n){
        for(int cont=0; cont<n; cont++){
            System.out.println();
        }
    }
/**
 * función  que comprueba si un nº es par o impar es 
 * @param n Nº a comprobar
 * @return par devuelve true y si es inpar false
 */    public static boolean par(int n){
        boolean bandera;
        if(n%2==0 ){
            bandera=true;
        } else{
            bandera=false;
        } 
        return bandera;
    }
    /**
     * función  si un nº es pos o neg
     * @param n Nº a comprobar
     * @return P si es posit o 0 y N si neg
     */
    public static char letra(int n){

        return (n<0) ? 'N' : 'P';
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter f = new PrintWriter("Bol3_Ejer2.txt");
        int num;

        System.out.println("introduce tu nombre: ");
        f.println(sc.nextLine());
        lineas(10);
        System.out.println("introduce un numero");
        f.println(num = sc.nextInt());
        System.out.println("si el numero es par, el valor será true, si es impar, será false");
        f.println(par(num)?"par" : "impar");
        System.out.println("si el numero es positivo, el caracter será una P, si es negativo, será una N");
        f.println(letra(num)=='N'?"Negativo":"Positivo");
        f.close();
    }
}
