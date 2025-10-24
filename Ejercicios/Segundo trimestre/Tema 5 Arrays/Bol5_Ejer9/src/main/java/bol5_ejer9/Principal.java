package bol5_ejer9;
import java.io.File;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        File f = new File("alumnos.txt");
        Scanner p = new Scanner(f);

        String[] alumnos = p.nextLine().toUpperCase().split("[;]");
        p.close();

        File r = new File("asignaturas.txt");
        Scanner q = new Scanner(new File("asignaturas.txt"));

        String[] asignaturas = q.nextLine().toUpperCase().split("[;]");
        q.close();

        Aula clase = new Aula(alumnos,asignaturas);
        
        Menu menu = new Menu();

        menu.menu(clase);
        
    }
}
