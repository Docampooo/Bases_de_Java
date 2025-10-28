public class Empleado {
    
    private String nombre;
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    private String apellidos;
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String getApellidos(){
        return apellidos;
    }
    private int edad;
    public void setEdad(int edad){
        this.edad = edad;
    }
    public int getEdad(){
        return edad;
    }

    private String DNI;
    public void setDNI(String DNI){
        this.DNI = DNI;
    }
    public String getDNI(){
        return this.DNI;
    }

    private double salarioAnual;
    public void setSalarioAnual(double salarioAnual){
        if(salarioAnual < 6000){
            irpf = 7.5;
        } else if(salarioAnual >= 6000 && salarioAnual <= 30000){
            irpf = 15;
        } else {
            irpf = 20;
        }
        this.salarioAnual = salarioAnual;
    }
    public double getSalarioAnual(){
        return salarioAnual;
    }

    private double irpf;
    public double getIrpf(double irfp){
        return irpf;
    }

    public Empleado (){
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.DNI = "";
        setSalarioAnual(0);
    }

    public Empleado (String nombre, String apellidos, int edad, String DNI, double salarioAnual){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.DNI = DNI;
        setSalarioAnual(salarioAnual);
    }

    public static double hacienda(double salario, double irpf){
        return salario * irpf/100;
    }
}
