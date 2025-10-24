package prueba;

public class Astro {
    
    private String nombre;

    public void setNombre(String nombre){
        this.nombre = nombre.toUpperCase().trim();
    }

    public String getNombre(){
        return nombre;
    }

    public String getNombre(String cad){
        String result = "";
        for(int i = 0; i < nombre.length();i++){
            result = result + (nombre.charAt(i) + cad);
        }
        return result;
    }

    private double radio;

    public void setRadio(double radio){

        if(radio < 0){
            throw new RadioNegativoException();
        }else{
            this.radio = radio;
        }
    }
    public double getRadio(){
        return radio;
    }

    public Astro(String nombre, double radio){

        setNombre(nombre);
        setRadio(radio);
    }

    @Override
    public boolean equals(Object obj) { //TODO comprobar este apartado 
        if(obj.getClass() == Astro.class){
            Astro astro = (Astro) obj;
            if(this.toString().equals(astro.toString())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return(String.format("%s;%.2f", getNombre(), getRadio()));
    }
}
