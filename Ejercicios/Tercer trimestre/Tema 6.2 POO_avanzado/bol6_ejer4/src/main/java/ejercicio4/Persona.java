package ejercicio4;

import ejercicio4.DNIException;

abstract public class Persona {

    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    private String apellidos;

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    private int edad;

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    private String DNI;

    public void setDNI(String dni) {
        
        char letra;
        dni=dni.toUpperCase();

        if (dni.length() != 9 || !((dni.charAt(dni.length()-1) >= 'A' && dni.charAt(dni.length()-1) <= 'Z'))){ // comprobar si el último caracter es una letra
            throw new DNIException();
        }else{
            letra = dni.charAt(dni.length() - 1);
            if(dni.charAt(dni.length()-1) > 91){
                letra = (char) (letra - 32);
            }
        }

        int num = Integer.parseInt(dni.substring(0, dni.length()-1))%23;

        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (letra == cadena.charAt(num)) {
            DNI = dni;
        } else {
            throw new DNIException();
        }
    }

    public String getDNI() {
        return DNI;
    }

    abstract public String firmaMail();

    @Override
    public String toString() {

        return String.format("%s %s ", getNombre(), getApellidos());
    }
}
