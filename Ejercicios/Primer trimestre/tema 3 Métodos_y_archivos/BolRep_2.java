public class BolRep_2 {
    /**
     * dependiendo de qué parametro sea mayor de los 2 parametros de la funcion devuelve 1, 2 o 0
     * @param n1 
     * @param n2
     * @return devuelve 1 si n1 > n2 , 2 si n2 > n1 y 0 si n1 == n2
     */
    public static int numeros(int n1, int n2){
        int res=0;
        if(n1 > n2){
            res=1;
        } else if(n2 > n1){
            res=2;
        } else{
            res=0;
        }
        return res;
    }

    public static boolean multiplos(int n1, int n2){
        return ((n1%n2==0)||(n2%n1==0));
    }

    public static void main(String[] args) {
        System.out.println(numeros(15, 15));

        System.out.println(multiplos(12, 3));
    }
}
