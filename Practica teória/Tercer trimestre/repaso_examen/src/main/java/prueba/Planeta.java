package prueba;

import java.util.ArrayList;

public class Planeta extends Astro {

    private boolean gaseoso;

    public void setGaseoso(boolean gaseoso){
        this.gaseoso = gaseoso;
    }
    public boolean getGaseoso(){
        return gaseoso;
    }

    public ArrayList<Astro> satelites;
    
    public Planeta(String nombre, double radio, boolean gaseoso){

        super(nombre, radio);
        setGaseoso(gaseoso);
        satelites = new ArrayList<>();
    }

    public Planeta(){
        this("", 0, false);

        satelites = new ArrayList<>();
    }
}
