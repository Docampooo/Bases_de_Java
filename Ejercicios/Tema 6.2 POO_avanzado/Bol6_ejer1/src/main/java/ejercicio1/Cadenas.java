package ejercicio1;

public class Cadenas {

    /**
     * Se le pasa una cadena, una posición que usa como referencia para devolver los caracteres de la cadena y un número de caracteres que va a devolver
     * @param cadena cadena de la que recoge los caracteres
     * @param posicion posicion desde la que comienza a devolver caracteres
     * @param caracteres numero de caracteres que devuelve
     * @return si la cadena es nula o los valores están fuera de rango, devuelve cadena vacía, otro, devuele el numero de caracteres indicado desde la posición indicada
     */
    public static String subCadena(String cadena, int posicion, int caracteres)throws Exception{

        String resultado ="";

        if((posicion < 0 || posicion >= cadena.length() ) || (caracteres < 0 || caracteres + posicion >= cadena.length())){

            throw new IndiceFueraDeRango("Error en los parámetros, la longitud de tu cadena es: "+cadena.length() + " el indice: "+ posicion + " y el numero de caracteres: "+ caracteres);
        }
        
        if ( cadena == null ||cadena.equals("")){
            return "";
        } else{
            for(int i = posicion;i<caracteres+posicion;i++){
                resultado = resultado + cadena.charAt(i);
            }
            return resultado;
        }
    }

    /**
     * Se le pasa una cadena y la devuelve centrada en la consola
     * @param cadena cadena a devolver centrada
     */
    public static void muestraCentrado(String cadena)throws Exception{

        if(cadena.length() >= 80){
            throw new StringTooLongException();
        }else{
            for(int i=0;i<(40 - cadena.length()/2);i++){
                System.out.print(" ");
            }
            System.out.println(cadena);
        }
    }


    public static void main(String[] args) throws Exception {

        String cadena = "";
        for(int i = 0;i<10;i++){
            cadena = cadena + "alberto carril ";
        }

        muestraCentrado(cadena);
        
        System.out.println(subCadena("AlbertoCarril", 15, 3));

    }
}
