public class BolRep_1 {

    public static void numeritos(boolean bandera){

        if(bandera){

            for(int cont=1;cont<=20;cont++){
                System.out.println(cont);
            }
        } else{
            for(int cont2=1; cont2<=50;cont2++){
                if(cont2%2==0){
                    System.out.printf("Los numeros pares del 1 al 50 son: %5d \n ", cont2);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        numeritos(false);
    }
}
