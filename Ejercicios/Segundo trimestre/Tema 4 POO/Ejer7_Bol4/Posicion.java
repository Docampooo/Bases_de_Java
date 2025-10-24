import java.util.Scanner;

public class Posicion {
    
    public int x;
    public void setX(int x){
        if(x < 1){
            this.x = 1;
        }else if(x > 5){
            this.x = 5;
        }else{
            this.x = x;
        }
    }
    public int getX(){
        return x;
    }

    public int y;
    public void setY(int y){
        if(y < 1){
            this.y = 1;
        }else if(y > 5){
            this.y = 5;
        }else{
            this.y = y;
        }
    }
    public int getY(){
        return y;
    }

    public Posicion(){
        x = 0;
        y = 0;
    }

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moverA(Guerrero g){
        Scanner sc = new Scanner(System.in);

        System.out.println("A donde te quieres mover?");
        this.setX(sc.nextInt());
        this.setY(sc.nextInt());
        System.out.printf("Te has desplazado a %d,%d \n", this.getX(), this.getY());
    }

    public void desplazarGuerrero(Guerrero g){
        Scanner sc = new Scanner(System.in);

        System.out.println("A que direccion quieres desplazarte?");
        String lugar = sc.nextLine();
        switch (lugar) {
            case "arriba":
                this.setX(this.getX() + 1);
                break;
            case "abajo":
                this.setX(this.getX() - 1);
                break;
            case "derecha":
                this.setY(this.getY() + 1);
                break;
            case "izquierda":
                this.setY(this.getY() - 1);
                break;
        
            default:
                System.out.println("direccion no valida");
                break;
        }
    }

    public void desplazarOrco(Orco o){
        int desplazamiento = (int) (Math.random()*4+1);
        if(desplazamiento == 1){
            this.setX(this.getY() + 1);
        } else if(desplazamiento == 2){
            this.setX(this.getX() - 1);
        } else if(desplazamiento == 3){
            this.setY(this.getY() + 1);
        } else if(desplazamiento == 4){
            this.setY(this.getY() - 1);
        }
    }
}
