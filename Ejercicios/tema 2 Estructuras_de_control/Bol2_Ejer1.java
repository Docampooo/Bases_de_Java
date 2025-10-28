public class Bol2_Ejer1 {
    public static void main(String[] args) {
        int cont = 0;

        while(cont<19){
            cont = cont + 1;
            System.out.println(cont);
        }
        do {
            cont = cont + 1;
            System.out.println(cont);
        }
        while(cont<20);
        
        for(cont = 0; cont<=20 ;cont ++){
            System.out.println(cont);
        }
        for(cont = 0; cont<=50 ;cont = cont + 2 ){
            System.out.printf(" %5d\n", cont);
        }

    }
}