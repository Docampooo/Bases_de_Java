public class principal {
    public static void main(String[] args) {
        Perro perro;

        perro = new Perro("Bobby","Can palleiro",5,35); //llama al constructor y le asigna los valores

        System.out.printf("Tengo un %s llamado %s de %d años \n",perro.raza, perro.nombre,perro.getEdad());
        
        if(perro.getfiebre()){
            System.out.printf("%s tiene fiebre \n", perro.nombre);
        }

        Perro p1 = new Perro("pablovaz","peruano",30 ,20);
        System.out.printf("mi perro %s es un tremendo peruano \n",p1.nombre);
        
        System.out.println(Perro.definicion);
    }
}