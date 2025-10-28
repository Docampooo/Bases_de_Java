public class Pelota {
    
    public static Object p;
    public static Object p1;
    public String tipo;
    private double radio;

    public void setRadio(double radio){
        this.radio=radio;
    }
    public double getRadio(){
        return radio;
    }

    public Pelota(){
        this.tipo = "playa";
        this.radio = 40;
    }

    public Pelota(String tipo, double radio){
        this.tipo = tipo;
        this.radio = radio;
    }

    public void inflar(){
        radio = radio + 1;
    }

    public void inflar (int n){
        radio = radio + n;
        System.out.println("el radio ha aumentado " + n + "cm");
    }
}
