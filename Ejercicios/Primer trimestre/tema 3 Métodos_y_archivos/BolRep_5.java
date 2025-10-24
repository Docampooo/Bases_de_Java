import java.util.Scanner;
public class BolRep_5 {

    public static double media(double n1, double n2, double n3, double n4, double n5){
        double mid=(n1 + n2 + n3 + n4 + n5)/5;

        return mid;
    }

    public static double media2(){
        Scanner sc = new Scanner(System.in);
        double mid=0;
        double acu=0;
        int cont=-1;
        double num;
        System.out.println("introduce los numeros que quieras, la funcion terminará cuando introduzcas el numero 0");
        do{
            cont++;
            num=sc.nextDouble(); 
            acu = acu + num;
        }while(num!=0);
        acu = acu / cont;

        return acu;
    }


    public static void main(String[] args) {
     
        System.out.println(media(5, 5, 5, 5, 5));

        System.out.println(media2());
    }
}
