public class ArrayBidimensional {
    
    public static void main(String[] args) {
        int[][] temp = new int[7][4]; //7 filas y 4 columnas

        int[][] tabla = { //declaracion de aray bidimentsional
            {15,2,14},
            {12,1,3},
            {14,0,16}
        };

        System.out.println("Nº de filas: " + temp.length);
        System.out.println("Nº de columnas: "+ temp[0].length);

        for(int cont = 0; cont < temp.length;cont++){ //bucle que recorre las filas

            for(int cont2 = 0; cont2 < temp[cont].length;cont2++){ //bucle que recorre las columnas

                temp[cont][cont2] = (int) (Math.random()* 50);
            }
        }

        for(int cont = 0; cont < temp.length;cont++){ //bucle que recorre las filas

            for(int cont2 = 0; cont2 < temp[cont].length;cont2++){ //bucle que recorre las columnas

                System.out.printf("%5d",temp[cont][cont2]); //imprime el contenido de la posicion de los vectores ocupando 5 espacios
            }
            System.out.println(); //comienza la siguiente vuelta y coloca retorno de carro
        }
    }
}
