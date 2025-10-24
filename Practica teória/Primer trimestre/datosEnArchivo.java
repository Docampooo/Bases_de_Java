import java.io.PrintWriter;
public class datosEnArchivo {
    public static void main(String[] args) throws Exception {
        //Apertura, se usa f como abreviación de file.
        PrintWriter f = new PrintWriter("prueba.txt"); //se usa para vincular un archivo del disco duro con el programa

        //escritura
        f.print("Prueba de archivos. ");
        
        f.println("Hola que tal.\n\n");

        f.printf("%5.2f\n", Math.PI);

        for (int i=10; i<=20; i++){
            f.printf("%4d",i);
            }

        //cierre
        f.close();

    }
}
