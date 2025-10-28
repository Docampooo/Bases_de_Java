import java.util.Scanner;

public class Pruebaexamen {

    public static void bucles() {
        System.out.println("los numeros impares del 5 al 40 son: ");
        int num;
        for (int cont = 40; cont >= 5; cont--) {
            if (cont % 2 != 0) {
                System.out.printf("%2d \n", cont);
            }
        }
        int acu = 1;
        System.out.println("la multiplicacion de pares entre 1 y 10 son: ");
        for (int cont2 = 1; cont2 < 10; cont2++) {
            if (cont2 % 2 == 0) {
                acu = acu * cont2;
            }
        }
        System.out.println(acu);
    }

    /**
     * funcion que en funcion de un numero como base y otro como exponente realiza
     * diferentes operaciones, si el exponente es mayor que 0, calcula la potencia,
     * si el exponente es menor que 0, divide la base por el valor absoluto del
     * exponente, en caso de que el exponente sea 0, y la base sea menor que 10,
     * devuelve un numero aleatorio entre 10 y 20, si el exponente es 0 y la base es
     * mayor que 10, devuelve un numero aleatorio entre 10 y la base.
     * 
     * @param base      numero como base elegido por el usuario
     * @param exponente exponente puesto por el usuario
     * @return devuelve la potencia o numero aleatorio correspondiente
     */
    public static double calculos(int base, int exponente) {
        double resultado = base;
        if (exponente > 0) {
            for (int cont = 1; cont < exponente; cont++) {
                resultado = resultado * base;
            }
        } else if (exponente < 0) {
            resultado = resultado / -exponente;
        } else if (exponente == 0) {
            if (base < 10)
                System.out.println("un numero aleatorio entre 10 y 20 es: ");
            resultado = (int) (Math.random() * 11 + 10);
            if (base > 10)
                resultado = (int) (Math.random() * (base - 10) + 10);
            return resultado;
        }
        return resultado;
    }

    /**
     * función que dependiendo de la elección del usuario y usando un parámetro tipo boolean, calcula o la media de ciertos números o la suma de estos.
     * @param cant cantidad de numeros  que va a introducir el usuario
     * @param bandera variable tipo boolean con la que decide qué hacer
     * @return devuelve o la media o la suma
     */
    public static double mediasOSumas(int cant, boolean bandera) {
        Scanner sc = new Scanner(System.in);
        double suma = 0;
        double media;
        double num;

        for (int cont = 0; cont < cant; cont++) {
            num = sc.nextDouble();
            suma = suma + num;
        }
        media = suma / cant;
        return bandera ? media : suma;
    }
    /**
     * función que realiza una pirámide con valores de 10 a 0 y de forma decreciente
     */
    public static void pirámide() {
        for (int cont = 10; cont > 0; cont--) {
            for (int cont2 = cont; cont2 > 0; cont2--) {
                System.out.print(cont2 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero y su exponente: ");
        int base = sc.nextInt();
        int exponente = sc.nextInt();
        int cant;
        int option;
        int option2;

        do {
            System.out.println("elige una de las funciones: ");
            System.out.println("1º bucles");
            System.out.println("2º calculos");
            System.out.println("3º Media");
            System.out.println("4º pirámide");
            System.out.println("5º salir");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    bucles();
                    break;
                case 2:
                    System.out.println(calculos(base, exponente));
                    break;
                case 3:
                    do {
                        System.out.println("elige una de las funciones: ");
                        System.out.println("1º bucles");
                        System.out.println("2º calculos");
                        System.out.println("3º Media");
                        System.out.println("4º pirámide");
                        System.out.println("5º salir");
                        option2 = sc.nextInt();
                        switch (option2) {
                            case 1:
                                System.out.println("cuantos numeros quieres introducir?");
                                cant = sc.nextInt();
                                System.out.println(mediasOSumas(cant, false));
                                option = 3;
                                break;
                            case 2:
                                System.out.println("cuantos numeros quieres introducir?");
                                cant = sc.nextInt();
                                System.out.println(mediasOSumas(cant, true));
                                option = 3;
                                break;
                            case 3:
                                System.out.println("has salido");
                            default:
                                System.out.println("valor fuera de rango");
                        }
                    } while (option2 != 3);
                    break;
                case 4:
                    pirámide();
                    break;
                case 5:
                    System.out.println("has salido");
                    break;
                default:
                    System.out.println("valor fuera de rango");
            }
        } while (option != 5);
    }
}
