import java.util.Scanner;
public class Bol3_Ejer11 {
    /**
     * funcion que calcula el factorial de un numero
     * @param num numero que introduce el usuario 
     * @return devuelve el factorial del numero
     */
    public static double factorial(double num){
        double facto = num;
        if(num==0){
            facto = 1;
        } else{
            for(double cont=num-1; cont>0; cont--){
                facto = facto*cont;
            }
        }
        return facto;
    }
    /**
     * funcion que calcula el coseno de un numero
     * @param num numero que introduce el usuario
     * @return devuelve el coseno del numero
     */
    public static double coseno(double num){
        double cos;
        cos = 1-(Bol3_Ejer6.potencia(num, 2)/factorial(2)) + (Bol3_Ejer6.potencia(num, 4)/factorial(4)) - (Bol3_Ejer6.potencia(num, 6)/factorial(6));
        return cos;
        }
    /**
     * funcion que calcula el error absoluto entre la funcion de coseno y el parametro Math.cos()
     * @param num numero del que se calcula el coseno
     * @return error absoluto de la función
     */
    public static double absoluto(double num){
        double resta =Math.cos(num)-(coseno(num));
        return Math.abs( resta);
    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num;
            double num2;
            
            System.out.println("introduce un número para calcular su factorial");
            num=sc.nextInt();
            System.out.println(factorial(num));

            System.out.println("introduce un número para calcular su coseno:  ");
            num2=sc.nextDouble();
            System.out.println(coseno(num2));

            System.out.println("el error de la función es: ");
            System.out.println(absoluto(num2));

            System.out.println("el calculo de los ángulos desde 0,1 hasta 1 radian y su error es:");

            for(double cont=0; cont<=1;cont=cont+0.1){
                System.out.printf("%8.5f, su coseno es %8.5f y su error absoluto es %8.5f \n",cont,coseno(cont),absoluto(cont));
            }
        }
    }

