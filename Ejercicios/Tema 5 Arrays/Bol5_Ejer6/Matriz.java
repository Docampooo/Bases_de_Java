public class Matriz {

    public int[][] matriz;

    /**
     * muestra una matriz
     * 
     * @param vector matriz de enteros que debe mostrar
     */
    public static void mostrar(int[][] vector) {//
        System.out.printf("%3s", "");
        for (int cont = 0; cont < vector[0].length; cont++) {
            System.out.printf("%3d", cont);
        }
        System.out.println();

        int cont = -1;
        for (int[] fila : vector) {
            cont++;
            System.out.printf("%3d", cont);
            for (int valor : fila) {
                System.out.printf("%3d", valor);
            }
            System.out.println();
        }
    }

    /**
     * Realiza una suma de todos los elementos de la matriz
     * 
     * @return suma de los elementos
     */
    public int suma() {
        int acu = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                acu = acu + valor;
            }
        }
        return acu;
    }

    /**
     * dependiendo del parámetro booleano realiza una suma u otra
     * 
     * @param bandera si está true devulve una suma de los elementos de la diagonal
     *                de la matriz, si está a false la suma del resto de elementos
     *                salvo los de la diagonal
     * @return la suma de los elementos
     */
    public int suma(boolean bandera) {

        int acu = 0;
        for (int i = 0; i < matriz.length; i++) {
            acu = acu + matriz[i][i];
        }
        acu = suma() - suma(true);
        return bandera ? acu : suma() - acu;
    }

    /**
     * realiza una suma con los elementos de una fila de la matriz
     * 
     * @param n índice de la fila en la que se suman los elementos
     * @return suma de los elementos
     */
    public int suma(int n) {// 

        int acu = 0;
        if (n >= matriz.length || n < 0) {
            return -1;
        } else {
            for (int valor = 0; valor < matriz.length; valor++) {
                acu = acu + matriz[n][valor];
            }
        }
        return acu;
    }

    /**
     * borra una fila de una matriz
     * 
     * @param n índice de la fila a eliminar
     */
    public int[][] borraFila(int n) { 
        int[][] filon;

        if (n < 0 || n >= matriz.length) {
            filon = new int[matriz.length][matriz.length];
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int columna = 0; columna < matriz[fila].length; columna++) {
                    filon[fila][columna] = matriz[fila][columna];
                }
            }
        } else {
            filon = new int[matriz.length - 1][matriz.length];
            int contNue = -1;
            for (int fila = 0; fila < matriz.length; fila++) {
                contNue++;
                if (contNue == n && n == matriz[fila].length) {
                    fila = fila + 1;
                    for (int columna = 0; columna < matriz[fila].length; columna++) {
                        filon[contNue][columna] = matriz[fila][columna];
                        // System.out.printf("%3d",filon[contNue][columna]);
                    }
                } else if(contNue == n && n != matriz[fila].length){
                    
                } else{
                    for (int columna = 0; columna < matriz[fila].length; columna++) {
                        filon[contNue][columna] = matriz[fila][columna];
                        // System.out.printf("%3d",filon[contNue][columna]);
                    }
                }
            }
        }
        return filon;
    }

    public Matriz(int n) {

        if (n < 0) {
            n = 3;
        }

        this.matriz = new int[n][n];

        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                this.matriz[fila][columna] = (int) (Math.random() * 10 + 0);
            }
        }
    }
}
