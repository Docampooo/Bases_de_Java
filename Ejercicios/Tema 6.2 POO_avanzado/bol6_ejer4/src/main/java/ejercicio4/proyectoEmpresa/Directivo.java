package ejercicio4.proyectoEmpresa;

import ejercicio4.Persona;

public class Directivo extends Persona {

    private String departamento;

    public void setDepartamento(String departamento) {
        this.departamento = departamento.toUpperCase();
    }

    public String getDepartamento() {
        return departamento;
    }

    private double beneficios;

    public void setBeneficios(double valor) {
        if (valor > 0 && valor < 100) {
            beneficios = valor;
        } else {
            beneficios = 0;
        }
    }

    public double getBeneficios() {
        return beneficios;
    }

    public Directivo(String nombre, String apellidos, int edad, String DNI, String departamento, double beneficios) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDNI(DNI);
        setDepartamento(departamento);
        setBeneficios(beneficios);
    }

    public Directivo() {
        this("", "", 0, "", "", 0);
    }

    public double ganancias(double beneficios) {
        if (beneficios > 0) {
            beneficios = beneficios * getBeneficios() / 100;
        } else {
            beneficios = 0;
        }
        return beneficios;
    }

    @Override
    public String firmaMail() {// TODO probar

        String caracteres = "";
        String nombre = "*";
        String depart = "*";
        for (int i = 0; i < 34; i++) {
            caracteres = caracteres + "*";
        }

        int contNombre = -1;
        int contDepart = -1;
        System.out.println(getDepartamento());

        for (int f = 0; f < 32; f++) {

            if (f >= 15 - (getNombre().length() / 2) && f <= 15 + (getNombre().length() / 2)) {
                contNombre++;
                if(getNombre().length() != contNombre){
                    nombre = nombre + getNombre().charAt(contNombre);
                }else{
                    nombre = nombre + " ";
                }
            }else{
                nombre = nombre + " ";
            }

            if(f >= 15 - (getDepartamento().length() / 2) && f <= 15 + (getDepartamento().length() / 2)) {
                contDepart++;
                if(getDepartamento().length() != contDepart){
                    depart = depart + getDepartamento().charAt(contDepart);
                }else{
                    depart = depart + " ";
                }
            }else{
                depart = depart + " ";
            }
        }

        nombre = nombre + "*";
        depart = depart + "*";

        return String.format("%s\n%s\n%s\n%s", caracteres, nombre, depart, caracteres);
    }
}

/******************
 * Nico *
 * Tecnico****
 *
 */
