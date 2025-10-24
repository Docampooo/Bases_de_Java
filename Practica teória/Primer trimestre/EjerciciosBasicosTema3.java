import java.util.Scanner;
public class EjerciciosBasicosTema3 {
    
    public static void saludo() {
        System.out.println("HOLA");
    }

    public static void saludo10(){
        for(int cont = 0; cont <10; cont++){
            System.out.printf("HOLA  ");
        } System.out.println();
    }

    public static void variosSaludos( int n){

        for(int cont=0; cont < n; cont++){
            System.out.printf("HOLA  ");
        } System.out.println();
    }

    public static void pintaMensaje(String msg) {
        System.out.println(msg);
    }

    public static void pintaMensaje10(String msg) {
        for(int cont=0; cont < 10; cont++ ){
            System.out.printf(msg);
        } System.out.println();
    }

    
    public static void pintaVariosMensajes(String msg, int n){
        for(int cont=0; cont<n; cont++){
            System.out.printf(msg);
        } System.out.println();
    }
    
    public static int suma20(){
        int acu=0;
        for(int cont=0; cont<=20; cont++){
            acu = acu + cont;
        }
        return acu;
    }

    public static int sumaN(int n){
        int acu=0;
        for(int cont=0; cont<n; cont++){
            acu = acu + cont;
        } 
        return acu;
    }

    public static int pideNumero(String msg){
        int n;
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        n = n*2;
        return n;        
    }

    public static void main(String[] args) {
        
        saludo();

        saludo10();

        variosSaludos(2);

        pintaMensaje("Adios");

        pintaMensaje10("adios");

        pintaVariosMensajes("adios  ", 3);

        System.out.println(suma20());

        System.out.println(sumaN(10));

        System.out.println(pideNumero("dime un numero y te daré el doble"));
    }
}
