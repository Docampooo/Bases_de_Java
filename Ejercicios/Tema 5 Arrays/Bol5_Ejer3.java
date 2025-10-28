import java.util.ArrayList;
public class Bol5_Ejer3 {

    public static ArrayList<Integer> aleatorios(int n){
        ArrayList<Integer> lista = new ArrayList<Integer>();

        for(int i = 0; i<n;i++){
            lista.add((int)(Math.random()*4001+1000));
        }
        return lista;
    }

    public static void mostrar(ArrayList<Integer> vector){
        for(int valor:vector){
            System.out.println(valor);
        }
    }

    public static int maximo(ArrayList<Integer> vector){ 

        int acu = vector.get(0);
        for(int i=0;i<vector.size();i++){
            if(vector.get(i)>acu){
                acu = vector.get(i);
                 
            }
        }
        return acu;
    }

    public static int minimo(ArrayList<Integer> vector){ // TODO foreach
        int acu = vector.get(0);
        for(int valor: vector){
            if(valor < acu){
                acu = valor;
            }
        }

        return acu;
    }

    public static void swap(ArrayList<Integer> coleccion, int n, int m){

        if((n<0 || n>=coleccion.size()) &&(m<0 && m>=coleccion.size())){
            System.out.println("Parámetro fuera de rango");
        }else{
            int recipiente = coleccion.get(n);
            coleccion.set(n,coleccion.get(m));
            coleccion.set(m,recipiente);  
        }
    
    }


    public static void eliminar(ArrayList<Integer> vector, int n){
        
        for(int i=vector.size()-1;i>=0;i--){ 
            if(vector.get(i)>n){
                vector.remove(i);
            }
        }
    }


    public static void main(String[] args){
        
        ArrayList<Integer> lista = new ArrayList<Integer>();

        lista = aleatorios(10);

        mostrar(lista);
        System.out.println();

        System.out.println(maximo(lista));
        System.out.println();

        System.out.println(minimo(lista));
        System.out.println();

        eliminar(lista, 3000);

        mostrar(lista);
        System.out.println();

        swap(lista, 1, 2);
        mostrar(lista);

    }
}
