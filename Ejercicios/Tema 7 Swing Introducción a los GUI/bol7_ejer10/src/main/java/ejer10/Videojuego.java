package ejer10;

public class Videojuego {

    private String titulo;

    public void setTitulo(String titulo) {

        this.titulo = titulo.toUpperCase().trim();
    }

    public String getTitulo() {
        return titulo;
    }

    private int año;

    public void setAño(int año) {

        if (año < 1950) {
            throw new IllegalArgumentException("El año no puede ser menor a 1950");
        } else {
            this.año = año;
        }
    }

    public int getAño() {
        return año;
    }

    public Videojuego(String titulo, int año) {

        setTitulo(titulo);
        setAño(año);
    }

    public Videojuego(){
        setTitulo("");
        setAño(1980);
    }

    @Override
    public String toString() {
        return String.format("%s;%4d \n", getTitulo(), getAño());//Por que no se añade el retorno de carro
    }

    /**
     * devuelve true si ambos objetos son videojuegos y ademas coinciden exactamente
     * en titulo y año, de lo contrario devuelve false
     */
    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() == Videojuego.class && obj.toString().equals(this.toString())) {

            return true;
        } else {
            return false;
        }
    }
}
