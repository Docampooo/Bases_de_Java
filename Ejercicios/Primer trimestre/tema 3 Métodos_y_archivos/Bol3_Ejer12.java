import java.util.Scanner;

public class Bol3_Ejer12 {
    /**
     * funcion que calcula los resultados de una quiniela
     * @return devuelve 2, 1 o X
     */
    public static String quiniela() {
        String random;
        double n = Math.random();
        if (n < 0.33) {
            random = "2";
        } else {
            if (n > 0.66) {
                random = "1";
            } else {
                random = "X";
            }
        }
        return random;
    }
    /**
     * funcion que hace una quiniela ponderada, mas probabilidades de que salga una de las opciones que la otra
     * @return devuelve 1, 2 o X
     */
    public static String quiniela2(){
        String random;
        double n = Math.random();
        if (n < 0.6) {
            random = "1";
        } else {
            if (n > 0.85) {
                random = "0";
            } else {
                random = "X";
            }
        }
        return random;
    }

    public static void main(String[] args) {// TODO printf para alinear col
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("elige una de las 2 opciones");
            System.out.println("1º quiniela normal");
            System.out.println("2º quiniela ponderada");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    for(double cont=1; cont<=14; cont++){
                        System.out.printf("el resultado del partido numero %2.0f es: %s \n",cont ,quiniela());
                    }
                break;
                case 2:
                    for(double cont=1; cont<=14; cont++){
                        System.out.printf("el resultado del partido numero %2.0f es: %s \n",cont ,quiniela());
                    }
                break;
                case 3:
                    System.out.println("has salido");
                break;
                default:
                    System.out.println("numero fuera de rango");
            }
        }while(opcion!=3);
    }
}
