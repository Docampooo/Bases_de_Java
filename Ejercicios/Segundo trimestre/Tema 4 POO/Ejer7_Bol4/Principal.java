import java.util.Scanner;
public class Principal {

        public static void help(){
            System.out.printf("\n-Para desplazarte por el mapa, escribe la direccion: arriba, abajo, derecha, izquierda.\n-Atacar: inflige daño al orco dependiendo de tu arma, el arco hace daño a mas distancia pero pega menos que la espada.\n-Recuperarse: regenera una cantidad minima de vida mas una cantidad aleatoria.");
        }

        public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in);
    
        Orco o = new Orco();
        Guerrero g = new Guerrero();
    
        System.out.println("Bienvenido a las mazmorras, contigo se encuentras un orco al que tendras que derrotar, escribe help para la ayuda de controles");
        
        int eleccion = 0;
        
        int eleccionArma = 0;
        do{
            System.out.println("¿Qué arma quieres elegir para el combate?");
            System.out.println("1º Espada");
            System.out.println("2º Arco");
            eleccionArma = sc.nextInt();
            if(eleccionArma == 1){
                g.setArma('E');
                System.out.println("Obtienes una espada");
            } else if(eleccionArma == 2){
                g.setArma('A');
                System.out.println("Obtienes un arco");
                eleccionArma = 1;
            } else{
                System.out.println("Opcion no valida");
            }

        }while(eleccionArma != 1);

        do{
            System.out.println("-------------------------------------------------------------");
            System.out.println("1º Atacar");
            System.out.println("2º Recuperarse");
            System.out.println("3º Desplazarse");
            System.out.println("4º Moverse (lejos)");
            System.out.println("-------------------------------------------------------------");
            eleccion = sc.nextInt();
            switch (eleccion) {
            case 1:
                System.out.println("Atacas al orco");
                g.atacar(o);
                break;
            case 2:
                System.out.println("Te recuperas");
                g.recuperarse();
                break;
            case 3:
                g.p.desplazarGuerrero(g);
                break;
            case 4:
                g.p.moverA(g);
                break;
        
            default:
                System.out.println("Opcion fuera de rango");
                break;
        }
        if(o.getEnergia() <=0){
            eleccion = 5;
            System.out.println("Has derrotado al Orco!");
        }
        if(g.getEnergia() <=0){
            eleccion = 5;
            System.out.println("Has muerto");
        }
        if(o.getEnergia()>0){
            o.patronOrco(g);
        }
    }while (eleccion != 5);

    }
}
