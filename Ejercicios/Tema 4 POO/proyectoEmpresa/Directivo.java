public class Directivo {
    
    private String nombre;
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    private String apellidos;
    public void setApellidos(String apellido){
        this.apellidos = apellido;
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
    
    private String dni;
    public void setDni(String dni){
        this.dni = dni;
    }
    public String getDni(){
        return dni;
    }

    private String departamento;
    public void setDepartamento(String departamento){
        this.departamento = departamento.toUpperCase();
    }
    public String getDepartamento(){
        departamento = "\"" + departamento + "\"";
        return departamento;
    }

    private double beneficios;
    public void setBeneficios(double valor){
        if(valor>0 && valor<100){
            beneficios = valor;
        }else{
            beneficios = 0;
        }
    }
    public double getBeneficios(){
        return beneficios;
    }

    public Directivo(){
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.dni = "";
        this.departamento = "";
        this.beneficios = 0;
    }

    public Directivo(String nombre, String apellidos, int edad, String dni, String departamento, double beneficios){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        setDepartamento(departamento);
        this.beneficios = beneficios;
    }

    public double ganancias(double beneficios){
        if(beneficios > 0){
            beneficios = beneficios*getBeneficios()/100;
        } else {
            beneficios = 0;
        }
        return beneficios;
    }
}
