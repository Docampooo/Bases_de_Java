
public class BolRep7 {

    public static double buscador(double parametro){
        int n=0;
        int cont = 0;
        for(cont=0; n<parametro;cont++){
            n=n+cont;
        }
        return cont;
    }

    public static void main(String[] args) {
        
        System.out.println(buscador(1000));
        
    }
}
