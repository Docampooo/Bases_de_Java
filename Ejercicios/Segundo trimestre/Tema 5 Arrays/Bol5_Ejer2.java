public class Bol5_Ejer2 {

    public static char[][] aleatorios(int n, int m){
        char[][] vector = new char[n][m];

        for(int i=0; i<vector.length;i++){
            for(int u=0;u<vector[i].length;u++){// Mejor j
                vector[i][u] = (char) (Math.random()*26+65);
            }
        }
        return vector;
    }

    public static char maximo(char[][] matriz){

        char maximo = matriz[0][0];
        for(int i=0;i<matriz.length;i++){
            for(int u=0;u<matriz[0].length;u++){
                if(matriz[i][u] > maximo){
                    maximo = matriz[i][u];
                }
            }
        }
        return maximo;
    }

    public static char minimo(char[][] matriz){

        char minimo = matriz[0][0];

        for(char[] fila: matriz){
            for(char valor: fila){
                if(valor < minimo){
                    minimo = valor;
                }
            }
        }
        return minimo;
    }

    public static void mostrar(char[][] matriz){
        System.out.printf("%3s","");
        for(int cont = 0;cont<matriz[0].length;cont++){ 
            System.out.printf("%3d",cont);
        }
    
        System.out.println();
        int cont = -1;
        for(char[] fila:matriz){
            cont++;
            System.out.printf("%3d",cont);
            for(char valor: fila){
                System.out.printf("%3c",valor); 
            }
            System.out.println();
        }
    }

    public static boolean cambio(char[][] matriz, int n, int n2, int m, int m2){

        boolean bandera = !((n < 0 || n >= matriz.length)||(n2 < 0 || n2 >= matriz[n].length)||(m < 0 || m >= matriz.length)||(m2 < 0 || m2 >= matriz[m].length));

        if(bandera){
            char recipiente = matriz[n][n2];
            matriz[n][n2] = matriz[m][m2];
            matriz[m][m2] = recipiente;
        }
        return bandera;
    }
    
    public static void main(String[] args) {
        
        char[][] letras = aleatorios(4, 4);

        mostrar(letras);
        
        cambio(letras, 1, 2, 3, 4);

        System.out.println();
        mostrar(letras);
    } 
}