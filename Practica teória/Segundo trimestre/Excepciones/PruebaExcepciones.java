import java.util.Scanner;

public class PruebaExcepciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividendo, divisor;
        int dividendo2;

        try{

            System.out.println("Por favor, introduce dividendo");
            dividendo = Integer.parseInt(sc.nextLine());
            // dividendo2 = sc.nextInt(); //El next Int saca una excepcion diferente a la que saca el parse Int
            // sc.nextLine();
        System.out.println("ahora el divisor");
        divisor = Integer.parseInt(sc.nextLine());
        System.out.printf("El resultado es %d\n", dividendo / divisor);
        
        }catch (NumberFormatException e){ //e recoge la excepcion y la guarda en una variable, el number format es de las que más veremos
            System.out.println("Ha introducido un dato no valido");
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir por 0"); //Se pueden anidar todos los catchs que se quiera
        }
        
        catch(Exception e){
            System.out.println("Excepcion desconocida: "+e.getMessage());
        }
        System.out.println("Fin del programa");
    }
}