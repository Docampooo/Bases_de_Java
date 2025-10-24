public class actividadfunciones {

    public static int sumaHastaN(int n){ //sale error siempre que la funcion no lleve return

        int acu = 0;

        for(int cont = 1; cont <= n; cont = cont +1 ){
            acu = acu + cont;
        }
        System.out.println(acu);

        return acu;
    } 
    public static void main(String[] args) {
        
        int reslutado = sumaHastaN(10);
        System.out.println(reslutado);

        System.out.println(sumaHastaN(10000));

        
    }
}
