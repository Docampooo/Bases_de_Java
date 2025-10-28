import java.util.Scanner;

public class Bol2_Ejer19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int opcion;
        int cont;
        int cont2;

        System.out.println("introduce el numero de asteriscos que quieres generar: ");
        do{
            n = sc.nextInt();
            cont = 0; 
            System.out.println("elige como quieres que se generen los asteriscos.");
            System.out.println("1º de izquierda a derecha");
            System.out.println("2º de derecha a izquierda");
            System.out.println("3º salir");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                for(cont = 0; cont < n; cont++){
                    
                        for(cont2 = 0; cont2 < cont; cont2++){
                            
                            System.out.print(" ");
                        }
                        System.out.println("*");
                    }

                break;
                case 2:
                    for(cont = n; cont > 0; cont--){

                        for(cont2 = 0; cont2 < cont; cont2++){

                            System.out.print(" ");
                        }
                    System.out.println("*");
                    }
                break;
                case 3:
                    System.out.println("has salido");
                break;
                default:
                    System.out.println("el numero no está en la lista");
            }

        }while(opcion != 4);
    }
}

