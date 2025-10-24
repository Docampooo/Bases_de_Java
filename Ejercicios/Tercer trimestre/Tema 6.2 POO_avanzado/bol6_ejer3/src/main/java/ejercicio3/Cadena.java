package ejercicio3;

import java.util.ArrayList;

public class Cadena {

    private ArrayList<Character> cadena = new ArrayList<>();

    public String quitarEspacios(String texto) {

        boolean error;
        boolean error2;
        String result;
        do {
            error = false;
            error2 = false;

            result = "";

            if (texto.charAt(0) == 32) {

                for (int i = 1; i < texto.length(); i++) {
                    result = result + texto.charAt(i);
                }
                texto = result;
                result = "";
                error = true;
            }

            if (texto.charAt(texto.length()-1) == 32) {

                for (int i = 0; i < texto.length() - 1; i++) {
                    result = result + texto.charAt(i);
                }
                texto = result;
                result = "";
                error2 = true;
            }
        } while (error || error2);

        return texto;
    }

    public void setCadena(String texto) {

        texto = quitarEspacios(texto);//el trim
        for (int i = 0; i < texto.length(); i++) {
            cadena.add(texto.charAt(i));
        }
    }

    /**
     * Devuelve una cadena de caracteres formada por los caracteres de una colección
     * Chararcter unidos
     */
    @Override
    public String toString() {

        String texto = "";
        for (int i = 0; i < cadena.size(); i++) {
            texto = texto + cadena.get(i);
        }
        return texto;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !((obj.getClass() == char[].class) || (obj.getClass() == Cadena.class)
                || (obj.getClass() == String.class))) {

            throw new IllegalArgumentException();
        } else {
            if (obj.getClass() == Cadena.class && obj.toString().equals(cadena.toString())) {
                return true;

            } else if (obj.getClass() == String.class && obj.equals(cadena.toString())) {
                return true;

            } else if (obj.getClass() == char[].class && obj.toString().equals(cadena.toString())) {
                return true;

            } else {
                return false;
            }
        }
    }

    public int eliminar(char car) {

        int acu = 0;
        for (int i = cadena.size() - 1; i >= 0; i--) {
            if (cadena.get(i) == car) {
                cadena.remove(i);
                acu++;
            }
        }
        return acu;

    }
}
