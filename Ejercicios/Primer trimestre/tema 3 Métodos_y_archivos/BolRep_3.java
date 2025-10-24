import java.io.PrintWriter;
import java.io.File;

public class BolRep_3 {
    public static int suma(int n)throws Exception{
        PrintWriter f = new PrintWriter(new File("rep3.txt"));
        int acu=0;

        if(n>=0){
            for(int cont=1;cont<n;cont++){
                acu=acu + cont;
                f.println(acu);
            }
            f.close();
        } else{
            acu=0;
            f.println(acu);
        }
            return acu;
    }
    public static void main(String[] args) throws Exception {
        
        System.out.println(suma(40));
    }
}
