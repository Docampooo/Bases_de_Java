package ejercicio4.proyectoEmpresa;
import ejercicio4.Persona;

public class Empleado extends Persona{

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

    public Empleado (String nombre, String apellidos, int edad, String DNI, double salarioAnual){
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDNI(DNI);
        setSalarioAnual(salarioAnual);
    }
    
    public Empleado (){
        this("", "", 0, "", 0);
    }


    public static double hacienda(double salario, double irpf){
        return salario * irpf/100;
    }

    @Override
    public String firmaMail() {
        return String.format("%s",super.toString());
    }
}
