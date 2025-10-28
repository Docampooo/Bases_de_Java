import java.util.Scanner;
public class Principal {
    
    public static void main(String[] args) {
        
        Matriz m = new Matriz(3);
        Scanner sc = new Scanner(System.in);

        int opcion;
        int eleccion;
        do{
            System.out.println("1º Mostrar matriz");
            System.out.println("2º Suma de todos los elementos");
            System.out.println("3º Suma diagonal");
            System.out.println("4º Suma de todos los elementos salvo la diagonal");
            System.out.println("5º Suma de elementos de una sola fila");
            System.out.println("6º Borrar una fila");
            System.out.println("7º Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Matriz.mostrar(m.matriz);

                    break;
                case 2:
                    System.out.println(m.suma());

                    break;
                case 3:
                    System.out.println(m.suma(true));

                    break;
                case 4:
                    System.out.println(m.suma(false));

                    break;
                case 5:
                    System.out.println("Elige una fila: ");
                    eleccion = sc.nextInt();
                    System.out.println(m.suma(eleccion));

                    break;
                case 6:
                    System.out.println("Elige una fila: ");
                    eleccion = sc.nextInt();
                     Matriz.mostrar(m.borraFila(eleccion));
                    break;
                case 7:
                    System.out.println("Has salido");
                    break;
            
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        }while(opcion != 7);

    }
}
