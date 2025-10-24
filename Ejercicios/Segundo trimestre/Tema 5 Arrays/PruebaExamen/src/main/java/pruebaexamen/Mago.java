package pruebaexamen;

public class Mago {
    
    /**
     * Se le pasa un Valor entero y devuelve una matriz con el numero de filas igual al valor introducido y 4 columnas
     * @param magos entero que toma como referencia para crear las filas de la matriz
     * @return matriz con valores aleatorios entre 1 y 5 en cada posicion
     */
    public int[][] creaMatriz(int magos){

        int[][] matriz = new int[magos][4];

        for(int fila=0;fila<matriz.length;fila++){
            for(int columna=0;columna<4;columna++){
                matriz[fila][columna] = (int) (Math.random()*5+1);
            }
        }
        return matriz;
    }
    /**
     * Se le pasa una matriz y la muestra todos sus valores ordenados, con cabecera y indice, si la matriz es nula, no la muestra
     * @param matriz matriz a mostrar
     */
    public void muestraMatriz(int[][] matriz){

        if(matriz != null){
            System.out.printf("%3s","");
            for(int i=0;i<4;i++){
                if(i==0){
                    System.out.printf("%3s","A");
                }else if(i==1){
                    System.out.printf("%3s","F");
                }else if(i==2){
                    System.out.printf("%3s","E");
                }else{
                    System.out.printf("%3s","W");
                }
            }
            System.out.println("");
    
            for(int fila=0;fila<matriz.length;fila++){
                System.out.printf("%3d",fila+1);
                for(int columna=0;columna<4;columna++){
                    System.out.printf("%3d",matriz[fila][columna]);
                }
                System.out.println();
            }
        }else{
            System.out.println("La matriz es nula");
        }
    }
    /**
     * Devuelve la suma de los valores enteros de una fila en una matriz
     * @param matriz matriz de la que se sacan los valores y filas
     * @param filaMatriz indice de la fila para hacer la suma
     * @return suma de los elementos de la fila
     */
    public int poderMago(int[][] matriz, int filaMatriz){

        if(filaMatriz < 0 || filaMatriz >= matriz.length){
            throw new ArrayIndexOutOfBoundsException("Mago no existente");
        }
        int nivel = 0;
        for(int columna:matriz[filaMatriz-1]){
            nivel = nivel + columna;
        }
        return nivel;
    }

    public void intercambioDePoder(int[][] matriz, int fila1, int fila2){

        int[] recipiente = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = recipiente;
    }
    
}
