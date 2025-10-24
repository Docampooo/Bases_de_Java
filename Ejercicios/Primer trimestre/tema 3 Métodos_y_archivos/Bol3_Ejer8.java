import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class Bol3_Ejer8 {
    /**
     * función que muestra si el numero   es un numero primo
     * o no y devuelve le valor ne booleano
     * 
     * @param n numero usado par comprobar si es primo
     * @return true si primo
     */
    public static boolean primo(double n) { // la función falla con los valores 1 y 2
        int cont = 1;
        do {
            cont++;
        } while (n % cont != 0 && cont < n - 1);

        return (n % cont != 0);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter f = new PrintWriter("Bol3_Ejer9.txt");


        int n;
        int opcion;

        int cin;
        System.out.println("introduce 5 numeros: ");
        for(int cont = 0; cont < 5; cont++){
            f.println(cin = sc.nextInt());
        }
        f.close();

        do {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("elige una de las opciones:  ");
            System.out.println("1º mostrar numeros primos menores al numero a introducir");
            System.out.println("2º primos en archivo");
            System.out.println("3º archivo con primos");
            System.out.println("4º salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(
                            "introduce un numero mayor que dos y el prgrama sacará por pantalla los numeros primos menores que dicho número");
                    n = sc.nextInt();

                    System.out.println(primo(n));

                    System.out.println("los numeros primos hasta el numero son:  ");
                    for (int cont = 2; cont < n; cont++) {
                        if (primo(cont) == true) {
                            System.out.println(cont);
                        }
                    }
                    break;
                case 2:
                    Scanner S = new Scanner(new File("Bol3_Ejer9.txt"));
                    System.out.println("si los numeros que introdujiste son primos saldrá true, si no saldrá false");
                    while(S.hasNext()){
                        cin =Integer.parseInt(S.nextLine());
                        System.out.println(cin + "\t" + primo(cin));
                    }
                    S.close();
                    break;
                case 3:
                    f = new PrintWriter("Bol3_Ejer9.txt");
                    System.out.println("introduce un numero mayor que 2");
                    n = sc.nextInt();
                    f.println("Los números primos desde el 0 al número son:  ");
                    for(int cont=2; cont < n; cont++){
                        if(primo(cont) == true){
                            f.print(cont + "; ");
                        }
                    }
                    f.close();
                    break;
                case 4:
                    System.out.println("has salido");
                    break;
                default:
                    System.out.println("numero no valido");
            }   
        } while (opcion != 4);
        f.close();
    }
}
