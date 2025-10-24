public class Perro {

    static String definicion="el mejor y más baboso amigo del hombre despues del javi";
    public String raza;
    public  String nombre;
    private int edad;

    public void setEdad(int edad) {
        if(edad > 0){
            this.edad = edad;
        } else{
            this.edad = 0;
        }
    }

    public int getEdad() {
        return edad;
    }
    public double temperatura;

    public void setTemperatura(double t){
        temperatura = t;
        if (t>39){
            fiebre = true;
        } else{
            fiebre = false;
        }
    }
    public double getTemperatura(){
        return temperatura;
    }

    private boolean fiebre;
    public boolean getfiebre(){
        return fiebre;
    }

    public Perro(String nombre, String raza, int edad, double temperatura){ //constructor, no puede devolver nada y tiene que llamarse exactamente igual que la clase y en mayúscula
        this.nombre=nombre;
        this.raza=raza;
        this.setEdad(edad);
        this.setTemperatura(temperatura);
    }


}
