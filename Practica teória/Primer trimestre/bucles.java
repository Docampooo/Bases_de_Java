public class bucles {
    public static void main(String[] args) {
        int cont = 0;
        int acu = 0;

        while(cont < 10){
            cont = cont + 1;
            acu = acu + cont;
            System.out.println("La suma de números da: " + acu);
        }
    }
}
