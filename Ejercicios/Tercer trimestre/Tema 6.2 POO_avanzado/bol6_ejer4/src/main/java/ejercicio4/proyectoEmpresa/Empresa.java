package ejercicio4.proyectoEmpresa;

public class Empresa {
    
   public Empleado e1;
   
   public Empleado e2;

   public Directivo d;

   public IUDirectivo iud;
   public IUEmpleado iue1;
   public IUEmpleado iue2;

   private double ganancias;
   public void setGanacias(double ganancias){
      this.ganancias = ganancias;
   }
   public double getGanancias(){
      return ganancias;
   }

   public Empresa(Directivo d, Empleado e1, Empleado e2){
      this.e1 = e1;
      this.e2 = e2;
      this.d = d;

      iud = new IUDirectivo(d);
      iue1 = new IUEmpleado(e1);
      iue2 = new IUEmpleado(e2);
   }
   public Empresa(Directivo d, Empleado e1, Empleado e2, double ganacias){
      this.e1 = e1;
      this.e2 = e2;
      this.d = d;

      iud = new IUDirectivo(d);
      iue1 = new IUEmpleado(e1);
      iue2 = new IUEmpleado(e2);
      setGanacias(ganacias);
   }
}