import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Bol3_Ejer13 {

    public static int dados(int eleccion) {
        int n = (int) (Math.random() * eleccion + 1);
        return n;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String nombre;
        int n1;
        int n2;
        int n3;
        int puntos;
        int eleccion = 0;
        int salir = 0;
        String cadena = "";
        String almacen="";

        
        System.out.println("introduce tu nombre");
        nombre = sc.nextLine();
        
        do {
            puntos = 0;
            PrintWriter f = new PrintWriter(new FileWriter("Bol3_Ejer13.txt",true)); 
            
            System.out.println("cuantas caras quieres que tenga tu dado?, tiene que se minimo de 4 caras");
            do{
                eleccion = sc.nextInt();
                if(eleccion < 4){
                    System.out.println("son muy pocas caras, prueba con otro dado");
                }
            }while(eleccion<4);

            System.out.println("introduce un numero");
            n1 = sc.nextInt();
            while ((n1 < 0) || (n1 > eleccion)) {
                System.out.println("el numero tiene que estar entre 1 y el numero de caras que elegiste");
                System.out.println("prueba con otro");
                n1=sc.nextInt();
            }
            System.out.println("introduce un segundo numero");
            n2 = sc.nextInt();
            while ((n2 < 0) || (n2 > eleccion)) {
                System.out.println("el numero tiene que estar entre 1 y el numero de caras que elegiste");
                System.out.println("prueba con otro");
                n2=sc.nextInt();
            }
            if (n1 == n2) {
                do {
                    System.out.println("numero duplicado, prueba con otro");
                    n2 = sc.nextInt();
                    while ((n2 < 0) || (n2 > eleccion)) {
                        System.out.println("el numero tiene que estar entre 1 y el numero de caras que elegiste");
                        System.out.println("prueba con otro");
                        n2 = sc.nextInt();
                    }
                } while (n1 == n2);
            }
            System.out.println("introduce un tercer numero");
            n3 = sc.nextInt();
            while ((n3 < 0) || (n3 > eleccion)) {
                System.out.println("el numero tiene que estar entre 1 y el numero de caras que elegiste");
                System.out.println("prueba con otro");
                n3 = sc.nextInt();
            }
            if ((n1 == n3) || (n2 == n3)) {
                do {
                    System.out.println("numero duplicado, prueba con otro");
                    n3 = sc.nextInt();
                    while ((n3 < 0) || (n3 > eleccion)) {
                        System.out.println("el numero tiene que estar entre 1 y el numero de caras que elegiste");
                        System.out.println("prueba con otro");
                        n3 = sc.nextInt();
                    }
                } while ((n1 == n3) || (n2 == n3));
            }

            int res1 = dados(eleccion);
            int res2 = dados(eleccion);

            while (res1 == res2) {
                res2 = dados(eleccion);
            }

            if ((res1 == n1) || (res1 == n2) || (res1 == n3)) {
                puntos = puntos + 1;
            }

            if ((res2 == n1) || (res2 == n2) || (res2 == n3)) {
                puntos = puntos + 1;
            }

            f.printf(
                    "%s, tus dados son de %4d caras y los numeros que han salido son: %4d y %4d. has acertado %d \n",
                    nombre, eleccion, res1, res2, puntos);
            f.close();
            Scanner p = new Scanner(new File("Bol3_Ejer13.txt"));

            while (p.hasNext()) {
                cadena = p.nextLine();
                almacen = almacen + "\n" + cadena;
                System.out.println(cadena);
            }
            p.close();
            System.out.println("introduce el numero 1 para salir y cualquier otro para volver a jugar");
            salir = sc.nextInt();
        } while (salir != 1);
    }
}
